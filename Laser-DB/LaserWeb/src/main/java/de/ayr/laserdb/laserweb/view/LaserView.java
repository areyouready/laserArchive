package de.ayr.laserdb.laserweb.view;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.AccessControl;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.infrastructure.boundary.UserService;
import de.ayr.laserdb.infrastructure.entity.LaserDisc;

import java.io.Serializable;

@CDIView
@RolesAllowed("admin")
public class LaserView extends AbstractLaserView implements Serializable {

	private final VerticalLayout vLayout = new VerticalLayout();
	private final Panel contentPanel = new Panel("Platzhalter");
	private final Label contentLabel = new Label("LaserView");
	private final Table laserTable = new Table();
	private LaserDisc laserDiscs = new LaserDisc();
	
	private final UserService userService;
	private JaasAccessControl jaasControl;

	@Inject
	public LaserView(UserService userService, JaasAccessControl jaasControl) {

		this.userService = userService;
		this.jaasControl = jaasControl;

	}

	@PostConstruct
	private void initUI() {
		Button newUserButton = new Button("Initiale User anlegen");

		setCompositionRoot(vLayout);
		setStyleName("LaserView-Style");
		setSizeFull();

		contentPanel.setHeight("300px");
		contentPanel.setWidth("250px");

		contentPanel.setContent(contentLabel);

		newUserButton.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				userService.createInitialUsers();

			}
		});

		setVisibleForRoles(newUserButton, "admin");

		
//		vLayout.addComponent(laserTable);
		vLayout.addComponent(contentPanel);
		vLayout.addComponent(newUserButton);

		vLayout.setComponentAlignment(contentPanel, Alignment.BOTTOM_CENTER);
		vLayout.setSizeFull();

	}

	public void setVisibleForRoles(Component component, String roles) {
		component.setVisible(jaasControl.isUserInSomeRole(roles));
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
