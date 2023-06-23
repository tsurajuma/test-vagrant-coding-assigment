package musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedSongListImplementation implements RecentlyPlayedSongListInterface {
	private int capacity;
	private Map<String, Map<String, Song>> userSongs;
	private Song firstSongInPlaylist;
	private Song lastSongInPlaylist;

	public RecentlyPlayedSongListImplementation(int capacity) {
		this.capacity = capacity;
		this.userSongs = new HashMap<>();
		this.firstSongInPlaylist = null;
		this.lastSongInPlaylist = null;
	}

	@Override
	public void playSong(String user, String songName) {
		if (!userSongs.containsKey(user)) {
			userSongs.put(user, new HashMap<>());
		}

		Map<String, Song> songs = userSongs.get(user);

		if (songs.containsKey(songName)) {
			updateSongPosition(user, songName);
		} else {
			addNewSong(user, songName);
		}

		if (songs.size() > capacity) {
			removeLeastRecentlyPlayedSong(user);
		}
	}

	@Override
	public List<String> getRecentlyPlayedSongsList(String user) {
		if (!userSongs.containsKey(user)) {
			return Collections.emptyList();
		}

		List<String> songs = new ArrayList<>();
		Song currentSong = firstSongInPlaylist;

		while (currentSong != null) {
			songs.add(currentSong.getSongName());
			currentSong = currentSong.getNextSong();
		}

		return songs;
	}

	private void updateSongPosition(String user, String songName) {
		Song currentSong = userSongs.get(user).get(songName);
		removeSong(currentSong);
		addSongToFront(currentSong);
	}

	private void addNewSong(String user, String songName) {
		Song newSong = new Song(songName);
		userSongs.get(user).put(songName, newSong);
		addSongToFront(newSong);
	}

	private void removeLeastRecentlyPlayedSong(String user) {
		Song leastRecentSong = lastSongInPlaylist;
		userSongs.get(user).remove(leastRecentSong.getSongName());
		removeSong(leastRecentSong);
	}

	private void addSongToFront(Song song) {
		if (firstSongInPlaylist == null) {
			firstSongInPlaylist = song;
			lastSongInPlaylist = song;
		} else {
			song.setNextSong(firstSongInPlaylist);
			firstSongInPlaylist.setPreviousSong(song);
			firstSongInPlaylist = song;
		}
	}

	private void removeSong(Song song) {
		if (song.getPreviousSong() != null) {
			song.getPreviousSong().setNextSong(song.getNextSong());
		} else {
			firstSongInPlaylist = song.getNextSong();
		}

		if (song.getNextSong() != null) {
			song.getNextSong().setPreviousSong(song.getPreviousSong());
		} else {
			lastSongInPlaylist = song.getPreviousSong();
		}
	}

}
