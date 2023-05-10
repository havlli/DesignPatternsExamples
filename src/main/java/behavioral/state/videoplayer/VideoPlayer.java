package behavioral.state.videoplayer;

public class VideoPlayer {
    private VideoPlayerState currentState;

    public VideoPlayer() {
        currentState = new StoppedState(this);
    }

    public void setState(VideoPlayerState state) {
        currentState = state;
    }

    public void play() {
        currentState.play();
    }

    public void pause() {
        currentState.pause();
    }

    public void stop() {
        currentState.stop();
    }
}
