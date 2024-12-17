package buttons;

import frames.SettingJFrame;
import manager.AnimationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//设置按钮
public class SettingButton extends JButton {
    private boolean isSettingJframeShow=false;
    public SettingButton()
    {
        setText("设置");
        setBackground(Color.GREEN);
       addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if(isSettingJframeShow)
               {
                   SettingJFrame jFrame=SettingJFrame.getInstance();
                   jFrame.setLocation(jFrame.getX(),300);

                   jFrame.setVisible(false);
                   isSettingJframeShow=false;
               }
               else {
                   SettingJFrame jFrame=SettingJFrame.getInstance();
                   jFrame.setVisible(true);

                   AnimationManager.getInstance().opacityFrom0To100(SettingJFrame.getInstance());
                   AnimationManager.getInstance().jframeDownMoveTo(SettingJFrame.getInstance(),320,1);
                   isSettingJframeShow=true;
               }


           }
       });

    }
}
