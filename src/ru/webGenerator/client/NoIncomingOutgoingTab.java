package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Created by DaH4uk on 21.02.2016.
 */
public class NoIncomingOutgoingTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    static final CheckBox sipCheck = new CheckBox();
    static final CheckBox callFromOfficeCheck = new CheckBox();
    static final CheckBox incomingCheck = new CheckBox();
    static final Radio passesSipRadio = new Radio();
    static final Radio callFromOfficePassesRadio = new Radio();
    static final CheckBox outgoingCheck = new CheckBox();
    static final Radio notPassSipRadio = new Radio();
    static final Radio callFromOfficeNoPassesRadio = new Radio();
    static final TextField moroMoroField = new TextField();
    static final CheckBox withSpecificNumberCheck = new CheckBox();
    static final TextField withSpecificNumberField = new TextField();
    static final Radio numberMatchesRadio = new Radio();
    static final Radio numberNoMatchesRadio = new Radio();
    static final CheckBox otherTaCheckBox = new CheckBox();
    static final Radio hornInTubeYesRadio = new Radio();
    static final Radio hornInTubeNoRadio = new Radio();
    static final Radio otherTaYesRadio = new Radio();
    static final Radio otherTaNoRadio = new Radio();
    static final CheckBox rebootedAdapterCheck = new CheckBox();
    static final TextArea samplesIncomingArea = new TextArea();
    static final TextArea samplesOutgoingArea = new TextArea();

    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();

            HorizontalLayoutContainer subContainer1 = new HorizontalLayoutContainer();

            Label noLabel = new Label("Отсутствует:");
            noLabel.setStyleName("label-text");
            subContainer1.add(noLabel, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            sipCheck.setBoxLabel("SIP-регистрация:");
            subContainer1.add(sipCheck, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            callFromOfficeCheck.setBoxLabel("Звонок из офиса:");
            subContainer1.add(callFromOfficeCheck, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            Label moroMoroLabel = new Label("Moro-moro:");
            moroMoroLabel.setStyleName("label-text");
            subContainer1.add(moroMoroLabel, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 10)));

            container.add(subContainer1, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer2 = new HorizontalLayoutContainer();


            incomingCheck.setBoxLabel("Входящая");
            subContainer2.add(incomingCheck, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            passesSipRadio.setBoxLabel("Проходит");
            subContainer2.add(passesSipRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            callFromOfficePassesRadio.setBoxLabel("Проходит");
            subContainer2.add(callFromOfficePassesRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            Label moroMoroLabel1 = new Label("код ошибки");
            moroMoroLabel1.setStyleName("sub-labels");
            subContainer2.add(moroMoroLabel1, new HorizontalLayoutData(0.25, 0, new Margins(-5, 0, 0, 10)));

            container.add(subContainer2, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer3 = new HorizontalLayoutContainer();


            outgoingCheck.setBoxLabel("Исходящая");
            subContainer3.add(outgoingCheck, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            notPassSipRadio.setBoxLabel("Не проходит");
            subContainer3.add(notPassSipRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            callFromOfficeNoPassesRadio.setBoxLabel("Не проходит");
            subContainer3.add(callFromOfficeNoPassesRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            subContainer3.add(moroMoroField, new HorizontalLayoutData(0.13, 0, new Margins(-10, 0, 0, 10)));

            container.add(subContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer4 = new HorizontalLayoutContainer();


            withSpecificNumberCheck.setBoxLabel("С конкретным номером:");
            subContainer4.add(withSpecificNumberCheck, new HorizontalLayoutData(0.3, 0, new Margins(5, 0, 0, 0)));


            subContainer4.add(withSpecificNumberField, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            Label samplesOfNumbersLabel = new Label("Примеры номеров:");
            samplesOfNumbersLabel.setStyleName("label-text");
            subContainer4.add(samplesOfNumbersLabel, new HorizontalLayoutData(0.13, 0, new Margins(5, 0, 0, 10)));

            container.add(subContainer4, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer5 = new HorizontalLayoutContainer();

            Label numberInAdapterLabel = new Label("Номер в приложении и в адаптере:");
            numberInAdapterLabel.setStyleName("label-text");
            subContainer5.add(numberInAdapterLabel, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));


            Label samplesIncomingLabel = new Label("Входящие:");
            samplesIncomingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesIncomingLabel, new HorizontalLayoutData(0.2, 0, new Margins(-10, 0, 0, 125)));


            Label samplesOutgoingLabel = new Label("Исходящие:");
            samplesOutgoingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesOutgoingLabel, new HorizontalLayoutData(0.13, 0, new Margins(-10, 0, 0, 100)));

            container.add(subContainer5, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer6 = new HorizontalLayoutContainer();

            VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();


            numberMatchesRadio.setBoxLabel("Совпадают");
            verticalLayoutContainer.add(numberMatchesRadio, new VerticalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));


            numberNoMatchesRadio.setBoxLabel("Не совпадают");
            verticalLayoutContainer.add(numberNoMatchesRadio, new VerticalLayoutData(0.7, 0, new Margins(0, 0, 0, 90)));

            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.add(numberMatchesRadio);
            toggleGroup.add(numberNoMatchesRadio);

            HorizontalLayoutContainer subContainer7 = new HorizontalLayoutContainer();


            Label hornInTubeLabel = new Label("Гудок в трубке:");
            hornInTubeLabel.setStyleName("label-text");
            subContainer7.add(hornInTubeLabel, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));



            otherTaCheckBox.setBoxLabel("Другой ТА:");
            subContainer7.add(otherTaCheckBox, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            verticalLayoutContainer.add(subContainer7, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, 0)));


            HorizontalLayoutContainer subContainer8 = new HorizontalLayoutContainer();


            hornInTubeYesRadio.setBoxLabel("Есть");
            subContainer8.add(hornInTubeYesRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            hornInTubeNoRadio.setBoxLabel("Нет");
            subContainer8.add(hornInTubeNoRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(hornInTubeYesRadio);
            group.add(hornInTubeNoRadio);


            otherTaYesRadio.setBoxLabel("Есть");
            subContainer8.add(otherTaYesRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 28)));


            otherTaNoRadio.setBoxLabel("Нет");
            subContainer8.add(otherTaNoRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup group1 = new ToggleGroup();
            group1.add(otherTaYesRadio);
            group1.add(otherTaNoRadio);


            verticalLayoutContainer.add(subContainer8, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));



            rebootedAdapterCheck.setBoxLabel("Адаптер перезагружали");
            verticalLayoutContainer.add(rebootedAdapterCheck, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, 0)));


            subContainer6.add(verticalLayoutContainer, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));


            samplesIncomingArea.setWidth(30);
            subContainer6.add(samplesIncomingArea, new HorizontalLayoutData(0.14, 1, new Margins(-15, 0, 0, 8)));



            subContainer6.add(samplesOutgoingArea, new HorizontalLayoutData(0.157, 1, new Margins(-15, 0, 0, 18)));

            container.add(subContainer6, new VerticalLayoutData(1, 0.25, new Margins(20, 0, 0, marginLeft)));

            ToggleGroup group2 = new ToggleGroup();
            group2.add(passesSipRadio);
            group2.add(notPassSipRadio);

            passesSipRadio.setEnabled(false);
            passesSipRadio.setValue(true);
            notPassSipRadio.setEnabled(false);

            sipCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (sipCheck.getValue()) {
                        notPassSipRadio.setEnabled(true);
                        passesSipRadio.setEnabled(true);
                    } else {
                        passesSipRadio.setEnabled(false);
                        notPassSipRadio.setEnabled(false);
                    }
                }
            });

            ToggleGroup group3 = new ToggleGroup();
            group3.add(callFromOfficeNoPassesRadio);
            group3.add(callFromOfficePassesRadio);

            callFromOfficeNoPassesRadio.setEnabled(false);
            callFromOfficePassesRadio.setEnabled(false);
            callFromOfficePassesRadio.setValue(true);

            callFromOfficeCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (callFromOfficeCheck.getValue()) {
                        callFromOfficeNoPassesRadio.setEnabled(true);
                        callFromOfficePassesRadio.setEnabled(true);
                    } else {
                        callFromOfficeNoPassesRadio.setEnabled(false);
                        callFromOfficePassesRadio.setEnabled(false);
                    }
                }
            });

            withSpecificNumberField.setEnabled(false);

            withSpecificNumberCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (withSpecificNumberCheck.getValue()) {
                        withSpecificNumberField.setEnabled(true);
                    } else {
                        withSpecificNumberField.setEnabled(false);
                    }
                }
            });

            numberMatchesRadio.setEnabled(false);
            numberMatchesRadio.setValue(true);
            numberNoMatchesRadio.setEnabled(false);
            samplesIncomingArea.setEnabled(false);

            incomingCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (incomingCheck.getValue() && !outgoingCheck.getValue()) {
                        numberMatchesRadio.setEnabled(true);
                        numberNoMatchesRadio.setEnabled(true);
                        hornInTubeYesRadio.setEnabled(false);
                        hornInTubeNoRadio.setEnabled(false);
                    } else if (incomingCheck.getValue() && outgoingCheck.getValue()) {
                        numberMatchesRadio.setEnabled(false);
                        numberNoMatchesRadio.setEnabled(false);
                        hornInTubeYesRadio.setEnabled(true);
                        hornInTubeNoRadio.setEnabled(true);
                    } else {
                        numberMatchesRadio.setEnabled(false);
                        numberNoMatchesRadio.setEnabled(false);
                        hornInTubeYesRadio.setEnabled(false);
                        hornInTubeNoRadio.setEnabled(false);
                    }
                    if (incomingCheck.getValue()) {
                        samplesIncomingArea.setEnabled(true);
                    } else {
                        samplesIncomingArea.setEnabled(false);
                        samplesIncomingArea.setText("");
                    }
                    if (outgoingCheck.getValue()) {
                        samplesOutgoingArea.setEnabled(true);
                    } else {
                        samplesOutgoingArea.setEnabled(false);
                        samplesOutgoingArea.setText("");
                    }


                }
            });
            samplesOutgoingArea.setEnabled(false);

            hornInTubeNoRadio.setEnabled(false);
            hornInTubeYesRadio.setEnabled(false);
            hornInTubeYesRadio.setValue(true);

            outgoingCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (incomingCheck.getValue() && !outgoingCheck.getValue()) {
                        numberMatchesRadio.setEnabled(true);
                        numberNoMatchesRadio.setEnabled(true);
                        hornInTubeYesRadio.setEnabled(false);
                        hornInTubeNoRadio.setEnabled(false);
                    } else if (incomingCheck.getValue() && outgoingCheck.getValue()) {
                        numberMatchesRadio.setEnabled(false);
                        numberNoMatchesRadio.setEnabled(false);
                        hornInTubeYesRadio.setEnabled(true);
                        hornInTubeNoRadio.setEnabled(true);
                    } else {
                        numberMatchesRadio.setEnabled(false);
                        numberNoMatchesRadio.setEnabled(false);
                        hornInTubeYesRadio.setEnabled(false);
                        hornInTubeNoRadio.setEnabled(false);
                    }
                    if (incomingCheck.getValue()) {
                        samplesIncomingArea.setEnabled(true);
                    } else {
                        samplesIncomingArea.setEnabled(false);
                        samplesIncomingArea.setText("");
                    }
                    if (outgoingCheck.getValue()) {
                        samplesOutgoingArea.setEnabled(true);
                    } else {
                        samplesOutgoingArea.setEnabled(false);
                        samplesOutgoingArea.setText("");
                    }
                }
            });

            otherTaYesRadio.setEnabled(false);
            otherTaYesRadio.setValue(true);
            otherTaNoRadio.setEnabled(false);

            otherTaCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (otherTaCheckBox.getValue()){
                        otherTaYesRadio.setEnabled(true);
                        otherTaNoRadio.setEnabled(true);
                    } else {
                        otherTaYesRadio.setEnabled(false);
                        otherTaNoRadio.setEnabled(false);
                    }
                }
            });
        }
        return container;
    }
}
