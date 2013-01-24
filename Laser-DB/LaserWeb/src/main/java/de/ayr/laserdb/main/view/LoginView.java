package de.ayr.laserdb.main.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;

import com.vaadin.cdi.VaadinView;
import com.vaadin.cdi.component.JaasTools;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.main.controller.LoginHandler;
import de.ayr.laserdb.main.ui.UIHandler;

@VaadinView
public class LoginView extends CustomComponent {

    private final VerticalLayout vLayout = new VerticalLayout();
//    private final LoginHandler loginHandler;
  
    //customer.changeSomething();

    private TextField txtUsername = new TextField("Login");
    private PasswordField pwdPassword = new PasswordField("Password");
    private final Panel loginPanel = new Panel("Login...");
    private final VerticalLayout formWrapper = new VerticalLayout();
    private final FormLayout formLogin = new FormLayout();
    private final HorizontalLayout buttonLayout = new HorizontalLayout();

    private UIHandler uiHandler;

//    @Inject
//    public LoginView(LoginHandler loginHandler) {
//
//        this.loginHandler = loginHandler;
//        
//    }
    
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
        Button logoutButton = new Button("Logout");
        buttonLayout.addComponent(loginButton);
        buttonLayout.addComponent(logoutButton);
        buttonLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
        buttonLayout.setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
        
        loginButton.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
                String loginField = (String) txtUsername.getValue();
                String pwdField = (String) pwdPassword.getValue();
                
                try {
                    JaasTools.login(loginField, pwdField);
                    uiHandler.show();
                } catch (ServletException e) {
//                     TODO Auto-generated catch block
                    e.printStackTrace();
                    Notification n = new Notification("Login fehlgeschlagen", Type.WARNING_MESSAGE);
                    n.show(UI.getCurrent().getPage());
                }
               
//                loginHandler.doLogin(loginField, pwdField);
                
                //getApplication().setUser(loginField);
                // if ("packtpub".equals(loginField)) {
                // getApplication().setUser(loginField);
                //
                // }
            }
        });

        logoutButton.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
//                getApplication().setUser(null);
            }
        });
        
        loginPanel.setContent(formWrapper);
        vLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        vLayout.setSizeFull();

    }
}

