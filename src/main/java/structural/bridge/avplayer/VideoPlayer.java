package structural.bridge.avplayer;

// Refined abstraction
public class VideoPlayer extends MediaPlayer {
    public VideoPlayer(MediaLibrary mediaLibrary) {
        super(mediaLibrary);
    }

    @Override
    public void play(String media) {
        mediaLibrary.playVideo(media);
    }
}
