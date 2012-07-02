package de.ayr.laserdb.main.view;

import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseListener;

import de.ayr.laserdb.main.ui.UIHandler;

public class MainWindow extends Window {
    private LoginView loginView;

    public MainWindow() {

        setName("LaserDisc Database");
        setSizeFull();
        setTheme("runo");
        setLoginView();
                
        
    }
    
    public void setLoginView() {
        
        loginView = new LoginView();
        setContent(loginView);
    }
    
    public void setLaserWebView(UIHandler uiHandler) {
        
        loginView = null;
        setContent(uiHandler);
        
    }

 
}
