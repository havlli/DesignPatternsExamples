package structural.bridge.avplayer;

// Concrete implementation
public class CustomMediaLibrary implements MediaLibrary {
    @Override
    public void playAudio(String media) {
        System.out.println("Playing audio " + media + " using custom library");
    }

    @Override
    public void playVideo(String media) {
        System.out.println("Playing video " + media + " using custom library");
    }
}
