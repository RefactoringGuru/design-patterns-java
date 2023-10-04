package refactoring_guru.facade.example.facade;

import refactoring_guru.facade.example.some_complex_media_library.*;

import java.io.File;

public class VideoConversionFacade {
  public void convertVideo(String fileName) {
    System.out.println("VideoConversionFacade: conversion started.");
    VideoFile file = new VideoFile(fileName);

    VideoFile buffer = BitrateReader.read(file);
    VideoFile intermediateResult = BitrateReader.convert(buffer);
    File result = (new AudioMixer()).fix(intermediateResult);
    System.out.println("VideoConversionFacade: conversion completed.");
  }
}
