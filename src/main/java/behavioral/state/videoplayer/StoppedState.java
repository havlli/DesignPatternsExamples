package behavioral.state.videoplayer;

public class StoppedState implements VideoPlayerState {
    private VideoPlayer videoPlayer;

    public StoppedState(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void play() {
        System.out.println("Playing video!");
        videoPlayer.setState(new PlayingState(videoPlayer));
    }

    @Override
    public void pause() {
        System.out.println("Video is stopped, cannot pause!");
    }

    @Override
    public void stop() {
        System.out.println("Video is already stopped!");
    }
}
