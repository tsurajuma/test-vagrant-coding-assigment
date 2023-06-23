package tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import musicplayer.RecentlyPlayedSongListImplementation;

public class RecentlyPlayedSongListTest {

	private RecentlyPlayedSongListImplementation musicPlayer;

	@BeforeTest
	public void setUp() {
		int recentlyPlayedSongListCapacity = 3;
		musicPlayer = new RecentlyPlayedSongListImplementation(recentlyPlayedSongListCapacity);
	}

	@Test(priority = 1)
	public void testPlaySong() {

		// Play Song1 for User1
		musicPlayer.playSong("User1", "Song1");
		Assert.assertEquals(List.of("Song1"), musicPlayer.getRecentlyPlayedSongsList("User1"));

		// Play Song2 for User1
		musicPlayer.playSong("User1", "Song2");
		Assert.assertEquals(List.of("Song2", "Song1"), musicPlayer.getRecentlyPlayedSongsList("User1"));

		// Play Song3 for User1
		musicPlayer.playSong("User1", "Song3");
		Assert.assertEquals(List.of("Song3", "Song2", "Song1"), musicPlayer.getRecentlyPlayedSongsList("User1"));

		// Play Song4 for User1
		musicPlayer.playSong("User1", "Song4");
		Assert.assertEquals(List.of("Song4", "Song3", "Song2"), musicPlayer.getRecentlyPlayedSongsList("User1"));

		// Play Song2 for User1
		musicPlayer.playSong("User1", "Song2");
		Assert.assertEquals(List.of("Song2", "Song4", "Song3"), musicPlayer.getRecentlyPlayedSongsList("User1"));

		// Play Song1 for User1
		musicPlayer.playSong("User1", "Song1");
		Assert.assertEquals(List.of("Song1", "Song2", "Song4"), musicPlayer.getRecentlyPlayedSongsList("User1"));

	}

	@Test(priority = 2)
	public void testGetRecentlyPlayedSongsForNonExistingUser() {

		// Play songs for a user
		musicPlayer.playSong("User1", "Song1");
		musicPlayer.playSong("User1", "Song2");

		// Get recently played songs for a non-existing user
		List<String> recentlyPlayedSongs = musicPlayer.getRecentlyPlayedSongsList("User2");

		// Verify that an empty list is returned
		Assert.assertTrue(recentlyPlayedSongs.isEmpty());
	}
}
