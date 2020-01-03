import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @Author:weizd
 * @Date:19-12-3
 * 讲获取的信息写入到文件中
 *
 *
 */

public class WriteToFileHandler implements DealStrHandler {

    private String localFilePath;

    public WriteToFileHandler(String localFilePath){
        this.localFilePath = localFilePath;
    }

    @Override
    public void handler(String str) throws IOException {

        List<String> lines = Lists.newArrayList();
        lines.add(str);



        Files.write(Paths.get(this.localFilePath),lines, Charsets.UTF_8, StandardOpenOption.APPEND);
    }


}
