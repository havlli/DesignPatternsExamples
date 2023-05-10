package behavioral.state.videoplayer;

public class Client {
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new VideoPlayer();

        videoPlayer.play();
        videoPlayer.stop();
        videoPlayer.pause();
        videoPlayer.stop();
        videoPlayer.play();
    }
}
