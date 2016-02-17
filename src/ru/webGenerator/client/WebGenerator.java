package ru.webGenerator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.form.TextArea;

import static com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.*;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class WebGenerator implements EntryPoint, IsWidget {


    private VerticalLayoutContainer container;
    private int marginLeft = 10;

    @Override
    public Widget asWidget() {
        if (container == null) {

            Label normalLabel1 = new Label("Just a pasdasdn old tab");
            Label normalLabel2 = new Label("Just a plaasdasd");


            Label razrLabel1 = new Label("Разрывы");
            Label speedLabel2 = new Label("Скорость");

            TabPanel internetTabPanel = new TabPanel();

            internetTabPanel.setWidth(400);


            //Internet tab
            //651 tab

            VerticalLayoutContainer netCableDisconnectedTab = new VerticalLayoutContainer();
            netCableDisconnectedTab.setHeight(900);
            netCableDisconnectedTab.setBorders(true);

            Label textErrorLabel = new Label("Текст ошибки:");
            textErrorLabel.addStyleName("label-text");
            netCableDisconnectedTab.add(textErrorLabel, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));


            Radio netCableDisconnectedRadio = new Radio();
            netCableDisconnectedRadio.setHeight(20);
            netCableDisconnectedRadio.setBoxLabel("Сетевой кабель не подключен");


            Radio remotePcNotAnsweredRadio = new Radio();
            remotePcNotAnsweredRadio.setHeight(20);
            remotePcNotAnsweredRadio.setBoxLabel("Удаленный компьютер не отвечает");

            CssFloatLayoutContainer radios = new CssFloatLayoutContainer();
            radios.add(netCableDisconnectedRadio, new CssFloatData(-1, new Margins(4, 20, 0, 0)));
            radios.add(remotePcNotAnsweredRadio, new CssFloatData(-1, new Margins(4, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(netCableDisconnectedRadio);
            group.add(remotePcNotAnsweredRadio);

            netCableDisconnectedTab.add(radios, new VerticalLayoutData(1, 0, new Margins(0, 0, 5, marginLeft)));


            Label operStatusLabel = new Label("Oper status:");
            operStatusLabel.addStyleName("label-text");

            Label macVisibleLabel = new Label("Mac-адрес виден?");
            macVisibleLabel.addStyleName("label-text");

            Label commutatorTypeLabel = new Label("Коммутатор управляемый?");
            commutatorTypeLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels = new CssFloatLayoutContainer();
            labels.add(operStatusLabel, new CssFloatData(-1, new Margins(4, 75, 0, marginLeft)));
            labels.add(macVisibleLabel, new CssFloatData(-1, new Margins(4, 35, 0, 0)));
            labels.add(commutatorTypeLabel, new CssFloatData(-1, new Margins(4, 0, 0, 20)));
            netCableDisconnectedTab.add(labels, new VerticalLayoutData(1, 0, new Margins(0, 0, 2, 0)));


            Radio operStatusDownRadio = new Radio();
            operStatusDownRadio.setHeight(20);
            operStatusDownRadio.setBoxLabel("Down");
            operStatusDownRadio.addStyleName("red");


            Radio operStatusUpRadio = new Radio();
            operStatusUpRadio.setHeight(20);
            operStatusUpRadio.setBoxLabel("Up");
            operStatusUpRadio.addStyleName("green");


            Radio macVisibleNoRadio = new Radio();
            macVisibleNoRadio.setHeight(20);
            macVisibleNoRadio.setBoxLabel("Нет");
            macVisibleNoRadio.addStyleName("red");


            Radio macVisibleYesRadio = new Radio();
            macVisibleYesRadio.setHeight(20);
            macVisibleYesRadio.setBoxLabel("Да");
            macVisibleYesRadio.addStyleName("green");


            Radio comControlledNoRadio = new Radio();
            comControlledNoRadio.setHeight(20);
            comControlledNoRadio.setBoxLabel("Нет");


            Radio comControlledYesRadio = new Radio();
            comControlledYesRadio.setHeight(20);
            comControlledYesRadio.setBoxLabel("Да");


            CssFloatLayoutContainer radios1 = new CssFloatLayoutContainer();
            radios1.add(operStatusDownRadio, new CssFloatData(-1, new Margins(10, 0, 0, 0)));
            radios1.add(operStatusUpRadio, new CssFloatData(-1, new Margins(10, 25, 0, 0)));
            radios1.add(macVisibleNoRadio, new CssFloatData(-1, new Margins(10, 0, 0, 0)));
            radios1.add(macVisibleYesRadio, new CssFloatData(-1, new Margins(10, 37, 0, 0)));
            radios1.add(comControlledNoRadio, new CssFloatData(-1, new Margins(10, 0, 0, 20)));
            radios1.add(comControlledYesRadio, new CssFloatData(-1, new Margins(10, 0, 0, 0)));

            ToggleGroup group1 = new ToggleGroup();
            group1.add(operStatusDownRadio);
            group1.add(operStatusUpRadio);

            ToggleGroup group2 = new ToggleGroup();
            group2.add(macVisibleYesRadio);
            group2.add(macVisibleNoRadio);

            ToggleGroup group3 = new ToggleGroup();
            group3.add(comControlledNoRadio);
            group3.add(comControlledYesRadio);

            netCableDisconnectedTab.add(radios1, new VerticalLayoutData(1, 0, new Margins(0, 0, 3, marginLeft)));

            Label breakLabel = new Label("Обрыв:");
            breakLabel.addStyleName("label-text");

            Label macsOfNeighborsLabel = new Label("Маки соседей видны?");
            macsOfNeighborsLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels2 = new CssFloatLayoutContainer();
            labels2.add(breakLabel, new CssFloatData(-1, new Margins(4, 240, 0, 0)));
            labels2.add(macsOfNeighborsLabel, new CssFloatData(-1, new Margins(4, 0, 0, 20)));

            netCableDisconnectedTab.add(labels2, new VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


            com.sencha.gxt.widget.core.client.form.CheckBox breakYesCheck = new CheckBox();
            breakYesCheck.setBoxLabel("Есть:");
            breakYesCheck.setStyleName("red");

            com.sencha.gxt.widget.core.client.form.CheckBox firstPairBreakCheck = new CheckBox();
            firstPairBreakCheck.setBoxLabel("Пара 1 на ");

            TextField firstPairBreakText = new TextField();
            firstPairBreakText.setWidth(40);
//            firstPairBreakText.setHeight(35);

            Label firstPairBreakLabel = new Label("метре");
            firstPairBreakLabel.setStyleName("label-add");

            Radio macNeighAdrNoRadio = new Radio();
            macNeighAdrNoRadio.setHeight(20);
            macNeighAdrNoRadio.setBoxLabel("Нет");
            macNeighAdrNoRadio.setStyleName("red");


            Radio macNeighAdrYesRadio = new Radio();
            macNeighAdrYesRadio.setHeight(20);
            macNeighAdrYesRadio.setBoxLabel("Да");
            macNeighAdrYesRadio.setStyleName("green");

            ToggleGroup group4 = new ToggleGroup();
            group4.add(macNeighAdrYesRadio);
            group4.add(macNeighAdrNoRadio);


            CssFloatLayoutContainer firstPairBreak = new CssFloatLayoutContainer();

            firstPairBreak.add(firstPairBreakCheck, new CssFloatData(-1, new Margins(10, 0, 0, 88)));
            firstPairBreak.add(firstPairBreakText, new CssFloatData(-1, new Margins(0, 0, 0, 0)));
            firstPairBreak.add(firstPairBreakLabel, new CssFloatData(-1, new Margins(10, 0, 0, 5)));
            firstPairBreak.add(macNeighAdrNoRadio, new CssFloatData(-1, new Margins(0, 0, 0, 40)));
            firstPairBreak.add(macNeighAdrYesRadio, new CssFloatData(-1, new Margins(0, 0, 0, 0)));

            netCableDisconnectedTab.add(firstPairBreak, new VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


            Label macBelongsLabel = new Label("Мак принадлежит клиенту?");
            macBelongsLabel.addStyleName("label-text");


            netCableDisconnectedTab.add(breakYesCheck, new VerticalLayoutData(0.5, 0, new Margins(-10, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(macBelongsLabel, new VerticalLayoutData(0.5, 0, new Margins(-10, 0, 0, marginLeft + 300)));


            com.sencha.gxt.widget.core.client.form.CheckBox secondPairBreakCheck = new CheckBox();
            secondPairBreakCheck.setBoxLabel("Пара 2 на ");


            TextField secondPairBreakText = new TextField();
            secondPairBreakText.setWidth(40);


            Label secondPairBreakLabel = new Label("метре");
            secondPairBreakLabel.setStyleName("label-add");

            Radio macBelongsNoRadio = new Radio();
            macBelongsNoRadio.setHeight(20);
            macBelongsNoRadio.setBoxLabel("Нет");


            Radio macBelongsYesRadio = new Radio();
            macBelongsYesRadio.setHeight(20);
            macBelongsYesRadio.setBoxLabel("Да");


            CssFloatLayoutContainer secondPairBreak = new CssFloatLayoutContainer();
            secondPairBreak.add(secondPairBreakCheck, new CssFloatData(-1, new Margins(10, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakText, new CssFloatData(-1, new Margins(0, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakLabel, new CssFloatData(-1, new Margins(10, 0, 0, 5)));
            secondPairBreak.add(macBelongsNoRadio, new CssFloatData(-1, new Margins(15, 0, 0, 40)));
            secondPairBreak.add(macBelongsYesRadio, new CssFloatData(-1, new Margins(15, 0, 0, 5)));

            netCableDisconnectedTab.add(secondPairBreak, new VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft + 88)));


            CheckBox portDoesNotRespondCheck = new CheckBox();
            portDoesNotRespondCheck.setBoxLabel("Порт не реагирует на отключение кабеля");

            CheckBox portRebootedCheck = new CheckBox();
            portRebootedCheck.setBoxLabel("Порт перезапускали");


            netCableDisconnectedTab.add(portDoesNotRespondCheck, new VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(portRebootedCheck, new VerticalLayoutData(0.5, 0, new Margins(-15, 0, 0, marginLeft + 300)));


            CheckBox portWorksOnCheck = new CheckBox();
            portWorksOnCheck.setBoxLabel("Порт работает в режиме");

            SimpleComboBox<String> portWorksOnCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            portWorksOnCombo.setTriggerAction(TriggerAction.ALL);
            portWorksOnCombo.setEditable(true);
            portWorksOnCombo.add("10 Мбит/с");
            portWorksOnCombo.add("100 Мбит/с Half-Duplex");
            portWorksOnCombo.setValue("10 Мбит/с");
            portWorksOnCombo.setWidth(178);

            netCableDisconnectedTab.add(portWorksOnCheck, new VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(portWorksOnCombo, new VerticalLayoutData(0.7, 0, new Margins(-20, 0, 0, marginLeft + 200)));

            CheckBox noSessionsNeighborsCheck = new CheckBox();
            noSessionsNeighborsCheck.setBoxLabel("Нет сессий соседей");

            CheckBox noSessionsNeighborsAdminCheck = new CheckBox();
            SimpleComboBox<String> noSessionsNeighborsAdminCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            noSessionsNeighborsAdminCombo.setTriggerAction(TriggerAction.ALL);
            noSessionsNeighborsAdminCombo.setEditable(false);
            noSessionsNeighborsAdminCombo.add("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.add("Единовременный разрыв сессий");
            noSessionsNeighborsAdminCombo.setValue("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.setWidth(20);

            netCableDisconnectedTab.add(noSessionsNeighborsCheck, new VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(noSessionsNeighborsAdminCheck, new VerticalLayoutData(0.6, 0, new Margins(-10, 0, 0, marginLeft + 300)));
            netCableDisconnectedTab.add(noSessionsNeighborsAdminCombo, new VerticalLayoutData(0.92, 0, new Margins(-20, 0, 0, marginLeft + 320)));


            CheckBox routerDefectiveCheck = new CheckBox();
            routerDefectiveCheck.setBoxLabel("Роутер неисправен (напрямую все ок)");

            CheckBox replacementIfNecessaryCheck = new CheckBox();
            replacementIfNecessaryCheck.setBoxLabel("Замена при необходимости");

            netCableDisconnectedTab.add(routerDefectiveCheck, new VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(replacementIfNecessaryCheck, new VerticalLayoutData(1, 0, new Margins(-15, 0, 0, marginLeft + 300)));

            CheckBox problemPortsCheck = new CheckBox();
            problemPortsCheck.setBoxLabel("Клиент попал в отчет по проблемным портам");

            netCableDisconnectedTab.add(problemPortsCheck, new VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));


            internetTabPanel.add(netCableDisconnectedTab, "678, 651, 815...");
            internetTabPanel.add(razrLabel1, "Разрывы");
            internetTabPanel.add(speedLabel2, "Скорость");


            TabPanel tabPanel = new TabPanel();
//            tabPanel.setStyleName("tab-style");
            tabPanel.add(internetTabPanel, "Интернет");
            tabPanel.add(normalLabel1, "Дом.ru TV");
            tabPanel.add(normalLabel2, "Телефония");

            container = new VerticalLayoutContainer();


            container.add(tabPanel, new VerticalLayoutData(1, 0.5, new Margins(0, 0, 0, marginLeft)));

            VerticalLayoutContainer generationContainer = new VerticalLayoutContainer();
            generationContainer.setBorders(true);


            CheckBox fromTheWordsCheck = new CheckBox();
            fromTheWordsCheck.setBoxLabel("Со слов клиента, ...");

            CheckBox cableConnectionsChecked = new CheckBox();
            cableConnectionsChecked.setBoxLabel("Подключение кабеля проверено, повреждений нет");

            HorizontalLayoutContainer checkCableContainer = new HorizontalLayoutContainer();

            checkCableContainer.add(fromTheWordsCheck, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            checkCableContainer.add(cableConnectionsChecked, new HorizontalLayoutData(2, 0, new Margins(0, 0, 0, 20)));

            generationContainer.add(checkCableContainer, new VerticalLayoutData(0.5, 0, new Margins(10, 0, 0, marginLeft)));




            CheckBox convenientTimeCheck = new CheckBox();
            convenientTimeCheck.setBoxLabel("Удобное время");

            SimpleComboBox<String> convenientTimeCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            convenientTimeCombo.setTriggerAction(TriggerAction.ALL);
            convenientTimeCombo.setEditable(true);
            for (int i = 9; i < 21; i++) {
                convenientTimeCombo.add("с " + i + ":00 до " + (i+1) +":00");
            }

            DateField convenientDateField = new DateField();
            final DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
            convenientDateField.setPropertyEditor(new DateTimePropertyEditor(format));
            convenientDateField.getDatePicker().setMinDate(new DateWrapper().addDays(0).asDate());





            HorizontalLayoutContainer convenientTimeContainer = new HorizontalLayoutContainer();

            convenientTimeContainer.add(convenientTimeCheck, new HorizontalLayoutData(0.3, 0, new Margins(10, 0, 0, 0)));
            convenientTimeContainer.add(convenientTimeCombo, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, -30)));
            convenientTimeContainer.add(convenientDateField, new HorizontalLayoutData(0.28, 0, new Margins(0, 0, 0, 10)));

            generationContainer.add(convenientTimeContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));






            Label contactTelLabel = new Label("Контактный тел.:");
            contactTelLabel.addStyleName("labels");

            TextField contactTelField = new TextField();

            HorizontalLayoutContainer contactTelContainer = new HorizontalLayoutContainer();

            contactTelContainer.add(contactTelLabel, new HorizontalLayoutData(0.3, 0, new Margins(20, 0, 0, 0)));
            contactTelContainer.add(contactTelField, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, -30)));

            generationContainer.add(contactTelContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));



            HorizontalLayoutContainer createTopChecksContainer = new HorizontalLayoutContainer();

            CheckBox clientConflictCheck = new CheckBox();
            clientConflictCheck.setBoxLabel("Клиент конфликтный");

            CheckBox fromPpdCheck = new CheckBox();
            fromPpdCheck.setBoxLabel("От ППД");

            CheckBox scheduleSzCheck = new CheckBox();
            scheduleSzCheck.setBoxLabel("СЗ вне графика");

            createTopChecksContainer.add(clientConflictCheck, new HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));
            createTopChecksContainer.add(fromPpdCheck, new HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -10)));
            createTopChecksContainer.add(scheduleSzCheck, new HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -30)));

            generationContainer.add(createTopChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer createBottomChecksContainer = new HorizontalLayoutContainer();

            CheckBox onHoldCheck = new CheckBox();
            onHoldCheck.setBoxLabel("На удержание");

            CheckBox guaranteeServiceCheck = new CheckBox();
            guaranteeServiceCheck.setBoxLabel("Гарантийное обслуживание");

            TextButton createButton = new TextButton("Создать заявку");

            createBottomChecksContainer.add(onHoldCheck, new HorizontalLayoutData(0.3, 0, new Margins(40, 0, 0, 0)));
            createBottomChecksContainer.add(guaranteeServiceCheck, new HorizontalLayoutData(0.35, 0, new Margins(40, 0, 0, -10)));
            createBottomChecksContainer.add(createButton, new HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));

            generationContainer.add(createBottomChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));

            TextArea orderTextArea = new TextArea();
            orderTextArea.setHeight(100);


            generationContainer.add(orderTextArea, new VerticalLayoutData(1, 0, new Margins(80, marginLeft, 0, marginLeft)));

            container.add(generationContainer, new VerticalLayoutData(1, 0.5, new Margins(0, 0, 0, marginLeft)));


        }

        return container;
    }


    public void onModuleLoad() {
        this.container = (VerticalLayoutContainer) asWidget();
        this.container.setStyleName("main");
        RootPanel.get().add(container);

    }


}
