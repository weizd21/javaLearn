import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.time.LocalDateTime;

/**
 * @Author:weizd
 * @Date:20-1-9
 */
public class ReadCSV {


    public static void main(String[] args) {

        String separator = ",";

        String title = "false";

        String address = "/home/weizd/dataset/dataset/abalone_nohead.csv";


        SparkSession sparkSession = SparkSession.builder()
                .appName("datastax-insight")
                .master("local[*]")
                .config("spark.driver.host", "localhost")
                // 工作目录 默认值为 /tmp
//                .config("spark.local.dir", tmpLocation)
                .getOrCreate();

        Dataset<Row> dataset =  sparkSession.read().option("header", "true").option("delimiter", separator)
                .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ").csv(address);



        dataset.show();



        System.out.println(LocalDateTime.now());

    }

}
