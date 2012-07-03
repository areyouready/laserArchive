package de.ayr.laserdb.main.ui;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.laserweb.view.HomeView;

public class UIHandler extends CustomComponent {

    private final VerticalLayout vLayout = new VerticalLayout();

    private Header header;

    private HorizontalSplitPanel menuHoSplit;
    private Menu menu;
    private HomeView hView;

    // private LaserView laserView;

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
        // header.setHeight(100, Sizeable.UNITS_PERCENTAGE);

        // laserView = new LaserView();

        menu = new Menu();
        hView = new HomeView();

        menuHoSplit = new HorizontalSplitPanel();
        menuHoSplit.setHeight(100, Sizeable.UNITS_PERCENTAGE);
        menuHoSplit.setSplitPosition(200, UNITS_PIXELS);
        menuHoSplit.setFirstComponent(menu);
        menuHoSplit.setSecondComponent(hView);
        // menuHoSplit.setHeight("100%");

        vLayout.addComponent(header);
        vLayout.addComponent(menuHoSplit);
//        vLayout.setExpandRatio(header, 0.15f);
//        vLayout.setExpandRatio(menuHoSplit, 0.8F);
        vLayout.setExpandRatio(menuHoSplit, 1);

    }

}
