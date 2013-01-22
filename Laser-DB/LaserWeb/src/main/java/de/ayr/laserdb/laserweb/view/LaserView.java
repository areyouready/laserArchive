package de.ayr.laserdb.laserweb.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.ayr.laserdb.main.view.AbstractLaserView;
import de.ayr.laserdb.ui.LaserWeb;

public class LaserView extends AbstractLaserView implements Serializable {
    
    private final VerticalLayout vLayout = new VerticalLayout();
    private final Panel contentPanel = new Panel("Platzhalter");
    private final Label contentLabel = new Label("LaserView");
    
    public LaserView() {
        
//        vLayout.setSizeFull();
        
    }

    @PostConstruct
    private void initUI() {
        setCompositionRoot(vLayout);
        setStyleName("LaserView-Style");
        setSizeFull();
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.setContent(contentLabel);
        vLayout.addComponent(contentPanel);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.BOTTOM_CENTER);
        vLayout.setSizeFull();
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
