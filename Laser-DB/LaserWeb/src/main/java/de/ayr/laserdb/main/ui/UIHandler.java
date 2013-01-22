package de.ayr.laserdb.main.ui;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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

    private HashMap<String, AbstractLaserView> viewList = new HashMap<String, AbstractLaserView>();    
    
    @Inject
    public UIHandler(Header header, Menu menu, HomeView homeView, LaserView laserView, NewDiscView newDiscView) {
        this.header = header;
        this.menu = menu;
        this.homeView = homeView;
        this.laserView = laserView;
        this.newDiscView = newDiscView;
    }

    @PostConstruct
    private void initUI() {
        vLayout.setSizeFull();
        setCompositionRoot(vLayout);
        setSizeFull();
        setStyleName("UIHandler-Style");

        viewList.put("Home", homeView);
        viewList.put("Discs anzeigen", laserView);
        viewList.put("Neue Disc", newDiscView);

        
        menuHoSplit = new HorizontalSplitPanel();
        menuHoSplit.setHeight(100, UNITS_PERCENTAGE);
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
