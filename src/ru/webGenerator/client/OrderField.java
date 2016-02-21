package ru.webGenerator.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.*;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by DaH4uk on 18.02.2016.
 */
public class OrderField implements IsWidget {

    private VerticalLayoutContainer generationContainer;
    private int marginLeft = WebGenerator.marginLeft;


    @Override
    public Widget asWidget() {
        if (generationContainer == null) {


            generationContainer = new VerticalLayoutContainer();
            generationContainer.setBorders(true);


            CheckBox fromTheWordsCheck = new CheckBox();
            fromTheWordsCheck.setBoxLabel("Со слов клиента, ...");

            CheckBox cableConnectionsChecked = new CheckBox();
            cableConnectionsChecked.setBoxLabel("Подключение кабеля проверено, повреждений нет");

            HorizontalLayoutContainer checkCableContainer = new HorizontalLayoutContainer();

            checkCableContainer.add(fromTheWordsCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            checkCableContainer.add(cableConnectionsChecked, new HorizontalLayoutContainer.HorizontalLayoutData(2, 0, new Margins(0, 0, 0, 20)));

            generationContainer.add(checkCableContainer, new VerticalLayoutData(0.5, 0, new Margins(10, 0, 0, marginLeft)));


            CheckBox convenientTimeCheck = new CheckBox();
            convenientTimeCheck.setBoxLabel("Удобное время");

            SimpleComboBox<String> convenientTimeCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            convenientTimeCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            convenientTimeCombo.setEditable(true);
            for (int i = 9; i < 21; i++) {
                convenientTimeCombo.add("с " + i + ":00 до " + (i + 1) + ":00");
            }

            DateField convenientDateField = new DateField();
            final DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
            convenientDateField.setPropertyEditor(new DateTimePropertyEditor(format));
            convenientDateField.getDatePicker().setMinDate(new DateWrapper().addDays(0).asDate());


            HorizontalLayoutContainer convenientTimeContainer = new HorizontalLayoutContainer();

            convenientTimeContainer.add(convenientTimeCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(10, 0, 0, 0)));
            convenientTimeContainer.add(convenientTimeCombo, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(0, 0, 0, -30)));
            convenientTimeContainer.add(convenientDateField, new HorizontalLayoutContainer.HorizontalLayoutData(0.28, 0, new Margins(0, 0, 0, 10)));

            generationContainer.add(convenientTimeContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            Label contactTelLabel = new Label("Контактный тел.:");
            contactTelLabel.addStyleName("labels");

            TextField contactTelField = new TextField();

            HorizontalLayoutContainer contactTelContainer = new HorizontalLayoutContainer();

            contactTelContainer.add(contactTelLabel, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(20, 0, 0, 0)));
            contactTelContainer.add(contactTelField, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, -30)));

            generationContainer.add(contactTelContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer createTopChecksContainer = new HorizontalLayoutContainer();

            CheckBox clientConflictCheck = new CheckBox();
            clientConflictCheck.setBoxLabel("Клиент конфликтный");

            CheckBox fromPpdCheck = new CheckBox();
            fromPpdCheck.setBoxLabel("От ППД");

            CheckBox scheduleSzCheck = new CheckBox();
            scheduleSzCheck.setBoxLabel("СЗ вне графика");

            createTopChecksContainer.add(clientConflictCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));
            createTopChecksContainer.add(fromPpdCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -10)));
            createTopChecksContainer.add(scheduleSzCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -30)));

            generationContainer.add(createTopChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer createBottomChecksContainer = new HorizontalLayoutContainer();

            CheckBox onHoldCheck = new CheckBox();
            onHoldCheck.setBoxLabel("На удержание");

            CheckBox guaranteeServiceCheck = new CheckBox();
            guaranteeServiceCheck.setBoxLabel("Гарантийное обслуживание");

            TextButton createButton = new TextButton("Создать заявку");

            createBottomChecksContainer.add(onHoldCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(40, 0, 0, 0)));
            createBottomChecksContainer.add(guaranteeServiceCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.35, 0, new Margins(40, 0, 0, -10)));
            createBottomChecksContainer.add(createButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));

            generationContainer.add(createBottomChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));

            TextArea orderTextArea = new TextArea();
            orderTextArea.setHeight(100);


            generationContainer.add(orderTextArea, new VerticalLayoutData(1, 0.5, new Margins(80, marginLeft, 0, marginLeft)));

            TextButton clearButton = new TextButton("Очистить все");
            TextButton copyButton = new TextButton("Копировать");

            HorizontalLayoutContainer buttonsContainer = new HorizontalLayoutContainer();
            buttonsContainer.add(clearButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));
            buttonsContainer.add(copyButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.665, 0, new Margins(30, 0, 0, 210)));

            generationContainer.add(buttonsContainer, new VerticalLayoutData(1, 0, new Margins(0, marginLeft, -10, marginLeft)));




        }
        return generationContainer;
    }
}
