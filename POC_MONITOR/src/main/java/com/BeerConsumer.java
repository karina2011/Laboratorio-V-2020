package com;

public class BeerConsumer implements Runnable{
    private final int TIEMPOESPERA = 500;
    private BeerHouse beerHouse;
    private String name;
    private String dni;

    public BeerConsumer(BeerHouse beerHouse, String name, String dni)
    {
        this.beerHouse=beerHouse;
        this.name=name;
        this.dni=dni;
    }

    @Override
    public void run()
    {
        while(Boolean.TRUE)
        {
            try {
                System.out.println("El BeerConsumer(consumidor) " + this.name + " consume: " + beerHouse.get(this.name));
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
