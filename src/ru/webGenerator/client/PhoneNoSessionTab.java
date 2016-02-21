package ru.webGenerator.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;

/**
 * Created by DaH4uk on 21.02.2016.
 */
public class PhoneNoSessionTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    @Override
    public Widget asWidget() {
        if (container == null){
            container = new VerticalLayoutContainer();

            HorizontalLayoutContainer horizontalContainer = new HorizontalLayoutContainer();

            VerticalLayoutContainer subContainer1 = new VerticalLayoutContainer();

            VerticalLayoutContainer subContainer2 = new VerticalLayoutContainer();


            Label operStatusLabel = new Label("Oper status:");
            operStatusLabel.setStyleName("label-text");
            subContainer1.add(operStatusLabel, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            Radio operStatusDownRadio = new Radio();
            operStatusDownRadio.setBoxLabel("Down");

            Radio operStatusUpRadio = new Radio();
            operStatusUpRadio.setBoxLabel("Up");

            ToggleGroup group = new ToggleGroup();
            group.add(operStatusDownRadio);
            group.add(operStatusUpRadio);




            HorizontalLayoutContainer subHorizContainer = new HorizontalLayoutContainer();
            subHorizContainer.add(operStatusDownRadio);
            subHorizContainer.add(operStatusUpRadio);
            subContainer1.add(subHorizContainer, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));



            CheckBox onMultipleChannelsCheck = new CheckBox();
            onMultipleChannelsCheck.setBoxLabel("На нескольких каналах");
            subContainer1.add(onMultipleChannelsCheck, new VerticalLayoutData(1, 0.1, new Margins(280, 0, 0, 0)));



            Label macAdrVisible = new Label("MAC-адрес виден?");
            macAdrVisible.setStyleName("label-text");
            subContainer2.add(macAdrVisible, new VerticalLayoutData(1, 0, new Margins(0, 0, 0, 0)));




            Radio macAdrVisibleNoRadio = new Radio();
            macAdrVisibleNoRadio.setBoxLabel("Нет");

            Radio macAdrVisibleYesRadio = new Radio();
            macAdrVisibleYesRadio.setBoxLabel("Да");

            ToggleGroup group1 = new ToggleGroup();
            group1.add(macAdrVisibleNoRadio);
            group1.add(macAdrVisibleYesRadio);




            HorizontalLayoutContainer subHorizContainer1 = new HorizontalLayoutContainer();
            subHorizContainer1.add(macAdrVisibleNoRadio);
            subHorizContainer1.add(macAdrVisibleYesRadio);

            subContainer2.add(subHorizContainer1, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));



            horizontalContainer.add(subContainer1, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1, new Margins(0, 0, 0, 0)));
            horizontalContainer.add(subContainer2, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1, new Margins(0, 0, 0, 0)));


            container.add(horizontalContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));
        }
        return container;
    }
}
