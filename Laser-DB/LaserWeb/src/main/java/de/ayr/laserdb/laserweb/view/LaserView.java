package de.ayr.laserdb.laserweb.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.ayr.laserdb.application.LaserWeb;
import de.ayr.laserdb.main.view.AbstractLaserView;

public class LaserView extends AbstractLaserView {
    
    private final VerticalLayout vLayout = new VerticalLayout();
    
    public LaserView() {
        
//        vLayout.setSizeFull();
        setCompositionRoot(vLayout);
        setStyleName("LaserView-Style");
        setSizeFull();
        
        initUI();
    }

    private void initUI() {
        
        Panel contentPanel = new Panel("Platzhalter");
        Label contentLabel = new Label("LaserView");
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.addComponent(contentLabel);
        vLayout.addComponent(contentPanel);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.BOTTOM_CENTER);
        vLayout.setSizeFull();
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
