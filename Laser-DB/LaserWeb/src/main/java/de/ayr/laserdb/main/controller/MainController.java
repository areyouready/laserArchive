package de.ayr.laserdb.main.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import de.ayr.laserdb.login.UserHandler;
import de.ayr.laserdb.main.ui.UIHandler;
import de.ayr.laserdb.main.view.MainWindow;

@SessionScoped
public class MainController implements Serializable {

    private MainWindow mainWindow;
    private UIHandler uiHandler;
    private UserHandler userHandler;

    @Inject
    public MainController(MainWindow mainWindow, UIHandler uiHandler, UserHandler userHandler) {
        this.mainWindow = mainWindow;
        this.uiHandler = uiHandler;
        this.userHandler = userHandler;
    }

    protected MainController() {
    }

    @PostConstruct
    private void init() {
        if (userHandler.getUser() == null) {
            showLogin();
        } else {
            showMainView();
        }
    }

    private void showMainView() {
        mainWindow.setLaserWebView();

    }

    private void showLogin() {
         mainWindow.setLoginView();

    }

//    public void userLoggedIn(String userName) {
//
//        if ("Demo User".equals(userName)) {
//
//            UI.getCurrent().showNotification("alles gut gelaufen");
//
//            mainWindow.setLaserWebView(uiHandler);
//
//        } else {
//
//            UI.getCurrent().showNotification("Muss was schief gegangen sein");
//
//        }
//
//    }

    // public UIHandler getUIHandler() {
    //
    // return uiHandler;
    //
    // }

}
