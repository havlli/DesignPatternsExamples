package behavioral.state.videoplayer;

public class PausedState implements VideoPlayerState {

    private VideoPlayer videoPlayer;

    public PausedState(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void play() {
        System.out.println("Playing video!");
        videoPlayer.setState(new PlayingState(videoPlayer));
    }

    @Override
    public void pause() {
        System.out.println("Video is already paused!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping video!");
        videoPlayer.setState(new StoppedState(videoPlayer));
    }
}
