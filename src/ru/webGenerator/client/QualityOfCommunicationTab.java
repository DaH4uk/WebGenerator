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

/**
 * Created by DaH4uk on 22.02.2016.
 */
public class QualityOfCommunicationTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

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

            Radio crackNoiseRadio = new Radio();
            crackNoiseRadio.setBoxLabel("Шум, треск и т.д...");
            subContainer2.add(crackNoiseRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));


            CheckBox incomingDirectionCheckBox = new CheckBox();
            incomingDirectionCheckBox.setBoxLabel("Входящая");
            subContainer2.add(incomingDirectionCheckBox, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            CheckBox whoHearsClientCheckbox = new CheckBox();
            whoHearsClientCheckbox.setBoxLabel("Клиент");
            subContainer2.add(whoHearsClientCheckbox, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            Radio otherTaNoRadio = new Radio();
            otherTaNoRadio.setBoxLabel("Нет");
            subContainer2.add(otherTaNoRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            container.add(subContainer2, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            HorizontalLayoutContainer subContainer3 = new HorizontalLayoutContainer();

            Radio lowVolumeLevelRadio = new Radio();
            lowVolumeLevelRadio.setBoxLabel("Низкий ур. громкости");
            subContainer3.add(lowVolumeLevelRadio, new HorizontalLayoutData(0.3, 0, new Margins(0, 0, 0, 0)));


            CheckBox outgoingDirectionCheckBox = new CheckBox();
            outgoingDirectionCheckBox.setBoxLabel("Исходящая");
            subContainer3.add(outgoingDirectionCheckBox, new HorizontalLayoutData(0.25, 0, new Margins(0, 0, 0, 0)));


            CheckBox whoHearsInterlocutorCheckbox = new CheckBox();
            whoHearsInterlocutorCheckbox.setBoxLabel("Собеседник");
            subContainer3.add(whoHearsInterlocutorCheckbox, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));



            Radio otherTaYesRadio = new Radio();
            otherTaYesRadio.setBoxLabel("Да");
            subContainer3.add(otherTaYesRadio, new HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, 0)));

            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.add(otherTaNoRadio);
            toggleGroup.add(otherTaYesRadio);

            ToggleGroup toggleGroup1 = new ToggleGroup();
            toggleGroup1.add(lowVolumeLevelRadio);
            toggleGroup1.add(crackNoiseRadio);

            container.add(subContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));
        }
        return container;
    }
}
