package panels.main_content_panel;

import javax.swing.*;
import java.awt.*;
//好友列表查看，添加，删除界面
public class MyFriendPanel extends JPanel {
    private static MyFriendPanel myFriendPanel=new MyFriendPanel();
    private MyFriendPanel()
    {
        setBackground(Color.YELLOW);



    }
    public static MyFriendPanel getInstance()
    {
        return myFriendPanel;
    }
}
