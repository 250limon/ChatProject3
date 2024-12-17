package panels.main_content_panel;

import buttons.FriendButton;
import buttons.SettingButton;

import javax.swing.*;
import java.awt.*;
//好友列表查看，添加，删除界面
public class MyFriendPanel extends JPanel {
    private static MyFriendPanel myFriendPanel=new MyFriendPanel();
    private MyFriendPanel()
    {
        setBackground(Color.YELLOW);

       setLayout(null);


    }
    public static MyFriendPanel getInstance()
    {
        return myFriendPanel;
    }
}
