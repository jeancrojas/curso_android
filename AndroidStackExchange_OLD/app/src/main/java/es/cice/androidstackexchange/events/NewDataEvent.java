package es.cice.androidstackexchange.events;

/**
 * Created by cice on 7/2/17.
 */

public class NewDataEvent {

    public final String message;

    public NewDataEvent(String message) {
        this.message = message;
    }
}