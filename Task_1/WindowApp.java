package Lab_6.Task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowApp extends JFrame {

    private final JLabel statusLabel = new JLabel();
    private final JPanel centerPanel = new JPanel();
    private final JPanel southPanel = new JPanel();
    private final JButton button = new JButton("Click");

    public WindowApp(){

        this.setBounds(400,200,500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 300));
        button.setBounds(200, 50,100, 40);
        statusLabel.setText("");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        centerPanel.setLayout(null);

        centerPanel.add(button);
        southPanel.add(statusLabel);
        add(BorderLayout.SOUTH, southPanel);
        add(BorderLayout.CENTER, centerPanel);

        addMouseMotionListener(new MouseAdapter() {
            public void setState(){
                int x;
                int y;
                if (centerPanel.getMousePosition()==null){
                    x = southPanel.getMousePosition().x;
                    y = southPanel.getMousePosition().y + centerPanel.getHeight();

                } else {
                    x = centerPanel.getMousePosition().x;
                    y = centerPanel.getMousePosition().y;
                }StringBuffer sb = new StringBuffer("x: ");
                sb.append(x);
                sb.append(" y: ");
                sb.append(y);
                statusLabel.setText(sb.toString());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                setState();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                setState();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBounds(centerPanel.getMousePosition().x - button.getWidth()/2, centerPanel.getMousePosition().y - button.getHeight()/2, button.getWidth(), button.getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusLabel.setText("");
            }
        });

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                StringBuffer sb = new StringBuffer("x: ");
                sb.append(e.getXOnScreen() - centerPanel.getLocationOnScreen().x);
                sb.append(" y: ");
                sb.append(e.getYOnScreen() - centerPanel.getLocationOnScreen().y);
                statusLabel.setText(sb.toString());
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                int startX = centerPanel.getLocationOnScreen().x;
                int startY = centerPanel.getLocationOnScreen().y;
                if (e.isControlDown()){
                    button.setLocation(e.getXOnScreen() - startX, e.getYOnScreen() - startY);
                }
                StringBuffer sb = new StringBuffer("x: ");
                sb.append(e.getXOnScreen() - startX);
                sb.append(" y: ");
                sb.append(e.getYOnScreen() - startY);
                statusLabel.setText(sb.toString());
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (button.getText().length() > 0){
                     button.setText(button.getText().substring(0, button.getText().length() - 1));
                    }
                } else
                    button.setText(button.getText() + e.getKeyChar());
            }
        });
    }
}
