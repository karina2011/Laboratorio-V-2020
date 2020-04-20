package com.UTN.POC_MONITOR;

import com.BeerConsumer;
import com.BeerHouse;
import com.BeerProductor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CerveceriaApplication {
	private static BeerHouse beerHouse;
	private static Thread beerProductor;
	private static Thread [] beerConsumidores;
	private static final int CANTIDADCONSUMIDORES = 1;
	public static void main(String[] args) {

		SpringApplication.run(CerveceriaApplication.class, args);
		beerHouse = new BeerHouse("ghghghg 121212","2222222");
		beerProductor = new Thread(new BeerProductor(beerHouse,"1111111","karina"));
		beerConsumidores = new Thread[CANTIDADCONSUMIDORES];

		for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
		{
			beerConsumidores[i] = new Thread(new BeerConsumer(beerHouse,"senor"+i,""+i+i+i+i+i+i+i));
			beerConsumidores[i].start();
		}

		beerProductor.start();
	}
}
