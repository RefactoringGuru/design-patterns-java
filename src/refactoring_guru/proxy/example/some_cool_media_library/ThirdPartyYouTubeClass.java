package refactoring_guru.proxy.example.some_cool_media_library;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

  private static final Logger LOGGER = Logger.getLogger(ThirdPartyYouTubeClass.class.getName());

  @Override
  public Map<String, Video> popularVideos() {
    connectToServer("http://www.youtube.com");
    return fetchPopularVideos();
  }

  @Override
  public Video getVideo(String videoId) {
    connectToServer("http://www.youtube.com/" + videoId);
    return fetchVideo(videoId);
  }

  private void connectToServer(String server) {
    LOGGER.info("Connecting to " + server + "... ");
    LOGGER.info("Connected!" + "\n");
  }

  private Map<String, Video> fetchPopularVideos() {
    LOGGER.info("Downloading popular videos... ");
    Map<String, Video> videoMap = new HashMap<>();
    videoMap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
    LOGGER.info("Done!" + "\n");
    return videoMap;
  }

  private Video fetchVideo(String videoId) {
    LOGGER.info("Downloading video... ");
    Video video = new Video(videoId, "Some video title");
    LOGGER.info("Done!" + "\n");
    return video;
  }
}
