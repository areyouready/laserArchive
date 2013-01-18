package de.ayr.laserdb.main.ui;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

import de.ayr.laserdb.ui.LaserWeb;

public class Menu extends CssLayout implements ValueChangeListener {

    private HorizontalLayout hLayout = new HorizontalLayout();
    private Tree menuTree = new Tree();
    private Panel menuPanel;

    // String Mappings für die Menüpunkte
    public static final String M_HOME = "Home";
    public static final String M_SHOW = "Discs anzeigen";
    public static final String M_NEU = "Neue Disc";

    public Menu() {

        // setCompositionRoot(hLayout);
        setHeight("100%");
        // setMargin(true);
        setStyleName("Menu-Style");

        menuTree = new Tree("Auswahlmenü");
        menuTree.setSelectable(true);
        menuTree.setMultiSelect(false);
        menuTree.setImmediate(true);
        menuTree.setStyleName("menuTree-style");

        menuTree.addListener((ValueChangeListener) this);

        treePop();

    }

    // Menüpunkte in den Tree einfügen
    private void treePop() {

        final String menu[] = { M_HOME, M_SHOW, M_NEU };

        // Alle Strings nacheinander aus dem Array holen und als Child in den
        // Tree aufnehmen
        for (String menuItem : menu) {

            menuTree.addItem(menuItem);
            menuTree.setChildrenAllowed(menuItem, false);

        }

        // menuPanel = new Panel();
        // menuPanel.addComponent(menuTree);
        // menuPanel.setSizeFull();
        addComponent(menuTree);
        setHeight("100%");
        // menuPanel.setHeight("100%");
        // addComponent(menuPanel);

    }

    // Wechseln des Views
    public void valueChange(ValueChangeEvent event) {

        String clickedView = menuTree.getValue().toString();

        // Referenz vom UIHandler aus LaserWeb holen und in UIHandler switchView
        // aufrufen. SwitchView wird der String des
        // geklickten Menüeintrages mitgegeben
        LaserWeb.getProject().getUiHandler().switchView(clickedView);

    }
}
