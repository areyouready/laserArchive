package de.ayr.laserdb.main.ui;

import java.util.HashMap;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.laserweb.view.HomeView;
import de.ayr.laserdb.laserweb.view.LaserView;
import de.ayr.laserdb.laserweb.view.NewDiscView;
import de.ayr.laserdb.main.view.AbstractLaserView;

public class UIHandler extends CustomComponent {

    private final VerticalLayout vLayout = new VerticalLayout();
    private HorizontalSplitPanel menuHoSplit;


    private Header header;
    private Menu menu;
    private HomeView homeView;
    private LaserView laserView;
    private NewDiscView newDiscView;

    // private LaserView laserView;

    private HashMap<String, AbstractLaserView> viewList = new HashMap<String, AbstractLaserView>();    
    
    public UIHandler() {

        vLayout.setSizeFull();
        setCompositionRoot(vLayout);
        setHeight("100%");
        setSizeFull();
        setStyleName("UIHandler-Style");

        initUI();
    }

    private void initUI() {

        header = new Header();

        // laserView = new LaserView();

        menu = new Menu();
        homeView = new HomeView();
        laserView = new LaserView();
        newDiscView = new NewDiscView();

        viewList.put("Home", homeView);
        viewList.put("Discs anzeigen", laserView);
        viewList.put("Neue Disc", newDiscView);

        
        menuHoSplit = new HorizontalSplitPanel();
        menuHoSplit.setHeight(100, Sizeable.UNITS_PERCENTAGE);
        menuHoSplit.setSplitPosition(200, UNITS_PIXELS);
        menuHoSplit.setFirstComponent(menu);
        menuHoSplit.setSecondComponent(homeView);

        vLayout.addComponent(header);
        vLayout.addComponent(menuHoSplit);
        vLayout.setExpandRatio(menuHoSplit, 1);

    }

    public void switchView(String clickedView) {
        
        setMainView(viewList.get(clickedView));
        
    }

    private void setMainView(AbstractLaserView abstractLaserView) {
        
        menuHoSplit.setSecondComponent(abstractLaserView);
        
    }

}
