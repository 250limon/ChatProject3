package frames;

import manager.ResourceManager;
import panels.MainWindowPanel;

import javax.swing.*;
import java.awt.*;

//主窗口
public class MainWindow extends JFrame {
    private static MainWindow main_window=new MainWindow();
    private Container container;
    private int width;
    private int height;
    private int x;
    private int y;
    private JPanel mainWindow;//主要展示的面板




    private MainWindow()
    {
        container=getContentPane();

        width=1200;
        height=800;
        x=350;
        y=150;


        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(false);

        setTitle("聊天软件");
        setIconImage(ResourceManager.getInstance().getIcon("app_icon"));

        mainWindow=MainWindowPanel.getInstance();


        container.add(mainWindow);
        mainWindow.setBounds(0,0,width,height);











    }
    public static MainWindow getInstance()
    {
        return main_window;
    }





    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
