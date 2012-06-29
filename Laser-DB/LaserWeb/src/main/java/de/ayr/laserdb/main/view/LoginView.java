package de.ayr.laserdb.main.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends CustomComponent {

    private final VerticalLayout vLayout = new VerticalLayout();

    private TextField txtUsername = new TextField("Login");
    private PasswordField pwdPassword = new PasswordField("Password");

    public LoginView() {

        setCompositionRoot(vLayout);
        setSizeFull();
        initUI();
    }

    private void initUI() {
        
        txtUsername.setRequired(true);
        pwdPassword.setRequired(true);
        
        final Panel loginPanel = new Panel("Login");
        vLayout.addComponent(loginPanel);
        loginPanel.setWidth("300px");
        loginPanel.setHeight("200px");
        
        //Ein Layout um Form und Buttons gemeinsam ins Panel packen zu können
        final VerticalLayout formWrapper = new VerticalLayout();
        
        final FormLayout formLogin = new FormLayout();
        formWrapper.addComponent(formLogin);
        formLogin.setMargin(true);
        formLogin.setStyleName("formLogin");
        formLogin.addComponent(txtUsername);
        formLogin.addComponent(pwdPassword);
        
        final HorizontalLayout buttonLayout = new HorizontalLayout();
        formWrapper.addComponent(buttonLayout);
        formWrapper.setComponentAlignment(buttonLayout, Alignment.BOTTOM_CENTER);
        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");
        buttonLayout.addComponent(loginButton);
        buttonLayout.addComponent(logoutButton);
        buttonLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
        buttonLayout.setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
        
        loginButton.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
                String loginField = (String) txtUsername.getValue();
                getApplication().setUser(loginField);
                // if ("packtpub".equals(loginField)) {
                // getApplication().setUser(loginField);
                //
                // }
            }
        });

        logoutButton.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
                getApplication().setUser(null);
            }
        });
        
        loginPanel.setContent(formWrapper);
        vLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        vLayout.setSizeFull();

    }
}
