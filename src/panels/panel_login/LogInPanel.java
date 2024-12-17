package panels.panel_login;

import buttons.LogInButton;
import buttons.RegisterButton;

import javax.swing.*;
import java.awt.*;

public class LogInPanel extends JPanel {
    private static LogInPanel logInPanel=new LogInPanel();
    TextField inputId=new TextField();
    TextField inputPassword=new TextField();
    private LogInPanel()
    {

        setLayout(null);
        addButton();
        inputId=new TextField();
        inputPassword=new TextField();
        add(inputId);
        inputId.setBounds(100,200,400,30);
        add(inputPassword);
        inputPassword.setBounds(100,300,400,30);

    }
    public static LogInPanel getInstance()
    {

        return logInPanel;
    }
    public void addButton()
    {
        LogInButton logInButton=new LogInButton("登录");
        add(logInButton);
        logInButton.setBounds(50,500,50,25);

        RegisterButton registerButton=new RegisterButton("注册");
        add(registerButton);
        registerButton.setBounds(200,500,50,25);
    }
    public String getUserName()
    {
        return inputId.getText();
    }
    public String getUserPassword()
    {
        return inputPassword.getText();
    }
}
