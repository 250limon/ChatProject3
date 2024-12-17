package panels.main_window_panels;

import javax.swing.*;
import java.awt.*;

public class UserDetailedInfo extends JPanel {
    private boolean isShow=false;
    private static UserDetailedInfo userDetailedInfo=new UserDetailedInfo();
    private UserDetailedInfo ()
    {
        setVisible(false);
        setBackground(Color.GREEN);










    }


    public static UserDetailedInfo getInstance()
    {
        return userDetailedInfo;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
