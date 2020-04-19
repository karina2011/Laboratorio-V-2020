package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BeerProductor implements Runnable {
    /*private final Random aleatorio;*/
    private final BeerHouse beerHouse;
    private String cuit;
    private String name;
    private final int TIEMPOESPERA = 1500;
    public BeerProductor(BeerHouse beerHouse, String cuit, String name)
    {
        this.beerHouse = beerHouse;
        this.cuit=cuit;
        this.name=name;
    }

    @Override
    public void run()
    {
        while(Boolean.TRUE)
        {
            List ingredientes=new ArrayList<>();
            ingredientes.add("alcohol");
            ingredientes.add("todo_resto");
            BeerType beerType= new BeerType("siempreLaMisma", ingredientes);
            beerHouse.put(beerType);
            System.out.println("El productor de cerveza " + this.getName() + " pone: " + beerType.getName());
            try
            {
                Thread.sleep(TIEMPOESPERA);
            }
            catch (InterruptedException e)
            {
                System.err.println("Productor de cerveza" + this.getName() + ": Error en run -> " + e.getMessage());
            }
        }
    }
}
