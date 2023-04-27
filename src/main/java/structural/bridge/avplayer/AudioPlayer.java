package structural.bridge.avplayer;

// Refined abstraction
public class AudioPlayer extends MediaPlayer {
    public AudioPlayer(MediaLibrary mediaLibrary) {
        super(mediaLibrary);
    }

    @Override
    public void play(String media) {
        mediaLibrary.playAudio(media);
    }
}
