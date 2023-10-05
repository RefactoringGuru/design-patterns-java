package refactoring_guru.proxy.example.downloader;

import refactoring_guru.proxy.example.some_cool_media_library.Video;

import java.util.Map;

public class Renderer {
  private static final String SEPARATOR = "\n-------------------------------\n";

  void renderVideo(Video video) {
    System.out.println(SEPARATOR);
    System.out.println("Video page (imagine fancy HTML)");
    System.out.println("ID: " + video.id);
    System.out.println("Title: " + video.title);
    System.out.println("Video: " + video.data);
    System.out.println(SEPARATOR);
  }

  void renderPopularVideos(Map<String, Video> videos) {
    System.out.println(SEPARATOR);
    System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
    for (Video video : videos.values()) {
      System.out.println("ID: " + video.id + " / Title: " + video.title);
    }
    System.out.println(SEPARATOR);
  }
}
