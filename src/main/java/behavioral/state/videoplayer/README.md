# Video Player
Video players can be modeled using the state pattern. The player can have different states, such as "playing", "paused", or "stopped". Depending on the current state, the player will behave differently when a user presses play, pause, or stop. By using the state pattern, it is easy to extend or modify the behavior of the video player.
```java
// State interface
interface VideoPlayerState {
    void play();
    void pause();
    void stop();
}

// Concrete state 1: Playing state
class PlayingState implements VideoPlayerState {
    private final VideoPlayer videoPlayer;
    
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

// Concrete state 2: Paused state
class PausedState implements VideoPlayerState {
    private final VideoPlayer videoPlayer;
    
    public PausedState(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }
    
    @Override
    public void play() {
        System.out.println("Resuming video");
        videoPlayer.setState(new PlayingState(videoPlayer));
    }
    
    @Override
    public void pause() {
        System.out.println("Video is already paused");
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping video");
        videoPlayer.setState(new StoppedState(videoPlayer));
    }
}

// Concrete state 3: Stopped state
class StoppedState implements VideoPlayerState {
    private final VideoPlayer videoPlayer;
    
    public StoppedState(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }
    
    @Override
    public void play() {
        System.out.println("Playing video");
        videoPlayer.setState(new PlayingState(videoPlayer));
    }
    
    @Override
    public void pause() {
        System.out.println("Video is stopped, cannot pause");
    }
    
    @Override
    public void stop() {
        System.out.println("Video is already stopped");
    }
}

// Context class: VideoPlayer
class VideoPlayer {
    private VideoPlayerState currentState;
    
    public VideoPlayer() {
        currentState = new StoppedState(this);
    }
    
    public void setState(VideoPlayerState state) {
        this.currentState = state;
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

// Usage
public class StatePatternDemo {
    public static void main(String[] args) {
        VideoPlayer player = new VideoPlayer();
        
        player.play();  // Playing video
        player.pause(); // Pausing video
        player.pause(); // Video is already paused
        player.play();  // Resuming video
        player.stop();  // Stopping video
        player.stop();  // Video is already stopped
        player.play();  // Playing video
    }
}
```
In the `VideoPlayer` class, we have a private `VideoPlayerState` variable called `currentState` that represents the current state of the video player. The class also has public methods `play()`, `pause()`, and `stop()` that delegate the request to the current state object.

We have defined three different state classes: `PlayingState`, `PausedState`, and `StoppedState`, each representing a different state of the video player. These state classes implement the `VideoPlayerState` interface and define their own behavior for the `play()`, `pause()`, and `stop()` methods.

When the video player is in the `PlayingState`, it will play the video and respond to the `pause()` and `stop()` methods as expected. Similarly, when the video player is in the `PausedState`, it will pause the video and respond to the `play()` and `stop()` methods as expected. And when the video player is in the `StoppedState`, it will stop the video and respond to the `play()` and `pause()` methods as expected.

This implementation makes it easy to add new states to the video player, such as a `FastForwardState` or a `RewindState`, without modifying the existing code. It also makes it easy to modify the behavior of the existing states, such as changing the way the video is paused or stopped.