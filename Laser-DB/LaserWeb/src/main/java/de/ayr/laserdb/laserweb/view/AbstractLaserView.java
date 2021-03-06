package de.ayr.laserdb.laserweb.view;

import java.io.Serializable;

import com.vaadin.ui.CustomComponent;

/* Zum Wechseln der Views im UIHandler. Da alle Views eine AbstractLaserView sind kann eine Hashmap angelegt werden
 * die Wertepaare aus einem String und einem AbstractLaserView übergeben bekommt. Anhand eines entsprechenden ausgewählten 
 * Strings aus dem Menü kann dann das entsprechende View (AbstractLaserView) herausgesucht und angezeigt werden. 
*/

public abstract class AbstractLaserView extends CustomComponent implements Serializable {
    
    protected abstract void close() throws Exception;

}
