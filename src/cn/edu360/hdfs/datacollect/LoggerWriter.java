package cn.edu360.hdfs.datacollect;


import org.apache.log4j.Logger;

public class LoggerWriter {
    public static void main(String[] args) throws  Exception{
        while(true){
            Logger logger = Logger.getLogger("logRollingFile");
            logger.info("111111111111111111111---" + System.currentTimeMillis());
            Thread.sleep(50);
        }

    }
}
