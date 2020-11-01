package Lab_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class SimpleGUI extends JFrame {

    private JButton button = new JButton("Press");
    private JTextField inputFirstEl = new JTextField("", 2);
    private JTextField inputD = new JTextField("", 2);
    private JTextField inputNumbrOfElements = new JTextField("", 2);
    private JTextField inputNameOfFile = new JTextField("", 2);
    private JLabel label1 = new JLabel("Input first element:");
    private JLabel label2 = new JLabel("Input D:");
    private JLabel label3 = new JLabel("Input number of elements:");
    private JLabel label4 = new JLabel("Input name of file:");
    private JRadioButton radioLiner = new JRadioButton("Liner");
    private JRadioButton radioExp = new JRadioButton("Exponential");

    public SimpleGUI() {
        super("Series");
        this.setBounds(400,200,550,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,2,2,2));
        container.add(label1);
        container.add(inputFirstEl);
        container.add(label2);
        container.add(inputD);
        container.add(label3);
        container.add(inputNumbrOfElements);
        container.add(label4);
        container.add(inputNameOfFile);

        ButtonGroup group = new ButtonGroup();
        group.add(radioLiner);
        group.add(radioExp);
        container.add(radioLiner);

        radioLiner.setSelected(true);
        container.add(radioExp);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double first_el = Double.parseDouble(inputFirstEl.getText());
            double D = Double.parseDouble(inputD.getText());
            int num_of_elements = Integer.parseInt(inputNumbrOfElements.getText());
            String name_of_file = inputNameOfFile.getText();
            Series series;
            if(radioLiner.isSelected()){
                series = new Liner(first_el, D, num_of_elements);
            } else {
                series = new Exponential(first_el, D, num_of_elements);
            }
            String message = series.toString();
            try {
                series.save(name_of_file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
