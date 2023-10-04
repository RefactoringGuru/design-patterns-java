package refactoring_guru.decorator.example.decorators;

public class DataSourceDecorator implements DataSource {
  private final DataSource dataSource;

  DataSourceDecorator(DataSource source) {
    this.dataSource = source;
  }

  @Override
  public void writeData(String data) {
    dataSource.writeData(data);
  }

  @Override
  public String readData() {
    return dataSource.readData();
  }
}
