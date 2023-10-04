package refactoring_guru.facade.example;

import refactoring_guru.facade.example.facade.VideoConversionFacade;

public class Demo {
  public static void main(String[] args) {
    VideoConversionFacade converter = new VideoConversionFacade();
    converter.convertVideo("youtubevideo.ogg");
  }
}
