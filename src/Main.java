import frames.LogInJFrame;
import frames.MainWindow;
import utils.Connector;

public class Main {
    public static void main(String[] args) {
        LogInJFrame.getInstance();
       MainWindow.getInstance();
        Connector.getInstance().connect();


    }
}
