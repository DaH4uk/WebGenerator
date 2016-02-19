package ru.webGenerator.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Created by DaH4uk on 18.02.2016.
 */
public class BreaksTab implements IsWidget {
    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;


    @Override
    public Widget asWidget() {
        if (container == null) {

            container = new VerticalLayoutContainer();
            container.setBorders(true);

            CheckBox breaksOnGnCheck = new CheckBox();
            breaksOnGnCheck.setBoxLabel("Разрывы на ГН");

            TextField breaksOnGnField = new TextField();

            HorizontalLayoutContainer breaksOnGnContainer = new HorizontalLayoutContainer();

            breaksOnGnContainer.add(breaksOnGnCheck, new HorizontalLayoutData(0.3, 0, new Margins(20, 0, 0, 0)));
            breaksOnGnContainer.add(breaksOnGnField, new HorizontalLayoutData(0.35, 0, new Margins(10, 0, 0, 0)));

            container.add(breaksOnGnContainer, new VerticalLayoutData(1, 0, new Margins(0, 0, 0, marginLeft)));

            Label reasonLabel = new Label("Причина завершения сессии:");
            reasonLabel.setStyleName("label-text");


            SimpleComboBox<String> reasonCombo = new SimpleComboBox<>(new StringLabelProvider<>());
            reasonCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            reasonCombo.setEditable(true);
            reasonCombo.add("Admin-Reset");
            reasonCombo.add("Lost-Carrier");
            reasonCombo.add("Lost-Service");
            reasonCombo.add("NAS-Error");
            reasonCombo.add("NAS-Reboot");
            reasonCombo.add("NAS-Request");
            reasonCombo.add("Port-Error");
            reasonCombo.add("User-Request");
            reasonCombo.add("Lost-Carrier/User-Request");

            reasonCombo.setValue("Lost-Carrier");

            HorizontalLayoutContainer reasonContainer = new HorizontalLayoutContainer();

            reasonContainer.add(reasonLabel, new HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));
            reasonContainer.add(reasonCombo, new HorizontalLayoutData(0.35, 0, new Margins(20, 0, 0, 0)));

            container.add(reasonContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));

            CheckBox neighborsBreaks = new CheckBox();
            neighborsBreaks.setBoxLabel("У соседей > 3 разрывов в это же время");

            container.add(neighborsBreaks, new VerticalLayoutData(1, 0, new Margins(85, 0, 0, marginLeft)));

            CheckBox errorsBreaks = new CheckBox();
            errorsBreaks.setBoxLabel("Δ ошибок > 0");

            container.add(errorsBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));
            
            CheckBox portFlopCheckBreaks = new CheckBox();
            portFlopCheckBreaks.setBoxLabel("Есть записи в Port flop check (более 5 единовременных падений порта)");

            container.add(portFlopCheckBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));

            CheckBox stormControlBreaks = new CheckBox();
            stormControlBreaks.setBoxLabel("Есть записи в Storm control");

            container.add(stormControlBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));
            
            CheckBox stpBreaks = new CheckBox();
            stpBreaks.setBoxLabel("Есть записи в STP: \"New root selected\" более 5 в день");

            container.add(stpBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));


            CheckBox problemPortsBreaks = new CheckBox();
            problemPortsBreaks.setBoxLabel("Клиент попал в отчет по проблемным портам");

            container.add(problemPortsBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));



            CheckBox defectiveRouterBreaks = new CheckBox();
            defectiveRouterBreaks.setBoxLabel("Роутер неисправен (напрямую все работает)");

            container.add(defectiveRouterBreaks, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));

            CheckBox replacementRouterBreaks = new CheckBox();
            replacementRouterBreaks.setBoxLabel("Замена роутера при необходимости");

            container.add(replacementRouterBreaks, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));

        }
        return container;
    }
}
