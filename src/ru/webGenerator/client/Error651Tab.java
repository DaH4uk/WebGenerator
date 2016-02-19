package ru.webGenerator.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Created by DaH4uk on 18.02.2016.
 */
public class Error651Tab implements IsWidget {

    private VerticalLayoutContainer netCableDisconnectedTab;
    private int marginLeft = WebGenerator.marginLeft;

    @Override
    public Widget asWidget() {
        if (netCableDisconnectedTab == null) {
            netCableDisconnectedTab = new VerticalLayoutContainer();

            netCableDisconnectedTab.setBorders(true);

            Label textErrorLabel = new Label("Текст ошибки:");
            textErrorLabel.addStyleName("label-text");
            netCableDisconnectedTab.add(textErrorLabel, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));


            Radio netCableDisconnectedRadio = new Radio();
            netCableDisconnectedRadio.setHeight(20);
            netCableDisconnectedRadio.setBoxLabel("Сетевой кабель не подключен");


            Radio remotePcNotAnsweredRadio = new Radio();
            remotePcNotAnsweredRadio.setHeight(20);
            remotePcNotAnsweredRadio.setBoxLabel("Удаленный компьютер не отвечает");

            CssFloatLayoutContainer radios = new CssFloatLayoutContainer();
            radios.add(netCableDisconnectedRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 20, 0, 0)));
            radios.add(remotePcNotAnsweredRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(netCableDisconnectedRadio);
            group.add(remotePcNotAnsweredRadio);

            netCableDisconnectedTab.add(radios, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 5, marginLeft)));


            Label operStatusLabel = new Label("Oper status:");
            operStatusLabel.addStyleName("label-text");

            Label macVisibleLabel = new Label("Mac-адрес виден?");
            macVisibleLabel.addStyleName("label-text");

            Label commutatorTypeLabel = new Label("Коммутатор управляемый?");
            commutatorTypeLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels = new CssFloatLayoutContainer();
            labels.add(operStatusLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 75, 0, marginLeft)));
            labels.add(macVisibleLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 35, 0, 0)));
            labels.add(commutatorTypeLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 20)));
            netCableDisconnectedTab.add(labels, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 2, 0)));


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
            radios1.add(operStatusDownRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 0)));
            radios1.add(operStatusUpRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 25, 0, 0)));
            radios1.add(macVisibleNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 0)));
            radios1.add(macVisibleYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 37, 0, 0)));
            radios1.add(comControlledNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 20)));
            radios1.add(comControlledYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 0)));

            ToggleGroup group1 = new ToggleGroup();
            group1.add(operStatusDownRadio);
            group1.add(operStatusUpRadio);

            ToggleGroup group2 = new ToggleGroup();
            group2.add(macVisibleYesRadio);
            group2.add(macVisibleNoRadio);

            ToggleGroup group3 = new ToggleGroup();
            group3.add(comControlledNoRadio);
            group3.add(comControlledYesRadio);

            netCableDisconnectedTab.add(radios1, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 3, marginLeft)));

            Label breakLabel = new Label("Обрыв:");
            breakLabel.addStyleName("label-text");

            Label macsOfNeighborsLabel = new Label("Маки соседей видны?");
            macsOfNeighborsLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels2 = new CssFloatLayoutContainer();
            labels2.add(breakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 240, 0, 0)));
            labels2.add(macsOfNeighborsLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 20)));

            netCableDisconnectedTab.add(labels2, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


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

            firstPairBreak.add(firstPairBreakCheck, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 88)));
            firstPairBreak.add(firstPairBreakText, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));
            firstPairBreak.add(firstPairBreakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 5)));
            firstPairBreak.add(macNeighAdrNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 40)));
            firstPairBreak.add(macNeighAdrYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));

            netCableDisconnectedTab.add(firstPairBreak, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


            Label macBelongsLabel = new Label("Мак принадлежит клиенту?");
            macBelongsLabel.addStyleName("label-text");


            netCableDisconnectedTab.add(breakYesCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(-10, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(macBelongsLabel, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(-10, 0, 0, marginLeft + 300)));


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
            secondPairBreak.add(secondPairBreakCheck, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakText, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 5)));
            secondPairBreak.add(macBelongsNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(15, 0, 0, 40)));
            secondPairBreak.add(macBelongsYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(15, 0, 0, 5)));

            netCableDisconnectedTab.add(secondPairBreak, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft + 88)));


            CheckBox portDoesNotRespondCheck = new CheckBox();
            portDoesNotRespondCheck.setBoxLabel("Порт не реагирует на отключение кабеля");

            CheckBox portRebootedCheck = new CheckBox();
            portRebootedCheck.setBoxLabel("Порт перезапускали");


            netCableDisconnectedTab.add(portDoesNotRespondCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(portRebootedCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(-15, 0, 0, marginLeft + 300)));


            CheckBox portWorksOnCheck = new CheckBox();
            portWorksOnCheck.setBoxLabel("Порт работает в режиме");

            SimpleComboBox<String> portWorksOnCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            portWorksOnCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            portWorksOnCombo.setEditable(true);
            portWorksOnCombo.add("10 Мбит/с");
            portWorksOnCombo.add("100 Мбит/с Half-Duplex");
            portWorksOnCombo.setValue("10 Мбит/с");
            portWorksOnCombo.setWidth(178);

            netCableDisconnectedTab.add(portWorksOnCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(portWorksOnCombo, new VerticalLayoutContainer.VerticalLayoutData(0.7, 0, new Margins(-20, 0, 0, marginLeft + 200)));

            CheckBox noSessionsNeighborsCheck = new CheckBox();
            noSessionsNeighborsCheck.setBoxLabel("Нет сессий соседей");

            CheckBox noSessionsNeighborsAdminCheck = new CheckBox();
            SimpleComboBox<String> noSessionsNeighborsAdminCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            noSessionsNeighborsAdminCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            noSessionsNeighborsAdminCombo.setEditable(false);
            noSessionsNeighborsAdminCombo.add("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.add("Единовременный разрыв сессий");
            noSessionsNeighborsAdminCombo.setValue("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.setWidth(20);

            netCableDisconnectedTab.add(noSessionsNeighborsCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(noSessionsNeighborsAdminCheck, new VerticalLayoutContainer.VerticalLayoutData(0.6, 0, new Margins(-10, 0, 0, marginLeft + 300)));
            netCableDisconnectedTab.add(noSessionsNeighborsAdminCombo, new VerticalLayoutContainer.VerticalLayoutData(0.92, 0, new Margins(-20, 0, 0, marginLeft + 320)));


            CheckBox routerDefectiveCheck = new CheckBox();
            routerDefectiveCheck.setBoxLabel("Роутер неисправен (напрямую все ок)");

            CheckBox replacementIfNecessaryCheck = new CheckBox();
            replacementIfNecessaryCheck.setBoxLabel("Замена при необходимости");

            netCableDisconnectedTab.add(routerDefectiveCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            netCableDisconnectedTab.add(replacementIfNecessaryCheck, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(-15, 0, 0, marginLeft + 300)));

            CheckBox problemPortsCheck = new CheckBox();
            problemPortsCheck.setBoxLabel("Клиент попал в отчет по проблемным портам");

            netCableDisconnectedTab.add(problemPortsCheck, new VerticalLayoutContainer.VerticalLayoutData(0.6, -1, new Margins(20, 0, 0, marginLeft)));

            netCableDisconnectedTab.setHeight(910);
        }

        return netCableDisconnectedTab;
    }
}
