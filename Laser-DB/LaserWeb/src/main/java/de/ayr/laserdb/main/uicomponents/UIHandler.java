package de.ayr.laserdb.main.uicomponents;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.laserweb.view.HomeView;
import de.ayr.laserdb.laserweb.view.LaserView;
import de.ayr.laserdb.laserweb.view.NewDiscView;
import de.ayr.laserdb.laserweb.view.NewUserView;
import de.ayr.laserdb.main.view.AbstractLaserView;

@SessionScoped
// @VaadinView(rolesAllowed = "admin")
public class UIHandler extends VerticalLayout {

    private HorizontalSplitPanel menuHoSplit;

    private Header header;
    private Menu menu;
    private HomeView homeView;
    private LaserView laserView;
    private NewDiscView newDiscView;
    private NewUserView newUserView;

    private HashMap<String, AbstractLaserView> viewList = new HashMap<String, AbstractLaserView>();

    @Inject
    public UIHandler(Header header, Menu menu, HomeView homeView, LaserView laserView,
            NewDiscView newDiscView, NewUserView newUserView) {
        this.header = header;
        this.menu = menu;
        this.homeView = homeView;
        this.laserView = laserView;
        this.newDiscView = newDiscView;
        this.newUserView = newUserView;
    }

    protected UIHandler() {

    }

    @PostConstruct
    private void initUI() {
        setStyleName("UIHandler-Style");
        setSizeFull();

//         ComponentTools.setVisibleForRoles(laserView, "admin");
        viewList.put("Home", homeView);
        // if(JaasTools.isUserInRole("admin")){
        viewList.put("Discs anzeigen", laserView);
        // } else {
        // Seite mit Berechtigungsinfo
        // }
        viewList.put("Neue Disc", newDiscView);
        viewList.put("Neue Benutzer", newUserView);

        menuHoSplit = new HorizontalSplitPanel();
        // menuHoSplit.setHeight(100, UNITS_PERCENTAGE);
        menuHoSplit.setSizeFull();
        menuHoSplit.setSplitPosition(200, Unit.PIXELS);
        menuHoSplit.setFirstComponent(menu);
        menuHoSplit.setSecondComponent(homeView);

        addComponent(header);
        addComponent(menuHoSplit);
        setExpandRatio(menuHoSplit, 1);

    }

    public void switchView(String clickedView) {

        setMainView(viewList.get(clickedView));

    }

    private void setMainView(AbstractLaserView abstractLaserView) {

        menuHoSplit.setSecondComponent(abstractLaserView);

    }

    public void show() {

        UI.getCurrent().setContent(this);
    }

}
