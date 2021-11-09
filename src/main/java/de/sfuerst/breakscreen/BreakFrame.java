package main.java.de.sfuerst.breakscreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import javazoom.jl.player.Player;

@SuppressWarnings("serial")
public class BreakFrame extends JFrame {
	private static long counter = TimeConstants.DELAY_BEFORE_LOCK_IN_SEC;
	private static long minutes = TimeConstants.WORKING_MINUTES;
	private static long seconds = 0;
	private static boolean justWorking = true;
	
	private static Timer timer;
	private static JLabel label;
	
	private MyPlayer player = new MyPlayer();
	
	

	public BreakFrame() {
		setSize(getMaximumSize());
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initLabel();
		getContentPane().add(label, BorderLayout.CENTER);
		pack();
		setVisible(true);
		maximize();
//		minimize();
	}

	private void initLabel() {
		label = new JLabel();
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 200));
	}

	public void minimize() {
		setExtendedState(JFrame.ICONIFIED);
		pack();
		setVisible(true);
	}

	public void maximize() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void lock() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		maximize();
		toFront();
		requestFocus(true);
		setAlwaysOnTop(true);
		setEnabled(false);
	}

	public void unlock() {
		setEnabled(true);
		setAlwaysOnTop(false);
		requestFocus(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		minimize();
	}

	public void performSingleWorkAndBreakCycle() {
		// create timer and execute method actionPerformed all 1000 millisec (= 1 sec)
		label.setText(format(minutes, seconds));
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				counter--;
				if (seconds == 0) {
					seconds = 59;
					minutes--;
				} else {
					seconds--;
				}
				// update label
				BreakFrame.label.setText(format(minutes, seconds));
				if (counter == 0 && justWorking) {
					justWorking = false;
					counter = TimeConstants.DELAY_BEFORE_UNLOCK_IN_SEC;
					minutes = TimeConstants.BREAK_MINUTES;
					seconds = 0;
					lock();
					if (Options.PLAY_MUSIK) {
						new Thread() {
							@Override
							public void run() {
								player.playNext();
							}
						}.start();
					}
				}
				if (counter == 0 && !justWorking) {
					justWorking = true;
					counter = TimeConstants.DELAY_BEFORE_LOCK_IN_SEC;
					minutes = TimeConstants.WORKING_MINUTES;
					seconds = 0;
					unlock();
					if (Options.PLAY_MUSIK) {
						player.stop();
					}
				}
			}
		});
		timer.start();
		
	}

	private String format(long min, long sec) {
		String minString;
		if (min < 10) {
			minString = "0" + String.valueOf(min);
		} else {
			minString = String.valueOf(min);
		}
		String secString;
		if (sec < 10) {
			secString = "0" + String.valueOf(sec);
		} else {
			secString = String.valueOf(sec);
		}
		return minString + ":" + secString;
	}

	public static void main(String[] args) {
		BreakFrame frame = new BreakFrame();
		frame.performSingleWorkAndBreakCycle();
	}

}