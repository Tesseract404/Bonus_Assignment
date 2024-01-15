package com.java.arnob;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class Buffer extends JFrame{
	JFrame frame;
	int i;
	Buffer buffer  = new Buffer();

	boolean bool = false;
	public synchronized void set  (int i) {
		while(bool) {
			try {
				wait();
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
		}
		this.i = i;
		bool = true;
		System.out.println("Producer"+i);
		notify();
	}
	public synchronized void get  () {
		while(! bool) {
			try {
				wait();
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
		}
	 
		bool = false;
		System.out.println("Consumer"+i);
		notify();
	}
	public Buffer() {
		frame = new JFrame();
		frame.setTitle(" ");
		frame.getContentPane().setBackground(new Color(219, 112, 147));
		frame.setBounds(350, 350, 576, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel StartPro = new JPanel();
		StartPro.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(StartPro);
		StartPro.setLayout(null);
		
		JPanel producer = new JPanel();
		producer.setBackground(SystemColor.activeCaption);
		producer.setBounds(22, 169, 144, 106);
		StartPro.add(producer);
		producer.setLayout(null);
		
		
		JButton Pbutton = new JButton("Start");
		Pbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Producer pr = new Producer (buffer );
		        pr.Start();
			}
		});
		Pbutton.setBounds(28, 72, 89, 23);
		producer.add(Pbutton);
		
		JLabel lblNewLabel_16 = new JLabel("Producer");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(28, 28, 89, 26);
		producer.add(lblNewLabel_16);
		
		JPanel consumer = new JPanel();
		consumer.setBackground(SystemColor.info);
		consumer.setBounds(392, 169, 144, 106);
		StartPro.add(consumer);
		consumer.setLayout(null);
		
		JButton Cbutton = new JButton("Start");
		Cbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Consumer co = new Consumer (buffer );
		        co.Start(); 
			}
		});
		Cbutton.setBounds(29, 72, 89, 23);
		consumer.add(Cbutton);
		
		JLabel lblNewLabel_16_1 = new JLabel("Consumer");
		lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16_1.setBounds(29, 23, 89, 26);
		consumer.add(lblNewLabel_16_1);
		
		JPanel feed = new JPanel();
		feed.setBounds(176, 112, 206, 226);
		StartPro.add(feed);
		feed.setLayout(null);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBackground(Color.BLACK);
		verticalStrut.setBounds(146, 11, -81, 130);
		feed.add(verticalStrut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY, 2));
		panel_1.setBounds(10, 11, 90, 204);
		feed.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblP1 = new JLabel(" ");
		lblP1.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1.setBackground(SystemColor.activeCaption);
		lblP1.setBounds(10, 179, 70, 14);
		panel_1.add(lblP1);
		
		JLabel lblP2 = new JLabel(" ");
		lblP2.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2.setBackground(SystemColor.activeCaption);
		lblP2.setBounds(10, 154, 70, 14);
		panel_1.add(lblP2);
		
		JLabel lblP3 = new JLabel(" ");
		lblP3.setHorizontalAlignment(SwingConstants.CENTER);
		lblP3.setBackground(SystemColor.activeCaption);
		lblP3.setBounds(10, 129, 70, 14);
		panel_1.add(lblP3);
		
		JLabel lblP4 = new JLabel(" ");
		lblP4.setHorizontalAlignment(SwingConstants.CENTER);
		lblP4.setBackground(SystemColor.activeCaption);
		lblP4.setBounds(10, 104, 70, 14);
		panel_1.add(lblP4);
		
		JLabel lblP5 = new JLabel(" ");
		lblP5.setHorizontalAlignment(SwingConstants.CENTER);
		lblP5.setBackground(SystemColor.activeCaption);
		lblP5.setBounds(10, 79, 70, 14);
		panel_1.add(lblP5);
		
		JLabel lblP6 = new JLabel(" ");
		lblP6.setHorizontalAlignment(SwingConstants.CENTER);
		lblP6.setBackground(SystemColor.activeCaption);
		lblP6.setBounds(10, 54, 70, 14);
		panel_1.add(lblP6);
		
		JLabel lblP7 = new JLabel(" ");
		lblP7.setHorizontalAlignment(SwingConstants.CENTER);
		lblP7.setBackground(SystemColor.activeCaption);
		lblP7.setBounds(10, 29, 70, 14);
		panel_1.add(lblP7);
		
		JLabel lblP8 = new JLabel(" ");
		lblP8.setHorizontalAlignment(SwingConstants.CENTER);
		lblP8.setBackground(SystemColor.activeCaption);
		lblP8.setBounds(10, 4, 70, 14);
		panel_1.add(lblP8);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.GRAY, 2));
		panel_1_1.setBounds(110, 11, 86, 204);
		feed.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblC1 = new JLabel(" ");
		lblC1.setHorizontalAlignment(SwingConstants.CENTER);
		lblC1.setBackground(SystemColor.activeCaption);
		lblC1.setBounds(10, 179, 70, 14);
		panel_1_1.add(lblC1);
		
		JLabel lblC2 = new JLabel(" ");
		lblC2.setHorizontalAlignment(SwingConstants.CENTER);
		lblC2.setBackground(SystemColor.activeCaption);
		lblC2.setBounds(10, 154, 70, 14);
		panel_1_1.add(lblC2);
		
		JLabel lblC3 = new JLabel(" ");
		lblC3.setHorizontalAlignment(SwingConstants.CENTER);
		lblC3.setBackground(SystemColor.activeCaption);
		lblC3.setBounds(10, 129, 70, 14);
		panel_1_1.add(lblC3);
		
		JLabel lblC4 = new JLabel(" ");
		lblC4.setHorizontalAlignment(SwingConstants.CENTER);
		lblC4.setBackground(SystemColor.activeCaption);
		lblC4.setBounds(10, 104, 70, 14);
		panel_1_1.add(lblC4);
		
		JLabel lblC5 = new JLabel(" ");
		lblC5.setHorizontalAlignment(SwingConstants.CENTER);
		lblC5.setBackground(SystemColor.activeCaption);
		lblC5.setBounds(10, 79, 70, 14);
		panel_1_1.add(lblC5);
		
		JLabel lblC6 = new JLabel(" ");
		lblC6.setHorizontalAlignment(SwingConstants.CENTER);
		lblC6.setBackground(SystemColor.activeCaption);
		lblC6.setBounds(10, 54, 70, 14);
		panel_1_1.add(lblC6);
		
		JLabel lblC7 = new JLabel(" ");
		lblC7.setHorizontalAlignment(SwingConstants.CENTER);
		lblC7.setBackground(SystemColor.activeCaption);
		lblC7.setBounds(10, 30, 70, 14);
		panel_1_1.add(lblC7);
		
		JLabel lblC8 = new JLabel(" ");
		lblC8.setHorizontalAlignment(SwingConstants.CENTER);
		lblC8.setBackground(SystemColor.activeCaption);
		lblC8.setBounds(10, 5, 70, 14);
		panel_1_1.add(lblC8);
		
		JLabel lblNewLabel_16_2 = new JLabel("Product");
		lblNewLabel_16_2.setForeground(SystemColor.window);
		lblNewLabel_16_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_16_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16_2.setBounds(235, 75, 89, 26);
		StartPro.add(lblNewLabel_16_2);
		
	}
	
	public static void main(String[] args) {
        Buffer buffer = new Buffer();
//        new Producer (bugger);
//        new Consumer (bugger);
        buffer.frame.setVisible(true);
        
	}
}
