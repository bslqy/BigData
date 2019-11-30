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
         * --定时探测日志源目录 -- 获取需要采集的文件 --移动这些文件到一个待上传的目录
         * --遍历待上传文件目录中的文件，逐一传输到HDFS的目标路径，同时将传输完成的文件移动到备份目录
         *
         */
        try{
         Properties props = PropertyHolderLazy.getProps();

        // Create a log4j instance
        Logger logger =  Logger.getLogger("logRollingFile");

        // Get the current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        String day = sdf.format(new Date());

        File srcDir = new File(props.getProperty(Constants.LOG_SOURCE_DIR));
        // Get the

        File[] listFiles = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.startsWith(Constants.LOG_LEGEL_PREFIX)){
                    return true;
                }
                return false;
            }
        });

        // Logging
        logger.info("Detected files: " + Arrays.toString(listFiles));


        // Move the file to the temp location
        File toUploadDir = new File(Constants.LOG_TOUPLOAD_DIR);
        for (File file:listFiles) {
            FileUtils.moveFileToDirectory(file,toUploadDir,true);

        }

        // Logging
        logger.info("Moved to upload directory: " + Arrays.toString(listFiles));

        // Create a HDFS client object
        FileSystem fs = FileSystem.get(new URI(Constants.HDFS_DEST_BASE_DIR), new Configuration(),"root");
        File[] toUploadFiles = toUploadDir.listFiles();

        // Check if the HDFS directory exists, if not ,create
        Path hdfsDestPath = new Path(Constants.HDFS_DEST_BASE_DIR+day);
        if(!fs.exists(hdfsDestPath)){
            fs.mkdirs(hdfsDestPath);
        }

        // Check if the local backup directory exists, if not, create
        File backupDir = new File(Constants.LOG_BACKUP_BASE_DIR+day+"/");
        if(!backupDir.exists()){
            backupDir.mkdirs();
        }


        // Move the uploaded file to the backup directory and ch
        for(File file: toUploadFiles){

            Path destPath = new Path(Constants.HDFS_DEST_BASE_DIR+day+Constants.HDFS_FILE_SUFFIX+ UUID.randomUUID()+Constants.HDFS_FILE_SUFFIX);

            // Upload to HDFS
            fs.copyFromLocalFile(new Path(file.getAbsolutePath()),destPath);

            // Logging
            logger.info("Moved to HDFS directory: " +  file.getAbsolutePath() + "-->" + destPath);

            FileUtils.moveFileToDirectory(file,new File(Constants.LOG_BACKUP_BASE_DIR+day),true);

            // Logging
            logger.info("Finished backup: " +  file.getAbsolutePath() + "-->" + destPath);
        }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
