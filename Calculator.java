package lab12_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class Main {
        public static void main(String[] args) {
            JFrame jFrame = new JFrame("Kalkulator");
            jFrame.setSize(400,400);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setLayout(new BorderLayout());


            JLabel liczba = new JLabel("");
            JLabel znak = new JLabel("");
            JLabel liczenie = new JLabel("");
            JLabel liczenieGora= new JLabel("");

            JButton zero =new JButton("0");
            JButton raz =new JButton("1");
            JButton dwa =new JButton("2");
            JButton trzy =new JButton("3");
            JButton cztery =new JButton("4");
            JButton pięc =new JButton("5");
            JButton szesc =new JButton("6");
            JButton siedem =new JButton("7");
            JButton osiem =new JButton("8");
            JButton dziewienc =new JButton("9");

            JButton krpka = new JButton(".");
            JButton c =new JButton("C");
            JButton plus =new JButton("+");
            JButton minus =new JButton("-");
            JButton mnozenie =new JButton("*");
            JButton dzielenie =new JButton("/");
            JButton wynik =new JButton("=");

            JPanel gora = new JPanel();
            JPanel cyfry = new JPanel();
            JPanel reszta = new JPanel();
            cyfry.setLayout(new GridLayout(4,4));
            reszta.setLayout(new GridLayout(5,1));
            reszta.setPreferredSize(new Dimension(100,50));
            gora.setLayout(new BorderLayout());
            gora.setPreferredSize(new Dimension(200,20));

            cyfry.add(siedem);
            cyfry.add(osiem);
            cyfry.add(dziewienc);
            cyfry.add(cztery);
            cyfry.add(pięc);
            cyfry.add(szesc);
            cyfry.add(raz);
            cyfry.add(dwa);
            cyfry.add(trzy);
            cyfry.add(zero);
            cyfry.add(krpka);
            cyfry.add(wynik);

            reszta.add(c);
            reszta.add(dzielenie);
            reszta.add(mnozenie);
            reszta.add(minus);
            reszta.add(plus);

            gora.add(liczenie,BorderLayout.CENTER);
            gora.add(liczenieGora,BorderLayout.NORTH);
            gora.setPreferredSize(new Dimension(400,80));

            zero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"0");
                }
            });

            raz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"1");
                }
            });

            dwa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"2");
                }
            });

            trzy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"3");
                }
            });

            cztery.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"4");
                }
            });

            pięc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"5");
                }
            });

            szesc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"6");
                }
            });

            siedem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"7");
                }
            });

            osiem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"8");
                }
            });

            dziewienc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"9");
                }
            });

            krpka.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+".");
                }
            });

            c.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    liczenieGora.setText(String.valueOf(liczenie.getText()));
                    liczenie.setText("");
                }
            });

            plus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"+");
                    znak.setText("+");
                }
            });

            minus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"-");
                    znak.setText("-");
                }
            });


            dzielenie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"/");
                    znak.setText("/");
                }
            });

            mnozenie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    liczenie.setText(old+"*");
                    znak.setText("*");
                }
            });

            wynik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String old=liczenie.getText();
                    Double wynik =0.0;
                    System.out.println((old.split("[+,-,/,*]")[0]));
                    System.out.println((old.split("[+,-,/,*]")[1]));

                        if (znak.getText().equals("+")){
                            wynik =Double.parseDouble(old.split("[+,-,/,*]")[0]) + (Double.parseDouble(old.split("[+,-,/,*]")[1]));
                        }else if (znak.getText().equals("-")){
                            wynik =Double.parseDouble(old.split("[+,-,/,*]")[0]) - Double.parseDouble(old.split("[+,-,/,*]")[1]);
                        }else if (znak.getText().equals("/")){
                            wynik = Double.parseDouble(old.split("[+,-,/,*]")[0]) / Double.parseDouble(old.split("[+,-,/,*]")[1]);
                        }else if (znak.getText().equals("*")){
                            wynik = Double.parseDouble(old.split("[+,-,/,*]")[0]) * Double.parseDouble(old.split("[+,-,/,*]")[1]);
                        }
                    liczenieGora.setText(old);
                    liczenie.setText(String.valueOf(wynik));
                    }
            });

            jFrame.add(gora,BorderLayout.NORTH);
            jFrame.add(cyfry,BorderLayout.CENTER);
            jFrame.add(reszta,BorderLayout.EAST);
            jFrame.setVisible(true);
        }
    }
