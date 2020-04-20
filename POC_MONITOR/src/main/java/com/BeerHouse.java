package com;

import java.util.HashMap;
import java.util.Map;

public class BeerHouse {
    private final Integer max=100;
    private String direccion;
    private String cuit;
    private HashMap<BeerType,Integer> stock;

    public BeerHouse (String direccion, String cuit){
        this.direccion= direccion;
        this.cuit= cuit;
        this.stock= new HashMap<>();
    }

    public Integer getTotalStock (){
        final Integer[] total = {0};
        stock.forEach((k,v)-> total[0] +=v);
        return total[0];
    }

    public Boolean beerHouseFull (){
        return getTotalStock().equals(max);
    }

    public Boolean beerHouseEmpty(){
        return getTotalStock().equals(0);
    }

    public BeerType deleteOne(){
        Map.Entry<BeerType,Integer> entry = stock.entrySet().iterator().next();
        BeerType key= entry.getKey();
        Integer value=entry.getValue();
        value--;
        stock.put(key,value);
        return key;
    }

    public synchronized HashMap get(String name)
    {
        while (beerHouseEmpty())
        {
            try
            {
                System.out.println(name +" tiene que esperar");
                wait();
            }
            catch (InterruptedException e)
            {
                System.err.println("BeerHouse (contenedor): Error en get -> " + e.getMessage());
            }
        }
        System.out.println("se consumio:"+deleteOne().getName());
        notifyAll();
        return stock;
    }

   /*Para poder realizar este ejercicio supongo que intentan poner de a una cerveza por eso solo necesito saber el tipo*/
    public synchronized void put(BeerType beerType) {
        while (beerHouseFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("BeerHouse (contenedor): Error en put -> " + e.getMessage());
            }
        }
        if (this.stock.containsKey(beerType)) {
            this.stock.put(beerType, this.stock.get(beerType) + 1);
        } else {
            this.stock.put(beerType, 1);
        }
        notifyAll();
    }
}
