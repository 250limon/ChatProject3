package panels.main_content_panel;

import javax.swing.*;
import java.awt.*;
//����ռ����
public class SharedRoomPanel extends JPanel {
    private static  SharedRoomPanel sharedRoomPanel=new SharedRoomPanel();
    private SharedRoomPanel()
    {
        setBackground(Color.magenta);


    }
    public static SharedRoomPanel getInstance()
    {

        return sharedRoomPanel;

    }

}
