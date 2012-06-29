package de.ayr.laserdb.application;

import com.vaadin.Application;
import com.vaadin.Application.UserChangeListener;

import de.ayr.laserdb.main.controller.MainController;
import de.ayr.laserdb.main.view.MainWindow;

public class LaserWeb extends Application implements UserChangeListener {

    protected static ThreadLocal<LaserWeb> thisApplication = new ThreadLocal<LaserWeb>();

    MainController mainController;
    MainWindow mainWindow;

    @Override
    public void init() {
        
        setProject(this);

        mainWindow = new MainWindow();
        setMainWindow(mainWindow);

        mainController = new MainController(mainWindow);

        addListener(this);

    }

    public static void setProject(LaserWeb t) {
        thisApplication.set(t);
    }

    public static LaserWeb getProject() {
        return thisApplication.get();
    }

    public void applicationUserChanged(UserChangeEvent event) {

        if (event.getNewUser() == null) {

            // setContent(loginView);
            mainWindow.showNotification("Ausgeloggt");

        } else if (event.getNewUser() != null) {

            mainWindow.showNotification("Eingeloggt");

            String userName = (String) getUser();
            mainController.userLoggedIn(userName);

        }

    }

}
