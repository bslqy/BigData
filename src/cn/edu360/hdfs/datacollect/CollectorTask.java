package cn.edu360.hdfs.datacollect;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectorTask extends TimerTask {

    @Override
    public void run() {
        /***
         *
         *
         *
         */

        // Create a log4j instance
        Logger logger =  Logger.getLogger("logRollingFile");

        // Get the current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        String day = sdf.format(new Date());

        File srcDir = new File("d:/logs/accesslog/");
        // Get the

        File[] listFiles = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.startsWith("access.log.")){
                    return true;
                }
                return false;
            }
        });

        // Logging
        logger.info("Detected files: " + Arrays.toString(listFiles));

        try{
        // Move the file to the temp location
        File toUploadDir = new File("d:/logs/toupload/");
        for (File file:listFiles) {
            FileUtils.moveFileToDirectory(file,toUploadDir,true);

        }

        // Logging
        logger.info("Moved to upload directory: " + Arrays.toString(listFiles));

        // Create a HDFS client object
        FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), new Configuration(),"root");
        File[] toUploadFiles = toUploadDir.listFiles();

        // Check if the HDFS directory exists, if not ,create
        Path hdfsDestPath = new Path("/logs/"+day);
        if(!fs.exists(hdfsDestPath)){
            fs.mkdirs(hdfsDestPath);
        }

        // Check if the local backup directory exists, if not, create
        File backupDir = new File("d:/logs/backup"+day);
        if(!backupDir.exists()){
            backupDir.mkdirs();
        }


        // Move the uploaded file to the backup directory and ch
        for(File file: toUploadFiles){

            Path destPath = new Path("/logs/"+day+"/access_log_"+ UUID.randomUUID()+".log");

            // Upload to HDFS
            fs.copyFromLocalFile(new Path(file.getAbsolutePath()),destPath);

            // Logging
            logger.info("Moved to HDFS directory: " +  file.getAbsolutePath() + "-->" + destPath);

            FileUtils.moveFileToDirectory(file,new File("d:/logs/backup/"+day),true);

            // Logging
            logger.info("Finished backup: " +  file.getAbsolutePath() + "-->" + destPath);
        }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
