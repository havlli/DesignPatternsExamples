package structural.bridge.avplayer;

// Concrete implementation
public class VLCMediaLibrary implements MediaLibrary {
    @Override
    public void playAudio(String media) {
        System.out.println("Playing audio " + media + " using VLC");
    }

    @Override
    public void playVideo(String media) {
        System.out.println("Playing video " + media + " using VLC");
    }
}
