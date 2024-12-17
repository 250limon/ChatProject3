package panels.main_window_panels;

import javax.swing.*;
import java.awt.*;

public class ToolsPanel extends JPanel {
    private static ToolsPanel toolsPanel=new ToolsPanel();
    private ToolsPanel()
    {
        setBackground(Color.ORANGE);

    }
    public static ToolsPanel getInstance()
    {
        return toolsPanel;
    }
}
