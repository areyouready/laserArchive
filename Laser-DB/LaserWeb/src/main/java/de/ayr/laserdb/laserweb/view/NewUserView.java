package de.ayr.laserdb.laserweb.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;

import com.vaadin.cdi.VaadinView;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import de.ayr.laserdb.infrastructure.service.UserService;
import de.ayr.laserdb.main.view.AbstractLaserView;

@VaadinView
public class NewUserView extends AbstractLaserView {
    
    protected final VerticalLayout vLayout = new VerticalLayout();
    private final Panel contentPanel = new Panel("Inhalt");
    private final Label contentLabel = new Label("Neue User View");
    
    private final VerticalLayout formWrapper = new VerticalLayout();
    private final FormLayout formLogin = new FormLayout();
    private TextField txtUsername = new TextField("Loginname");
    private TextField txtGroup = new TextField("Gruppe");
    private PasswordField pwdPassword = new PasswordField("Password");
    
    private UserService userService;
    
    @Inject
    public NewUserView(UserService userService) {
        this.userService = userService;
    }
    
    protected NewUserView() {
        
    }
    
    @PostConstruct
    private void initUI() {
        setCompositionRoot(vLayout);
        setSizeFull();
        setStyleName("NewUserView-Style");
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        txtUsername.setRequired(true);
        pwdPassword.setRequired(true);
        txtGroup.setRequired(true);
        
        vLayout.addComponent(contentPanel);
        contentPanel.setWidth("400px");
        contentPanel.setHeight("300px");
        
//        ComboBox userBox = new ComboBox("Benutzer");
//        
//        IndexedContainer indexedContainer = new IndexedContainer(userService.getUser());
        
        formWrapper.addComponent(formLogin);
        formLogin.setMargin(true);
        formLogin.setStyleName("formLogin");
        formLogin.addComponent(txtUsername);
        formLogin.addComponent(pwdPassword);
        formLogin.addComponent(txtGroup);
        
        Button newUserButton = new Button("Save");
        newUserButton.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                 try {
                    userService.createNewUser(txtUsername.getValue(), pwdPassword.getValue(), txtGroup.getValue());
                    Notification n = new Notification("Benutzer wurde angelegt.", Type.HUMANIZED_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
            
        
        formWrapper.addComponent(newUserButton);
        formWrapper.setComponentAlignment(newUserButton, Alignment.BOTTOM_CENTER);
      
        
        contentPanel.setContent(formWrapper);
        vLayout.addComponent(contentPanel);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
        
    }
    
    
    

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
