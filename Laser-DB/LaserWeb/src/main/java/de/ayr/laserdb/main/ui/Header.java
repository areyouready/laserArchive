package de.ayr.laserdb.main.ui;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

public class Header extends HorizontalLayout {

    public Header() {

        setStyleName("Header-Style");
        setHeight("66px");

        initUI();
    }

    private void initUI() {

        setWidth("100%");
        Panel headerPanel = new Panel();
        // headerPanel.setSizeFull();
        headerPanel.setScrollable(false);
        // headerPanel.setHeight("150");
        headerPanel.setHeight("100%");

        // Standard Margin von 18px rund um Elemente in einem Panel entfernen
        AbstractLayout headerPanelLayout = (AbstractLayout) headerPanel.getContent();
        headerPanelLayout.setMargin(false);

        // neues Image aus Theme Ordner einbinden
        Embedded logoImage = new Embedded(null, new ThemeResource("img/laserarchive_logo.png"));
        logoImage.setType(Embedded.TYPE_IMAGE);

        HorizontalLayout hLayout = new HorizontalLayout();

        // Label titleLabel = new Label("LaserDisc Database");
        // titleLabel.setHeight("50%");
        hLayout.addComponent(logoImage);
        hLayout.setComponentAlignment(logoImage, Alignment.MIDDLE_LEFT);
        hLayout.setWidth("100%");

        Button btnLogout = new Button("Logout");
        hLayout.addComponent(btnLogout);
        hLayout.setComponentAlignment(btnLogout, Alignment.MIDDLE_CENTER);

        headerPanel.addComponent(hLayout);

        addComponent(headerPanel);
    }

}
