package structural.bridge.avplayer;

// Abstraction
public abstract class MediaPlayer {
    protected MediaLibrary mediaLibrary;

    public MediaPlayer(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public abstract void play(String media);
}
