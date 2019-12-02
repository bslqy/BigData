package cn.edu360.hdfs.wordcount;

import cn.edu360.hdfs.Demo.Context;
import cn.edu360.hdfs.Demo.Mapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HdfsWordCount {
    public static void main(String[] args) throws Exception {

        /**
         * 初始化文件
         */
        Properties pros = new Properties();
        // 在jar包HDFSWordCount类的相对路径中获取properties文件
        pros.load(HdfsWordCount.class.getClassLoader().getResourceAsStream("job.properties"));

        // 获取MAPPER_CLASS. 当前设定为MAPPER_CLASS接口通用，需要传入具体参数来确定哪个方法，所以使用反射
        Class<?> mapper_class = Class.forName(pros.getProperty("MAPPER_CLASS"));

        Mapper mapper = (Mapper) mapper_class.newInstance();
        // 其实是一个封装的HashMap
        Context context = new Context();

        FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), new Configuration(), "root");
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/wordcount/input/"), false);

        /***
         * 处理数据
         */
        while(iter.hasNext()){
            LocatedFileStatus file = iter.next();
            FSDataInputStream in = fs.open(file.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while((line = br.readLine())!=null){
                mapper.map(line,context);

            }
        br.close();
        in.close();
        }

        /***
         * 输出结果
         */
        HashMap<Object, Object> contextMap = context.getContextMap();

        Path outpath = new Path("/wordcount/output/");
        if (!fs.exists(outpath)){
            fs.mkdirs(outpath);
        }

          FSDataOutputStream out = fs.create(new Path("/wordcount/output/res.dat"));
        Set<Map.Entry<Object, Object>> entrySet = contextMap.entrySet();
        for (Map.Entry<Object,Object> entry:entrySet){
            out.write((entry.getKey().toString()+"\t"+entry.getValue()+"\n").getBytes());
        }
        out.close();
        fs.close();

        System.out.println("数据统计完成.....");

        // 去hdfs读文件，每次读一行



        // 对每一行进行业务处理

        // 将这一行的处理结果放入一个缓存

        // 将缓存中的结果输出到HDFS文件


    }
}
