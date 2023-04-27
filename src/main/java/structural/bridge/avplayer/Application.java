package structural.bridge.avplayer;

// Client
public class Application {

    public static void main(String[] args) {
        MediaLibrary vlcLibrary = new VLCMediaLibrary();
        MediaPlayer videoPlayer = new VideoPlayer(vlcLibrary);
        videoPlayer.play("MovieX");

        MediaPlayer audioPlayer = new AudioPlayer(vlcLibrary);
        audioPlayer.play("SongX");

        MediaLibrary customLibrary = new CustomMediaLibrary();
        videoPlayer = new VideoPlayer(customLibrary);
        videoPlayer.play("MovieY");

        audioPlayer = new AudioPlayer(customLibrary);
        audioPlayer.play("SongY");
    }
}
