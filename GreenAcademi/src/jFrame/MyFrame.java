package jFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	MyFrame() {
		this.setTitle("JFrame title goes here"); // set title of this
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		this.setResizable(false); // prevent this from being resized
		this.setSize(420, 420); // sets the x-dimension, and y-dimension of this
		this.setVisible(true); // make this visible

		ImageIcon image = new ImageIcon("balsamiq wirethiss.png"); // create an ImageIcon, 파일위치는 자바프로젝트 폴더
		this.setIconImage(image.getImage()); // change icon of this
		this.getContentPane().setBackground(new Color(125, 50, 250)); // change color of background
	}
}