package de.kohnlehome;

public interface IKursMaxWerte {
    double maxKursAnstieg(String aktienname,int jahr);
    double maxKursFall(String aktienname,int jahr);
}
