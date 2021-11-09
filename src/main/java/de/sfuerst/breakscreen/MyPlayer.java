package main.java.de.sfuerst.breakscreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;


public class MyPlayer {

	public static String[] trackList = new File(Options.PLAY_LIST.getPath()).list();
	public static final int TOTAL_TRACKS = trackList.length;
	public static int trackCount = 0;
	public Player player;
	
	public void playNext() {
		try {
			String filePath = Options.PLAY_LIST.getPath() + "/" + trackList[trackCount];
			InputStream track = new FileInputStream(filePath);
			player = new Player(track);
			player.play();
			trackCount = (trackCount+1) % TOTAL_TRACKS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		player.close();
	}

}
