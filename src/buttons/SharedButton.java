package buttons;

import manager.CenterPanelManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//分享按钮
public class SharedButton extends Button {
   private static SharedButton sharedButton=new SharedButton();
    private SharedButton()
    {
        super("分享空间");
        setBackground(Color.BLUE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CenterPanelManager.getInstance().transToPanel("shared_room_panel");
            }
        });

    }
    public  static SharedButton getInstance()
    {
        return sharedButton;
    }

}
