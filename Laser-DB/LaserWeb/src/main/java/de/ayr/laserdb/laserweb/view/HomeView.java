package de.ayr.laserdb.laserweb.view;

import javax.annotation.PostConstruct;

import com.vaadin.cdi.VaadinView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.view.AbstractLaserView;

@VaadinView
public class HomeView extends AbstractLaserView {
    
    private VerticalLayout vLayout = new VerticalLayout();;
    private Label welcomeLbl;
    
    public HomeView() {
        
        
    }

    @PostConstruct
    private void initUI() {
        vLayout.setSizeFull();
        setCompositionRoot(vLayout);
        setStyleName("HomeView-Style");
         
        welcomeLbl = new Label("Willkommen");
        
        vLayout.addComponent(welcomeLbl);
        vLayout.setSizeFull();
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
