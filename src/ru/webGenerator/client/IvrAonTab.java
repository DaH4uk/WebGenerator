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
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;

import static com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.*;

/**
 * Created by DaH4uk on 22.02.2016.
 */
public class IvrAonTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;

    static final CheckBox aonCheck = new CheckBox();
    static final Radio doesNotWorkRadio = new Radio();
    static final Radio incorrectWorkRadio = new Radio();
    static final TextField samplesAonField = new TextField();
    static final TextField determinedNumberField = new TextField();
    static final CheckBox breakTimeCheck = new CheckBox();
    static final CheckBox ivrCheck = new CheckBox();
    static final Radio from7Radio = new Radio();
    static final Radio from7and8Radio = new Radio();
    static final Radio withCityNumberRadio = new Radio();
    static final TextField samplesOfIvrField = new TextField();

    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();

            HorizontalLayoutContainer horizontalLayoutContainer = new HorizontalLayoutContainer();

            VerticalLayoutContainer container1 = new VerticalLayoutContainer();
            VerticalLayoutContainer container2 = new VerticalLayoutContainer();


            aonCheck.setBoxLabel("АОН:");
            container1.add(aonCheck, new VerticalLayoutData(1, 0, new Margins(0, 0, 0, 0)));


            doesNotWorkRadio.setBoxLabel("Не срабатывает");
            container1.add(doesNotWorkRadio, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));


            incorrectWorkRadio.setBoxLabel("Не корректно работает");
            container1.add(incorrectWorkRadio, new VerticalLayoutData(1, 0, new Margins(5, 0, 0, 0)));

            ToggleGroup group = new ToggleGroup();
            group.add(doesNotWorkRadio);
            group.add(incorrectWorkRadio);



            Label samplesLabel = new Label("Примеры номеров:");
            samplesLabel.setStyleName("labels");
            container1.add(samplesLabel, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));


            container1.add(samplesAonField, new VerticalLayoutData(0.8, 0, new Margins(0, 0, 0, 0)));


            Label determinedNumberLabel = new Label("Определившийся номер:");
            determinedNumberLabel.setStyleName("labels");
            container1.add(determinedNumberLabel, new VerticalLayoutData(0.8, 0, new Margins(40, 0, 0, 0)));


            container1.add(determinedNumberField, new VerticalLayoutData(0.8, 0, new Margins(0, 0, 0, 0)));


            breakTimeCheck.setBoxLabel("Сбивается время на ТА");
            container1.add(breakTimeCheck, new VerticalLayoutData(0.8, 0, new Margins(60, 0, 0, 0)));



            ivrCheck.setBoxLabel("IVR (донабор в голосовом меню):");
            container2.add(ivrCheck, new VerticalLayoutData(1, 0, new Margins(0, 0, 0, 0)));

            Label formatOfNumberLabel = new Label("Формат набора номера:");
            formatOfNumberLabel.setStyleName("labels");
            container2.add(formatOfNumberLabel, new VerticalLayoutData(1, 0, new Margins(30, 0, 0, 0)));


            from7Radio.setBoxLabel("Через 7");
            container2.add(from7Radio, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, 0)));


            from7and8Radio.setBoxLabel("Через 7 и 8");
            container2.add(from7and8Radio, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, 0)));


            withCityNumberRadio.setBoxLabel("При наборе через городской номер");
            container2.add(withCityNumberRadio, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, 0)));

            ToggleGroup group1 = new ToggleGroup();
            group1.add(from7Radio);
            group1.add(from7and8Radio);
            group1.add(withCityNumberRadio);


            Label samplesOfIVRLabel = new Label("Примеры номеров:");
            samplesOfIVRLabel.setStyleName("labels");
            container2.add(samplesOfIVRLabel, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, 0)));


            container2.add(samplesOfIvrField, new VerticalLayoutData(0.8, 0, new Margins(0, 0, 0, 0)));

            

            horizontalLayoutContainer.add(container1, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            horizontalLayoutContainer.add(container2, new HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));

            container.add(horizontalLayoutContainer, new VerticalLayoutData(1, 1, new Margins(20, 0, 0, marginLeft)));


            doesNotWorkRadio.setEnabled(false);
            incorrectWorkRadio.setEnabled(false);
            samplesAonField.setEnabled(false);
            determinedNumberField.setEnabled(false);


            aonCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (aonCheck.getValue()){
                        doesNotWorkRadio.setEnabled(true);
                        incorrectWorkRadio.setEnabled(true);
                        samplesAonField.setEnabled(true);
                        determinedNumberField.setEnabled(true);
                    } else {
                        doesNotWorkRadio.setEnabled(false);
                        incorrectWorkRadio.setEnabled(false);
                        samplesAonField.setEnabled(false);
                        determinedNumberField.setEnabled(false);
                    }
                }
            });


            from7Radio.setEnabled(false);
            from7and8Radio.setEnabled(false);
            withCityNumberRadio.setEnabled(false);
            samplesOfIvrField.setEnabled(false);

            ivrCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (ivrCheck.getValue()){
                        from7Radio.setEnabled(true);
                        from7and8Radio.setEnabled(true);
                        withCityNumberRadio.setEnabled(true);
                        samplesOfIvrField.setEnabled(true);
                    } else {
                        from7Radio.setEnabled(false);
                        from7and8Radio.setEnabled(false);
                        withCityNumberRadio.setEnabled(false);
                        samplesOfIvrField.setEnabled(false);
                    }

                }
            });
        }
        return container;
    }
}
