package Lab_6.Task_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowApp_2 extends JFrame {
    private final JLabel questionLabel = new JLabel();
    private final JLabel answerLabel = new JLabel();
    private final JButton btn1 = new JButton("Нет");
    private final JButton btn2 = new JButton("Нет, но...");
    private final JPanel panel = new JPanel();
    public WindowApp_2(){
        this.setBounds(300,150,600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Container container = this.getContentPane();
        container.add(panel);
        panel.setLayout(null);

        questionLabel.setText("Вас устраивает размер стипендии?");
        questionLabel.setBounds(50, 15, 400, 20);
        answerLabel.setBounds(50, 60, 300, 20);
        btn1.setBounds(100, 100,60, 35);
        btn2.setBounds(400, 100,100, 35);
        panel.add(questionLabel);
        panel.add(answerLabel);
        panel.add(btn1);
        panel.add(btn2);

        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                answerLabel.setText("Радуйтесь, что она у вас вообще есть!");
                btn1.setEnabled(false);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            int R, Ox, Oy, dist;
            @Override
            public void mouseMoved(MouseEvent e) {
                R = (int)(btn2.getWidth()*1.1);
                Ox = btn2.getLocation().x + (btn2.getWidth()/2);    //Абсцисса середины кнопки на окне
                Oy = btn2.getLocation().y + (btn2.getHeight()/2);   //Ордината середины кнопки на окне
                dist = (int)(Math.sqrt(Math.pow(e.getX() - Ox, 2) + Math.pow(e.getY() - Oy, 2)));
                if (dist < R)
                    move(e);
            }

            private void move(MouseEvent e){
                int dx = R - dist;
                int dy = R - dist;
                if (e.getX() > Ox)
                    dx*=(-1);
                if (e.getY()> Oy)
                    dy*=(-1);
                if(dx > 0){
                    if(Ox + btn2.getWidth()/2 + dx < getWidth())
                        btn2.setLocation(btn2.getLocation().x + dx, btn2.getLocation().y);
                    else
                        btn2.setLocation(10, btn2.getLocation().y);
                }
                if(dy > 0){
                    if(Oy + btn2.getHeight()/2 + dy < getHeight())
                        btn2.setLocation(btn2.getLocation().x, btn2.getLocation().y + dy);
                    else
                        btn2.setLocation(btn2.getLocation().x, 10);
                }
                if(dx < 0){
                    if(Ox - btn2.getWidth()/2 > (-1)*dx)
                        btn2.setLocation(btn2.getLocation().x + dx, btn2.getLocation().y);
                    else
                        btn2.setLocation(getWidth() - btn2.getWidth() - 10, btn2.getLocation().y);
                }
                if(dy < 0){
                    if(Oy - btn2.getHeight()/2 > (-1)*dy)
                        btn2.setLocation(btn2.getLocation().x, btn2.getLocation().y + dy);
                    else
                        btn2.setLocation(btn2.getLocation().x, getHeight() - btn2.getHeight() - 10);
                }
            }
        });
    }
}
