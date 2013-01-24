package de.ayr.laserdb.main.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.component.ComponentTools;
import com.vaadin.cdi.component.JaasTools;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

import de.ayr.laserdb.ui.LaserWeb;

public class Menu extends CssLayout implements ValueChangeListener {

    private HorizontalLayout hLayout = new HorizontalLayout();
    private Tree menuTree = new Tree("Auswahlmenü");
    // private Panel menuPanel;

    private UIHandler uiHandler;
    private List<String> menu;

    // String Mappings für die Menüpunkte
    public static final String M_HOME = "Home";
    public static final String M_SHOW = "Discs anzeigen";
    public static final String M_NEU = "Neue Disc";

    @Inject
    public Menu(UIHandler uiHandler) {

        this.uiHandler = uiHandler;
    }

    @PostConstruct
    private void init() {
        // setCompositionRoot(hLayout);
        // setHeight("100%");
        // setMargin(true);
        setSizeFull();
        setStyleName("Menu-Style");

        menuTree.setSelectable(true);
        menuTree.setMultiSelect(false);
        menuTree.setImmediate(true);
        menuTree.setStyleName("menuTree-style");
        menuTree.setSizeFull();

        menuTree.addListener((ValueChangeListener) this);

        treePop();

    }

    // Menüpunkte in den Tree einfügen
    private void treePop() {
//         final String menu[] = { M_HOME, M_SHOW, M_NEU };
        
        if (JaasTools.isUserInRole("admin") || JaasTools.isUserInRole("mgmt")) {
            final String menu[] = { M_HOME, M_SHOW, M_NEU };
            for (String menuItem : menu) {

                menuTree.addItem(menuItem);
                menuTree.setChildrenAllowed(menuItem, false);

            }
        } else {
            final String menu[] = { M_HOME, M_NEU };
            for (String menuItem : menu) {

                menuTree.addItem(menuItem);
                menuTree.setChildrenAllowed(menuItem, false);

            }
        }

        // Alle Strings nacheinander aus dem Array holen und als Child in den
        // Tree aufnehmen
//        for (String menuItem : menu) {
//
//            menuTree.addItem(menuItem);
//            menuTree.setChildrenAllowed(menuItem, false);
//
//        }

        // menuPanel = new Panel();
        // menuPanel.addComponent(menuTree);
        // menuPanel.setSizeFull();
        addComponent(menuTree);
        // setHeight("100%");
        // menuPanel.setHeight("100%");
        // addComponent(menuPanel);

    }

    // Wechseln des Views
    public void valueChange(ValueChangeEvent event) {

        String clickedView = menuTree.getValue().toString();

        // Referenz vom UIHandler aus LaserWeb holen und in UIHandler switchView
        // aufrufen. SwitchView wird der String des
        // geklickten Menüeintrages mitgegeben
        // LaserWeb.getProject().getUiHandler().switchView(clickedView);

        uiHandler.switchView(clickedView);

    }
}
