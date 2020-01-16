package top.oldwei.main;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import javafx.scene.image.Image;
import top.oldwei.tool.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:weizd
 * @Date:20-1-9
 */
public class PicTest {


    private final static Log log = LogFactory.get();

    public static void main(String[] args) throws Exception{

        Set<String> notList = new HashSet<>();
        notList.add("/home/ap/nas/source/assert/assets/1-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/2-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/2-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/4-2-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/4-2-3-01.png");

        notList.add("/home/ap/nas/source/assert/assets/6-2-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-2-4-01.png");


        notList.add("/home/ap/nas/source/assert/assets/6-2-4-05.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-2-03.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-2-04.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-2-05.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-3-02.png");

        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-3-03.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-3-04.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-3-05.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-03.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-04.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-05.png");

        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-06.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-07.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-08.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-4-4-09.png");


        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-2-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-3-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-4-4-5-4-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-5-2-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-6-1-1-03.png");
        notList.add("/home/ap/nas/source/assert/assets/6-6-2-1-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-6-2-1-2-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-6-6-03.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-1-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-4-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-5-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-6-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-2-7-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-1-3-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-1-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-1-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-2-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-2-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-2-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-3-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-3-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-7-3-3-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-8-3-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-1-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-2-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-2-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-2-2-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-3-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-1-5-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-3-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-9-3-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-10-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-10-4-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-11-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/6-11-6-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-12-1-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-12-3-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/6-12-3-3-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-4-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-4-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-5-01.png");

        notList.add("/home/ap/nas/source/assert/assets/7-1-5-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-5-04.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-7-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-7-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-7-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-8-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-8-02.png");

        notList.add("/home/ap/nas/source/assert/assets/7-1-9-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-9-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-1-9-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-4-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-4-1-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-4-2-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-5-1-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-5-2-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-5-2-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-6-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-7-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-7-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-2-7-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-4-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-4-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-4-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-5-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-5-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-5-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-5-04.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-7-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-7-02.png");

        notList.add("/home/ap/nas/source/assert/assets/7-3-7-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-3-8-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-4-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-4-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-4-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-5-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-5-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-5-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-5-04.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-6-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-6-02.png");

        notList.add("/home/ap/nas/source/assert/assets/7-4-6-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-7-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-7-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-7-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-8-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-8-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-8-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-10-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-10-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-10-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-11-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-12-01.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-12-02.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-12-03.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-12-04.png");
        notList.add("/home/ap/nas/source/assert/assets/7-4-12-05.png");

        log.info("不需要裁剪的数量：{}",notList.size());

        String sourcePath = "/home/ap/nas/source/assert/assets";

        String distPath = "/home/ap/nas/target/assert/assets";

        List<File> fileList = FileUtil.loopFiles(sourcePath);

        log.info("图片数量：{}",fileList.size());

        int notNeed = 0;

        int need = 0;
        for(File file:fileList){

            String sourceName = file.getName();

            if(notList.contains(file.getAbsolutePath())){
                FileUtil.copy(file,new File(Paths.get(distPath,sourceName).toString()),true);
                log.info("移动【{}】成功",file.getName());
                notNeed++;


            }else {
                BufferedImage bufferedImage = ImageIO.read(file);
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();

                log.info("【{}】 图片大小:{} x {} ",sourceName,width,height);

                ImgUtil.cut(file,new File(Paths.get(distPath,sourceName).toString()),new Rectangle(0,60,width,height-60));
                need++;
            }

        }

        log.info("总张数：{},移动张数：{},裁剪张数:{}",fileList.size(),notNeed,need);

        log.info("是否正确:{}",fileList.size() == need+notNeed);

    }





}
