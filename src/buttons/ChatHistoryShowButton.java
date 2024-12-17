package buttons;

import manager.AnimationManager;
import panels.main_window_panels.ChatHistoryPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//查看消息按钮
public class ChatHistoryShowButton extends Button {
    private boolean isChatHistoryShow=false;
    public ChatHistoryShowButton()
    {
        setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isChatHistoryShow)
                {

                    AnimationManager.getInstance().jpanelRightMoveTo(ChatHistoryPanel.getInstance(),50,5);
                    isChatHistoryShow=true;
                    AnimationManager.getInstance().changeCenterJPanelWidth(-1);
                    AnimationManager.getInstance().changeJPanelTitleWidth(-1);

                }
                else {
                    AnimationManager.getInstance().jpanelLeftMoveTo(ChatHistoryPanel.getInstance(),-300,5);
                    isChatHistoryShow=false;
                    AnimationManager.getInstance().changeCenterJPanelWidth(1);
                    AnimationManager.getInstance().changeJPanelTitleWidth(1);
                }
            }
        });
    }
}
