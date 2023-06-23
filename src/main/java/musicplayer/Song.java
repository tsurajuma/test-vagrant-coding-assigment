package musicplayer;

public class Song {
	private String songName;
	private Song previousSong;
	private Song nextSong;

	public Song(String songName) {
		this.songName = songName;
	}

	public String getSongName() {
		return songName;
	}

	public Song getPreviousSong() {
		return previousSong;
	}

	public void setPreviousSong(Song previousSong) {
		this.previousSong = previousSong;
	}

	public Song getNextSong() {
		return nextSong;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}
}
