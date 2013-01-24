package de.ayr.laserdb.laserweb.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.VaadinView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import de.ayr.laserdb.infrastructure.service.UserService;
import de.ayr.laserdb.main.view.AbstractLaserView;

@VaadinView
public class LaserView extends AbstractLaserView implements Serializable {
    
    private final VerticalLayout vLayout = new VerticalLayout();
    private final Panel contentPanel = new Panel("Platzhalter");
    private final Label contentLabel = new Label("LaserView");
    private Button newUserButton;
    
    private final UserService userService;
    
    @Inject
    public LaserView(UserService userService) {
        
        this.userService = userService;
        
    }

    @PostConstruct
    private void initUI() {
        setCompositionRoot(vLayout);
        setStyleName("LaserView-Style");
        setSizeFull();
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.setContent(contentLabel);
        
        newUserButton = new Button("TestUser anlegen");
        newUserButton.addClickListener(new Button.ClickListener() {
            
            
            public void buttonClick(ClickEvent event) {
                 userService.createNewUser();
                
            }
        });
        
        vLayout.addComponent(contentPanel);
        vLayout.addComponent(newUserButton);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.BOTTOM_CENTER);
        vLayout.setSizeFull();
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
