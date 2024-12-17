package manager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//字体样式管理器，获取用户选择的聊天字体
public class FontManager {
    private static FontManager fontManager=new FontManager();
    private List<String>fontStyles=new ArrayList<>();
    private String currentFontStyle;
    private FontManager()
    {
        currentFontStyle=Font.SERIF;
    }
    public static FontManager getInstance()
    {
        return fontManager;
    }
    public void changeFontStyle(String name)
    {
        currentFontStyle=name;
    }
    public String getCurrentFontStyle()
    {
        return currentFontStyle;
    }
    public String getFontStyle(int index)
    {
        return fontStyles.get(index);
    }
}
