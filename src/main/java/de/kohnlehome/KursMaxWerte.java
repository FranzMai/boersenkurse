package de.kohnlehome;

public class KursMaxWerte implements IKursMaxWerte {
    IBoersenreader boersenreader;

    public KursMaxWerte(IBoersenreader boersenreader) {
        this.boersenreader = boersenreader;
    }

    @Override
    public double maxKursAnstieg(String aktienname, int jahr) {
        return 0;
    }

    @Override
    public double maxKursFall(String aktienname, int jahr) {
        return 0;
    }
}
