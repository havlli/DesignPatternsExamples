package behavioral.state.videoplayer;

public class PlayingState implements VideoPlayerState {

    private VideoPlayer videoPlayer;

    public PlayingState(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void play() {
        System.out.println("Video is already playing");
    }

    @Override
    public void pause() {
        System.out.println("Pausing video");
        videoPlayer.setState(new PausedState(videoPlayer));
    }

    @Override
    public void stop() {
        System.out.println("Stopping video");
        videoPlayer.setState(new StoppedState(videoPlayer));
    }
}
