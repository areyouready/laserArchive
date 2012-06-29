package de.ayr.laserdb.main.view;

import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseListener;

public class MainWindow extends Window {
    private LoginView loginView;

    public MainWindow() {

        setName("LaserDisc Database");
        setSizeFull();
        setTheme("runo");
        
        loginView = new LoginView();
        setContent(loginView);
                
        
    }

 
}
