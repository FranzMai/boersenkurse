package de.kohnlehome;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KursMaxWerteTest {
    private IBoersenreader boersenreader;
    private KursMaxWerte kursMaxWerte;

    @BeforeEach
    void init(){
        //Arrange
        boersenreader = mock(IBoersenreader.class);          //Mock erstellen
        //Mein vorbereiteter Mock für den Test für Vodafon -> 110.0
        when(boersenreader.readKurs("Vodafon",2017)).thenReturn(new double[]{12.0,17.3,2.0,37.99,5.0});
        // Main vorbereiteter Mock für den Test für Telekom -> 35.99
        when(boersenreader.readKurs("Telekom",2019)).thenReturn(new double[]{12.3,13.4,123.4,1.0});

        kursMaxWerte = new KursMaxWerte(boersenreader);     // Instanz von KursMaxWerte
    }

    @Test
    void maxKursAnstiegTest_Vodafon_2017() {
        //Act
        double result = kursMaxWerte.maxKursAnstieg("Vodafon",2017);
        //Assert
        assertThat(result).isEqualTo(110.0);
    }
    @Test
    void maxKursAnstiegTest_Telekom_2019() {
        //Act
        double result = kursMaxWerte.maxKursAnstieg("Telekom",2019);
        //Assert
        assertThat(result).isEqualTo(35.99);
    }
    @Test
    void maxKursFallTest_Vodafon_2017() {
        //Act
        double result = kursMaxWerte.maxKursAnstieg("Vodafon",2017);
        //Assert
        assertThat(result).isEqualTo(123.4 - 1.0);
    }
    @Test
    void maxKursFallTest_Telekom_2019() {
        //Act
        double result = kursMaxWerte.maxKursAnstieg("Telekom",2019);
        //Assert
        assertThat(result).isEqualTo(37.99 - 5.0);
    }

}
