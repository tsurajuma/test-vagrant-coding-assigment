package musicplayer;

public class Main {

	 public static void main(String[] args) {
		 	int recentlyPlayedSongListCapacity = 3; 
	        RecentlyPlayedSongListInterface musicPlayer = new RecentlyPlayedSongListImplementation(recentlyPlayedSongListCapacity);

	        musicPlayer.playSong("User1", "Song1");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1")); 

	        musicPlayer.playSong("User1", "Song2");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1"));

	        musicPlayer.playSong("User1", "Song3");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1"));

	        musicPlayer.playSong("User1", "Song4");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1"));

	        musicPlayer.playSong("User1", "Song2");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1")); 

	        musicPlayer.playSong("User1", "Song1");
	        System.out.println(musicPlayer.getRecentlyPlayedSongsList("User1"));
	    }

}
