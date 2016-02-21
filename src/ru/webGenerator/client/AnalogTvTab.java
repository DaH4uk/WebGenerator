package ru.webGenerator.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;

/**
 * Created by DaH4uk on 21.02.2016.
 */
public class AnalogTvTab implements IsWidget {


    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;


    @Override
    public Widget asWidget() {
        if (container == null){
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");

            HorizontalLayoutContainer horizontalContainer = new HorizontalLayoutContainer();

            VerticalLayoutContainer subContainer1 = new VerticalLayoutContainer();
            VerticalLayoutContainer subContainer2 = new VerticalLayoutContainer();

            CheckBox qualityImageCheck = new CheckBox();
            qualityImageCheck.setBoxLabel("Качество сигнала:");
            subContainer1.add(qualityImageCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            CheckBox interferenceRipplesCheck = new CheckBox();
            interferenceRipplesCheck.setBoxLabel("Помехи / рябь");
            subContainer1.add(interferenceRipplesCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            CheckBox noSoundCheck = new CheckBox();
            noSoundCheck.setBoxLabel("Нет звука");
            subContainer1.add(noSoundCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox blackWhiteImageCheck = new CheckBox();
            blackWhiteImageCheck.setBoxLabel("Ч/б изображение");
            subContainer1.add(blackWhiteImageCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));



            Label whatToCheckLabel = new Label("Что проверить");
            whatToCheckLabel.setStyleName("label-text");
            subContainer1.add(whatToCheckLabel, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));


            CheckBox integrityOfCableCheck = new CheckBox();
            integrityOfCableCheck.setBoxLabel("Целостность кабеля");
            subContainer1.add(integrityOfCableCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox levelOfSignalCheck = new CheckBox();
            levelOfSignalCheck.setBoxLabel("Уровень сигнала");
            subContainer1.add(levelOfSignalCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));

            horizontalContainer.add(subContainer1, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            CheckBox noSignalCheck = new CheckBox();
            noSignalCheck.setBoxLabel("Нет сигнала");
            subContainer2.add(noSignalCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            CheckBox onAllChannelsCheck = new CheckBox();
            onAllChannelsCheck.setBoxLabel("На всех каналах");
            subContainer2.add(onAllChannelsCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            CheckBox onMultipleChannelsCheck = new CheckBox();
            onMultipleChannelsCheck.setBoxLabel("На нескольких каналах");
            subContainer2.add(onMultipleChannelsCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));

            
            CheckBox channelsRescannedCheck = new CheckBox();
            channelsRescannedCheck.setBoxLabel("Каналы пересканировали");
            subContainer2.add(channelsRescannedCheck, new VerticalLayoutData(1, 0.1, new Margins(60, 0, 0, 0)));

            horizontalContainer.add(subContainer2, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            container.add(horizontalContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));

        }
        return container;
    }
}
