package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.box.PromptMessageBox;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;

/**
 * Created by DaH4uk on 21.02.2016.
 */
public class AnalogTvTab implements IsWidget {


    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    static final CheckBox qualityImageCheck = new CheckBox();
    static final CheckBox interferenceRipplesCheck = new CheckBox();
    static final CheckBox noSoundCheck = new CheckBox();
    static final CheckBox blackWhiteImageCheck = new CheckBox();
    static final CheckBox integrityOfCableCheck = new CheckBox();
    static final CheckBox levelOfSignalCheck = new CheckBox();
    static final CheckBox noSignalCheck = new CheckBox();
    static final Radio onAllChannelsRadio = new Radio();
    static final Radio onMultipleChannelsRadio = new Radio();
    static final CheckBox channelsRescannedCheck = new CheckBox();
    static String ch = "";

    @Override
    public Widget asWidget() {
        if (container == null){
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");

            HorizontalLayoutContainer horizontalContainer = new HorizontalLayoutContainer();

            VerticalLayoutContainer subContainer1 = new VerticalLayoutContainer();
            VerticalLayoutContainer subContainer2 = new VerticalLayoutContainer();


            qualityImageCheck.setBoxLabel("Качество сигнала:");
            subContainer1.add(qualityImageCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            interferenceRipplesCheck.setBoxLabel("Помехи / рябь");
            subContainer1.add(interferenceRipplesCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            noSoundCheck.setBoxLabel("Нет звука");
            subContainer1.add(noSoundCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            blackWhiteImageCheck.setBoxLabel("Ч/б изображение");
            subContainer1.add(blackWhiteImageCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));



            Label whatToCheckLabel = new Label("Что проверить");
            whatToCheckLabel.setStyleName("label-text");
            subContainer1.add(whatToCheckLabel, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));


            integrityOfCableCheck.setBoxLabel("Целостность кабеля");
            subContainer1.add(integrityOfCableCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            levelOfSignalCheck.setBoxLabel("Уровень сигнала");
            subContainer1.add(levelOfSignalCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));

            horizontalContainer.add(subContainer1, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));


            noSignalCheck.setBoxLabel("Нет сигнала");
            subContainer2.add(noSignalCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            onAllChannelsRadio.setBoxLabel("На всех каналах");
            subContainer2.add(onAllChannelsRadio, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            onMultipleChannelsRadio.setBoxLabel("На нескольких каналах");
            subContainer2.add(onMultipleChannelsRadio, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));
            onMultipleChannelsRadio.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    final PromptMessageBox messageBox = new PromptMessageBox("Уточните!", "Нет вещания на:");

                    messageBox.addDialogHideHandler(new DialogHideEvent.DialogHideHandler() {
                        @Override
                        public void onDialogHide(DialogHideEvent event) {
                            if (event.getHideButton() == Dialog.PredefinedButton.OK) {
                                ch = messageBox.getValue() + "";
                            } else {
                                ch = "нескольких каналах";
                            }
                        }
                    });

                    messageBox.show();
                }
            });


            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.add(onAllChannelsRadio);
            toggleGroup.add(onMultipleChannelsRadio);


            channelsRescannedCheck.setBoxLabel("Каналы пересканировали");
            subContainer2.add(channelsRescannedCheck, new VerticalLayoutData(1, 0.1, new Margins(60, 0, 0, 0)));

            horizontalContainer.add(subContainer2, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            container.add(horizontalContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));

            interferenceRipplesCheck.setEnabled(false);
            noSoundCheck.setEnabled(false);
            blackWhiteImageCheck.setEnabled(false);

            qualityImageCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (qualityImageCheck.getValue()){
                        interferenceRipplesCheck.setEnabled(true);
                        noSoundCheck.setEnabled(true);
                        blackWhiteImageCheck.setEnabled(true);
                    } else {
                        interferenceRipplesCheck.setEnabled(false);
                        noSoundCheck.setEnabled(false);
                        blackWhiteImageCheck.setEnabled(false);
                    }
                }
            });

            onAllChannelsRadio.setEnabled(false);
            onMultipleChannelsRadio.setEnabled(false);

            noSignalCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (noSignalCheck.getValue()){
                        onAllChannelsRadio.setEnabled(true);
                        onMultipleChannelsRadio.setEnabled(true);
                    } else {
                        onAllChannelsRadio.setEnabled(false);
                        onMultipleChannelsRadio.setEnabled(false);
                    }
                }
            });
        }
        return container;
    }
}
