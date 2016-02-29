package ru.webGenerator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class WebGenerator implements EntryPoint, IsWidget {


    private VerticalLayoutContainer container;
    public static int marginLeft = 15;
    static final TabPanel tabPanel = new TabPanel();
    static final TabPanel internetTabPanel = new TabPanel();
    static final TabPanel domRuTVPanel = new TabPanel();
    static TabPanel phoneTabPanel = new TabPanel();
    static IsWidget error651Tab = new Error651Tab().asWidget();
    static IsWidget breaksTab = new BreaksTab().asWidget();
    static IsWidget speedTab = new SpeedTab().asWidget();
    static IsWidget digitalTvTab = new DigitalTvTab().asWidget();
    static IsWidget analogTvTab = new AnalogTvTab().asWidget();
    static VerticalLayoutContainer phoneContainer = new VerticalLayoutContainer();
    static final TextField phoneField = new TextField();
    static IsWidget phoneNoSession = new PhoneNoSessionTab().asWidget();
    static IsWidget noIncomingOutgoingTab = new NoIncomingOutgoingTab().asWidget();
    static IsWidget qualityOfCommunicationTab = new QualityOfCommunicationTab().asWidget();
    static IsWidget ivrAonTab = new IvrAonTab().asWidget();
    static IsWidget timerTab = new TimerTab().asWidget();

    @Override
    public Widget asWidget() {
        if (container == null) {

            internetTabPanel.add(error651Tab, "678, 651, 815...");
            internetTabPanel.add(breaksTab, "Разрывы");
            internetTabPanel.add(speedTab, "Скорость");



            phoneContainer.setStyleName("borders");
            HorizontalLayoutContainer phoneSubContainer = new HorizontalLayoutContainer();

            Label phoneLabel = new Label("ГН: ");
            phoneLabel.setStyleName("labels");


            phoneSubContainer.add(phoneLabel);
            phoneSubContainer.add(phoneField, new HorizontalLayoutData(0.2, 0, new Margins(-7, 0, 0, 10)));

            phoneContainer.add(phoneSubContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            phoneTabPanel.add(phoneNoSession, "Нет сессии");
            phoneTabPanel.add(noIncomingOutgoingTab, "Отсутствие вх/исх");
            phoneTabPanel.add(qualityOfCommunicationTab, "Качество связи");
            phoneTabPanel.add(ivrAonTab, "IVR, АОН, время...");

            phoneContainer.add(phoneTabPanel, new VerticalLayoutData(1, 1, new Margins(30, 0, 0, 0)));



            domRuTVPanel.add(digitalTvTab, "ЦКТВ");
            domRuTVPanel.add(analogTvTab, "КТВ");


            tabPanel.add(internetTabPanel, "Интернет");
            tabPanel.add(domRuTVPanel, "Дом.ru TV");
            tabPanel.add(phoneContainer, "Телефония");
            tabPanel.add(timerTab, "Напоминание");



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
        container2.setPixelSize(600, 430);


        RootPanel.get().add(container2);

    }


}
