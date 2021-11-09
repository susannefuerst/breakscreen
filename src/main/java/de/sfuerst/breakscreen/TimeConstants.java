package main.java.de.sfuerst.breakscreen;

public class TimeConstants {
	
	// only configure these two
	public static final long WORKING_MINUTES = 30;
	public static final long BREAK_MINUTES = 10;
	
	public static final long DELAY_BEFORE_LOCK_IN_SEC = WORKING_MINUTES * 60; // seconds
	public static final long DELAY_BEFORE_LOCK = DELAY_BEFORE_LOCK_IN_SEC * 100;
	public static final long DELAY_BEFORE_UNLOCK_IN_SEC = BREAK_MINUTES * 60; // seconds
	public static final long DELAY_BEFORE_UNLOCK = DELAY_BEFORE_UNLOCK_IN_SEC * 100;

}
