package de.ayr.laserdb.main.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.vaadin.cdi.access.JaasAccessControl;

import de.ayr.laserdb.main.ui.UIHandler;
import de.ayr.laserdb.main.view.MainWindow;

@SessionScoped
public class MainController implements Serializable {

	private MainWindow mainWindow;
	private UIHandler uiHandler;
	private JaasAccessControl jaasControl;

	@Inject
	public MainController(MainWindow mainWindow, UIHandler uiHandler,
			JaasAccessControl jaasControl) {
		this.mainWindow = mainWindow;
		this.uiHandler = uiHandler;
		this.jaasControl = jaasControl;
	}

	protected MainController() {
	}

	@PostConstruct
	private void init() {
		if (jaasControl.isUserSignedIn()) {
			showMainView();
		} else {
			showLogin();
		}
	}

	private void showMainView() {
		mainWindow.setLaserWebView();

	}

	private void showLogin() {
		mainWindow.setLoginView();

	}

	// public void userLoggedIn(String userName) {
	//
	// if ("Demo User".equals(userName)) {
	//
	// UI.getCurrent().showNotification("alles gut gelaufen");
	//
	// mainWindow.setLaserWebView(uiHandler);
	//
	// } else {
	//
	// UI.getCurrent().showNotification("Muss was schief gegangen sein");
	//
	// }
	//
	// }

	// public UIHandler getUIHandler() {
	//
	// return uiHandler;
	//
	// }

}
