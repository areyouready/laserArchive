package de.ayr.laserdb.main.uicomponents;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Tree;

public class Menu extends CssLayout implements ValueChangeListener {

    private HorizontalLayout hLayout = new HorizontalLayout();
    private Tree menuTree = new Tree("Auswahlmenü");
    // private Panel menuPanel;

    private UIHandler uiHandler;
    private JaasAccessControl jaasControl;
    private List<String> menu;

    // String Mappings für die Menüpunkte
    public static final String M_HOME = "Home";
    public static final String M_SHOW = "Discs anzeigen";
    public static final String M_NEU = "Neue Disc";
    public static final String M_USER = "Neue Benutzer";

    @Inject
    public Menu(UIHandler uiHandler, JaasAccessControl jaasControl) {

        this.uiHandler = uiHandler;
        this.jaasControl = jaasControl;
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

        menuTree.addValueChangeListener((ValueChangeListener) this);

        treePop();

    }

    // Menüpunkte in den Tree einfügen
    private void treePop() {
        
        if (jaasControl.isUserInRole("admin") || jaasControl.isUserInRole("mgmt")) {
            final String menu[] = { M_HOME, M_SHOW, M_NEU, M_USER };
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

        
        //         final String menu[] = { M_HOME, M_SHOW, M_NEU };

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

//         Referenz vom UIHandler aus LaserWeb holen und in UIHandler switchView
//         aufrufen. SwitchView wird der String des
//         geklickten Menüeintrages mitgegeben

        uiHandler.switchView(clickedView);

    }
}
