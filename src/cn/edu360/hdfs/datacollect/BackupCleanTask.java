package cn.edu360.hdfs.datacollect;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

public class BackupCleanTask extends TimerTask {
    @Override
    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        long now = new Date().getTime();


        try{
        // Detect the backup directory
        File backupBaseDir = new File("d:/logs/backup");
        File[] dayBackDir = backupBaseDir.listFiles();

        // Determine if the backup directory is older than 24 hrs.
        for (File dir: dayBackDir){
            long time = sdf.parse(dir.getName()).getTime();
            if (now - time > 20*60*60*1000L){
                FileUtils.deleteDirectory(dir);
            }

        }

        }
        catch(Exception e){
            e.printStackTrace();
        }




    }

}
