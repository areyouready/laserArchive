package de.ayr.laserdb.laserweb.view;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class HomeView extends CustomComponent {
    
    private VerticalLayout vLayout = new VerticalLayout();;
    private Label welcomeLbl;
    
    public HomeView() {
        
        vLayout.setSizeFull();
        setCompositionRoot(vLayout);
        setStyleName("HomeView-Style");
        
        initUI();
    }

    private void initUI() {
         
        welcomeLbl = new Label("Willkommen");
        
        vLayout.addComponent(welcomeLbl);
        vLayout.setSizeFull();
    }

}
