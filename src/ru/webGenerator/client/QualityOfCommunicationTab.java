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
 * Created by DaH4uk on 22.02.2016.
 */
public class QualityOfCommunicationTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    static final Radio crackNoiseRadio = new Radio();
    static final CheckBox incomingDirectionCheckBox = new CheckBox();
    static final CheckBox whoHearsClientCheckbox = new CheckBox();
    static final Radio otherTaNoRadio = new Radio();
    static final Radio lowVolumeLevelRadio = new Radio();
    static final CheckBox outgoingDirectionCheckBox = new CheckBox();
    static final CheckBox whoHearsInterlocutorCheckbox = new CheckBox();
    static final Radio otherTaYesRadio = new Radio();
    static final CheckBox lossToAdapterCheck = new CheckBox();
    static final TextField lossToAdapterField = new TextField();
    static final CheckBox lossToCommutatorCheck = new CheckBox();
    static final TextField lossToCommutatorField = new TextField();
    static final CheckBox adapterRebootedCheckbox = new CheckBox();
    static final CheckBox gainOfSignalCheck = new CheckBox();
    static final Radio gainOfSignalUpRadio = new Radio();
    static final Radio gainOfSignalDownRadio = new Radio();
    static final CheckBox errorsOnPortCheck = new CheckBox();
    static final TextField errorsOnPortField = new TextField();
    static final CheckBox errorsOnPortGrowCheck = new CheckBox();
    static final TextArea samplesIncomingArea = new TextArea();
    static final TextArea samplesOutgoingArea = new TextArea();

    @Override
    public Widget asWidget() {
        if (container == null){
            container = new VerticalLayoutContainer();

            HorizontalLayoutContainer subContainer1 = new HorizontalLayoutContainer();

            Label characterComplexityLabel = new Label("Характер сложности:");
            characterComplexityLabel.setStyleName("label-text");
            subContainer1.add(characterComplexityLabel, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));


            Label directionLabel = new Label("Направление:");
            directionLabel.setStyleName("label-text");
            subContainer1.add(directionLabel, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            Label whoHearsLabel = new Label("Кто слышит?");
            whoHearsLabel.setStyleName("label-text");
            subContainer1.add(whoHearsLabel, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            Label otherTaLabel = new Label("Другой ТА?");
            otherTaLabel.setStyleName("label-text");
            subContainer1.add(otherTaLabel, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            container.add(subContainer1, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));



            HorizontalLayoutContainer subContainer2 = new HorizontalLayoutContainer();


            crackNoiseRadio.setBoxLabel("Шум, треск и т.д...");
            subContainer2.add(crackNoiseRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));



            incomingDirectionCheckBox.setBoxLabel("Входящая");
            subContainer2.add(incomingDirectionCheckBox, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));



            whoHearsClientCheckbox.setBoxLabel("Клиент");
            subContainer2.add(whoHearsClientCheckbox, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));




            otherTaNoRadio.setBoxLabel("Нет");
            subContainer2.add(otherTaNoRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            container.add(subContainer2, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            HorizontalLayoutContainer subContainer3 = new HorizontalLayoutContainer();


            lowVolumeLevelRadio.setBoxLabel("Низкий ур. громкости");
            subContainer3.add(lowVolumeLevelRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));



            outgoingDirectionCheckBox.setBoxLabel("Исходящая");
            subContainer3.add(outgoingDirectionCheckBox, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));



            whoHearsInterlocutorCheckbox.setBoxLabel("Собеседник");
            subContainer3.add(whoHearsInterlocutorCheckbox, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));




            otherTaYesRadio.setBoxLabel("Да");
            subContainer3.add(otherTaYesRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.add(otherTaNoRadio);
            toggleGroup.add(otherTaYesRadio);

            ToggleGroup toggleGroup1 = new ToggleGroup();
            toggleGroup1.add(lowVolumeLevelRadio);
            toggleGroup1.add(crackNoiseRadio);

            container.add(subContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            HorizontalLayoutContainer subContainer4 = new HorizontalLayoutContainer();


            lossToAdapterCheck.setBoxLabel("Потери до шлюза (%)");
            subContainer4.add(lossToAdapterCheck, new HorizontalLayoutData(0.35, 0, new Margins(5, 0, 0, 0)));



            subContainer4.add(lossToAdapterField, new HorizontalLayoutData(0.1, 0, new Margins(0, 0, 0, 0)));


            Label samplesOfNumbersLabel = new Label("Примеры номеров:");
            samplesOfNumbersLabel.setStyleName("label-text");
            subContainer4.add(samplesOfNumbersLabel, new HorizontalLayoutData(0.13, 0, new Margins(5, 0, 0, 30)));

            container.add(subContainer4, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, marginLeft)));





            HorizontalLayoutContainer subContainer5 = new HorizontalLayoutContainer();


            lossToCommutatorCheck.setBoxLabel("Потери до коммутатора(%):");
            subContainer5.add(lossToCommutatorCheck, new HorizontalLayoutData(0.35, 0, new Margins(0, 0, 0, 0)));




            subContainer5.add(lossToCommutatorField, new HorizontalLayoutData(0.1, 0, new Margins(0, 0, 0, 0)));

            Label samplesIncomingLabel = new Label("Входящие:");
            samplesIncomingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesIncomingLabel, new HorizontalLayoutData(0.18, 0, new Margins(-10, 0, 0, 30)));


            Label samplesOutgoingLabel = new Label("Исходящие:");
            samplesOutgoingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesOutgoingLabel, new HorizontalLayoutData(0.13, 0, new Margins(-10, 0, 0, 5)));

            container.add(subContainer5, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));





            HorizontalLayoutContainer subContainer6 = new HorizontalLayoutContainer();

            VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();


            adapterRebootedCheckbox.setBoxLabel("Адаптер перезагружали");
            verticalLayoutContainer.add(adapterRebootedCheckbox, new VerticalLayoutData(0.8, 0, new Margins(15, 0, 0, 0)));


            gainOfSignalCheck.setBoxLabel("Усиление сигнала на выходе");
            verticalLayoutContainer.add(gainOfSignalCheck, new VerticalLayoutData(0.8, 0, new Margins(15, 0, 0, 0)));

            HorizontalLayoutContainer horizontalLayoutContainer = new HorizontalLayoutContainer();


            gainOfSignalUpRadio.setBoxLabel("Увеличивали");
            horizontalLayoutContainer.add(gainOfSignalUpRadio);


            gainOfSignalDownRadio.setBoxLabel("Уменьшали");
            horizontalLayoutContainer.add(gainOfSignalDownRadio);

            ToggleGroup toggleGroup2 = new ToggleGroup();
            toggleGroup2.add(gainOfSignalDownRadio);
            toggleGroup2.add(gainOfSignalUpRadio);

            verticalLayoutContainer.add(horizontalLayoutContainer, new VerticalLayoutData(0.8, 0, new Margins(10, 0, 0, 0)));

            HorizontalLayoutContainer horizontalLayoutContainer1 = new HorizontalLayoutContainer();


            errorsOnPortCheck.setBoxLabel("Ошибки за портом");
            horizontalLayoutContainer1.add(errorsOnPortCheck, new HorizontalLayoutData(0.5, 0, new Margins(23, 0, 0, 0)));


            horizontalLayoutContainer1.add(errorsOnPortField, new HorizontalLayoutData(0.2, 0, new Margins(15, 0, 0, 0)));


            errorsOnPortGrowCheck.setBoxLabel("Растут");
            horizontalLayoutContainer1.add(errorsOnPortGrowCheck, new HorizontalLayoutData(0.3, 0, new Margins(20, 0, 0, 10)));

            verticalLayoutContainer.add(horizontalLayoutContainer1, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));


            subContainer6.add(verticalLayoutContainer, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));


            samplesIncomingArea.setWidth(30);
            subContainer6.add(samplesIncomingArea, new HorizontalLayoutData(0.14, 1, new Margins(-15, 0, 0, 0)));


            subContainer6.add(samplesOutgoingArea, new HorizontalLayoutData(0.157, 1, new Margins(-15, 0, 0, 10)));

            container.add(subContainer6, new VerticalLayoutData(1, 0.25, new Margins(20, 0, 0, marginLeft)));


            samplesIncomingArea.setEnabled(false);

            incomingDirectionCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (incomingDirectionCheckBox.getValue()){
                        samplesIncomingArea.setEnabled(true);
                    } else {
                        samplesIncomingArea.setEnabled(false);
                    }
                }
            });

            samplesOutgoingArea.setEnabled(false);

            outgoingDirectionCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (outgoingDirectionCheckBox.getValue()){
                        samplesOutgoingArea.setEnabled(true);
                    } else {
                        samplesOutgoingArea.setEnabled(false);
                    }
                }
            });

            lossToAdapterField.setEnabled(false);

            lossToAdapterCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (lossToAdapterCheck.getValue()){
                        lossToAdapterField.setEnabled(true);
                    } else {
                        lossToAdapterField.setEnabled(false);
                    }
                }
            });


            lossToCommutatorField.setEnabled(false);

            lossToCommutatorCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (lossToCommutatorCheck.getValue()){
                        lossToCommutatorField.setEnabled(true);
                    } else {
                        lossToCommutatorField.setEnabled(false);
                    }
                }
            });

            gainOfSignalDownRadio.setEnabled(false);
            gainOfSignalUpRadio.setEnabled(false);

            gainOfSignalCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (gainOfSignalCheck.getValue()){
                        gainOfSignalDownRadio.setEnabled(true);
                        gainOfSignalUpRadio.setEnabled(true);
                    } else {
                        gainOfSignalDownRadio.setEnabled(false);
                        gainOfSignalUpRadio.setEnabled(false);
                    }
                }
            });

            errorsOnPortGrowCheck.setEnabled(false);
            errorsOnPortField.setEnabled(false);

            errorsOnPortCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (errorsOnPortCheck.getValue()){
                        errorsOnPortField.setEnabled(true);
                        errorsOnPortGrowCheck.setEnabled(true);

                    }else {
                        errorsOnPortGrowCheck.setEnabled(false);
                        errorsOnPortField.setEnabled(false);
                    }
                }
            });
        }
        return container;
    }
}
