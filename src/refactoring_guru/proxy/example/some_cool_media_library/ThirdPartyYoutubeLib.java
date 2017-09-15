package refactoring_guru.proxy.example.some_cool_media_library;

import java.util.HashMap;

public interface ThirdPartyYoutubeLib {
    public HashMap<String, Video> popularVideos();

    public Video getVideo(String videoId);
}
