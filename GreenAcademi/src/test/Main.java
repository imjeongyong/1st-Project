package test;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); // creates a frame
		frame.setTitle("JFrame title goes here"); // set title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false); // prevent frame from being resized
		frame.setSize(420, 420); // sets the x-dimension, and y-dimension of frame
		frame.setVisible(true); // make frame visible

		ImageIcon image = new ImageIcon("balsamiq wireframes.png"); // create an ImageIcon
		frame.setIconImage(image.getImage()); //change icon of frame
		frame.getContentPane().setBackground(new Color(125, 50, 250)); // change color of background
	}
}