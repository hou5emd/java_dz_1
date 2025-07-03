package homeworks.homework03;

import java.util.Random;

public class Television {
    private String brand;
    private int inchSize;
    private boolean isSmart;
    private int volume;
    private int channel;

    public Television(String brand, int size, boolean isSmart, int volume, int channel) {
        this.brand = brand;
        this.inchSize = size;
        this.isSmart = isSmart;
        this.volume = volume;
        this.channel = channel;
    }

    public Television() {
        Random rand = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Philips", "Panasonic"};
        this.brand = brands[rand.nextInt(brands.length)];
        this.inchSize = 24 + rand.nextInt(33); 
        this.isSmart = rand.nextBoolean();
        this.volume = rand.nextInt(101); 
        this.channel = 1 + rand.nextInt(99);
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getInchSize() { return inchSize; }
    public void setInchSize(int size) { this.inchSize = size; }

    public boolean isSmart() { return isSmart; }
    public void setSmart(boolean smart) { isSmart = smart; }

    public int getVolume() { return volume; }
    public void setVolume(int volume) { this.volume = volume; }

    public int getChannel() { return channel; }
    public void setChannel(int channel) { this.channel = channel; }

    public void increaseVolume() { if (volume < 100) volume++; }
    public void decreaseVolume() { if (volume > 0) volume--; }
    public void nextChannel() { channel++; }
    public void previousChannel() { if (channel > 1) channel--; }

    @Override
    public String toString() {
        return String.format("Television [brand=%s, size=%d, smart=%b, volume=%d, channel=%d]", brand, inchSize, isSmart, volume, channel);
    }
}
