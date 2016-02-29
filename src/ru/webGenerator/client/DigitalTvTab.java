package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.info.DefaultInfoConfig;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * Created by DaH4uk on 21.02.2016.
 */
public class DigitalTvTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;


    static final CheckBox noBroadcastingOnAllCheck = new CheckBox();
    static final CheckBox interruptedBroadcastCheck = new CheckBox();
    static final CheckBox fadingImageCheck = new CheckBox();
    static final CheckBox splittingImageCheck = new CheckBox();
    static final CheckBox noBroadcastingOnEncodedCheck = new CheckBox();
    static final CheckBox noBroadcastingOnMultipleCheck = new CheckBox();
    static final CheckBox doesntOpenPortalCheck = new CheckBox();
    static final CheckBox noSoundCheck = new CheckBox();
    static final CheckBox analogTvCheck = new CheckBox();
    static final Radio analogTvYesRadio = new Radio();
    static final Radio analogTvNoRadio = new Radio();
    static final CheckBox analogTvCheckCheckbox = new CheckBox();
    static final Radio decoderCheck = new Radio();
    static final CheckBox decoderRebootedCheck = new CheckBox();
    static final CheckBox decoderDumpedCheck = new CheckBox();
    static final Radio camCheck = new Radio();
    static final CheckBox channelsRescannedCheck = new CheckBox();
    static final CheckBox camTookOutPutBackCheck = new CheckBox();
    static final CheckBox cardTookOutPutBackCheck = new CheckBox();
    static final CheckBox updatedSubscriptionCheck = new CheckBox();
    static final CheckBox suspectedFaultCheck = new CheckBox();
    static final CheckBox replacementCheck = new CheckBox();
    static String ch = "";

    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");

            HorizontalLayoutContainer horizontalContainer = new HorizontalLayoutContainer();


            VerticalLayoutContainer subContainer1 = new VerticalLayoutContainer();


            interruptedBroadcastCheck.setBoxLabel("Прерывается вещание");
            subContainer1.add(interruptedBroadcastCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            fadingImageCheck.setBoxLabel("Замирание изображения");
            subContainer1.add(fadingImageCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            splittingImageCheck.setBoxLabel("Рассыпание изображения");
            subContainer1.add(splittingImageCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            noBroadcastingOnAllCheck.setBoxLabel("Нет вещания на всех каналах");
            subContainer1.add(noBroadcastingOnAllCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            noBroadcastingOnEncodedCheck.setBoxLabel("Нет вещания на зашифрованных каналах");
            subContainer1.add(noBroadcastingOnEncodedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            noBroadcastingOnMultipleCheck.setBoxLabel("Нет вещания на нескольких каналах");
            subContainer1.add(noBroadcastingOnMultipleCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            noBroadcastingOnMultipleCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
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







            doesntOpenPortalCheck.setBoxLabel("Не открывается портал");
            subContainer1.add(doesntOpenPortalCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            noSoundCheck.setBoxLabel("Нет звука");
            subContainer1.add(noSoundCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            analogTvCheck.setBoxLabel("КТВ показывает?");
            subContainer1.add(analogTvCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));


            analogTvYesRadio.setBoxLabel("Да");

            analogTvNoRadio.setBoxLabel("Нет");

            ToggleGroup group1 = new ToggleGroup();
            group1.add(analogTvYesRadio);
            group1.add(analogTvNoRadio);


            HorizontalLayoutContainer subHorizContainer = new HorizontalLayoutContainer();
            subHorizContainer.add(analogTvYesRadio);
            subHorizContainer.add(analogTvNoRadio);
            subContainer1.add(subHorizContainer, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            analogTvCheckCheckbox.setBoxLabel("Проверить линию КТВ");
            subContainer1.add(analogTvCheckCheckbox, new VerticalLayoutData(1, 0.1, new Margins(35, 0, 0, 0)));


            VerticalLayoutContainer subContainer2 = new VerticalLayoutContainer();


            decoderCheck.setBoxLabel("Декодер:");
            subContainer2.add(decoderCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            decoderRebootedCheck.setBoxLabel("Перезагружали");
            subContainer2.add(decoderRebootedCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            decoderDumpedCheck.setBoxLabel("Сбрасывали, перенастраивали");
            subContainer2.add(decoderDumpedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            camCheck.setBoxLabel("САМ-модуль:");
            subContainer2.add(camCheck, new VerticalLayoutData(1, 0.1, new Margins(20, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(decoderCheck);
            group.add(camCheck);


            channelsRescannedCheck.setBoxLabel("Каналы пересканировали");
            subContainer2.add(channelsRescannedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            camTookOutPutBackCheck.setBoxLabel("Доставали, вставляли обратно");
            subContainer2.add(camTookOutPutBackCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            cardTookOutPutBackCheck.setBoxLabel("Карту доставали, вставляли обратно");
            subContainer2.add(cardTookOutPutBackCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));


            cardTookOutPutBackCheck.addValueChangeHandler(ValueChangeEvent);
            camTookOutPutBackCheck.addValueChangeHandler(ValueChangeEvent);

            updatedSubscriptionCheck.setBoxLabel("Подписку обновляли");
            subContainer2.add(updatedSubscriptionCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            suspectedFaultCheck.setBoxLabel("Подозрение на неисправность");
            subContainer2.add(suspectedFaultCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, -20)));


            replacementCheck.setBoxLabel("Замена при необходимости");
            subContainer2.add(replacementCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, -20)));


            horizontalContainer.add(subContainer1, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            horizontalContainer.add(subContainer2, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            container.add(horizontalContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));


            noBroadcastingOnAllCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (noBroadcastingOnAllCheck.getValue()) {
                        interruptedBroadcastCheck.setValue(false);
                        fadingImageCheck.setValue(false);
                        splittingImageCheck.setValue(false);
                        noBroadcastingOnEncodedCheck.setValue(false);
                        noBroadcastingOnMultipleCheck.setValue(false);
                        noSoundCheck.setValue(false);
                    }

                }
            });
//
            interruptedBroadcastCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (interruptedBroadcastCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });
            fadingImageCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (fadingImageCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });
            splittingImageCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (splittingImageCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });
            noBroadcastingOnEncodedCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (noBroadcastingOnEncodedCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });
            noBroadcastingOnMultipleCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (noBroadcastingOnMultipleCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });
            noSoundCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (noSoundCheck.getValue()) {
                        noBroadcastingOnAllCheck.setValue(false);
                    }
                }
            });


            decoderCheck.setValue(true);

            decoderRebootedCheck.setEnabled(true);
            decoderDumpedCheck.setEnabled(true);
            decoderRebootedCheck.setEnabled(true);
            decoderDumpedCheck.setEnabled(true);
            camTookOutPutBackCheck.setEnabled(false);
            channelsRescannedCheck.setEnabled(false);

            decoderCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (decoderCheck.getValue()) {
                        decoderRebootedCheck.setEnabled(true);
                        decoderDumpedCheck.setEnabled(true);
                        camTookOutPutBackCheck.setEnabled(false);
                        channelsRescannedCheck.setEnabled(false);
                        channelsRescannedCheck.setValue(false);
                        camTookOutPutBackCheck.setValue(false);
                    }
                }
            });

            camCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (camCheck.getValue()) {
                        camTookOutPutBackCheck.setEnabled(true);
                        channelsRescannedCheck.setEnabled(true);
                        decoderRebootedCheck.setEnabled(false);
                        decoderDumpedCheck.setEnabled(false);
                        decoderRebootedCheck.setValue(false);
                        decoderDumpedCheck.setValue(false);
                    }
                }
            });


            analogTvYesRadio.setEnabled(false);
            analogTvYesRadio.setValue(true);
            analogTvNoRadio.setEnabled(false);

            analogTvCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (analogTvCheck.getValue()){
                        analogTvYesRadio.setEnabled(true);
                        analogTvNoRadio.setEnabled(true);
                    } else {
                        analogTvYesRadio.setEnabled(false);
                        analogTvNoRadio.setEnabled(false);
                    }
                }
            });
        }
        return container;
    }

    ValueChangeHandler ValueChangeEvent = new ValueChangeHandler<Boolean>() {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event) {
            if (cardTookOutPutBackCheck.getValue() && camTookOutPutBackCheck.getValue()){
                DefaultInfoConfig config = new DefaultInfoConfig("Внимание!",
                        "Убедитесь, что логотипы на карте и САМ-модуле клиента смотрят в одну сторону, и что САМ-модуль вставлен логотипом к стене.");
                config.setDisplay(3000);
                Info.display(config);
            }
        }
    };
}
