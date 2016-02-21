package ru.webGenerator.client;

import com.google.gwt.user.client.ui.IsWidget;
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
 * Created by DaH4uk on 21.02.2016.
 */
public class DigitalTvTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");

            HorizontalLayoutContainer horizontalContainer = new HorizontalLayoutContainer();


            VerticalLayoutContainer subContainer1 = new VerticalLayoutContainer();

            CheckBox interruptedBroadcastCheck = new CheckBox();
            interruptedBroadcastCheck.setBoxLabel("Прерывается вещание");
            subContainer1.add(interruptedBroadcastCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            CheckBox fadingImageCheck = new CheckBox();
            fadingImageCheck.setBoxLabel("Замирание изображения");
            subContainer1.add(fadingImageCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));


            CheckBox splittingImageCheck = new CheckBox();
            splittingImageCheck.setBoxLabel("Рассыпание изображения");
            subContainer1.add(splittingImageCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox noBroadcastingOnAllCheck = new CheckBox();
            noBroadcastingOnAllCheck.setBoxLabel("Нет вещания на всех каналах");
            subContainer1.add(noBroadcastingOnAllCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox noBroadcastingOnEncodedCheck = new CheckBox();
            noBroadcastingOnEncodedCheck.setBoxLabel("Нет вещания на зашифрованных каналах");
            subContainer1.add(noBroadcastingOnEncodedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox noBroadcastingOnMultipleCheck = new CheckBox();
            noBroadcastingOnMultipleCheck.setBoxLabel("Нет вещания на нескольких каналах");
            subContainer1.add(noBroadcastingOnMultipleCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox doesntOpenPortalCheck = new CheckBox();
            doesntOpenPortalCheck.setBoxLabel("Не открывается портал");
            subContainer1.add(doesntOpenPortalCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox noSoundCheck = new CheckBox();
            noSoundCheck.setBoxLabel("Нет звука");
            subContainer1.add(noSoundCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox analogTvCheck = new CheckBox();
            analogTvCheck.setBoxLabel("КТВ показывает?");
            subContainer1.add(analogTvCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));




            Radio analogTvYesRadio = new Radio();
            analogTvYesRadio.setBoxLabel("Да");

            Radio analogTvNoRadio = new Radio();
            analogTvNoRadio.setBoxLabel("Нет");

            ToggleGroup group1 = new ToggleGroup();
            group1.add(analogTvYesRadio);
            group1.add(analogTvNoRadio);



            HorizontalLayoutContainer subHorizContainer = new HorizontalLayoutContainer();
            subHorizContainer.add(analogTvYesRadio);
            subHorizContainer.add(analogTvNoRadio);
            subContainer1.add(subHorizContainer, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox analogTvCheckCheckbox = new CheckBox();
            analogTvCheckCheckbox.setBoxLabel("Проверить линию КТВ");
            subContainer1.add(analogTvCheckCheckbox, new VerticalLayoutData(1, 0.1, new Margins(35, 0, 0, 0)));



            VerticalLayoutContainer subContainer2 = new VerticalLayoutContainer();


            Radio decoderCheck = new Radio();
            decoderCheck.setBoxLabel("Декодер:");
            subContainer2.add(decoderCheck, new VerticalLayoutData(1, 0.1, new Margins(0, 0, 0, 0)));


            CheckBox decoderRebootedCheck = new CheckBox();
            decoderRebootedCheck.setBoxLabel("Перезагружали");
            subContainer2.add(decoderRebootedCheck, new VerticalLayoutData(1, 0.1, new Margins(25, 0, 0, 0)));

            CheckBox decoderDumpedCheck = new CheckBox();
            decoderDumpedCheck.setBoxLabel("Сбрасывали, перенастраивали");
            subContainer2.add(decoderDumpedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            Radio camCheck = new Radio();
            camCheck.setBoxLabel("САМ-модуль:");
            subContainer2.add(camCheck, new VerticalLayoutData(1, 0.1, new Margins(20, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(decoderCheck);
            group.add(camCheck);


            CheckBox channelsRescannedCheck = new CheckBox();
            channelsRescannedCheck.setBoxLabel("Каналы пересканировали");
            subContainer2.add(channelsRescannedCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox camTookOutPutBackCheck = new CheckBox();
            camTookOutPutBackCheck.setBoxLabel("Доставали, вставляли обратно");
            subContainer2.add(camTookOutPutBackCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));


            CheckBox cardTookOutPutBackCheck = new CheckBox();
            cardTookOutPutBackCheck.setBoxLabel("Карту доставали, вставляли обратно");
            subContainer2.add(cardTookOutPutBackCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, 0)));


            CheckBox updatedSubscriptionCheck = new CheckBox();
            updatedSubscriptionCheck.setBoxLabel("Подписку обновляли");
            subContainer2.add(updatedSubscriptionCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, 0)));

            

            CheckBox suspectedFaultCheck = new CheckBox();
            suspectedFaultCheck.setBoxLabel("Подозрение на неисправность");
            subContainer2.add(suspectedFaultCheck, new VerticalLayoutData(1, 0.1, new Margins(30, 0, 0, -20)));


            CheckBox replacementCheck = new CheckBox();
            replacementCheck.setBoxLabel("Замена при необходимости");
            subContainer2.add(replacementCheck, new VerticalLayoutData(1, 0.1, new Margins(10, 0, 0, -20)));


            horizontalContainer.add(subContainer1, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            horizontalContainer.add(subContainer2, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            container.add(horizontalContainer, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));

        }
        return container;
    }
}
