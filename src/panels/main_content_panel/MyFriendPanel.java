package panels.main_content_panel;

import javax.swing.*;
import java.awt.*;
//�����б�鿴����ӣ�ɾ������
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
