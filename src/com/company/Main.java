package com.company;


import javax.swing.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setContentPane(new MyGUI().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(300,200,490,270);
        frame.setVisible(true);
    }}