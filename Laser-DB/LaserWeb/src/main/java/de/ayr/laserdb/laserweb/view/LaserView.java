package de.ayr.laserdb.laserweb.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.ayr.laserdb.infrastructure.boundary.LaserService;
import de.ayr.laserdb.infrastructure.boundary.UserService;
import de.ayr.laserdb.infrastructure.entity.LaserDisc;

@CDIView
@RolesAllowed("admin")
public class LaserView extends AbstractLaserView implements Serializable {

	private final VerticalLayout vLayout = new VerticalLayout();
//	private final Panel contentPanel = new Panel("Platzhalter");
//	private final Label contentLabel = new Label("LaserView");
	private final Table laserTable = new Table();
	private LaserDisc laserDiscs = new LaserDisc();
	private BeanItemContainer<LaserDisc> ldContainer;

	private final UserService userService;
	private JaasAccessControl jaasControl;
	private LaserService laserService;

	@Inject
	public LaserView(UserService userService, JaasAccessControl jaasControl,
			LaserService laserService) {

		this.userService = userService;
		this.jaasControl = jaasControl;
		this.laserService = laserService;

	}

	@PostConstruct
	private void initUI() {
		Button newUserButton = new Button("Initiale User anlegen");

		setCompositionRoot(vLayout);
		setStyleName("LaserView-Style");
		setSizeFull();

//		contentPanel.setHeight("300px");
//		contentPanel.setWidth("250px");
//
//		contentPanel.setContent(contentLabel);

		newUserButton.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				userService.createInitialUsers();

			}
		});

		setVisibleForRoles(newUserButton, "admin");

		laserTable.setContainerDataSource(populateTable());

		vLayout.addComponent(laserTable);
//		vLayout.addComponent(contentPanel);
		vLayout.addComponent(newUserButton);

//		vLayout.setComponentAlignment(contentPanel, Alignment.BOTTOM_CENTER);
		vLayout.setSizeFull();

	}

	private BeanItemContainer<LaserDisc> populateTable() {
		ldContainer = new BeanItemContainer(LaserDisc.class, laserService.fetchAllDiscs());
		return ldContainer;
	}

	public void setVisibleForRoles(Component component, String roles) {
		component.setVisible(jaasControl.isUserInSomeRole(roles));
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
