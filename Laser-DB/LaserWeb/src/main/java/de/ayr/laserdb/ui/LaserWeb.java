package de.ayr.laserdb.ui;

import java.io.Serializable;

import javax.inject.Inject;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.ayr.laserdb.main.controller.MainController;
import de.ayr.laserdb.main.ui.UIHandler;
import de.ayr.laserdb.main.view.MainWindow;

//@Theme("reindeer")
@Theme("lasertheme")
@Title("LaserDisc Database")
@PreserveOnRefresh
@Root
@VaadinUI
public class LaserWeb extends UI implements Serializable {

    private MainController mainController;
//    private MainWindow mainWindow;
    private UIHandler uiHandler;

    @Inject
    public LaserWeb(MainController mainController, /*MainWindow mainWindow*/ UIHandler uiHandler ) {
        this.mainController = mainController;
//        this.mainWindow = mainWindow;
        this.uiHandler = uiHandler;
    }
    
    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();
        
        uiHandler.show();
        
        
        
    }

    
//    public UIHandler getUiHandler() {
//                
//        return thisApplication.get().mainController.getUIHandler();
//    }

//    public void applicationUserChanged(UserChangeEvent event) {
//
//        if (event.getNewUser() == null) {
//
//            // setContent(loginView);
//            mainWindow.showNotification("Ausgeloggt");
//
//        } else if (event.getNewUser() != null) {
//
//            mainWindow.showNotification("Eingeloggt");
//
//            String userName = (String) getUser();
//            mainController.userLoggedIn(userName);
//
//        }
//
//    }

}
