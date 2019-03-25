package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondTask {

    public static void main(String[] args) {
        new Window();
    }

}

class Window extends JFrame {
    JLabel field = new JLabel("Ф.И.О.:");
    Window() {
        setTitle("Персональные данные");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,300,100);
        setResizable(false);

        add(field, BorderLayout.NORTH);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton button = new JButton("Заполнить данные");
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Window2(Window.this);
            }
        });

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class Window2 extends JFrame {
    Window2(Window w) {

        setTitle("Ввод данных");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(350,320,300,150);
        setResizable(false);

        JPanel panel2 = new JPanel(new GridLayout(4, 2));
        panel2.add(new JLabel("Фамилия"));
        JTextField textField1 = new JTextField();
        panel2.add(textField1);
        panel2.add(new JLabel("Имя"));
        JTextField textField2 = new JTextField();
        panel2.add(textField2);
        panel2.add(new JLabel("Отчество"));
        JTextField textField3 = new JTextField();
        panel2.add(textField3);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton button = new JButton("OK");
        panel3.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f = textField1.getText();
                String i = textField2.getText();
                String o = textField3.getText();
                w.field.setText("Ф.И.О.: "+f+" "+i+" "+o);
                setVisible(false);
            }
        });

        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.SOUTH);

        setVisible(true);
    }
}
