package refactoring_guru.facade.example.some_complex_media_library;

import java.io.File;

public class AudioMixer {
    public static File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
