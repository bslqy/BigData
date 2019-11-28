package cn.edu360.hdfs.datacollect;

import java.util.Timer;

public class DataCollectionMain {
    public static void main(String args[]){
        // Timer can schedule a task

        Timer timer = new Timer();
        timer.schedule(new CollectorTask(),0,60*60*1000L);
        timer.schedule(new BackupCleanTask(),0,60*60*1000L);

    }


}
