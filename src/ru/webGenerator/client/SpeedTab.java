package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.*;

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


    static final CheckBox speedOnSpeedTestCheck = new CheckBox();
    static final CheckBox externalResourceCheck = new CheckBox();
    static final TextField externalResourceNameField = new TextField();
    static final IntegerField externalResourceSizeField = new IntegerField();
    static final IntegerField externalResourceSentField = new IntegerField();
    static final IntegerField externalResourceReceivedField = new IntegerField();
    static final DoubleField speedTestDownloadField = new DoubleField();
    static final DoubleField speedTestUploadField = new DoubleField();
    static final CheckBox stCheck = new CheckBox();
    static final IntegerField stSizeField = new IntegerField();
    static final IntegerField stSentField = new IntegerField();
    static final IntegerField stReceivedField = new IntegerField();
    static final DoubleField speedTestMustBeField = new DoubleField();
    static final CheckBox commutatorCheck = new CheckBox();
    static final IntegerField commutatorSizeField = new IntegerField();
    static final IntegerField commutatorSentField = new IntegerField();
    static final IntegerField commutatorReceivedField = new IntegerField();
    static final CheckBox iperfCheck = new CheckBox();
    static final TextField commutatorIpField = new TextField();
    static final TextField portField = new TextField();
    static final TextField speedIperfField = new TextField();
    static final SimpleComboBox<String> cityIperfComboBox = new SimpleComboBox<String>(new StringLabelProvider<String>());
    static final CheckBox clientCheck = new CheckBox();
    static final IntegerField clientSizeField = new IntegerField();
    static final IntegerField clientSentField = new IntegerField();
    static final IntegerField clientReceivedField = new IntegerField();
    static final IntegerField errorsField = new IntegerField();
    static final CheckBox increaseErrorsCheck = new CheckBox();
    static final CheckBox routerDefectiveCheck = new CheckBox();
    static final CheckBox difficultWithWifiCheck = new CheckBox();
    static final SimpleComboBox<String> complexityRouterCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
    static final CheckBox routerReplacementCheck = new CheckBox();
    static final CheckBox softDisabledCheck = new CheckBox();
    static final CheckBox problemPortCheck = new CheckBox();

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

            externalResourceCheck.setBoxLabel("До ");


            externalResourceNameField.setValue("ya.ru");

            externalResourceSizeField.setValue(1400);

            externalResourceSentField.setValue(30);


            speedTestDownloadField.setFormat(NumberFormat.getFormat("0.00"));

            speedTestUploadField.setFormat(NumberFormat.getFormat("0.00"));

            HorizontalLayoutContainer horizontalContainer3 = new HorizontalLayoutContainer();

            horizontalContainer3.add(externalResourceCheck, new HorizontalLayoutData(0.1, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer3.add(externalResourceNameField, new HorizontalLayoutData(0.11, 0, new Margins(5, 0, 0, 5)));
            horizontalContainer3.add(externalResourceSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(speedTestDownloadField, new HorizontalLayoutData(0.20, 0, new Margins(5, 0, 0, 55)));
            horizontalContainer3.add(speedTestUploadField, new HorizontalLayoutData(0.17, 0, new Margins(5, 18, 0, 20)));

            container.add(horizontalContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));


            stCheck.setBoxLabel("До ST:");


            stSizeField.setValue(1400);


            stSentField.setValue(30);


            Label mustStLabel = new Label("Д/быть:");
            mustStLabel.addStyleName("labels");


            HorizontalLayoutContainer horizontalContainer4 = new HorizontalLayoutContainer();

            horizontalContainer4.add(stCheck, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer4.add(stSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(stSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(stReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer4.add(mustStLabel, new HorizontalLayoutData(0.20, 0, new Margins(15, 0, 0, 55)));
            horizontalContainer4.add(speedTestMustBeField, new HorizontalLayoutData(0.17, 0, new Margins(5, 18, 0, 20)));

            container.add(horizontalContainer4, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));


            commutatorCheck.setBoxLabel("До коммутатора:");


            commutatorSizeField.setValue(1200);

            commutatorSentField.setValue(30);


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

            horizontalContainer6.add(speedSubTableLabel, new HorizontalLayoutData(0.22, 0, new Margins(15, 0, 0, 385)));
            horizontalContainer6.add(citySubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(15, 0, 0, 310)));


            container.add(horizontalContainer6, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));


            Label ipLabel = new Label("IP:");
            ipLabel.setStyleName("labels");

            commutatorIpField.setValue("0.0.0.0");

            Label portLabel = new Label("Порт:");
            portLabel.setStyleName("labels");


            speedIperfField.setWidth(50);
//            speedIperfField.setFormat(NumberFormat.getFormat("0.00"));


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


            clientCheck.setBoxLabel("До клиента:");


            clientSizeField.setValue(1200);

            clientSentField.setValue(30);


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


            errorsField.setValue(0);


            increaseErrorsCheck.setBoxLabel("Растут");

            routerDefectiveCheck.setBoxLabel("Роутер неисправен (напрямую все ОК)");


            HorizontalLayoutContainer horizontalContainer9 = new HorizontalLayoutContainer();

            horizontalContainer9.add(errorsLabel, new HorizontalLayoutData(0.21, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer9.add(errorsField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer9.add(increaseErrorsCheck, new HorizontalLayoutData(0.15, 0, new Margins(15, 0, 0, 20)));
            horizontalContainer9.add(routerDefectiveCheck, new HorizontalLayoutData(0.5, 0, new Margins(15, 0, 0, 20)));

            container.add(horizontalContainer9, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));


            difficultWithWifiCheck.setBoxLabel("Сложность с Wi-Fi:");


            complexityRouterCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            complexityRouterCombo.setEditable(true);
            complexityRouterCombo.add("Низкий уровень сигнала");
            complexityRouterCombo.add("Просто низкая скорость");
            complexityRouterCombo.setValue("Низкий уровень сигнала");


            routerReplacementCheck.setBoxLabel("Замена роутера");


            HorizontalLayoutContainer horizontalContainer10 = new HorizontalLayoutContainer();

            horizontalContainer10.add(difficultWithWifiCheck, new HorizontalLayoutData(0.24, 0, new Margins(15, 0, 0, 0)));
            horizontalContainer10.add(complexityRouterCombo, new HorizontalLayoutData(0.36, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer10.add(routerReplacementCheck, new HorizontalLayoutData(0.15, 0, new Margins(15, 0, 0, 20)));

            container.add(horizontalContainer10, new VerticalLayoutData(1, 0, new Margins(40, 0, 0, marginLeft)));


            softDisabledCheck.setBoxLabel("Защитное ПО, торренты, закачки отключили");

            container.add(softDisabledCheck, new VerticalLayoutData(1, 0, new Margins(50, 0, 0, marginLeft)));

            problemPortCheck.setBoxLabel("Клиент попал в отчет по проблемным портам");

            container.add(problemPortCheck, new VerticalLayoutData(1, 0, new Margins(10, 0, 0, marginLeft)));

            externalResourceNameField.setEnabled(false);
            externalResourceReceivedField.setEnabled(false);
            externalResourceSentField.setEnabled(false);
            externalResourceSizeField.setEnabled(false);


            externalResourceCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (externalResourceCheck.getValue()) {
                        externalResourceNameField.setEnabled(true);
                        externalResourceReceivedField.setEnabled(true);
                        externalResourceSentField.setEnabled(true);
                        externalResourceSizeField.setEnabled(true);
                    } else {
                        externalResourceNameField.setEnabled(false);
                        externalResourceReceivedField.setEnabled(false);
                        externalResourceSentField.setEnabled(false);
                        externalResourceSizeField.setEnabled(false);
                    }
                }
            });

            stReceivedField.setEnabled(false);
            stSentField.setEnabled(false);
            stSizeField.setEnabled(false);

            stCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (stCheck.getValue()) {
                        stReceivedField.setEnabled(true);
                        stSentField.setEnabled(true);
                        stSizeField.setEnabled(true);
                    } else {
                        stReceivedField.setEnabled(false);
                        stSentField.setEnabled(false);
                        stSizeField.setEnabled(false);
                    }
                }
            });


            commutatorIpField.setEnabled(false);
            commutatorReceivedField.setEnabled(false);
            commutatorSentField.setEnabled(false);
            commutatorSizeField.setEnabled(false);
            portField.setEnabled(false);

            commutatorCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (commutatorCheck.getValue()) {
                        commutatorIpField.setEnabled(true);
                        commutatorReceivedField.setEnabled(true);
                        commutatorSentField.setEnabled(true);
                        commutatorSizeField.setEnabled(true);
                        portField.setEnabled(true);
                    } else {
                        commutatorIpField.setEnabled(false);
                        commutatorReceivedField.setEnabled(false);
                        commutatorSentField.setEnabled(false);
                        commutatorSizeField.setEnabled(false);
                        portField.setEnabled(false);
                    }
                }
            });
            clientReceivedField.setEnabled(false);
            clientSentField.setEnabled(false);
            clientSizeField.setEnabled(false);

            clientCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (clientCheck.getValue()) {
                        clientReceivedField.setEnabled(true);
                        clientSentField.setEnabled(true);
                        clientSizeField.setEnabled(true);
                    } else {
                        clientReceivedField.setEnabled(false);
                        clientSentField.setEnabled(false);
                        clientSizeField.setEnabled(false);
                    }
                }
            });

            speedTestDownloadField.setEnabled(false);
            speedTestUploadField.setEnabled(false);
            speedTestMustBeField.setEnabled(false);

            speedOnSpeedTestCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (speedOnSpeedTestCheck.getValue()) {
                        speedTestDownloadField.setEnabled(true);
                        speedTestUploadField.setEnabled(true);
                        speedTestMustBeField.setEnabled(true);
                    } else {
                        speedTestDownloadField.setEnabled(false);
                        speedTestUploadField.setEnabled(false);
                        speedTestMustBeField.setEnabled(false);
                    }
                }
            });

            speedIperfField.setEnabled(false);
            cityIperfComboBox.setEnabled(false);

            iperfCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (iperfCheck.getValue()) {
                        speedIperfField.setEnabled(true);
                        cityIperfComboBox.setEnabled(true);
                    } else {
                        speedIperfField.setEnabled(false);
                        cityIperfComboBox.setEnabled(false);
                    }
                }
            });

            difficultWithWifiCheck.setEnabled(false);
            complexityRouterCombo.setEnabled(false);
            routerReplacementCheck.setEnabled(false);

            routerDefectiveCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (routerDefectiveCheck.getValue()) {
                        difficultWithWifiCheck.setEnabled(true);
                        complexityRouterCombo.setEnabled(true);
                        routerReplacementCheck.setEnabled(true);
                    } else {
                        difficultWithWifiCheck.setEnabled(false);
                        complexityRouterCombo.setEnabled(false);
                        routerReplacementCheck.setEnabled(false);
                    }
                }
            });
        }


        return container;
    }
}
