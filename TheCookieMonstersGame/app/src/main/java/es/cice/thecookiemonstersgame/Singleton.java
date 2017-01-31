package es.cice.thecookiemonstersgame;

/**
 * Created by cice on 31/1/17.
 */

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton () {}

    public static Singleton getInstance () {
        return INSTANCE;
    }

    public Object clone () throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}
