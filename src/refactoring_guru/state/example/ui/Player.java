package refactoring_guru.state.example.ui;

import refactoring_guru.state.example.states.ReadyState;
import refactoring_guru.state.example.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private static final String PLAY = "Playing ";
  private State state;
  private boolean playing = false;
  private final List<String> playlist = new ArrayList<>();
  private int currentTrack = 0;

  public Player() {
    this.state = new ReadyState(this);
    setPlaying(true);
    for (int i = 1; i <= 12; i++) {
      playlist.add("Track " + i);
    }
  }

  public void changeState(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }

  public boolean isPlaying() {
    return playing;
  }

  public String startPlayback() {
    return PLAY + playlist.get(currentTrack);
  }

  public String nextTrack() {
    currentTrack++;
    if (currentTrack > playlist.size() - 1) {
      currentTrack = 0;
    }
    return PLAY + playlist.get(currentTrack);
  }

  public String previousTrack() {
    currentTrack--;
    if (currentTrack < 0) {
      currentTrack = playlist.size() - 1;
    }
    return PLAY + playlist.get(currentTrack);
  }

  public void setCurrentTrackAfterStop() {
    this.currentTrack = 0;
  }
}
