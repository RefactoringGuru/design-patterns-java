package refactoring_guru.proxy.example.proxy;

import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYouTubeClass;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYouTubeLib;
import refactoring_guru.proxy.example.some_cool_media_library.Video;

import java.util.HashMap;
import java.util.Map;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
  private final ThirdPartyYouTubeLib youtubeService;
  private final Map<String, Video> cachePopular = new HashMap<>();
  private final Map<String, Video> cacheAll = new HashMap<>();

  public YouTubeCacheProxy() {
    this.youtubeService = new ThirdPartyYouTubeClass();
  }

  @Override
  public Map<String, Video> popularVideos() {
    return cachePopular.isEmpty() ? youtubeService.popularVideos() : logAndReturn(cachePopular);
  }

  @Override
  public Video getVideo(String videoId) {
    return cacheAll.computeIfAbsent(videoId, key -> {
      System.out.println("Fetching video '" + key + "' from YouTube service.");
      return youtubeService.getVideo(key);
    });
  }

  private <T> T logAndReturn(T result) {
    System.out.println("Retrieved a list from cache.");
    return result;
  }
}
