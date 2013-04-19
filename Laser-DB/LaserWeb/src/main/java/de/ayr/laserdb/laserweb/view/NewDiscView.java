package de.ayr.laserdb.laserweb.view;

import javax.annotation.PostConstruct;

import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


@CDIView
public class NewDiscView extends AbstractLaserView {
    
    protected final VerticalLayout vLayout = new VerticalLayout();
    private final Panel contentPanel = new Panel("Inhalt");
    private final Label contentLabel = new Label("Neue Disc View");
    
    public NewDiscView() {
        
    }
    
    @PostConstruct
    private void initUI() {
        setCompositionRoot(vLayout);
        setSizeFull();
        setStyleName("NewDiscView-Style");
        
        
        contentPanel.setHeight("300px");
        contentPanel.setWidth("250px");
        
        contentPanel.setContent(contentLabel);
        vLayout.addComponent(contentPanel);
        
        vLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
        
    }

    @Override
    protected void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
