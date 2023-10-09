package refactoring_guru.proxy.example.some_cool_media_library;

import java.util.Map;

public interface ThirdPartyYouTubeLib {
  Map<String, Video> popularVideos();

  Video getVideo(String videoId);
}
