package hdfs24;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HdfsClientDemo {
    public static void main (String[] args) throws IOException, URISyntaxException, InterruptedException {
        // new Configuration() 会从项目classpath中加载core-default.xml,hdfs-default.xml core-site.xml hdfs-site.xml
        Configuration conf = new Configuration();
        // No of copy
        conf.set("dfs.replication","2");
        //指定本客户端上hdfs切块时规格大小:64m
        conf.set("dfs.blocksize","64m");

        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hdp-01:9000"),conf,"root");

        //上传文件到hdfs
        fileSystem.copyFromLocalFile(new Path("D:/hadoop-2.8.1/LICENSE.txt"),new Path("/aaa/"));
        fileSystem.close();
    }

    FileSystem fs = null;
    @Before
    public void init() throws Exception{

        // new Configuration() 会从项目classpath中加载core-default.xml,hdfs-default.xml core-site.xml hdfs-site.xml
        Configuration conf = new Configuration();
        // No of copy
        conf.set("dfs.replication","2");
        //指定本客户端上hdfs切块时规格大小:64m
        conf.set("dfs.blocksize","64m");

        fs = FileSystem.get(new URI("hdfs://hdp-01:9000"),conf,"root");


    }

    /***
     *
     * @throws IOException
     * java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.
     * Reason： 下载时候调用C语言包，包在hadoop安装包内。Windows环境变量没配就会报错。
     */
    @Test
    public void testGet() throws IOException {
        fs.copyToLocalFile(new Path("/install.log"), new Path("D:/hadoop-2.8.1"));
        fs.close();
    }

    /***
     * hdf内部移动以及改名
     * @throws IOException
     */
    @Test
    public void testRename() throws IOException {
        fs.rename(new Path("/install.log"),new Path("/aaa/in.log"));
        fs.close();
    }

    @Test
    public void testMkdir() throws IOException {
        fs.mkdirs(new Path("/xx"));
        fs.close();
    }

    @Test
    public void testRemove() throws IOException {
        fs.delete(new Path("/xx"),true);
        fs.close();
    }


    @Test
    public void testLs() throws IOException {
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/"), true);
        while (iter.hasNext()){
            LocatedFileStatus status = iter.next();
            System.out.println("全路径:"+ status.getPath());
            System.out.println("块大小:"+status.getBlockSize());
            System.out.println("文件长度:"+status.getLen());
            System.out.println("副本数量:"+status.getReplication());
            System.out.println("块信息:"+ Arrays.toString(status.getBlockLocations()));
            System.out.println("\n");
        }
        fs.close();
    }

    @Test
    public void testLs2() throws IOException {

        FileStatus[] FileStatus = fs.listStatus(new Path("/aaa"));
        for (FileStatus status:FileStatus){

            System.out.println("全路径:"+ status.getPath());
            System.out.println(status.isDir()?"文件夹":"文件");
            System.out.println("块大小:"+status.getBlockSize());
            System.out.println("文件长度:"+status.getLen());
            System.out.println("副本数量:"+status.getReplication());
            System.out.println("-------------------------------");
        }
        fs.close();
    }



}
