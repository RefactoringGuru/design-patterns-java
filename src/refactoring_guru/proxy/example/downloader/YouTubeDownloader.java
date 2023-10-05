package refactoring_guru.proxy.example.downloader;

import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYouTubeLib;
import refactoring_guru.proxy.example.some_cool_media_library.Video;

import java.util.Map;

public class YouTubeDownloader {
  private final ThirdPartyYouTubeLib api;
  private final Renderer renderer;

  public YouTubeDownloader(ThirdPartyYouTubeLib api, Renderer renderer) {
    this.api = api;
    this.renderer = renderer;
  }

  public void renderVideoPage(String videoId) {
    Video video = api.getVideo(videoId);
    if (video != null) {
      renderer.renderVideo(video);
    } else {
      throw new IllegalArgumentException("No more videos ");
    }
  }

  public void renderPopularVideos() {
    Map<String, Video> list = api.popularVideos();
    if (list != null && !list.isEmpty()) {
      renderer.renderPopularVideos(list);
    } else {
      throw new IllegalArgumentException("The List is empty ");
    }
  }
}
