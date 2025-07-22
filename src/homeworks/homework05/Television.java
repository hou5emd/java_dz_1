package homeworks.homework05;

import java.util.Random;
import java.util.Objects;

public class Television {
    private String brand;
    private int inchSize;
    private boolean isSmart;
    private int volume;
    private int channel;
    private boolean isOn;

    public Television(String brand, int size, boolean isSmart, int volume, int channel,
            boolean isOn) {
        this.brand = brand;
        this.inchSize = size;
        this.isSmart = isSmart;
        this.volume = volume;
        this.channel = channel;
        this.isOn = isOn;
    }

    public Television() {
        Random rand = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Philips", "Panasonic"};
        this.brand = brands[rand.nextInt(brands.length)];
        this.inchSize = 24 + rand.nextInt(33);
        this.isSmart = rand.nextBoolean();
        this.volume = rand.nextInt(101);
        this.channel = 1 + rand.nextInt(99);
        this.isOn = rand.nextBoolean();
    }

    public String getBrand() {
        return brand;
    }

    public int getInchSize() {
        return inchSize;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void increaseVolume() {
        if (volume < 100)
            volume++;
    }

    public void decreaseVolume() {
        if (volume > 0)
            volume--;
    }

    public void nextChannel() {
        channel++;
    }

    public void previousChannel() {
        if (channel > 1)
            channel--;
    }

    @Override
    public String toString() {
        return String.format("%s [brand=%s, size=%d, smart=%b, volume=%d, channel=%d, isOn=%b]",
                getClass().getSimpleName(), brand, inchSize, isSmart, volume, channel, isOn);
    }

    @Override
    public boolean equals(Object input) {
        if (this == input)
            return true;
        if (input == null || getClass() != input.getClass())
            return false;
        Television inputTelevision = (Television) input;
        return inchSize == inputTelevision.inchSize && isSmart == inputTelevision.isSmart
                && volume == inputTelevision.volume && channel == inputTelevision.channel
                && isOn == inputTelevision.isOn && Objects.equals(brand, inputTelevision.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, inchSize, isSmart, volume, channel, isOn);
    }
}
