package ru.webGenerator.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.info.Info;


/**
 * Created by DaH4uk on 18.02.2016.
 */
public class OrderField implements IsWidget {

    private VerticalLayoutContainer generationContainer;
    private int marginLeft = WebGenerator.marginLeft;
    final TextArea orderTextArea = new TextArea();

    final CheckBox fromTheWordsCheck = new CheckBox();
    final CheckBox cableConnectionsChecked = new CheckBox();
    final CheckBox convenientTimeCheck = new CheckBox();
    final SimpleComboBox<String> convenientTimeCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
    final DateField convenientDateField = new DateField();
    final TextField contactTelField = new TextField();
    final CheckBox clientConflictCheck = new CheckBox();
    final CheckBox fromPpdCheck = new CheckBox();
    final CheckBox scheduleSzCheck = new CheckBox();
    final CheckBox onHoldCheck = new CheckBox();
    final CheckBox guaranteeServiceCheck = new CheckBox();



    @Override
    public Widget asWidget() {
        if (generationContainer == null) {


            generationContainer = new VerticalLayoutContainer();
            generationContainer.setBorders(true);



            fromTheWordsCheck.setBoxLabel("Со слов клиента, ...");

            cableConnectionsChecked.setBoxLabel("Подключение кабеля проверено, повреждений нет");

            HorizontalLayoutContainer checkCableContainer = new HorizontalLayoutContainer();

            checkCableContainer.add(fromTheWordsCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 0, new Margins(0, 0, 0, 0)));
            checkCableContainer.add(cableConnectionsChecked, new HorizontalLayoutContainer.HorizontalLayoutData(2, 0, new Margins(0, 0, 0, 20)));

            generationContainer.add(checkCableContainer, new VerticalLayoutData(0.5, 0, new Margins(10, 0, 0, marginLeft)));


            convenientTimeCheck.setBoxLabel("Удобное время");

            convenientTimeCombo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            convenientTimeCombo.setEditable(true);
            for (int i = 9; i < 21; i++) {
                convenientTimeCombo.add(" с " + i + ":00 до " + (i + 1) + ":00");
            }

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


            HorizontalLayoutContainer contactTelContainer = new HorizontalLayoutContainer();

            contactTelContainer.add(contactTelLabel, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(20, 0, 0, 0)));
            contactTelContainer.add(contactTelField, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, -30)));

            generationContainer.add(contactTelContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer createTopChecksContainer = new HorizontalLayoutContainer();

            clientConflictCheck.setBoxLabel("Клиент конфликтный");

            fromPpdCheck.setBoxLabel("От ППД");

            scheduleSzCheck.setBoxLabel("СЗ вне графика");

            final TextButton createButton = new TextButton("Создать заявку", new SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    createOrder();
                }
            });

            createTopChecksContainer.add(clientConflictCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(30, 0, 0, 0)));
            createTopChecksContainer.add(fromPpdCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -10)));
            createTopChecksContainer.add(scheduleSzCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.2, 0, new Margins(30, 0, 0, -40)));
            createTopChecksContainer.add(createButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.28, 0, new Margins(20, 0, 0, -20)));

            generationContainer.add(createTopChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            HorizontalLayoutContainer createBottomChecksContainer = new HorizontalLayoutContainer();

            onHoldCheck.setBoxLabel("На удержание");

            guaranteeServiceCheck.setBoxLabel("Гарантийное обслуживание");

            TextButton copyButton = new TextButton("Копировать", new SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    copyToClipboard();
                }
            });

            createBottomChecksContainer.add(onHoldCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(40, 0, 0, 0)));
            createBottomChecksContainer.add(guaranteeServiceCheck, new HorizontalLayoutContainer.HorizontalLayoutData(0.35, 0, new Margins(40, 0, 0, -10)));
            createBottomChecksContainer.add(copyButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.326, 0, new Margins(35, 0, 0, 8)));

            generationContainer.add(createBottomChecksContainer, new VerticalLayoutData(1, 0, new Margins(25, 0, 0, marginLeft)));


            orderTextArea.setHeight(150);
            orderTextArea.setId("orderTextArea");




            generationContainer.add(orderTextArea, new VerticalLayoutData(1, 0.5, new Margins(80, marginLeft, 0, marginLeft)));

//            TextButton newWindow = new TextButton("В новом окне", new SelectHandler() {
//                @Override
//                public void onSelect(SelectEvent event) {
//                    Window.open("WebGenerator.html", "newwin", "'top=15, left=20, menubar=0, toolbar=0, location=0, directories=0, status=0, scrollbars=0, resizable=0, width=620, height=825'");
//                }
//            });

            TextButton clearButton = new TextButton("Очистить все", new SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    clearAll();
                }
            });


            HorizontalLayoutContainer buttonsContainer = new HorizontalLayoutContainer();
            buttonsContainer.add(clearButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.3, 0, new Margins(10, 0, 0, 0)));
//            buttonsContainer.add(clearButton, new HorizontalLayoutContainer.HorizontalLayoutData(0.7, 0, new Margins(10, 0, 0, 210)));

            generationContainer.add(buttonsContainer, new VerticalLayoutData(1, 0, new Margins(0, marginLeft, -10, marginLeft)));


        }
        return generationContainer;
    }

    public static native void copyToClipboard() /*-{
        var selection = $wnd.getSelection();
        var text = $doc.getElementById("orderTextArea");
        var range = $doc.createRange();
        range.selectNodeContents(text);
        selection.removeAllRanges();
        selection.addRange(range);
        $doc.execCommand('copy');
        selection.removeAllRanges();
    }-*/;


    private void createOrder(){
        String request = "";
        if (convenientTimeCombo.getValue() == null) {
            convenientTimeCombo.setValue("");
        }
        if (convenientTimeCheck.getValue() && !scheduleSzCheck.getValue()) {

            request = request + "Клиенту удобно принять техника " + convenientDateField.getValue().toLocaleString().substring(0, 10) +
                    convenientTimeCombo.getValue() + ". ";
        }

        if (scheduleSzCheck.getValue()) {
            request = request + "ВЫСОКИЙ ПРИОРИТЕТ! ";
            if (convenientTimeCheck.getValue()) {
                request = request + "Клиенту удобно принять техника " + convenientDateField.getValue().toLocaleString().substring(0, 10) +
                        convenientTimeCombo.getValue() + ". ";
            } else {
                request = request + "Требуется СЗ вне графика на " + convenientDateField.getValue().toLocaleString().substring(0, 10) +
                        convenientTimeCombo.getValue() + ". ";
            }
        }

        if (fromPpdCheck.getValue()) {
            request = request + "От ППД. ";
        }

        if (onHoldCheck.getValue()) {
            request = request + "Удержание. ";
        }

        if (guaranteeServiceCheck.getValue()) {
            request = request + "Гарантийное обслуживание. ";
        }


        //Логика для Internet Tab
        if (WebGenerator.tabPanel.getActiveWidget() == WebGenerator.internetTabPanel) {
            //Логика для табы с 651 ошибкой
            if (WebGenerator.internetTabPanel.getActiveWidget() == WebGenerator.error651Tab) {

                if (Error651Tab.problemPortsCheck.getValue()) {
                    request = request + "Клиент попал в отчет по проблемным портам. ";
                }

                if (Error651Tab.routerDefectiveCheck.getValue()) {
                    request = request + "Подозрение на неисправность роутера. ";
                } else {
                    if (Error651Tab.netCableDisconnectedRadio.getValue()) {
                        request = request + "Сетевой кабель не подключен. ";
                    } else {
                        request = request + "Удалённый компьютер не отвечает. ";
                    }
                }

                if (Error651Tab.comControlledYesRadio.getValue()) {
                    request = request + "Подключен к упр. коммутатору. ";
                } else {
                    request = request + "Подключен к неупр. коммутатору. ";
                }
                if (Error651Tab.operStatusDownRadio.getValue()) {
                    request = request + "По EQM Oper status DOWN. Mac-адрес не виден. ";
                } else {
                    request = request + "По EQM Oper status UP. ";
                    if (Error651Tab.macVisibleNoRadio.getValue()) {
                        request = request + "Mac-адрес не виден. ";
                    } else {
                        if (Error651Tab.macBelongsNoRadio.getValue()) {
                            request = request + "За портом Mac-адрес не клиента. ";
                        } else if (Error651Tab.noSessionsNeighborsCheck.getValue() && Error651Tab.noSessionsNeighborsAdminCheck.getValue()
                                && (Error651Tab.noSessionsNeighborsAdminCombo.getValue() == "Магистральный порт NO")) {
                            request = request + "На коммутаторе нет сессий соседей. Магистральный порт NO. ";

                        } else if (Error651Tab.noSessionsNeighborsCheck.getValue() && Error651Tab.noSessionsNeighborsAdminCheck.getValue()
                                && (Error651Tab.noSessionsNeighborsAdminCombo.getValue() == "Единовременный разрыв сессий")) {
                            request = request + "На коммутаторе нет сессий соседей. Магистральный порт определен. Был единовременный разрыв сессий соседей. ";
                        } else if (Error651Tab.noSessionsNeighborsCheck.getValue() && !Error651Tab.noSessionsNeighborsAdminCheck.getValue()) {
                            request = request + "На коммутаторе нет сессий соседей. Магистральный порт определен. Единовременного разрыва сессий соседей не было. ";
                        }
                        if (Error651Tab.comControlledNoRadio.getValue() && Error651Tab.macNeighAdrNoRadio.getValue()) {
                            request = request + "Mac-адреса других клиентов не видны. ";
                        }
                        if (Error651Tab.comControlledNoRadio.getValue() && Error651Tab.macNeighAdrYesRadio.getValue()) {
                            request = request + "Mac-адреса других клиентов видны. ";
                        }
                    }
                }

                if (Error651Tab.operStatusDownRadio.getValue() && Error651Tab.breakYesCheck.getValue()) {
                    request = request + "Зафиксирован обрыв ";
                    if (Error651Tab.firstPairBreakCheck.getValue()) {
                        request = request + "1 пары на " + Error651Tab.firstPairBreakText.getValue() + " метре. ";
                    }
                    if (Error651Tab.secondPairBreakCheck.getValue()) {
                        request = request + "2 пары на " + Error651Tab.secondPairBreakText.getValue() + " метре. ";
                    }
                }
                if (Error651Tab.portDoesNotRespondCheck.getValue()) {
                    request = request + "Порт не реагирует на отключение кабеля. ";
                }
                if (Error651Tab.portRebootedCheck.getValue()) {
                    request = request + "Порт перезапускали. ";
                }
                if (Error651Tab.portWorksOnCheck.getValue()) {
                    request = request + "Порт работает в режиме " + Error651Tab.portWorksOnCombo.getValue() + "." +
                            " В параметрах драйвера Lan указывали 100 Mb/Full-Duplex, ситуация не изменилась. ";
                }
                if (Error651Tab.routerDefectiveCheck.getValue() && Error651Tab.replacementIfNecessaryCheck.getValue()) {
                    request = request + "Напрямую всё в норме. Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность и при необходимости заменить. ";
                } else if (Error651Tab.routerDefectiveCheck.getValue()) {
                    request = request + "Напрямую всё в норме. Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность. ";
                }


                //Логика для Разрывов
            } else if (WebGenerator.internetTabPanel.getActiveWidget() == WebGenerator.breaksTab) {
                if (BreaksTab.problemPortsBreaks.getValue()) {
                    request = request + "Клиент попал в отчет по проблемным портам. ";
                }

                if (BreaksTab.breaksOnGnField.getValue() == null) {
                    BreaksTab.breaksOnGnField.setValue("");
                }

                if (BreaksTab.breaksOnGnCheck.getValue()) {
                    if (BreaksTab.breaksOnGnField.getValue().equals("")) {
                        if (BreaksTab.defectiveRouterBreaks.getValue()) {
                            request = request + "Подозрение на неисправность роутера. Через роутер: ";
                        }
                    } else {
                        if (BreaksTab.defectiveRouterBreaks.getValue()) {
                            request = request + "Подозрение на неисправность шлюза телефонии. Через шлюз: ";
                        }
                        request = request + "ГН: " + BreaksTab.breaksOnGnField.getValue() + ". ";
                    }
                } else {
                    if (BreaksTab.defectiveRouterBreaks.getValue()) {
                        request = request + "Подозрение на неисправность роутера. Через роутер: ";
                    }
                }

                request = request + "Частые разрывы соединения по причине " + BreaksTab.reasonCombo.getValue() + ". ";
                if ((BreaksTab.reasonCombo.getValue().equals("Lost-Carrier") || BreaksTab.reasonCombo.getValue().equals("Lost-Service")
                        || BreaksTab.reasonCombo.getValue().equals("Port-Error") || BreaksTab.reasonCombo.getValue().equals("NAS-Error") || BreaksTab.reasonCombo.getValue().equals("NAS-Reboot")
                        || BreaksTab.reasonCombo.getValue().equals("NAS-Request")) && !BreaksTab.neighborsBreaks.getValue() && !BreaksTab.errorsBreaks.getValue()
                        && !BreaksTab.portFlopCheckBreaks.getValue() && !BreaksTab.stormControlBreaks.getValue() && !BreaksTab.stpBreaks.getValue()) {
                    request = request + "Ошибок за портом, падений порта нет. В логах Storm Control и STP пусто. ";
                }
                if (BreaksTab.neighborsBreaks.getValue()) {
                    request = request + "У соседей аналогичные разрывы в это же время. ";
                }
                if (BreaksTab.errorsBreaks.getValue()) {
                    request = request + "Копятся ошибки за портом. ";
                }
                if (BreaksTab.portFlopCheckBreaks.getValue()) {
                    request = request + "Фиксируются периодические падения порта. ";
                }
                if (BreaksTab.stormControlBreaks.getValue()) {
                    request = request + "В логах Storm Control фиксируется сетевой шторм. ";
                }
                if (BreaksTab.stpBreaks.getValue()) {
                    request = request + "В логах STP фигурируют записи new root selected. ";
                }
                if (BreaksTab.whenMovmentOfCableCheck.getValue()) {
                    request = request + "При движении кабеля линк не падает. ";
                }

                if (BreaksTab.breaksOnGnCheck.getValue() && !BreaksTab.breaksOnGnField.getValue().equals("")) {
                    if (BreaksTab.defectiveRouterBreaks.getValue() && BreaksTab.replacementRouterBreaks.getValue()) {
                        request = request + "Напрямую всё в норме. Шлюз перезагружали. Требуется проверить шлюз на работоспособность и при необходимости заменить. ";
                    } else if (BreaksTab.defectiveRouterBreaks.getValue()) {
                        request = request + "Напрямую всё в норме. Шлюз перезагружали. Требуется проверить шлюз на работоспособность. ";
                    }
                } else {
                    if (BreaksTab.defectiveRouterBreaks.getValue() && BreaksTab.replacementRouterBreaks.getValue()) {
                        request = request + "Напрямую всё в норме. Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность и при необходимости заменить. ";
                    } else if (BreaksTab.defectiveRouterBreaks.getValue()) {
                        request = request + "Напрямую всё в норме. Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность. ";
                    }
                }

                //Логика для табы Скорость интернета
            } else if (WebGenerator.internetTabPanel.getActiveWidget() == WebGenerator.speedTab) {

                if (SpeedTab.problemPortCheck.getValue()) {
                    request = request + "Клиент попал в отчет по проблемным портам. ";
                }

                if (SpeedTab.routerDefectiveCheck.getValue()) {
                    request = request + "Подозрение на неисправность роутера. ";
                    if (SpeedTab.difficultWithWifiCheck.getValue()) {
                        if (!SpeedTab.complexityRouterCombo.getValue().equals("Просто низкая скорость")) {
                            request = request + "Через роутер по wi-fi: " + SpeedTab.complexityRouterCombo.getValue() + ". ";
                        } else {
                            request = request + "Через роутер по wi-fi: ";
                        }

                    } else {
                        request = request + "Через роутер по патч-корду: ";
                    }
                }

                request = request + "Низкая скорость. ";

                if (SpeedTab.speedOnSpeedTestCheck.getValue()) {
                    request = request + "По ST: Download: " + SpeedTab.speedTestDownloadField.getValue() + " Мбит/с, Upload: " + SpeedTab.speedTestUploadField.getValue() +
                            " Мбит/с. (Должно быть " + SpeedTab.speedTestMustBeField.getValue() + " Мбит/с). ";
                }
                if (SpeedTab.iperfCheck.getValue()) {
                    request = request + "По Iperf: " + SpeedTab.speedIperfField.getValue() + " Мбит/c до г.: " + SpeedTab.cityIperfComboBox.getValue() + ". ";
                }

                if (SpeedTab.externalResourceCheck.getValue()) {
                    request = request + "При пинге до " + SpeedTab.externalResourceNameField.getValue() + " " + SpeedTab.externalResourceSentField.getValue()
                            + " пакетами по " + SpeedTab.externalResourceSizeField.getValue() + " байт: " +
                            (100 - 100 * (SpeedTab.externalResourceReceivedField.getValue()) / (SpeedTab.externalResourceSentField.getValue()))
                            + "% потерь. ";
                }



                if (SpeedTab.stCheck.getValue()) {
                    request = request + "При пинге до ST " + SpeedTab.stSentField.getValue()
                            + " пакетами по " + SpeedTab.stSizeField.getValue() + " байт: " +
                            (100 - 100 * (SpeedTab.stReceivedField.getValue()) / SpeedTab.stSentField.getValue())
                            + "% потерь. ";
                }



                if (SpeedTab.commutatorCheck.getValue()) {
                    request = request + " При пинге до коммутатора (Ip: " + SpeedTab.commutatorIpField.getValue() + ") " + SpeedTab.commutatorSentField.getValue() +
                            " пакетами по " + SpeedTab.commutatorSizeField.getValue() + " байт: " +
                            (100 - 100 * (SpeedTab.commutatorReceivedField.getValue()) / (SpeedTab.commutatorSentField.getValue())) + "% потерь.  Клиент подключен к порту: "
                            + SpeedTab.portField.getValue() + ". ";
                }



                if (SpeedTab.clientCheck.getValue()) {
                    request = request + " При пинге до клиента " + SpeedTab.clientSizeField.getValue() +
                            " пакетами по " + SpeedTab.clientSentField.getValue() + " байт: " +
                            (100 - 100 * (SpeedTab.clientReceivedField.getValue()) / (SpeedTab.clientSentField.getValue())) + "% потерь. ";
                }


                if (SpeedTab.errorsField.getValue().equals("0")) {
                    request = request + "Ошибок за портом нет. ";
                } else {
                    request = request + "Ошибок за портом: " + SpeedTab.errorsField.getValue() + ". ";
                    if (SpeedTab.increaseErrorsCheck.getValue()) {
                        request = request + "Число ошибок растет. ";
                    }
                }

                if (SpeedTab.routerDefectiveCheck.getValue()) {
                    request = request + "Напрямую скорость согласно ТП. ";
                    if (SpeedTab.difficultWithWifiCheck.getValue()) {
                        request = request + "Канал меняли. ";
                    }
                    if (!SpeedTab.routerReplacementCheck.getValue()) {
                        request = request + " Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность. ";
                    } else {
                        request = request + " Роутер перезагружали, сбрасывали, перенастраивали. Требуется проверить роутер на работоспособность и при необходимости заменить. ";
                    }
                }

                if (SpeedTab.softDisabledCheck.getValue()){
                    request = request + "Защитное ПО, торренты, закачки и т.п. отключили. ";
                }

            }
        } else if (WebGenerator.tabPanel.getActiveWidget() == WebGenerator.domRuTVPanel){
            if (WebGenerator.domRuTVPanel.getActiveWidget() == WebGenerator.digitalTvTab){
                request = request + "ЦКТВ. ";

                if (DigitalTvTab.suspectedFaultCheck.getValue() && DigitalTvTab.decoderCheck.getValue()) {
                    request = request + "Подозрение на неисправность декодера. ";
                } else if (DigitalTvTab.suspectedFaultCheck.getValue() && DigitalTvTab.camCheck.getValue()) {
                    request = request + "Подозрение на неисправность Cam-модуля. ";
                }


                if (DigitalTvTab.splittingImageCheck.getValue()) {
                    if (DigitalTvTab.fadingImageCheck.getValue()) {
                        request = request + "Происходит рассыпание, замирание изображения. ";
                    } else {
                        request = request + "Происходит рассыпание изображения. ";
                    }
                }
                if (DigitalTvTab.fadingImageCheck.getValue() && !DigitalTvTab.splittingImageCheck.getValue()) {
                    request = request + "Происходит замирание изображения. ";
                }
                if (DigitalTvTab.interruptedBroadcastCheck.getValue()) {
                    request = request + "Прерывается вещание на нескольких каналах. ";
                }
                if (DigitalTvTab.noBroadcastingOnAllCheck.getValue()) {
                    request = request + "Нет вещания на всех каналах. ";
                }
                if (DigitalTvTab.noBroadcastingOnEncodedCheck.getValue()) {
                    request = request + "Нет вещания на закодированных каналах. ";
                }
                if (DigitalTvTab.noBroadcastingOnMultipleCheck.getValue()) {
                    request = request + "Нет вещания на " + DigitalTvTab.ch + ". ";
                }

                if (DigitalTvTab.doesntOpenPortalCheck.getValue()) {
                    request = request + "Не открывается портал. ";
                }
                //TODO: Добавить messageBox
                if (DigitalTvTab.noSoundCheck.getValue()) {

                    request = request + "Нет звука. ";
                }

                if (DigitalTvTab.decoderCheck.getValue()) {
                    if (DigitalTvTab.decoderDumpedCheck.getValue() && DigitalTvTab.decoderRebootedCheck.getValue()) {
                        request = request + "Декодер перезагружали, сбрасывали, перенастраивали. ";
                    } else {
                        if (DigitalTvTab.decoderRebootedCheck.getValue()) {
                            request = request + "Декодер перезагружали. ";
                        }
                        if (DigitalTvTab.decoderDumpedCheck.getValue()) {
                            request = request + "Декодер сбрасывали, перенастраивали. ";
                        }
                    }
                }

                if (DigitalTvTab.camCheck.getValue()) {
                    if (DigitalTvTab.channelsRescannedCheck.getValue()) {
                        request = request + "Каналы пересканировали. ";
                    }
                    if (DigitalTvTab.camTookOutPutBackCheck.getValue()) {
                        request = request + "Сам-модуль достали, вставили корректно. ";
                    }

                }


                if (DigitalTvTab.cardTookOutPutBackCheck.getValue()) {
                    request = request + "Карту достали, вставили верно. ";
                }
                if (DigitalTvTab.updatedSubscriptionCheck.getValue()) {
                    request = request + "Данные по подписке обновили. ";
                }

                if (DigitalTvTab.analogTvCheck.getValue() && DigitalTvTab.analogTvYesRadio.getValue()) {
                    request = request + "КТВ показывает. ";
                } else if (DigitalTvTab.analogTvCheck.getValue() && DigitalTvTab.analogTvNoRadio.getValue()) {
                    request = request + "КТВ не показывает. ";
                }

                if (DigitalTvTab.suspectedFaultCheck.getValue() && DigitalTvTab.decoderCheck.getValue()) {
                    if (DigitalTvTab.replacementCheck.getValue()) {
                        request = request + "Требуется проверить декодер на работоспособность и при необходимости заменить. ";
                    } else {
                        request = request + "Требуется проверить декодер на работоспособность. ";
                    }

                } else if (DigitalTvTab.suspectedFaultCheck.getValue() && DigitalTvTab.camCheck.getValue()) {
                    if (DigitalTvTab.replacementCheck.getValue()) {
                        request = request + "Требуется проверить Cam-модуль на работоспособность и при необходимости заменить. ";
                    } else {
                        request = request + "Требуется проверить Cam-модуль на работоспособность. ";
                    }
                }
                if (DigitalTvTab.analogTvCheckCheckbox.getValue()) {
                    request = request + "Требуется проверить линию КТВ. ";
                }
            } else if (WebGenerator.domRuTVPanel.getActiveWidget() == WebGenerator.analogTvTab){
                if (AnalogTvTab.qualityImageCheck.getValue()) {
                    String sbd = "";
                    if (AnalogTvTab.interferenceRipplesCheck.getValue()) {
                        sbd = sbd + "Помехи/рябь ";
                    }
                    if (AnalogTvTab.noSoundCheck.getValue()) {
                        sbd = sbd + "Нет звука ";
                    }
                    if (AnalogTvTab.blackWhiteImageCheck.getValue()) {
                        sbd = sbd + "Ч/Б изображение ";
                    }
                    request = request + "Клиента не устраивает качество сигнала (" + sbd + "). ";

                }
                if (AnalogTvTab.noSignalCheck.getValue()) {
                    request = request + "Нет сигнала на ";
                    if (AnalogTvTab.onAllChannelsRadio.getValue()) {
                        request = request + "всех каналах. ";
                    } else {
                        request = request + AnalogTvTab.ch + " каналах. ";
                    }
                }

                if (AnalogTvTab.channelsRescannedCheck.getValue()) {
                    request = request + "Каналы пересканировали. ";
                }

                if (AnalogTvTab.integrityOfCableCheck.getValue() && AnalogTvTab.levelOfSignalCheck.getValue()) {
                    request = request + "Требуется проверить целостность кабеля и уровень сигнала. ";
                } else if (AnalogTvTab.integrityOfCableCheck.getValue()) {
                    request = request + "Требуется проверить целостность кабеля. ";
                } else if (AnalogTvTab.levelOfSignalCheck.getValue()) {
                    request = request + "Требуется проверить уровень сигнала. ";
                }

            }
        } if (WebGenerator.tabPanel.getActiveWidget() == WebGenerator.phoneContainer){
            if (WebGenerator.phoneField.getValue() == null)
            {
                WebGenerator.phoneField.setValue("");
            }
            if (QualityOfCommunicationTab.samplesIncomingArea.getValue() == null)
            {
                QualityOfCommunicationTab.samplesIncomingArea.setValue("");
            }
            if (QualityOfCommunicationTab.samplesOutgoingArea.getValue() == null)
            {
                QualityOfCommunicationTab.samplesOutgoingArea.setValue("");
            }
            if (NoIncomingOutgoingTab.samplesIncomingArea.getValue() == null)
            {
                NoIncomingOutgoingTab.samplesIncomingArea.setValue("");
            }
            if (NoIncomingOutgoingTab.samplesOutgoingArea.getValue() == null)
            {
                NoIncomingOutgoingTab.samplesOutgoingArea.setValue("");
            }
            if (NoIncomingOutgoingTab.moroMoroField.getValue() == null)
            {
                NoIncomingOutgoingTab.moroMoroField.setValue("");
            }

            if (NoIncomingOutgoingTab.withSpecificNumberField.getValue() == null)
            {
                NoIncomingOutgoingTab.withSpecificNumberField.setValue("");
            }

            request = request + "ГН: " + WebGenerator.phoneField.getValue() + ". ";
            if (WebGenerator.phoneTabPanel.getActiveWidget() == WebGenerator.phoneNoSession) {
                request = request + "Адаптер не устанавливает сессию. ";

                if (PhoneNoSessionTab.operStatusUpRadio.getValue()) {
                    request = request + "Линк есть. ";
                } else {
                    request = request + "За портом клиента нет линка. ";
                }
                if (PhoneNoSessionTab.macAdrVisibleNoRadio.getValue()) {
                    request = request + "Мак-адрес не виден. ";
                } else {
                    request = request + "Мак-адрес виден. ";
                }

                if (PhoneNoSessionTab.adapterRebootedCheck.getValue()) {
                    request = request + "Адаптер перезагружали. ";
                }
            }  else if (WebGenerator.phoneTabPanel.getActiveWidget() == WebGenerator.noIncomingOutgoingTab) {
                if (NoIncomingOutgoingTab.incomingCheck.getValue() && NoIncomingOutgoingTab.outgoingCheck.getValue()) {
                    if (NoIncomingOutgoingTab.withSpecificNumberCheck.getValue()) {
                        request = request + "Отсутствует входящая и исходящая связь с номером: " + NoIncomingOutgoingTab.withSpecificNumberField.getValue() + ". ";
                        if (NoIncomingOutgoingTab.hornInTubeYesRadio.getValue()) {
                            request = request + "Гудок в трубке есть. ";
                        } else {
                            request = request + "Гудка в трубке нет. ";
                        }
                    } else {
                        request = request + "Отсутствует входящая и исходящая связь. ";
                        if (NoIncomingOutgoingTab.hornInTubeYesRadio.getValue()) {
                            request = request + "Гудок в трубке есть. ";
                        } else {
                            request = request + "Гудка в трубке нет. ";
                        }
                    }


                } else if (NoIncomingOutgoingTab.incomingCheck.getValue()) {

                    if (NoIncomingOutgoingTab.withSpecificNumberCheck.getValue()) {
                        request = request + "Отсутствует входящая связь с номером: " + NoIncomingOutgoingTab.withSpecificNumberField.getValue() + ". ";
                        if (NoIncomingOutgoingTab.numberMatchesRadio.getValue()) {
                            request = request + "Номер, закрепленный за приложением и указанный в параметрах адаптера, совпадают. ";
                        } else {
                            request = request + "Номер, закрепленный за приложением и указанный в параметрах адаптера, не совпадают. ";
                        }
                    } else {
                        request = request + "Отсутствует входящая связь. ";
                        if (NoIncomingOutgoingTab.numberMatchesRadio.getValue()) {
                            request = request + "Номер, закрепленный за приложением и установленный в адаптер, совпадают. ";
                        } else {
                            request = request + "Номер, закрепленный за приложением и установленный в адаптер, не совпадают. ";
                        }
                    }
                } else if (NoIncomingOutgoingTab.outgoingCheck.getValue()) {
                    if (NoIncomingOutgoingTab.withSpecificNumberCheck.getValue()) {
                        request = request + "Отсутствует исходящая связь с номером: " + NoIncomingOutgoingTab.withSpecificNumberField.getValue() + ". ";
                    } else
                        request = request + "Отсутствует исходящая связь. ";
                }


                ///////
                if (NoIncomingOutgoingTab.rebootedAdapterCheck.getValue()) {
                    request = request + "Адаптер перезагружали. ";
                }

                if (NoIncomingOutgoingTab.sipCheck.getValue()) {
                    if (NoIncomingOutgoingTab.passesSipRadio.getValue())
                        request = request + "SIP-регистрация проходит. ";
                    else
                        request = request + "SIP-регистрация не проходит. ";
                }

                if (NoIncomingOutgoingTab.callFromOfficeCheck.getValue()) {
                    if (NoIncomingOutgoingTab.callFromOfficePassesRadio.getValue())
                        request = request + "Звонок из офиса проходит. ";
                    else
                        request = request + "Звонок из офиса так же не проходит. ";
                }

                if (NoIncomingOutgoingTab.otherTaCheckBox.getValue()) {
                    if (NoIncomingOutgoingTab.otherTaYesRadio.getValue()) {
                        request = request + "С другого ТА сложность так же сохраняется. ";
                    } else {
                        request = request + "Другим ТА нет возможности проверить. ";
                    }
                }

                if (NoIncomingOutgoingTab.outgoingCheck.getValue()) {
                    if (!NoIncomingOutgoingTab.moroMoroField.getValue().equals("")) {
                        request = request + "При проверке через Moro-Moro код ошибки: " + NoIncomingOutgoingTab.moroMoroField + ". ";
                    }
                }
                if (NoIncomingOutgoingTab.incomingCheck.getValue() && !NoIncomingOutgoingTab.samplesIncomingArea.getValue().equals("")) {
                    request = request + "Примеры номеров, до которых клиенту не удалось дозвониться: " + NoIncomingOutgoingTab.samplesIncomingArea.getValue() + ". ";
                }
                if (NoIncomingOutgoingTab.outgoingCheck.getValue() && !NoIncomingOutgoingTab.samplesOutgoingArea.getValue().equals("")) {
                    request = request + "Примеры номеров, на которые звонил клиент: " + NoIncomingOutgoingTab.samplesOutgoingArea.getValue() + ". ";
                }

                if (NoIncomingOutgoingTab.samplesIncomingArea.getValue().equals("") && NoIncomingOutgoingTab.samplesOutgoingArea.getValue().equals("")) {
                    Info.display("Внимание!", "Не забудьте примеры номеров!");

                }

            } else if (WebGenerator.phoneTabPanel.getActiveWidget() == WebGenerator.qualityOfCommunicationTab){

                if (QualityOfCommunicationTab.crackNoiseRadio.getValue()) {
                    String trt = "";
                    if (QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && !QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при входящей связи";
                    } else if (!QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при исходящей связи";
                    } else if (QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при входящей и исходящей связи";
                    }
                    request = request + "Посторонние шумы в трубке (треск, шум, т.п.)" + trt + ". ";
                } else if (QualityOfCommunicationTab.lowVolumeLevelRadio.getValue()) {
                    String trt = "";
                    if (QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && !QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при входящей связи";
                    } else if (!QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при исходящей связи";
                    } else if (QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue()) {
                        trt = " при входящей и исходящей связи";
                    }
                    request = request + "Тихая слышимость" + trt + ". ";
                }


                if (QualityOfCommunicationTab.whoHearsClientCheckbox.getValue() && !QualityOfCommunicationTab.whoHearsInterlocutorCheckbox.getValue()) {
                    request = request + "Слышит только клиент. ";
                } else if (!QualityOfCommunicationTab.whoHearsClientCheckbox.getValue() && QualityOfCommunicationTab.whoHearsInterlocutorCheckbox.getValue()) {
                    request = request + "Слышит только собеседник клиента. ";
                } else if (QualityOfCommunicationTab.whoHearsClientCheckbox.getValue() && QualityOfCommunicationTab.whoHearsInterlocutorCheckbox.getValue()) {
                    request = request + "Слышит как клиент, так и его собеседник. ";
                }
                if (QualityOfCommunicationTab.lossToAdapterCheck.getValue() && !QualityOfCommunicationTab.lossToAdapterField.getValue().equals("")) {
                    request = request + "При опросе шлюза " + QualityOfCommunicationTab.lossToAdapterField.getValue() + "% потерь. ";
                } else {
                    request = request + "При опросе шлюза потерь нет. ";
                }
                if (QualityOfCommunicationTab.lossToCommutatorCheck.getValue()) {
                    if (QualityOfCommunicationTab.lossToCommutatorField.getValue().equals("") || QualityOfCommunicationTab.lossToCommutatorField.getValue().equals("0")) {
                        request = request + "При опросе коммутатора потерь нет. ";
                    } else {
                        request = request + "При опросе коммутатора " + QualityOfCommunicationTab.lossToCommutatorField.getValue() + "% потерь. ";
                    }
                }
                if (QualityOfCommunicationTab.errorsOnPortCheck.getValue()) {
                    if (QualityOfCommunicationTab.errorsOnPortField.getValue().equals("") || QualityOfCommunicationTab.errorsOnPortField.getValue().equals("0")) {
                        request = request + "Ошибок за портом нет. ";
                    } else {
                        request = request + "Ошибок за портом: " + QualityOfCommunicationTab.errorsOnPortField.getValue() + ". ";
                        if (QualityOfCommunicationTab.errorsOnPortGrowCheck.getValue()) {
                            request = request + "Ошибки растут. ";
                        }
                    }
                }
                if (QualityOfCommunicationTab.otherTaNoRadio.getValue()) {
                    request = request + "С другого ТА нет возможности проверить. ";
                } else  {
                    request = request + "С другого ТА сложность сохраняется. ";
                }
                if (QualityOfCommunicationTab.adapterRebootedCheckbox.getValue()) {
                    request = request + "Адаптер перезагружали. ";
                }
                if (QualityOfCommunicationTab.gainOfSignalCheck.getValue()) {
                    if (QualityOfCommunicationTab.gainOfSignalUpRadio.getValue()) {
                        request = request + "Усиление сигнала на выходе увеличили. ";
                    } else {
                        request = request + "Усиление сигнала на выходе уменьшали. ";
                    }
                }
                if (QualityOfCommunicationTab.incomingDirectionCheckBox.getValue() && !QualityOfCommunicationTab.samplesIncomingArea.getValue().equals("")) {
                    request = request + "Примеры номеров входящей связи: " + QualityOfCommunicationTab.samplesIncomingArea.getValue() + ". ";
                }
                if (QualityOfCommunicationTab.outgoingDirectionCheckBox.getValue() && !QualityOfCommunicationTab.samplesOutgoingArea.getValue().equals("")) {
                    request = request + "Примеры номеров исходящей связи: " + QualityOfCommunicationTab.samplesOutgoingArea.getValue() + ". ";
                }
                if (QualityOfCommunicationTab.samplesIncomingArea.getValue().equals("") && QualityOfCommunicationTab.samplesOutgoingArea.getValue().equals("")) {
                    Info.display("Внимание!", "Не забудьте примеры номеров!");

                }
            } else if (WebGenerator.phoneTabPanel.getActiveWidget() == WebGenerator.ivrAonTab){
                if (IvrAonTab.aonCheck.getValue() && IvrAonTab.doesNotWorkRadio.getValue()) {
                    request = request + "Не срабатывает определитель номера при входящих вызовах. Включен Евро АОН. ";
                } else if (IvrAonTab.aonCheck.getValue() && IvrAonTab.incorrectWorkRadio.getValue()) {
                    request = request + "Некорректно работает определитель номера. Примеры номеров, которые звонили клиенту: "
                            + IvrAonTab.samplesAonField.getValue() + ". Номер, который по факту определяется у клиента: " +
                            IvrAonTab.determinedNumberField.getValue() + ". ";
                }
                if (IvrAonTab.ivrCheck.getValue()) {
                    request = request + "Не срабатывает донабор в голосовом меню ";
                    if (IvrAonTab.from7Radio.getValue()) {
                        request = request + "при звонке через 7. ";
                    } else if (IvrAonTab.from7and8Radio.getValue()) {
                        request = request + "при звонке через 7 и 8. ";
                    } else {
                        request = request + "при наборе через городской номер. ";
                    }
                    request = request + "Примеры номеров, где клиент пытался использовать IVR: " +
                            IvrAonTab.samplesOfIvrField.getValue() + ". ";
                }
                if (IvrAonTab.breakTimeCheck.getValue()) {
                    request = request + "Со слов клиента, на трубке сбивается время. ";
                }
            }
        }

        if (clientConflictCheck.getValue()) {
            request = request + "Клиент конфликтный. ";
        }

        if (fromTheWordsCheck.getValue() && cableConnectionsChecked.getValue()) {
            request = request + "Со слов клиента, кабель подключен плотно и повреждений не имеет. ";
        } else if (cableConnectionsChecked.getValue()) {
            request = request + "Подключение кабеля проверено, повреждений нет. ";
        }
        if(contactTelField.getValue() == null){
            contactTelField.setValue("");
        }

        if (!contactTelField.getValue().equals("")){
            request = request + "к.т. " + contactTelField.getValue();
        }

        orderTextArea.setValue(request);




    }


    private void clearAll(){
        Error651Tab.netCableDisconnectedRadio.setValue(true);
        Error651Tab.remotePcNotAnsweredRadio.setValue(false);

        Error651Tab.operStatusDownRadio.setValue(true);
        Error651Tab.operStatusUpRadio.setValue(false);

        Error651Tab.macNeighAdrYesRadio.setValue(false);
        Error651Tab.macNeighAdrYesRadio.setEnabled(false);

        Error651Tab.macNeighAdrNoRadio.setValue(true);
        Error651Tab.macNeighAdrNoRadio.setEnabled(false);

        Error651Tab.comControlledYesRadio.setValue(true);
        Error651Tab.comControlledNoRadio.setValue(false);

        Error651Tab.macVisibleNoRadio.setValue(true);
        Error651Tab.macVisibleNoRadio.setEnabled(false);

        Error651Tab.macVisibleYesRadio.setValue(false);
        Error651Tab.macVisibleYesRadio.setEnabled(false);

        Error651Tab.macBelongsYesRadio.setValue(false);
        Error651Tab.macBelongsYesRadio.setEnabled(false);

        Error651Tab.macBelongsNoRadio.setValue(true);
        Error651Tab.macBelongsNoRadio.setEnabled(false);

        Error651Tab.breakYesCheck.setValue(false);

        Error651Tab.firstPairBreakCheck.setValue(false);
        Error651Tab.firstPairBreakCheck.setEnabled(false);

        Error651Tab.firstPairBreakText.setValue("");
        Error651Tab.firstPairBreakText.setEnabled(false);

        Error651Tab.secondPairBreakCheck.setValue(false);
        Error651Tab.secondPairBreakCheck.setEnabled(false);

        Error651Tab.secondPairBreakText.setValue("");
        Error651Tab.secondPairBreakText.setEnabled(false);

        Error651Tab.portRebootedCheck.reset();
        Error651Tab.portRebootedCheck.setEnabled(true);

        Error651Tab.portDoesNotRespondCheck.reset();

        Error651Tab.portWorksOnCheck.reset();
        Error651Tab.portWorksOnCombo.setValue("10 Мбит/с");

        Error651Tab.noSessionsNeighborsCheck.reset();

        Error651Tab.noSessionsNeighborsAdminCheck.reset();
        Error651Tab.noSessionsNeighborsAdminCombo.setValue("Магистральный порт NO");

        Error651Tab.routerDefectiveCheck.reset();

        Error651Tab.replacementIfNecessaryCheck.reset();

        Error651Tab.problemPortsCheck.reset();







        ///////////////////////////////////////////////////////////////////


        fromTheWordsCheck.reset();
        cableConnectionsChecked.reset();

        convenientTimeCheck.reset();
        convenientTimeCombo.reset();
        convenientDateField.reset();

        contactTelField.reset();


        clientConflictCheck.reset();
        fromPpdCheck.reset();
        scheduleSzCheck.reset();

        onHoldCheck.reset();
        guaranteeServiceCheck.reset();

        orderTextArea.reset();



        ///////////////////////////////////////////////////////////////


        BreaksTab.breaksOnGnCheck.reset();

        BreaksTab.breaksOnGnField.reset();
        BreaksTab.breaksOnGnField.setEnabled(false);

        BreaksTab.reasonCombo.setValue("Lost-Carrier");

        BreaksTab.neighborsBreaks.reset();
        BreaksTab.errorsBreaks.reset();
        BreaksTab.portFlopCheckBreaks.reset();
        BreaksTab.stormControlBreaks.reset();
        BreaksTab.stpBreaks.reset();
        BreaksTab.whenMovmentOfCableCheck.reset();
        BreaksTab.problemPortsBreaks.reset();
        BreaksTab.defectiveRouterBreaks.reset();
        BreaksTab.replacementRouterBreaks.reset();


        /////////////////////////////////////////////////////////////

        SpeedTab.externalResourceCheck.reset();
        SpeedTab.externalResourceNameField.setValue("ya.ru");
        SpeedTab.externalResourceNameField.setEnabled(false);

        SpeedTab.externalResourceSizeField.setValue(1400);
        SpeedTab.externalResourceSizeField.setEnabled(false);

        SpeedTab.externalResourceSentField.setValue(30);
        SpeedTab.externalResourceSentField.setEnabled(false);

        SpeedTab.externalResourceReceivedField.reset();
        SpeedTab.externalResourceReceivedField.setEnabled(false);


        SpeedTab.stCheck.reset();

        SpeedTab.stSizeField.setValue(1400);
        SpeedTab.stSizeField.setEnabled(false);

        SpeedTab.stSentField.setValue(30);
        SpeedTab.stSentField.setEnabled(false);

        SpeedTab.stReceivedField.reset();
        SpeedTab.stReceivedField.setEnabled(false);

        SpeedTab.commutatorCheck.reset();

        SpeedTab.commutatorSizeField.setValue(1200);
        SpeedTab.commutatorSizeField.setEnabled(false);

        SpeedTab.commutatorSentField.setValue(30);
        SpeedTab.commutatorSentField.setEnabled(false);

        SpeedTab.commutatorReceivedField.reset();
        SpeedTab.commutatorReceivedField.setEnabled(false);

        SpeedTab.commutatorIpField.setValue("0.0.0.0");
        SpeedTab.commutatorIpField.setEnabled(false);

        SpeedTab.portField.reset();
        SpeedTab.portField.setEnabled(false);

        SpeedTab.clientCheck.reset();

        SpeedTab.clientSizeField.setValue(1400);
        SpeedTab.clientSizeField.setEnabled(false);

        SpeedTab.clientSentField.setValue(30);
        SpeedTab.clientSentField.setEnabled(false);

        SpeedTab.clientReceivedField.reset();
        SpeedTab.clientReceivedField.setEnabled(false);


        SpeedTab.speedOnSpeedTestCheck.reset();

        SpeedTab.speedTestDownloadField.reset();
        SpeedTab.speedTestDownloadField.setEnabled(false);

        SpeedTab.speedTestUploadField.reset();
        SpeedTab.speedTestUploadField.setEnabled(false);

        SpeedTab.speedTestMustBeField.reset();
        SpeedTab.speedTestMustBeField.setEnabled(false);

        SpeedTab.iperfCheck.reset();


        SpeedTab.speedIperfField.setEnabled(false);

        SpeedTab.cityIperfComboBox.reset();
        SpeedTab.cityIperfComboBox.setEnabled(false);

        SpeedTab.errorsField.setValue(0);
        SpeedTab.increaseErrorsCheck.reset();
        SpeedTab.routerDefectiveCheck.reset();

        SpeedTab.difficultWithWifiCheck.reset();
        SpeedTab.difficultWithWifiCheck.setEnabled(false);

        SpeedTab.complexityRouterCombo.setEnabled(false);
        SpeedTab.complexityRouterCombo.setValue("Низкий уровень сигнала");

        SpeedTab.routerReplacementCheck.reset();
        SpeedTab.routerReplacementCheck.setEnabled(false);

        SpeedTab.softDisabledCheck.reset();

        SpeedTab.problemPortCheck.reset();


        //////////////////////////////////////////////////////////////////////

        DigitalTvTab.noBroadcastingOnAllCheck.reset();
        DigitalTvTab.interruptedBroadcastCheck.reset();
        DigitalTvTab.fadingImageCheck.reset();
        DigitalTvTab.splittingImageCheck.reset();
        DigitalTvTab.noBroadcastingOnEncodedCheck.reset();
        DigitalTvTab.noBroadcastingOnMultipleCheck.reset();
        DigitalTvTab.doesntOpenPortalCheck.reset();
        DigitalTvTab.noSoundCheck.reset();

        DigitalTvTab.analogTvCheck.reset();
        DigitalTvTab.analogTvYesRadio.setEnabled(false);
        DigitalTvTab.analogTvYesRadio.setValue(true);

        DigitalTvTab.analogTvNoRadio.setEnabled(false);
        DigitalTvTab.analogTvNoRadio.setValue(false);

        DigitalTvTab.analogTvCheckCheckbox.reset();

        DigitalTvTab.decoderCheck.setValue(true);
        DigitalTvTab.decoderRebootedCheck.reset();
        DigitalTvTab.decoderDumpedCheck.reset();

        DigitalTvTab.camCheck.reset();
        DigitalTvTab.channelsRescannedCheck.reset();
        DigitalTvTab.channelsRescannedCheck.setEnabled(false);
        DigitalTvTab.camTookOutPutBackCheck.reset();
        DigitalTvTab.camTookOutPutBackCheck.setEnabled(false);

        DigitalTvTab.cardTookOutPutBackCheck.reset();
        DigitalTvTab.updatedSubscriptionCheck.reset();
        DigitalTvTab.suspectedFaultCheck.reset();
        DigitalTvTab.replacementCheck.reset();

        /////////////////////////////////////////////


        AnalogTvTab.qualityImageCheck.reset();
        AnalogTvTab.interferenceRipplesCheck.reset();
        AnalogTvTab.interferenceRipplesCheck.setEnabled(false);
        AnalogTvTab.noSoundCheck.reset();
        AnalogTvTab.noSoundCheck.setEnabled(false);
        AnalogTvTab.blackWhiteImageCheck.reset();
        AnalogTvTab.blackWhiteImageCheck.setEnabled(false);

        AnalogTvTab.integrityOfCableCheck.reset();
        AnalogTvTab.levelOfSignalCheck.reset();

        AnalogTvTab.noSignalCheck.reset();
        AnalogTvTab.onAllChannelsRadio.reset();
        AnalogTvTab.onAllChannelsRadio.setEnabled(false);
        AnalogTvTab.onMultipleChannelsRadio.reset();
        AnalogTvTab.onMultipleChannelsRadio.setEnabled(false);

        AnalogTvTab.channelsRescannedCheck.reset();


        //////////////////////////////////////////////////

        PhoneNoSessionTab.macAdrVisibleNoRadio.reset();
        PhoneNoSessionTab.operStatusUpRadio.reset();
        PhoneNoSessionTab.adapterRebootedCheck.reset();
        PhoneNoSessionTab.macAdrVisibleYesRadio.reset();
        PhoneNoSessionTab.operStatusDownRadio.reset();

        ///////////////////////////////////////////////////

        NoIncomingOutgoingTab.outgoingCheck.reset();
        NoIncomingOutgoingTab.incomingCheck.reset();

        NoIncomingOutgoingTab.sipCheck.reset();

        NoIncomingOutgoingTab.passesSipRadio.reset();
        NoIncomingOutgoingTab.notPassSipRadio.reset();
        NoIncomingOutgoingTab.passesSipRadio.setEnabled(false);
        NoIncomingOutgoingTab.notPassSipRadio.setEnabled(false);
        NoIncomingOutgoingTab.passesSipRadio.setValue(true);

        NoIncomingOutgoingTab.callFromOfficeCheck.reset();

        NoIncomingOutgoingTab.callFromOfficePassesRadio.setValue(true);
        NoIncomingOutgoingTab.callFromOfficePassesRadio.setEnabled(false);
        NoIncomingOutgoingTab.callFromOfficeNoPassesRadio.setValue(false);
        NoIncomingOutgoingTab.callFromOfficeNoPassesRadio.setEnabled(false);

        NoIncomingOutgoingTab.moroMoroField.setValue("");

        NoIncomingOutgoingTab.withSpecificNumberCheck.reset();
        NoIncomingOutgoingTab.withSpecificNumberField.reset();
        NoIncomingOutgoingTab.withSpecificNumberField.setEnabled(false);

        NoIncomingOutgoingTab.samplesOutgoingArea.setValue("");
        NoIncomingOutgoingTab.samplesOutgoingArea.setEnabled(false);
        NoIncomingOutgoingTab.samplesIncomingArea.setValue("");
        NoIncomingOutgoingTab.samplesIncomingArea.setEnabled(false);

        NoIncomingOutgoingTab.numberMatchesRadio.reset();
        NoIncomingOutgoingTab.numberMatchesRadio.setEnabled(false);
        NoIncomingOutgoingTab.numberMatchesRadio.setValue(true);
        NoIncomingOutgoingTab.numberNoMatchesRadio.reset();
        NoIncomingOutgoingTab.numberNoMatchesRadio.setEnabled(false);

        NoIncomingOutgoingTab.hornInTubeYesRadio.setValue(true);
        NoIncomingOutgoingTab.hornInTubeNoRadio.setValue(false);

        NoIncomingOutgoingTab.otherTaCheckBox.reset();
        NoIncomingOutgoingTab.otherTaYesRadio.setValue(true);
        NoIncomingOutgoingTab.otherTaYesRadio.setEnabled(false);
        NoIncomingOutgoingTab.otherTaNoRadio.setValue(false);
        NoIncomingOutgoingTab.otherTaNoRadio.setEnabled(false);

        NoIncomingOutgoingTab.rebootedAdapterCheck.reset();

        /////////////////////////////////////////////////////////////
        QualityOfCommunicationTab.crackNoiseRadio.reset();
        QualityOfCommunicationTab.crackNoiseRadio.reset();
        QualityOfCommunicationTab.incomingDirectionCheckBox.reset();
        QualityOfCommunicationTab.whoHearsClientCheckbox.reset();
        QualityOfCommunicationTab.otherTaNoRadio.reset();
        QualityOfCommunicationTab.lowVolumeLevelRadio.reset();
        QualityOfCommunicationTab.outgoingDirectionCheckBox.reset();
        QualityOfCommunicationTab.whoHearsInterlocutorCheckbox.reset();
        QualityOfCommunicationTab.otherTaYesRadio.reset();
        QualityOfCommunicationTab.lossToAdapterCheck.reset();
        QualityOfCommunicationTab.lossToAdapterField.reset();
        QualityOfCommunicationTab.lossToAdapterField.setEnabled(false);
        QualityOfCommunicationTab.lossToCommutatorCheck.reset();
        QualityOfCommunicationTab.lossToCommutatorField.reset();
        QualityOfCommunicationTab.lossToCommutatorField.setEnabled(false);
        QualityOfCommunicationTab.adapterRebootedCheckbox.reset();
        QualityOfCommunicationTab.gainOfSignalCheck.reset();
        QualityOfCommunicationTab.gainOfSignalUpRadio.reset();
        QualityOfCommunicationTab.gainOfSignalUpRadio.setEnabled(false);
        QualityOfCommunicationTab.gainOfSignalDownRadio.reset();
        QualityOfCommunicationTab.gainOfSignalDownRadio.setEnabled(false);
        QualityOfCommunicationTab.errorsOnPortCheck.reset();
        QualityOfCommunicationTab.errorsOnPortField.reset();
        QualityOfCommunicationTab.errorsOnPortField.setEnabled(false);
        QualityOfCommunicationTab.errorsOnPortGrowCheck.reset();
        QualityOfCommunicationTab.errorsOnPortGrowCheck.setEnabled(false);
        QualityOfCommunicationTab.samplesIncomingArea.reset();
        QualityOfCommunicationTab.samplesIncomingArea.setEnabled(false);
        QualityOfCommunicationTab.samplesOutgoingArea.reset();
        QualityOfCommunicationTab.samplesOutgoingArea.setEnabled(false);




        ////////////////////////////////////////////////////////////////////////



        IvrAonTab.aonCheck.reset();
        IvrAonTab.doesNotWorkRadio.reset();
        IvrAonTab.doesNotWorkRadio.setEnabled(false);
        IvrAonTab.incorrectWorkRadio.reset();
        IvrAonTab.incorrectWorkRadio.setEnabled(false);
        IvrAonTab.samplesAonField.reset();
        IvrAonTab.samplesAonField.setEnabled(false);
        IvrAonTab.determinedNumberField.reset();
        IvrAonTab.determinedNumberField.setEnabled(false);
        IvrAonTab.breakTimeCheck.reset();
        IvrAonTab.ivrCheck.reset();
        IvrAonTab.from7Radio.reset();
        IvrAonTab.from7Radio.setEnabled(false);
        IvrAonTab.from7and8Radio.reset();
        IvrAonTab.from7and8Radio.setEnabled(false);
        IvrAonTab.withCityNumberRadio.reset();
        IvrAonTab.withCityNumberRadio.setEnabled(false);
        IvrAonTab.samplesOfIvrField.reset();
        IvrAonTab.samplesOfIvrField.setEnabled(false);











        Info.display("Оповещение", "Все поля очищены");
    }

}
