package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    static final Radio netCableDisconnectedRadio = new Radio();
    static final Radio remotePcNotAnsweredRadio = new Radio();
    static final Radio operStatusDownRadio = new Radio();
    static final Radio operStatusUpRadio = new Radio();
    static final Radio macVisibleNoRadio = new Radio();
    static final Radio macVisibleYesRadio = new Radio();
    static final Radio comControlledNoRadio = new Radio();
    static final Radio comControlledYesRadio = new Radio();
    static final CheckBox breakYesCheck = new CheckBox();
    static final CheckBox firstPairBreakCheck = new CheckBox();
    static final TextField firstPairBreakText = new TextField();
    static final CheckBox secondPairBreakCheck = new CheckBox();
    static final Radio macNeighAdrNoRadio = new Radio();
    static final Radio macNeighAdrYesRadio = new Radio();
    static final TextField secondPairBreakText = new TextField();
    static final Radio macBelongsNoRadio = new Radio();
    static final Radio macBelongsYesRadio = new Radio();
    static final CheckBox portRebootedCheck = new CheckBox();
    static final CheckBox portWorksOnCheck = new CheckBox();
    static final CheckBox noSessionsNeighborsCheck = new CheckBox();
    static final CheckBox portDoesNotRespondCheck = new CheckBox();
    static final SimpleComboBox<String> portWorksOnCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
    static final CheckBox noSessionsNeighborsAdminCheck = new CheckBox();
    static final SimpleComboBox<String> noSessionsNeighborsAdminCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
    static final CheckBox routerDefectiveCheck = new CheckBox();
    static final CheckBox replacementIfNecessaryCheck = new CheckBox();
    static final CheckBox problemPortsCheck = new CheckBox();

    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();


            container.setStyleName("borders");

            Label textErrorLabel = new Label("Текст ошибки:");
            textErrorLabel.addStyleName("label-text");
            container.add(textErrorLabel, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));


            netCableDisconnectedRadio.setHeight(20);
            netCableDisconnectedRadio.setBoxLabel("Сетевой кабель не подключен");
            netCableDisconnectedRadio.setValue(true);
            netCableDisconnectedRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (netCableDisconnectedRadio.getValue()){
                        remotePcNotAnsweredRadio.setValue(false);
                    }
                }
            });


            remotePcNotAnsweredRadio.setHeight(20);
            remotePcNotAnsweredRadio.setBoxLabel("Удаленный компьютер не отвечает");
            remotePcNotAnsweredRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (remotePcNotAnsweredRadio.getValue()){
                        netCableDisconnectedRadio.setValue(false);
                    }
                }
            });

            CssFloatLayoutContainer radios = new CssFloatLayoutContainer();
            radios.add(netCableDisconnectedRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 20, 0, 0)));
            radios.add(remotePcNotAnsweredRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(netCableDisconnectedRadio);
            group.add(remotePcNotAnsweredRadio);

            container.add(radios, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 5, marginLeft)));


            Label operStatusLabel = new Label("Oper status:");
            operStatusLabel.addStyleName("label-text");

            Label macVisibleLabel = new Label("Mac-адрес виден?");
            macVisibleLabel.addStyleName("label-text");


            Label commutatorTypeLabel = new Label("Коммутатор управляемый?");
            commutatorTypeLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels = new CssFloatLayoutContainer();
            labels.add(operStatusLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 70, 0, marginLeft)));
            labels.add(macVisibleLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 40, 0, 0)));
            labels.add(commutatorTypeLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 5)));
            container.add(labels, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 2, 0)));


            operStatusDownRadio.setHeight(20);
            operStatusDownRadio.setBoxLabel("Down");
            operStatusDownRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (operStatusDownRadio.getValue()){
                        operStatusUpRadio.setValue(false);
                    }
                }
            });
            operStatusUpRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (operStatusUpRadio.getValue()){
                        operStatusDownRadio.setValue(false);
                    }
                }
            });


            operStatusUpRadio.setHeight(20);
            operStatusUpRadio.setBoxLabel("Up");
            operStatusUpRadio.addStyleName("green");


            macVisibleNoRadio.setHeight(20);
            macVisibleNoRadio.setBoxLabel("Нет");
            macVisibleNoRadio.addStyleName("red");


            macVisibleYesRadio.setHeight(20);
            macVisibleYesRadio.setBoxLabel("Да");
            macVisibleYesRadio.addStyleName("green");


            macVisibleNoRadio.setEnabled(false);
            macVisibleYesRadio.setEnabled(false);
            operStatusDownRadio.setValue(true);
            macVisibleNoRadio.setValue(true);

            comControlledNoRadio.setHeight(20);
            comControlledNoRadio.setBoxLabel("Нет");
            comControlledNoRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (comControlledNoRadio.getValue()){
                        comControlledYesRadio.setValue(false);
                    }
                }
            });


            comControlledYesRadio.setHeight(20);
            comControlledYesRadio.setBoxLabel("Да");
            comControlledYesRadio.setValue(true);
            comControlledYesRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (comControlledYesRadio.getValue()){
                        comControlledNoRadio.setValue(false);
                    }
                }
            });


            CssFloatLayoutContainer radios1 = new CssFloatLayoutContainer();
            radios1.add(operStatusDownRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 0, 0, 0)));
            radios1.add(operStatusUpRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 25, 0, 0)));
            radios1.add(macVisibleNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 0, 0, 0)));
            radios1.add(macVisibleYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 37, 0, 0)));
            radios1.add(comControlledYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 0, 0, 20)));
            radios1.add(comControlledNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(5, 0, 0, 0)));


            container.add(radios1, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 3, marginLeft)));

            Label breakLabel = new Label("Обрыв:");
            breakLabel.addStyleName("label-text");

            Label macsOfNeighborsLabel = new Label("Маки соседей видны?");
            macsOfNeighborsLabel.addStyleName("label-text");


            CssFloatLayoutContainer labels2 = new CssFloatLayoutContainer();
            labels2.add(breakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 240, 0, 0)));
            labels2.add(macsOfNeighborsLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(4, 0, 0, 15)));

            container.add(labels2, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


            breakYesCheck.setBoxLabel("Есть:");
            breakYesCheck.setStyleName("red");

            firstPairBreakCheck.setBoxLabel("Пара 1 на ");

            firstPairBreakText.setWidth(40);
//            firstPairBreakText.setHeight(35);

            Label firstPairBreakLabel = new Label("метре");
            firstPairBreakLabel.setStyleName("label-add");


            macNeighAdrNoRadio.setHeight(20);
            macNeighAdrNoRadio.setBoxLabel("Нет");
            macNeighAdrNoRadio.setStyleName("red");
            macNeighAdrNoRadio.setValue(true);
            macNeighAdrNoRadio.setEnabled(false);


            macNeighAdrYesRadio.setHeight(20);
            macNeighAdrYesRadio.setBoxLabel("Да");
            macNeighAdrYesRadio.setStyleName("green");
            macNeighAdrYesRadio.setEnabled(false);


            CssFloatLayoutContainer firstPairBreak = new CssFloatLayoutContainer();

            firstPairBreak.add(firstPairBreakCheck, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 88)));
            firstPairBreak.add(firstPairBreakText, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));
            firstPairBreak.add(firstPairBreakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 5)));
            firstPairBreak.add(macNeighAdrNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 40)));
            firstPairBreak.add(macNeighAdrYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));

            container.add(firstPairBreak, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft)));


            Label macBelongsLabel = new Label("Мак принадлежит клиенту?");
            macBelongsLabel.addStyleName("label-text");


            container.add(breakYesCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(-20, 0, 0, marginLeft)));
            container.add(macBelongsLabel, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(-20, 0, 0, marginLeft + 300)));


            secondPairBreakCheck.setBoxLabel("Пара 2 на ");


            secondPairBreakText.setWidth(40);


            Label secondPairBreakLabel = new Label("метре");
            secondPairBreakLabel.setStyleName("label-add");


            macBelongsNoRadio.setHeight(20);
            macBelongsNoRadio.setBoxLabel("Нет");
            macBelongsNoRadio.setValue(true);
            macBelongsNoRadio.setEnabled(false);
            macBelongsNoRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (macBelongsNoRadio.getValue()){
                        macBelongsYesRadio.setValue(false);
                    }
                }
            });


            macBelongsYesRadio.setHeight(20);
            macBelongsYesRadio.setBoxLabel("Да");
            macBelongsYesRadio.setEnabled(false);
            macBelongsYesRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (macBelongsYesRadio.getValue()){
                        macBelongsNoRadio.setValue(false);
                    }
                }
            });

            CssFloatLayoutContainer secondPairBreak = new CssFloatLayoutContainer();
            secondPairBreak.add(secondPairBreakCheck, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakText, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(0, 0, 0, 0)));
            secondPairBreak.add(secondPairBreakLabel, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 5)));
            secondPairBreak.add(macBelongsNoRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 40)));
            secondPairBreak.add(macBelongsYesRadio, new CssFloatLayoutContainer.CssFloatData(-1, new Margins(10, 0, 0, 5)));

            container.add(secondPairBreak, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(0, 0, 10, marginLeft + 88)));


            ToggleGroup group1 = new ToggleGroup();
            group1.add(operStatusDownRadio);
            group1.add(operStatusUpRadio);

            ToggleGroup group2 = new ToggleGroup();
            group2.add(macVisibleYesRadio);
            group2.add(macVisibleNoRadio);

            ToggleGroup group3 = new ToggleGroup();
            group3.add(comControlledNoRadio);
            group3.add(comControlledYesRadio);


            ToggleGroup group4 = new ToggleGroup();
            group4.add(macNeighAdrYesRadio);
            group4.add(macNeighAdrNoRadio);

            ToggleGroup group5 = new ToggleGroup();
            group5.add(macBelongsNoRadio);
            group5.add(macBelongsYesRadio);

            ToggleGroup group6 = new ToggleGroup();
            group6.add(macNeighAdrYesRadio);
            group6.add(macNeighAdrNoRadio);


            portDoesNotRespondCheck.setBoxLabel("Порт не реагирует на отключение кабеля");


            portRebootedCheck.setBoxLabel("Порт перезапускали");


            container.add(portDoesNotRespondCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(0, 0, 0, marginLeft)));
            container.add(portRebootedCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(0, 0, 0, marginLeft + 300)));


            portWorksOnCheck.setBoxLabel("Порт работает в режиме");


            portWorksOnCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            portWorksOnCombo.add("10 Мбит/с");
            portWorksOnCombo.add("100 Мбит/с Half-Duplex");
            portWorksOnCombo.setValue("10 Мбит/с");
            portWorksOnCombo.setWidth(178);
            portWorksOnCombo.setEditable(false);

            container.add(portWorksOnCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(30, 0, 0, marginLeft)));
            container.add(portWorksOnCombo, new VerticalLayoutContainer.VerticalLayoutData(0.7, 0, new Margins(-20, 0, 0, marginLeft + 200)));


            noSessionsNeighborsCheck.setBoxLabel("Нет сессий соседей");


            noSessionsNeighborsAdminCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            noSessionsNeighborsAdminCombo.setEditable(false);
            noSessionsNeighborsAdminCombo.add("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.add("Единовременный разрыв сессий");
            noSessionsNeighborsAdminCombo.setValue("Магистральный порт NO");
            noSessionsNeighborsAdminCombo.setWidth(20);

            container.add(noSessionsNeighborsCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            container.add(noSessionsNeighborsAdminCheck, new VerticalLayoutContainer.VerticalLayoutData(0.6, 0, new Margins(-10, 0, 0, marginLeft + 300)));
            container.add(noSessionsNeighborsAdminCombo, new VerticalLayoutContainer.VerticalLayoutData(0.96, 0, new Margins(-20, 0, 0, marginLeft + 320)));


            routerDefectiveCheck.setBoxLabel("Роутер неисправен (напрямую все ок)");


            replacementIfNecessaryCheck.setBoxLabel("Замена при необходимости");

            container.add(routerDefectiveCheck, new VerticalLayoutContainer.VerticalLayoutData(0.5, 0, new Margins(20, 0, 0, marginLeft)));
            container.add(replacementIfNecessaryCheck, new VerticalLayoutContainer.VerticalLayoutData(1, 0, new Margins(-15, 0, 0, marginLeft + 300)));


            problemPortsCheck.setBoxLabel("Клиент попал в отчет по проблемным портам");

            container.add(problemPortsCheck, new VerticalLayoutContainer.VerticalLayoutData(0.6, -1, new Margins(15, 0, 0, marginLeft)));

            container.setHeight(820);


            operStatusUpRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (operStatusUpRadio.getValue()) {
                        macVisibleNoRadio.setEnabled(true);
                        macVisibleYesRadio.setEnabled(true);
                    }
                }
            });

            operStatusDownRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (operStatusDownRadio.getValue()) {
                        macVisibleNoRadio.setEnabled(false);
                        macVisibleYesRadio.setEnabled(false);
                        macVisibleYesRadio.setValue(false);
                        macVisibleNoRadio.setValue(true);
                        macBelongsNoRadio.setEnabled(false);
                        macBelongsNoRadio.setValue(true);
                        macBelongsYesRadio.setEnabled(false);
                        macBelongsNoRadio.setValue(false);
                    }
                }
            });

            macVisibleYesRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (macVisibleYesRadio.getValue()) {
                        macBelongsNoRadio.setEnabled(true);
                        macBelongsYesRadio.setEnabled(true);
                        macVisibleNoRadio.setValue(false);

                    }
                }
            });

            macVisibleNoRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (macVisibleNoRadio.getValue()) {
                        macBelongsNoRadio.setEnabled(true);
                        macBelongsYesRadio.setEnabled(true);
                        macVisibleYesRadio.setValue(false);
                    }
                }
            });

            comControlledNoRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (comControlledNoRadio.getValue()) {
                        macNeighAdrNoRadio.setEnabled(true);
                        macNeighAdrYesRadio.setEnabled(true);
                        portRebootedCheck.setEnabled(false);
                        portRebootedCheck.setValue(false);
                    }
                }
            });

            comControlledYesRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (comControlledYesRadio.getValue()) {
                        macNeighAdrNoRadio.setEnabled(false);
                        macNeighAdrYesRadio.setEnabled(false);
                        macNeighAdrNoRadio.setValue(true);
                        macNeighAdrYesRadio.setValue(false);
                        portRebootedCheck.setEnabled(true);
                    }
                }
            });

            macNeighAdrYesRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (macNeighAdrYesRadio.getValue()) {
                        macNeighAdrNoRadio.setValue(false);
                    }
                }
            });

            firstPairBreakCheck.setEnabled(false);
            firstPairBreakText.setEnabled(false);
            secondPairBreakCheck.setEnabled(false);
            secondPairBreakText.setEnabled(false);
            firstPairBreakCheck.setValue(false);
            secondPairBreakCheck.setValue(false);


            breakYesCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (breakYesCheck.getValue()) {
                        firstPairBreakCheck.setEnabled(true);
                        firstPairBreakText.setEnabled(true);
                        secondPairBreakCheck.setEnabled(true);
                        secondPairBreakText.setEnabled(true);
                    } else {
                        firstPairBreakCheck.setEnabled(false);
                        firstPairBreakText.setEnabled(false);
                        secondPairBreakCheck.setEnabled(false);
                        secondPairBreakText.setEnabled(false);
                        firstPairBreakCheck.setValue(false);
                        secondPairBreakCheck.setValue(false);
                        firstPairBreakText.setValue("");
                        secondPairBreakText.setValue("");
                    }
                }
            });


        }

        return container;
    }
}
