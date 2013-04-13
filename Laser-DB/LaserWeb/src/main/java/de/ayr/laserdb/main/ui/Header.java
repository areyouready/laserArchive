package de.ayr.laserdb.main.ui;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

@CDIView
public class Header extends VerticalLayout {

      private Button btnLogout = new Button("Logout");
      private HorizontalLayout hLayout = new HorizontalLayout();

    public Header() {

        setStyleName("Header-Style");

    }

    @PostConstruct
    private void initUI() {

        hLayout.setSizeFull();


        // neues Image aus Theme Ordner einbinden
        Embedded logoImage = new Embedded(null, new ThemeResource("img/laserarchive_logo.png"));
        logoImage.setType(Embedded.TYPE_IMAGE);

        
        btnLogout.addClickListener(new Button.ClickListener() {
            
            public void buttonClick(ClickEvent event) {
                try {
                    JaasAccessControl.logout();
                    Notification n = new Notification("Benutzer wurde erfolgreich sudgeloggt", Type.HUMANIZED_MESSAGE);
                } catch (ServletException e) {
                    e.printStackTrace();
                }



                
                // Close the VaadinServiceSession
//                    getUI().getSession().getService().getCurrentRequest().getWrappedSession().invalidate();
                // Redirect to avoid keeping the removed UI open in the browser
//                    getUI().getPage().setLocation("/LaserWeb");
                }
            
        });
        
        hLayout.addComponent(logoImage);
        hLayout.addComponent(btnLogout);
//        hLayout.setWidth("100%");

//        hLayout.setComponentAlignment(logoImage, Alignment.MIDDLE_LEFT);
//        hLayout.setComponentAlignment(btnLogout, Alignment.MIDDLE_CENTER);

        addComponent(hLayout);
    }

}
