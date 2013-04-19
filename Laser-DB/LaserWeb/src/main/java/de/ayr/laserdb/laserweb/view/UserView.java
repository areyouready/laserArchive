package de.ayr.laserdb.laserweb.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.security.auth.spi.Util;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.infrastructure.boundary.UserService;
import de.ayr.laserdb.infrastructure.entity.User;
import de.ayr.laserdb.infrastructure.entity.UserRole;

@CDIView
public class UserView extends AbstractLaserView {

	protected final VerticalLayout vLayout = new VerticalLayout();
	private BeanItemContainer<User> beanContainer;
	private final Panel contentPanel = new Panel("Inhalt");
	private final Label contentLabel = new Label("Neue User View");

	private final VerticalLayout formWrapper = new VerticalLayout();
	private final FormLayout formLogin = new FormLayout();
	private TextField txtUsername = new TextField("Loginname");
	private TextField txtGroup = new TextField("Gruppe");
	private PasswordField pwdPassword = new PasswordField("Password");
	private ComboBox userBox;
	private String userName;
	private String passWord;
	private String nutzerRolle;

	private User user;
	private UserRole role;

	private UserService userService;

	@Inject
	public UserView(UserService userService) {
		this.userService = userService;
	}

	protected UserView() {

	}

	@PostConstruct
	private void initUI() {
		setCompositionRoot(vLayout);
		setSizeFull();
		setStyleName("NewUserView-Style");

		contentPanel.setHeight("200px");
		contentPanel.setWidth("250px");

		txtUsername.setRequired(true);
		pwdPassword.setRequired(true);
		txtGroup.setRequired(true);

		vLayout.addComponent(contentPanel);
		contentPanel.setWidth("400px");
		contentPanel.setHeight("300px");

		userBox = new ComboBox("Benutzer");
		beanContainer = new BeanItemContainer(User.class, userService.getUser());

		userBox.setContainerDataSource(beanContainer);
		userBox.setItemCaptionPropertyId("username");
		userBox.setImmediate(true);
		userBox.addListener(ValueChangeEvent.class, this, "fillFields");
		txtUsername.setImmediate(true);
		txtUsername.addListener(ValueChangeEvent.class, this,
				"onUsernameChange");

		formWrapper.addComponent(formLogin);
		formLogin.setMargin(true);
		formLogin.setStyleName("formLogin");
		formLogin.addComponent(userBox);
		formLogin.addComponent(txtUsername);
		formLogin.addComponent(pwdPassword);
		formLogin.addComponent(txtGroup);

		Button newUserButton = new Button("Save");
		newUserButton.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				try {
					if (userBox.getValue() != null) {
						user.setUsername(txtUsername.getValue());
						user.setPassword(Util.createPasswordHash("SHA-256",
								Util.BASE64_ENCODING, null, null,
								pwdPassword.getValue()));
						role.setUser(user);
						role.setRole(txtGroup.getValue());
						user = userService.updateUser(user, role);
					} else {
						userService.createNewUser(txtUsername.getValue(),
								pwdPassword.getValue(), txtGroup.getValue());
					}

					Notification n = new Notification(
							"Benutzer wurde angelegt.", Type.HUMANIZED_MESSAGE);
					n.show(UI.getCurrent().getPage());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		formWrapper.addComponent(newUserButton);
		formWrapper.setComponentAlignment(newUserButton,
				Alignment.BOTTOM_CENTER);

		contentPanel.setContent(formWrapper);
		vLayout.addComponent(contentPanel);

		vLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);

	}

	public void fillFields() {
		if (userBox.getValue() != null) {
			BeanItem<User> userItem = beanContainer.getItem(userBox.getValue());
			user = userItem.getBean();
			userName = user.getUsername();
			passWord = user.getPassword();
			List<UserRole> roles = user.getUserRoles();
			role = roles.get(0);
			nutzerRolle = role.getRole();

			txtUsername.setValue(userName);
			pwdPassword.setValue(passWord);
			txtGroup.setValue(nutzerRolle);
		} else {
			passWord = "";
			nutzerRolle = "";

			pwdPassword.setValue(passWord);
			txtGroup.setValue(nutzerRolle);
		}
	}

	public void onUsernameChange() {
		user.setUsername(txtUsername.getValue());
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
