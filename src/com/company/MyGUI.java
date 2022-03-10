package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyGUI extends JFrame {
    private JPanel panel1;
    private JTextField importField;
    private JTextField exportField;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;

    public MyGUI() throws IOException {

        Calculation calc = new Calculation();
        Reading r = new Reading();
        Writing wr = new Writing();



        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calc.calculation(r.Reading(importField.getText()));
                    JOptionPane.showMessageDialog(null, "Файл загружен", "Чтение", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Файл не найден", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wr.Writing(calc, exportField.getText());
                    JOptionPane.showMessageDialog(null, "Файл сохранен", "Запись", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка в пути файла", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public JPanel getJPanel(){
        return  panel1;
    }

}
