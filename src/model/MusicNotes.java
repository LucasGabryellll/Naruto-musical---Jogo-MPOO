package model;

public class MusicNotes {
	private static MusicNote[] musicNote = new MusicNote[7];
	
	public static MusicNote[] startNotes(){
		musicNote[0] = new MusicNote(530, 520);
		musicNote[1] = new MusicNote(200, 50);
		musicNote[2] = new MusicNote(300, 120);
		musicNote[3] = new MusicNote(120, 400);
		musicNote[4] = new MusicNote(330, 220);
		musicNote[5] = new MusicNote(280, 420);
		musicNote[6] = new MusicNote(530, 230);
//		
		return musicNote;
	}

	public static MusicNote[] getMusicNote() {
		return musicNote;
	}
	
}
