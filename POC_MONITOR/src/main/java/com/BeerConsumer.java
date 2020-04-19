package com;

public class BeerConsumer implements Runnable{
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
            System.out.println("El BeerConsumer(consumidor) " + this.name + " consume: " + beerHouse.get(this.name));
        }
    }
}
