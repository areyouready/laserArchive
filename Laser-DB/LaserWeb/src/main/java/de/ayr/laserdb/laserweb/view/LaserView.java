package de.ayr.laserdb.laserweb.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.view.AbstractLaserView;

public class LaserView extends AbstractLaserView {
    
    private final VerticalLayout vLayout = new VerticalLayout();
    
    public LaserView() {
        
        setCompositionRoot(vLayout);
        setSizeFull();
        setStyleName("LaserView-Style");
        
        initUI();
    }

    private void initUI() {
        
        Panel contentPanel = new Panel("Platzhalter");
        Label contentLabel = new Label("LaserView");
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.addComponent(contentLabel);
        vLayout.addComponent(contentPanel);
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
