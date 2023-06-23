package musicplayer;

import java.util.List;

public interface RecentlyPlayedSongListInterface {
	void playSong(String user, String songName);

	List<String> getRecentlyPlayedSongsList(String user);
}
