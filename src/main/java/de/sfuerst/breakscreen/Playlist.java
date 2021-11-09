package main.java.de.sfuerst.breakscreen;

public enum Playlist {
	DISTURBED("/home/susanne/Musik/disturbed/"),
	HINDER("/home/susanne/Musik/hinder/"),
	NIRVANA("/home/susanne/Musik/nirvana/"),
	OFFSPRING("/home/susanne/Musik/offspring/"),
	ADELTAWIL("/home/susanne/Musik/adeltawil/alleslebt/"),
	LEA_TREPPENHAUS("/home/susanne/Musik/lea/treppenhaus"),
	LEA_ZEILEN("/home/susanne/Musik/lea/zwischen_meinen_zeilen"),
	LOTTE("/home/susanne/Musik/lotte/glueck"),
	REVOLVERHELD("/home/susanne/Musik/revolverheld/zimmer_mit_blick"),
	NOAH("/home/susanne/Musik/noahcyrus/the_end_of_everything");
	
	private final String path;

	Playlist(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	

}
