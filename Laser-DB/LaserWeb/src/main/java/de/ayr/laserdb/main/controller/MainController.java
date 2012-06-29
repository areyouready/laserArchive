package de.ayr.laserdb.main.controller;

import com.vaadin.ui.Window;

import de.ayr.laserdb.main.view.MainWindow;

public class MainController {

    private MainWindow mainWindow;

    public MainController(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        init();
    }

    private void init() {

    }

    public void userLoggedIn(String userName) {

        if ("Demo User".equals(userName)) {

            mainWindow.showNotification("alles gut gelaufen");

        } else {

            mainWindow.showNotification("Muss was schief gegangen sein");

        }

    }

}
