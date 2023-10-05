package refactoring_guru.proxy.example;

import refactoring_guru.proxy.example.downloader.Renderer;
import refactoring_guru.proxy.example.downloader.YouTubeDownloader;
import refactoring_guru.proxy.example.proxy.YouTubeCacheProxy;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYouTubeClass;

import java.util.logging.Logger;

public class Demo {
  private static final Logger LOGGER = Logger.getLogger(Demo.class.getName());

  public static void main(String[] args) {
    final YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass(), new Renderer());
    final YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy(), new Renderer());

    final long naive = test(naiveDownloader);
    final long smart = test(smartDownloader);

    LOGGER.info("Time saved by caching proxy: " + (naive - smart) + "ms");
  }

  private static long test(YouTubeDownloader downloader) {
    final long startTime = System.currentTimeMillis();
    simulateUserBehavior(downloader);

    final long estimatedTime = System.currentTimeMillis() - startTime;
    LOGGER.info("Time elapsed: " + estimatedTime + "ms");
    return estimatedTime;
  }

  private static void simulateUserBehavior(YouTubeDownloader downloader) {
    downloader.renderPopularVideos();
    downloader.renderVideoPage("catzzzzzzzzz");
    downloader.renderPopularVideos();
    downloader.renderVideoPage("dancesvideoo");
    downloader.renderVideoPage("catzzzzzzzzz");
    downloader.renderVideoPage("someothervid");
  }
}