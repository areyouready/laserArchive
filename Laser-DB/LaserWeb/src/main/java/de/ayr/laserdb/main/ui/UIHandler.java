package de.ayr.laserdb.main.ui;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.laserweb.view.LaserView;

public class UIHandler extends CustomComponent {
    
    private final VerticalLayout vLayout = new VerticalLayout();
    
    private Header header;
    //private LaserMenu laserMenu;
    //private LaserView laserView;
    
    public UIHandler () {
        
        setCompositionRoot(vLayout);
        setSizeFull();
        
        
        header = new Header();
        //laserMenu = new LaserMenu();
        //laserView = new LaserView();
        
        vLayout.addComponent(header);
       // initUI();
    }

    private void initUI() {
            
        
    }
    
    

}
