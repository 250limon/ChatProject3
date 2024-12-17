package manager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
//资源管理器，用于加载并保存资源，获取资源
public class ResourceManager {
    private static ResourceManager resourceManager=new ResourceManager();
    //存储图标资源
    private Map<String, Image>icons=new HashMap<>();
    //存储用户头像资源
    private Map<String,Image>user_images=new HashMap<>();
    private ResourceManager()
    {
        try {
            Image app_icon= ImageIO.read(new File("resource/icons/yoimiya7.jpg"));
            icons.put("app_icon",app_icon);

            Image pic1=ImageIO.read(new File("resource/user_image/yaoyao.jpg"));
            Image pic2=ImageIO.read(new File("resource/user_image/yoimiya1.jpg"));
            Image pic3=ImageIO.read(new File("resource/user_image/yoimiya2.jpg"));
            Image pic4=ImageIO.read(new File("resource/user_image/yoimiya3.jpg"));
            Image pic5=ImageIO.read(new File("resource/user_image/yoimiya4.jpg"));
            Image pic6=ImageIO.read(new File("resource/user_image/yoimiya5.jpg"));
            Image pic7=ImageIO.read(new File("resource/user_image/yoimiya6.jpg"));
            Image pic8=ImageIO.read(new File("resource/user_image/yoimiya7.jpg"));
            Image pic9=ImageIO.read(new File("resource/user_image/yoimiya8.jpg"));
            user_images.put("resource/user_image/yaoyao.jpg",pic1);
            user_images.put("resource/user_image/yoimiya1.jpg",pic2);
            user_images.put("resource/user_image/yoimiya2.jpg",pic3);
            user_images.put("resource/user_image/yoimiya3.jpg",pic4);
            user_images.put("resource/user_image/yoimiya4.jpg",pic5);
            user_images.put("resource/user_image/yoimiya5.jpg",pic6);
            user_images.put("resource/user_image/yoimiya6.jpg",pic7);
            user_images.put("resource/user_image/yoimiya7.jpg",pic8);
            user_images.put("resource/user_image/yoimiya8.jpg",pic9);



        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public static ResourceManager getInstance()
    {
        return resourceManager;
    }
    public Image getIcon(String name)
    {
        return icons.get(name);
    }
    public Image getUserImage(String path)
    {
        return user_images.get(path);
    }

}
