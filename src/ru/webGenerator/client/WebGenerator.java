package ru.webGenerator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.form.TextField;


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

            Label domruTVlabel1 = new Label("ДОМРУ ТВ ЦКТВ");
            Label domruTVlabel2 = new Label("ДОМРУ ТВ КТВ");


            TabPanel internetTabPanel = new TabPanel();
            internetTabPanel.add(new Error651Tab().asWidget(), "678, 651, 815...");
            internetTabPanel.add(new BreaksTab().asWidget(), "Разрывы");
            internetTabPanel.add(new SpeedTab().asWidget(), "Скорость");
            internetTabPanel.setAnimScroll(true);

            VerticalLayoutContainer phoneContainer = new VerticalLayoutContainer();
            phoneContainer.setStyleName("borders");
            HorizontalLayoutContainer phoneSubContainer = new HorizontalLayoutContainer();

            Label phoneLabel = new Label("ГН: ");
            phoneLabel.setStyleName("labels");
            TextField phoneField = new TextField();

            phoneSubContainer.add(phoneLabel);
            phoneSubContainer.add(phoneField, new HorizontalLayoutData(0.2, 0, new Margins(-7, 0, 0, 10)));

            phoneContainer.add(phoneSubContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));

            TabPanel phoneTabPanel = new TabPanel();

            phoneTabPanel.add(new PhoneNoSessionTab().asWidget(), "Нет сессии");
            phoneTabPanel.add(new NoIncomingOutgoingTab().asWidget(), "Отсутствие вх/исх");
            phoneTabPanel.add(new QualityOfCommunicationTab().asWidget(), "Качество связи");
            phoneTabPanel.add(new Label("IVR, АОН, время..."), "IVR, АОН, время...");

            phoneContainer.add(phoneTabPanel, new VerticalLayoutData(1, 1, new Margins(30, 0, 0, 0)));


            TabPanel domRuTVPanel = new TabPanel();
            domRuTVPanel.add(new DigitalTvTab().asWidget(), "ЦКТВ");
            domRuTVPanel.add(new AnalogTvTab().asWidget(), "КТВ");


            TabPanel tabPanel = new TabPanel();
//            tabPanel.setStyleName("tab-style");
            tabPanel.add(internetTabPanel, "Интернет");
            tabPanel.add(domRuTVPanel, "Дом.ru TV");
            tabPanel.add(phoneContainer, "Телефония");

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
        container2.setPixelSize(600, 400);


        RootPanel.get().add(container2);

    }


}
