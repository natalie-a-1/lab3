import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	private static final int EXPAND_THRESHOLD = 4;
	private int expandBy = 2;
	private int expandFrequency = 0;

	Playlist() {
		numSongs = 0;
		songs = new Song[MIN_CAPACITY];
	}

	Playlist(int capacity) {
		numSongs = 0;
		if (capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		} else {
			songs = new Song[capacity];
		}
	}

	public int getCapacity() {
		return songs.length;
	}

	public int getNumSongs() {
		return numSongs;
	}

	public Song getSong(int index) {
		if (index < 0 || index > (numSongs - 1)) {
			return null;
		} else {
			return songs[index];
		}
	}

	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}

	public void expand() {
		if (expandFrequency < EXPAND_THRESHOLD) {
			songs = Arrays.copyOf(songs, (numSongs + expandBy));
			expandFrequency++;
		} else {
			expandBy = (2 * expandBy);
			songs = Arrays.copyOf(songs, (numSongs + expandBy));
			expandFrequency++;
		}
	}

	public boolean addSong(int index, Song song) {
		boolean song_added = false;
		if (index < 0 || index > numSongs || song == null) {
			song_added = false;
		} else {
			
			if (numSongs == songs.length) {
				expand();
			}
			for (int i = numSongs-1; i >= index; i--) {
				songs[i + 1] = songs[i];
			}
			songs[index] = song;
			numSongs++;
			song_added = true;
		}
		return song_added;
	}

	public int addSongs(Playlist playlist) {

		if (playlist == null || playlist.getNumSongs() == 0) {
			return 0;
		} else {
			int count = playlist.getNumSongs();
			for (int i = 0; i < count; i++)
				this.addSong(playlist.getSong(i));
			return count;
		}
	}

	public boolean addSong(Song song) {
		return addSong(numSongs, song);
	}

	public Song removeSong() {
		return removeSong(numSongs -1);
	}

	public Song removeSong(int index) {
		if (index >= numSongs || index < 0) {
			return null;
		}
		Song rid = songs[index];
		for (int i = index; i < numSongs -1 ; ++i) {
			songs[i] = songs[i + 1];
		}
		songs[numSongs-1] = null;
		--numSongs;
		return rid;
	}
}
