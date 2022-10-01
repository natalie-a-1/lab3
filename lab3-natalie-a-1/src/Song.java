import java.util.Arrays;

public class Song {
	private String title;
	private String artist;
	private int[] duration;

	public Song(String title, String artist, int[] duration) {
		this.title = title;
		this.artist = artist;
		this.duration = Arrays.copyOf(duration, duration.length);
	}

	public String getTitle() {
		return title;
	}	

	public String getArtist() {
		return artist;
	}

	public int[] getDuration() {
		return Arrays.copyOf(duration, duration.length);
	}

}
