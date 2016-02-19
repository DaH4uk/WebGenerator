package ru.webGenerator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.TabPanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class WebGenerator implements EntryPoint, IsWidget {


    private VerticalLayoutContainer container;
    public static int marginLeft = 15;

    @Override
    public Widget asWidget() {
        if (container == null) {

            Label normalLabel1 = new Label("Just a pasdasdn old tab");
            Label normalLabel2 = new Label("Just a plaasdasd");




            TabPanel internetTabPanel = new TabPanel();



            internetTabPanel.add(new Error651Tab().asWidget(), "678, 651, 815...");
            internetTabPanel.add(new BreaksTab().asWidget(), "Разрывы");
            internetTabPanel.add(new SpeedTab().asWidget(), "Скорость");
            internetTabPanel.setAnimScroll(true);


            TabPanel tabPanel = new TabPanel();
//            tabPanel.setStyleName("tab-style");
            tabPanel.add(internetTabPanel, "Интернет");
            tabPanel.add(normalLabel1, "Дом.ru TV");
            tabPanel.add(normalLabel2, "Телефония");

            container = new VerticalLayoutContainer();


            container.add(tabPanel, new VerticalLayoutData(1, 0.5, new Margins(0, 0, 0, 0)));







        }

        return container;
    }


    public void onModuleLoad() {
        this.container = (VerticalLayoutContainer) asWidget();
        this.container.setStyleName("main");
        RootPanel.get().add(container);

        VerticalLayoutContainer container2 = (VerticalLayoutContainer) new OrderField().asWidget();
        container2.asWidget().setStyleName("main");
        container2.setBorders(true);
        container2.setPixelSize(600,400);


        RootPanel.get().add(container2);

    }


}
