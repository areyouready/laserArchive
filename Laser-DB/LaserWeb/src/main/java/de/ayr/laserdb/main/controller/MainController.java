package de.ayr.laserdb.main.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.vaadin.ui.UI;

import de.ayr.laserdb.login.UserHandler;
import de.ayr.laserdb.main.ui.UIHandler;
import de.ayr.laserdb.main.view.MainWindow;

@SessionScoped
public class MainController implements Serializable {

    private MainWindow mainWindow;
    private UIHandler uiHandler;

    @Inject
    public MainController(MainWindow mainWindow, UIHandler uiHandler) {
        this.mainWindow = mainWindow;
        this.uiHandler = uiHandler;
    }
    
    protected MainController() {
    }

    @PostConstruct
    private void init() {
//        public void go() {
            if (UserHandler.getUser() == null) {
                showLogin();
            } else {
                showMainView();
            }

//        }

    }

    public void userLoggedIn(String userName) {

        if ("Demo User".equals(userName)) {

            UI.getCurrent().showNotification("alles gut gelaufen");
            uiHandler = new UIHandler();
            
            mainWindow.setLaserWebView(uiHandler);

        } else {

            UI.getCurrent().showNotification("Muss was schief gegangen sein");
            
        }

    }
    
    public UIHandler getUIHandler() {
        
        return uiHandler;
        
    }

}
