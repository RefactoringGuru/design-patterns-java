package refactoring_guru.bridge.example.devices;

public interface Device {
    public boolean isEnabled();

    public void enable();

    public void disable();

    public int getVolume();

    public void setVolume(int percent);

    public int getChannel();

    public void setChannel(int channel);

    public void printStatus();
}
