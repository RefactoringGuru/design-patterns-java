package refactoring_guru.decorator.example.decorators;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDataSource implements DataSource {
  private final String name;

  public FileDataSource(String name) {
    this.name = name;
  }

  @Override
  public void writeData(String data) {
    Path path = Paths.get(name);
    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
      writer.write(data, 0, data.length());
    } catch (IOException ex) {
      throw new RuntimeException("Failed to write data to file: " + name, ex);
    }
  }

  @Override
  public String readData() {
    Path path = Paths.get(name);
    try {
      return Files.readString(path);
    } catch (IOException ex) {
      throw new RuntimeException("Failed to read data from file: " + name, ex);
    }
  }
}
