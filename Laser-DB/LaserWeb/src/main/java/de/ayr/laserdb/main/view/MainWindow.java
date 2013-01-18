package de.ayr.laserdb.main.view;

import com.vaadin.ui.Window;

import de.ayr.laserdb.main.ui.UIHandler;

public class MainWindow extends Window {
    private LoginView loginView;

    public MainWindow() {

        setName("LaserDisc Database");
        setSizeFull();
        setTheme("lasertheme");
        // setTheme("runo");
        setLoginView();
        setCaption("Laser Archive");

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
