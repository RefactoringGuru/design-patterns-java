package refactoring_guru.facade.example.some_complex_media_library;

public final class BitrateReader {

  private BitrateReader() {
  }

  public static VideoFile read(VideoFile file) {
    System.out.println("BitrateReader: reading file...");
    return file;
  }

  public static VideoFile convert(VideoFile buffer) {
    System.out.println("BitrateReader: writing file...");
    return buffer;
  }
}
