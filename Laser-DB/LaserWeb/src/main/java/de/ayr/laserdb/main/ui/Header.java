package de.ayr.laserdb.main.ui;

import javax.annotation.PostConstruct;

import com.vaadin.cdi.VaadinView;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@VaadinView
public class Header extends VerticalLayout {

//    private final Panel headerPanel = new Panel();
//    private AbstractLayout headerPanelLayout;
      private Button btnLogout = new Button("Logout");
      private HorizontalLayout hLayout = new HorizontalLayout();

    public Header() {

        setStyleName("Header-Style");

    }

    @PostConstruct
    private void initUI() {

//        setWidth("100%");
//        setSizeFull();
        hLayout.setSizeFull();

        // headerPanel.setHeight("150");
//        headerPanel.setHeight("100%");

        // Standard Margin von 18px rund um Elemente in einem Panel entfernen
//        headerPanelLayout = (AbstractLayout) headerPanel.getContent();

        // neues Image aus Theme Ordner einbinden
        Embedded logoImage = new Embedded(null, new ThemeResource("img/laserarchive_logo.png"));
        logoImage.setType(Embedded.TYPE_IMAGE);

        
        // Label titleLabel = new Label("LaserDisc Database");
        // titleLabel.setHeight("50%");
        hLayout.addComponent(logoImage);
        hLayout.addComponent(btnLogout);
//        hLayout.setWidth("100%");

//        hLayout.setComponentAlignment(logoImage, Alignment.MIDDLE_LEFT);
//        hLayout.setComponentAlignment(btnLogout, Alignment.MIDDLE_CENTER);

//        headerPanel.setContent(hLayout);
//
//        addComponent(headerPanel);
        addComponent(hLayout);
    }

}
