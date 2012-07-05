package de.ayr.laserdb.laserweb.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.view.AbstractLaserView;

public class HomeView extends AbstractLaserView {
    
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

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
