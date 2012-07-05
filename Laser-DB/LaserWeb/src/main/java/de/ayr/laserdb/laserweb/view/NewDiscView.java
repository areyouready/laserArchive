package de.ayr.laserdb.laserweb.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.view.AbstractLaserView;

public class NewDiscView extends AbstractLaserView {
    
    protected final VerticalLayout vLayout = new VerticalLayout();
    
    public NewDiscView() {
        
        setCompositionRoot(vLayout);
        setSizeFull();
        setStyleName("NewDiscView-Style");
        
        initUI();
        
    }
    
    private void initUI() {
        
        Panel contentPanel = new Panel("Inhalt");
        Label contentLabel = new Label("Neue Disc View");
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.addComponent(contentLabel);
        vLayout.addComponent(contentPanel);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
