package panels.main_content_panel;

import buttons.FriendButton;
import buttons.SettingButton;

import javax.swing.*;
import java.awt.*;
//�����б�鿴����ӣ�ɾ������
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
