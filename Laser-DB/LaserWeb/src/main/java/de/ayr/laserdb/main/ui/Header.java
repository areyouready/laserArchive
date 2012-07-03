package de.ayr.laserdb.main.ui;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class Header extends HorizontalLayout {

    public Header() {
        
        setStyleName("Header-Style");
        setHeight("44px");
        
        initUI();
    }

    private void initUI() {
        
        setWidth("100%");
        Panel headerPanel = new Panel();
//        headerPanel.setSizeFull();
        headerPanel.setScrollable(false);
//        headerPanel.setHeight("150");
        headerPanel.setHeight("100%");
        
        HorizontalLayout hLayout = new HorizontalLayout();
        
        Label titleLabel = new Label("LaserDisc Database");
        //titleLabel.setHeight("50%");
        hLayout.addComponent(titleLabel);
        hLayout.setComponentAlignment(titleLabel, Alignment.MIDDLE_LEFT);
        hLayout.setWidth("100%");
        
        Button btnLogout = new Button("Logout");
        hLayout.addComponent(btnLogout);
        hLayout.setComponentAlignment(btnLogout, Alignment.BOTTOM_RIGHT);
        
        headerPanel.addComponent(hLayout);
        
        addComponent(headerPanel);
    }
    
}
