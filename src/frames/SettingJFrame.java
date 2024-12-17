package frames;

import buttons.SettingButton;

import javax.swing.*;
import java.awt.*;
//…Ë÷√ΩÁ√Ê
public class SettingJFrame extends JFrame {
    private static SettingJFrame settingJFrame=new SettingJFrame();
    private SettingJFrame()
    {

         setUndecorated(true);
         setBackground(new Color(0,0,0,255));
         setBounds(800,300,300,300);
         setLayout(null);
         setOpacity(0f);

         JLabel jLabel=new JLabel("");

         jLabel.setFont(new Font(Font.SERIF,Font.PLAIN,50));
         jLabel.setForeground(new Color(255,255,25));
         getContentPane().add(jLabel);
         jLabel.setBounds(10,10,300,100);
    }
    public static SettingJFrame getInstance()
    {
        return settingJFrame;
    }
}
