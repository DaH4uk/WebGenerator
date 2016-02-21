package ru.webGenerator.client;

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

    @Override
    public Widget asWidget() {
        if (container == null){
            container = new VerticalLayoutContainer();

            HorizontalLayoutContainer subContainer1 = new HorizontalLayoutContainer();

            Label noLabel = new Label("Отсутствует:");
            noLabel.setStyleName("label-text");
            subContainer1.add(noLabel, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            CheckBox sipCheck = new CheckBox();
            sipCheck.setBoxLabel("SIP-регистрация:");
            subContainer1.add(sipCheck, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            CheckBox callFromOfficeCheck = new CheckBox();
            callFromOfficeCheck.setBoxLabel("Звонок из офиса:");
            subContainer1.add(callFromOfficeCheck, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));



            Label moroMoroLabel = new Label("Moro-moro:");
            moroMoroLabel.setStyleName("label-text");
            subContainer1.add(moroMoroLabel, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 10)));

            container.add(subContainer1, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));




            HorizontalLayoutContainer subContainer2 = new HorizontalLayoutContainer();

            CheckBox incomingCheck = new CheckBox();
            incomingCheck.setBoxLabel("Входящая");
            subContainer2.add(incomingCheck, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            Radio passesSipRadio = new Radio();
            passesSipRadio.setBoxLabel("Проходит");
            subContainer2.add(passesSipRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            Radio callFromOfficePassesRadio = new Radio();
            callFromOfficePassesRadio.setBoxLabel("Проходит");
            subContainer2.add(callFromOfficePassesRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));



            Label moroMoroLabel1 = new Label("код ошибки");
            moroMoroLabel1.setStyleName("sub-labels");
            subContainer2.add(moroMoroLabel1, new HorizontalLayoutData(0.25, 0, new Margins(-5, 0, 0, 10)));

            container.add(subContainer2, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer subContainer3 = new HorizontalLayoutContainer();

            CheckBox outgoingCheck = new CheckBox();
            outgoingCheck.setBoxLabel("Исходящая");
            subContainer3.add(outgoingCheck, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            Radio notPassSipRadio = new Radio();
            notPassSipRadio.setBoxLabel("Не проходит");
            subContainer3.add(notPassSipRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            Radio callFromOfficeNoPassesRadio = new Radio();
            callFromOfficeNoPassesRadio.setBoxLabel("Не проходит");
            subContainer3.add(callFromOfficeNoPassesRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));



            TextField moroMoroField = new TextField();
            subContainer3.add(moroMoroField, new HorizontalLayoutData(0.13, 0, new Margins(-10, 0, 0, 10)));

            container.add(subContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            HorizontalLayoutContainer subContainer4 = new HorizontalLayoutContainer();

            CheckBox withSpecificNumberCheck = new CheckBox();
            withSpecificNumberCheck.setBoxLabel("С конкретным номером:");
            subContainer4.add(withSpecificNumberCheck, new HorizontalLayoutData(0.3, 0, new Margins(5, 0, 0, 0)));


            TextField withSpecificNumberField = new TextField();
            subContainer4.add(withSpecificNumberField, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));


            Label samplesOfNumbersLabel = new Label("Примеры номеров:");
            samplesOfNumbersLabel.setStyleName("label-text");
            subContainer4.add(samplesOfNumbersLabel, new HorizontalLayoutData(0.13, 0, new Margins(5, 0, 0, 10)));

            container.add(subContainer4, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, marginLeft)));




            HorizontalLayoutContainer subContainer5 = new HorizontalLayoutContainer();

            Label numberInAdapterCheck = new Label("Номер в приложении и в адаптере:");
            numberInAdapterCheck.setStyleName("label-text");
            subContainer5.add(numberInAdapterCheck, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));


            Label samplesIncomingLabel = new Label("Входящие:");
            samplesIncomingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesIncomingLabel, new HorizontalLayoutData(0.2, 0, new Margins(-10, 0, 0, 125)));


            Label samplesOutgoingLabel = new Label("Исходящие:");
            samplesOutgoingLabel.setStyleName("sub-labels");
            subContainer5.add(samplesOutgoingLabel, new HorizontalLayoutData(0.13, 0, new Margins(-10, 0, 0, 100)));

            container.add(subContainer5, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));




            HorizontalLayoutContainer subContainer6 = new HorizontalLayoutContainer();

            VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();


            Radio numberMatchesRadio = new Radio();
            numberMatchesRadio.setBoxLabel("Совпадают");
            verticalLayoutContainer.add(numberMatchesRadio, new VerticalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));


            Radio numberNoMatchesRadio = new Radio();
            numberNoMatchesRadio.setBoxLabel("Не совпадают");
            verticalLayoutContainer.add(numberNoMatchesRadio, new VerticalLayoutData(0.7, 0, new Margins(0, 0, 0, 90)));

            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.add(numberMatchesRadio);
            toggleGroup.add(numberNoMatchesRadio);

            HorizontalLayoutContainer subContainer7 = new HorizontalLayoutContainer();


            Label hornInTubeLabel = new Label("Гудок в трубке:");
            hornInTubeLabel.setStyleName("label-text");
            subContainer7.add(hornInTubeLabel, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            CheckBox otherTaCheckBox = new CheckBox();
            otherTaCheckBox.setBoxLabel("Другой ТА:");
            subContainer7.add(otherTaCheckBox, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            verticalLayoutContainer.add(subContainer7, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, 0)));


            HorizontalLayoutContainer subContainer8 = new HorizontalLayoutContainer();


            Radio hornInTubeYesRadio = new Radio();
            hornInTubeYesRadio.setBoxLabel("Есть");
            subContainer8.add(hornInTubeYesRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            Radio hornInTubeNoRadio = new Radio();
            hornInTubeNoRadio.setBoxLabel("Нет");
            subContainer8.add(hornInTubeNoRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(hornInTubeYesRadio);
            group.add(hornInTubeNoRadio);


            Radio otherTaYesRadio = new Radio();
            otherTaYesRadio.setBoxLabel("Есть");
            subContainer8.add(otherTaYesRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 28)));

            Radio otherTaNoRadio = new Radio();
            otherTaNoRadio.setBoxLabel("Нет");
            subContainer8.add(otherTaNoRadio, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup group1 = new ToggleGroup();
            group1.add(otherTaYesRadio);
            group1.add(otherTaNoRadio);


            verticalLayoutContainer.add(subContainer8, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));

            CheckBox rebootedAdapterCheck = new CheckBox();
            rebootedAdapterCheck.setBoxLabel("Адаптер перезагружали");
            verticalLayoutContainer.add(rebootedAdapterCheck, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, 0)));


            subContainer6.add(verticalLayoutContainer, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));



            TextArea samplesIncomingArea = new TextArea();
            samplesIncomingArea.setWidth(30);
            subContainer6.add(samplesIncomingArea, new HorizontalLayoutData(0.14, 1, new Margins(-15, 0, 0, 8)));

            TextArea samplesOutgoingArea = new TextArea();
            subContainer6.add(samplesOutgoingArea, new HorizontalLayoutData(0.157, 1, new Margins(-15, 0, 0, 18)));

            container.add(subContainer6, new VerticalLayoutData(1, 0.25, new Margins(20, 0, 0, marginLeft)));

        }
        return container;
    }
}
