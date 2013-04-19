package de.ayr.laserdb.main.login;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.ui.UIHandler;


@CDIView
public class LoginView extends CustomComponent {

    private final VerticalLayout vLayout = new VerticalLayout();

    private TextField txtUsername = new TextField("Login");
    private PasswordField pwdPassword = new PasswordField("Password");
    private final Panel loginPanel = new Panel("Login...");
    private final VerticalLayout formWrapper = new VerticalLayout();
    private final FormLayout formLogin = new FormLayout();
    private final HorizontalLayout buttonLayout = new HorizontalLayout();

    private UIHandler uiHandler;

    
    @Inject
    public LoginView(UIHandler uiHandler) {
        this.uiHandler = uiHandler;
        
    }

    @PostConstruct
    private void initUI() {
        setCompositionRoot(vLayout);
        setSizeFull();
        
        txtUsername.setRequired(true);
        pwdPassword.setRequired(true);
        
        vLayout.addComponent(loginPanel);
        loginPanel.setWidth("300px");
        loginPanel.setHeight("200px");
        
        
        //Ein Layout um Form und Buttons gemeinsam ins Panel packen zu können
        
        formWrapper.addComponent(formLogin);
        formLogin.setMargin(true);
        formLogin.setStyleName("formLogin");
        formLogin.addComponent(txtUsername);
        formLogin.addComponent(pwdPassword);
        
        formWrapper.addComponent(buttonLayout);
        formWrapper.setComponentAlignment(buttonLayout, Alignment.BOTTOM_CENTER);
        Button loginButton = new Button("Login");
        buttonLayout.addComponent(loginButton);
        buttonLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
        
        loginButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                String loginField = (String) txtUsername.getValue();
                String pwdField = (String) pwdPassword.getValue();
                
                try {
                    JaasAccessControl.login(loginField, pwdField);
                    uiHandler.show();
                } catch (ServletException e) {
                    e.printStackTrace();
                    Notification n = new Notification("Login fehlgeschlagen", Type.ERROR_MESSAGE);
                    n.show(UI.getCurrent().getPage());
                }
               
            }
        });

        
        loginPanel.setContent(formWrapper);
        vLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        vLayout.setSizeFull();

    }
}

