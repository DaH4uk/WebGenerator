package ru.webGenerator.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.ArrayList;
import java.util.List;

import static com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.*;

/**
 * Created by DaH4uk on 18.02.2016.
 */
public class SpeedTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;
    private List<String> cities = new ArrayList<>();



    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");

            cities.add("Барнаул");
            cities.add("Брянск");
            cities.add("Волгоград");
            cities.add("Воронеж");
            cities.add("Екатеринбург");
            cities.add("Ижевск");
            cities.add("Иркутск");
            cities.add("Йошкар-Ола");
            cities.add("Казань");
            cities.add("Киров");
            cities.add("Красноярск");
            cities.add("Курган");
            cities.add("Курск");
            cities.add("Липецк");
            cities.add("Магнитогорск");
            cities.add("Набережные Челны");
            cities.add("Нижний Новгород");
            cities.add("Новосибирск");
            cities.add("Омск");
            cities.add("Оренбург");
            cities.add("Пенза");
            cities.add("Пермь");
            cities.add("Ростов-на-Дону");
            cities.add("Рязань");
            cities.add("Самара");
            cities.add("Санкт-Петербург");
            cities.add("Саратов");
            cities.add("Тверь");
            cities.add("Томск");
            cities.add("Тула");
            cities.add("Тюмень");
            cities.add("Ульяновск");
            cities.add("Уфа");
            cities.add("Чебоксары");
            cities.add("Челябинск");
            cities.add("Ярославль");

            Label lossLabel = new Label("Потери при пинге");
            lossLabel.setStyleName("label-text");

            CheckBox speedOnSpeedTestCheck = new CheckBox();
            speedOnSpeedTestCheck.setBoxLabel("Скорость (Speedtest):");

            HorizontalLayoutContainer horizontalContainer1 = new HorizontalLayoutContainer();

            horizontalContainer1.add(lossLabel, new HorizontalLayoutData(0.3, 0, new Margins(10, 0, 0, 0)));
            horizontalContainer1.add(speedOnSpeedTestCheck, new HorizontalLayoutData(1, 0, new Margins(10, 0, 0, 210)));

            container.add(horizontalContainer1, new VerticalLayoutData(1, 0, new Margins(0, 0, 0, marginLeft)));

            Label sizeSubTableLabel = new Label("Размер:");
            sizeSubTableLabel.setStyleName("sub-labels");

            Label sentSubTableLabel = new Label("Отправлено:");
            sentSubTableLabel.setStyleName("sub-labels");

            Label receivedSubTableLabel = new Label("Получено:");
            receivedSubTableLabel.setStyleName("sub-labels");

            Label speedTestDownSubTableLabel = new Label("Download:");
            speedTestDownSubTableLabel.setStyleName("sub-labels");

            Label speedTestUpSubTableLabel = new Label("Upload:");
            speedTestUpSubTableLabel.setStyleName("sub-labels");

            HorizontalLayoutContainer horizontalContainer2 = new HorizontalLayoutContainer();

            horizontalContainer2.add(sizeSubTableLabel, new HorizontalLayoutData(0.22, 0, new Margins(10, 0, 0, 143)));
            horizontalContainer2.add(sentSubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, 84)));
            horizontalContainer2.add(receivedSubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, 35)));
            horizontalContainer2.add(speedTestDownSubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, 25)));
            horizontalContainer2.add(speedTestUpSubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, -10)));

            container.add(horizontalContainer2, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));

            CheckBox externalResourceCheck = new CheckBox();
            externalResourceCheck.setBoxLabel("До ");


            TextField externalResourceNameField = new TextField();
            externalResourceNameField.setValue("ya.ru");

            TextField externalResourceSizeField = new TextField();
            externalResourceSizeField.setValue("1400");

            TextField externalResourceSentField = new TextField();
            externalResourceSentField.setValue("30");

            TextField externalResourceReceivedField = new TextField();

            TextField speedTestDownloadField = new TextField();
            TextField speedTestUploadField = new TextField();

            HorizontalLayoutContainer horizontalContainer3 = new HorizontalLayoutContainer();

            horizontalContainer3.add(externalResourceCheck, new HorizontalLayoutData(0.1, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer3.add(externalResourceNameField, new HorizontalLayoutData(0.11, 0, new Margins(5, 0, 0, 5)));
            horizontalContainer3.add(externalResourceSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(speedTestDownloadField, new HorizontalLayoutData(0.20, 0, new Margins(5, 0, 0, 55)));
            horizontalContainer3.add(speedTestUploadField, new HorizontalLayoutData(0.17, 0, new Margins(5, 18, 0, 20)));

            container.add(horizontalContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            CheckBox stCheck = new CheckBox();
            stCheck.setBoxLabel("До ST:");


            TextField stSizeField = new TextField();
            stSizeField.setValue("1400");

            TextField stSentField = new TextField();
            stSentField.setValue("30");

            TextField stReceivedField = new TextField();

            Label mustStLabel = new Label("Д/быть:");
            mustStLabel.addStyleName("labels");
            TextField speedTestMustBeField = new TextField();

            HorizontalLayoutContainer horizontalContainer4 = new HorizontalLayoutContainer();

            horizontalContainer4.add(stCheck, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer4.add(stSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(stSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(stReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(mustStLabel, new HorizontalLayoutData(0.20, 0, new Margins(15, 0, 0, 55)));
            horizontalContainer4.add(speedTestMustBeField, new HorizontalLayoutData(0.17, 0, new Margins(5, 18, 0, 20)));

            container.add(horizontalContainer4, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));


            CheckBox commutatorCheck = new CheckBox();
            commutatorCheck.setBoxLabel("До коммутатора:");


            TextField commutatorSizeField = new TextField();
            commutatorSizeField.setValue("1400");

            TextField commutatorSentField = new TextField();
            commutatorSentField.setValue("30");

            TextField commutatorReceivedField = new TextField();

            CheckBox iperfCheck = new CheckBox();
            iperfCheck.setBoxLabel("Скорость по Iperf:");



            HorizontalLayoutContainer horizontalContainer5 = new HorizontalLayoutContainer();

            horizontalContainer5.add(commutatorCheck, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer5.add(commutatorSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer5.add(commutatorSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer5.add(commutatorReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer5.add(iperfCheck, new HorizontalLayoutData(0.35, 0, new Margins(15, 0, 0, 55)));

            container.add(horizontalContainer5, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));

            Label speedSubTableLabel = new Label("Speed:");
            speedSubTableLabel.setStyleName("sub-labels");

            Label citySubTableLabel = new Label("Город:");
            citySubTableLabel.setStyleName("sub-labels");

            HorizontalLayoutContainer horizontalContainer6 = new HorizontalLayoutContainer();

            horizontalContainer6.add(speedSubTableLabel, new HorizontalLayoutData(0.22, 0, new Margins(15, 0, 0,385)));
            horizontalContainer6.add(citySubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(15, 0, 0, 310)));


            container.add(horizontalContainer6, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));




            Label ipLabel = new Label("IP:");
            ipLabel.setStyleName("labels");

            TextField commutatorIpField = new TextField();
            commutatorIpField.setValue("0.0.0.0");

            Label portLabel = new Label("Порт:");
            portLabel.setStyleName("labels");


            TextField portField = new TextField();


            TextField speedIperfField = new TextField();
            speedIperfField.setWidth(50);

            SimpleComboBox<String> cityIperfComboBox = new SimpleComboBox<String>(new StringLabelProvider<String>());
            cityIperfComboBox.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            cityIperfComboBox.setEditable(true);
            cityIperfComboBox.add(cities);



            HorizontalLayoutContainer horizontalContainer7 = new HorizontalLayoutContainer();

            horizontalContainer7.add(ipLabel, new HorizontalLayoutData(0.03, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer7.add(commutatorIpField, new HorizontalLayoutData(0.25, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer7.add(portLabel, new HorizontalLayoutData(0.03, 0, new Margins(13, 0, 0, 20)));
            horizontalContainer7.add(portField, new HorizontalLayoutData(0.14, 0, new Margins(5, 0, 0, 40)));
            horizontalContainer7.add(speedIperfField, new HorizontalLayoutData(0.05, 0, new Margins(5, 0, 0, 120)));
            horizontalContainer7.add(cityIperfComboBox, new HorizontalLayoutData(0.48, 0, new Margins(5, 0, 0, 150)));

            container.add(horizontalContainer7, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));



            CheckBox clientCheck = new CheckBox();
            clientCheck.setBoxLabel("До клиента:");


            TextField clientSizeField = new TextField();
            clientSizeField.setValue("1400");

            TextField clientSentField = new TextField();
            clientSentField.setValue("30");

            TextField clientReceivedField = new TextField();

            Label label = new Label("Измерения в мбит/с");
            label.setStyleName("labels");



            HorizontalLayoutContainer horizontalContainer8 = new HorizontalLayoutContainer();

            horizontalContainer8.add(clientCheck, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer8.add(clientSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer8.add(clientSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer8.add(clientReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer8.add(label, new HorizontalLayoutData(0.35, 0, new Margins(15, 0, 0, 55)));

            container.add(horizontalContainer8, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));




            Label errorsLabel = new Label("Ошибок на порту");
            errorsLabel.setStyleName("labels");


            TextField errorsField = new TextField();
            errorsField.setValue("0");

            CheckBox increaseErrorsCheck = new CheckBox();
            increaseErrorsCheck.setBoxLabel("Растут");

            CheckBox routerDefectiveCheck = new CheckBox();
            routerDefectiveCheck.setBoxLabel("Роутер неисправен (напрямую все ОК)");




            HorizontalLayoutContainer horizontalContainer9 = new HorizontalLayoutContainer();

            horizontalContainer9.add(errorsLabel, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer9.add(errorsField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer9.add(increaseErrorsCheck, new HorizontalLayoutData(0.15, 0, new Margins(15, 0, 0, 20)));
            horizontalContainer9.add(routerDefectiveCheck, new HorizontalLayoutData(0.5, 0, new Margins(15, 0, 0, 20)));

            container.add(horizontalContainer9, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));

            CheckBox complexityRouterCheck = new CheckBox();
            complexityRouterCheck.setBoxLabel("Сложность с Wi-Fi:");


            SimpleComboBox<String> complexityRouterCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
            complexityRouterCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            complexityRouterCombo.setEditable(true);
            complexityRouterCombo.add("Низкий уровень сигнала");
            complexityRouterCombo.add("Просто низкая скорость");
            complexityRouterCombo.setValue("Низкий уровень сигнала");


            CheckBox routerReplacementCheck = new CheckBox();
            routerReplacementCheck.setBoxLabel("Замена роутера");






            HorizontalLayoutContainer horizontalContainer10 = new HorizontalLayoutContainer();

            horizontalContainer10.add(complexityRouterCheck, new HorizontalLayoutData(0.24, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer10.add(complexityRouterCombo, new HorizontalLayoutData(0.36, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer10.add(routerReplacementCheck, new HorizontalLayoutData(0.15, 0, new Margins(15, 0, 0, 20)));

            container.add(horizontalContainer10, new VerticalLayoutData(1, 0, new Margins(90, 0, 0, marginLeft)));

            CheckBox softDisabledCheck = new CheckBox();
            softDisabledCheck.setBoxLabel("Защитное ПО, торренты, закачки отключили");

            container.add(softDisabledCheck, new VerticalLayoutData(1, 0, new Margins(50, 0, 0, marginLeft)));

        }

        return container;
    }
}
