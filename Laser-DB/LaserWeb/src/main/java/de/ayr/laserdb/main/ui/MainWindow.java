package de.ayr.laserdb.main.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.ui.Window;

import de.ayr.laserdb.main.login.LoginView;

public class MainWindow extends Window {
    private LoginView loginView;
    private UIHandler uiHandler;

    @Inject
    public MainWindow(LoginView loginView, UIHandler uiHandler) {
        this.loginView = loginView;
        this.uiHandler = uiHandler;
    }
    
    @PostConstruct
    protected void init() {
        setSizeFull();
        setLoginView();
        setCaption("Laser Archive");
    }
    
    public void setLoginView() {
        setContent(loginView);
    }

    public void setLaserWebView() {

        loginView = null;
        setContent(uiHandler);

    }

}
