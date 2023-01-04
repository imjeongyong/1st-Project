package test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class ReserveSystemTest {
	
	static int count = 60;
	
	public static void main(String[] args) {
		LocalTime ct = LocalTime.now();
		Timer timer = new Timer();

		Frame f1 = new Frame();
		f1.setLayout(new FlowLayout());
		f1.setSize(300, 200);
		f1.setVisible(true);

		TextField currentTime = new TextField(10);
		currentTime.setText(ct.getHour() + ":" + ct.getMinute());

		Button enter = new Button("enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent areg0) {
				TimerTask task = new TimerTask() {
					public void run() {
						if(count <=60) {
							System.out.println("카운트다운"+count);
							count--;
						} else {
							timer.cancel();
							System.out.println("카운트 다운 종료");
						}
					}
				};
				timer.schedule(task, 1000, 1000);
			}
		});

		f1.add(currentTime);
		f1.add(enter);
	}

}