package manager;

import styles.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//样式风格管理器，用于管理样式的获取，保存，转换。
public class AppStyleManager {
    private static AppStyleManager appStyleManager=new AppStyleManager();
    private Map<String, Style>styleMap=new HashMap<>();
    private Style currentStyle;
    private AppStyleManager()
    {

        styleMap.put("spring",new SpringStyle());
        styleMap.put("summer",new SummerStyle());
        styleMap.put("autumn",new AutumnStyle());
        styleMap.put("winter",new WinterStyle());
        currentStyle=styleMap.get("spring");

    }
    public static AppStyleManager getInstance()
    {
        return appStyleManager;
    }
    public void transToStyle(String name)
    {
        currentStyle=styleMap.get(name);
    }
    public Color getButtonColor()
    {
        return currentStyle.getButtonColor();
    }
    public Color getPanelColor()
    {
        return currentStyle.getPanelColor();
    }

}
