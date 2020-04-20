# Laboratorio-V-2020
  Dependiendo de la cantidad de productores y consumidores que tengamos y si se le agrega el factor tiempo de espera las respuesta varían.
Pero si consideramos un consumidor, un productor y cero tiempos de espera solo se necesita un consumidor para que el stock llegue a cero.
Uno produce el otro consume y no existe tiempo de espera que pueda demorar entre el que consume y el que produce.
  Al poner la palabra reservada synchronized en un bloque estamos indicando que en ese bloque tenemos una sección crítica del código y por 
lo tanto los thread que accedan deberán hacerlo de forma síncrona.
  Esa sección critica es el recurso compartido que debe ser arbitrado para que no puedan acceder todos juntos, el ejemplo más claro es el 
acceso a información en donde uno modifica y el otro lee, si se intenta acceder a una misma información pueda que el que lee lo haga 
antes de que la información sea modificada y se lleve una información desactualizada, si imaginamos esta situación en una cuenta de 
banco veremos con claridad el problema que estamos teniendo y lo importante que es que esa situación sea arbitrada. 
  Hay dos modos de conseguir threads en Java. Una es implementando el interfaz Runnable, la otra es extender la clase Thread.
El primer método de crear un hilo de ejecución es simplemente extender la clase Thread:

class MiThread extends Thread {
    public void run() {
        . . .}

  El ejemplo anterior crea una nueva clase MiThread que extiende la clase Thread y sobreescribe el método Thread.run() por su propia 
implementación. El método run() es donde se realizará todo el trabajo de la clase. Esto puede ser una desventaja si necesito extender 
de otra clase ya que no podemos hacer herencias múltiples en java. Es por ello que tenemos la otra opción en donde se implementa 
Runnable:

public class MiThread implements Runnable {
    Thread t;
    public void run() {
        // Ejecución del thread una vez creado
        }
    }

En este caso necesitamos crear una instancia de Thread antes de que el sistema pueda ejecutar el proceso como un hilo. Además, el método 
abstracto run() está definido en el interfaz Runnable y tiene que ser implementado. La mayoría de las clases creadas que necesiten 
ejecutarse como un hilo, implementarán el interfaz Runnable, ya que probablemente extenderán alguna de su funcionalidad a otras clases 
o puede que en el futuro necesiten hacerlo

A continuación veremos las tres formas de instanciar un thread  implementando la interfaz Runnable para crear un programa multihilo.

class javaThread1 {
    static public void main( String args[] ) {
        // Se instancian dos nuevos objetos Thread
        Thread hiloA = new Thread( new MiHilo(),"hiloA" );
        Thread hiloB = new Thread( new MiHilo(),"hiloB" );
        // Se arrancan los dos hilos, para que comiencen su ejecución
        hiloA.start();
        hiloB.start();
         …….
      // Se detiene la ejecución de los dos hilos
        hiloA.stop();
        hiloB.stop();
        }
    }

class NoHaceNada {
/* Esta clase existe solamente para que sea heredada por la clase MiHilo, para evitar que esta clase sea capaz de heredar la clase 
Thread, y se pueda implementar el interfaz Runnable en su lugar*/
}
class MiHilo extends NoHaceNada implements Runnable {
    public void run() {
        // Presenta en pantalla información sobre este hilo en particular
        System.out.println( Thread.currentThread() );
        }
    }

  Como se puede observar, el programa define una clase MiHilo que extiende a la clase NoHaceNada e implementa el interfaz Runnable. Se 
redefine el método run() en la clase MiHilo para presentar información sobre el hilo.
La única razón de extender la clase NoHaceNada es proporcionar un ejemplo de situación en que haya que extender alguna otra clase, 
además de implementar el interfaz.

  En el ejemplo javaThread2.java muestra el mismo programa básicamente, pero en este caso extendiendo la clase Thread, en lugar de 
implementar el interfaz Runnable para crear el programa multihilo.

class javaThread2 {
    static public void main( String args[] ) {
        // Se instancian dos nuevos objetos Thread
        Thread hiloA = new Thread( new MiHilo(),"hiloA" );
        Thread hiloB = new Thread( new MiHilo(),"hiloB" );

        // Se arrancan los dos hilos, para que comiencen su ejecución
        hiloA.start();
        hiloB.start();
         ……….
        // Presenta información acerca del Thread o hilo principal del programa
        System.out.println( Thread.currentThread() );        
        // Se detiene la ejecución de los dos hilos
        hiloA.stop();
        hiloB.stop();
        }
    }

class MiHilo extends Thread {
    public void run() {
        // Presenta en pantalla información sobre este hilo en particular
        System.out.println( Thread.currentThread() );
        }
    }

  En ese caso, la nueva clase MiHilo extiende la clase Thread y no implementa el interfaz Runnable directamente (la clase Thread 
implementa el interfaz Runnable, por lo que indirectamente MiHilo también está implementando ese interfaz). El resto del programa es 
similar al anterior.

  Y todavía se puede presentar un ejemplo más simple, utilizando un constructor de la clase Thread que no necesita parámetros, tal 
como se presenta en el ejemplo javaThread3.java. En los ejemplos anteriores, el constructor utilizado para Thread necesitaba dos 
parámetros, el primero un objeto de cualquier clase que implemente el interfaz Runnable y el segundo una cadena que indica el nombre 
del hilo (este nombre es independiente del nombre de la variable que referencia al objeto Thread).

class javaThread3 {
    static public void main( String args[] ) {
        // Se instancian dos nuevos objetos Thread
        Thread hiloA = new MiHilo();
        Thread hiloB = new MiHilo();

        // Se arrancan los dos hilos, para que comiencen su ejecución
        hiloA.start();
        hiloB.start();
        ……..
        // Presenta información acerca del Thread o hilo principal del programa
        System.out.println( Thread.currentThread() ); 
        // Se detiene la ejecución de los dos hilos
        hiloA.stop();
        hiloB.stop();
        }
    }

class MiHilo extends Thread {
    public void run() {
        // Presenta en pantalla información sobre este hilo en particular
        System.out.println( Thread.currentThread() );
        }
    }
  Las sentencias en este ejemplo para instanciar objetos Thread, son mucho menos complejas, siendo el programa, en esencia, el mismo 
de los ejemplos anteriores.
