package ru.webGenerator.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.TextField;

import static com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.*;

/**
 * Created by DaH4uk on 18.02.2016.
 */
public class SpeedTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;


    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();
            container.setBorders(true);

            Label lossLabel = new Label("Потери при пинге");
            lossLabel.setStyleName("label-text");

            CheckBox speedOnSpeedTestCheck = new CheckBox();
            speedOnSpeedTestCheck.setBoxLabel("Скорость (Speedtest):");

            HorizontalLayoutContainer horizontalContainer1 = new HorizontalLayoutContainer();

            horizontalContainer1.add(lossLabel, new HorizontalLayoutData(0.3, 0, new Margins(10, 0, 0, 0)));
            horizontalContainer1.add(speedOnSpeedTestCheck, new HorizontalLayoutData(1, 0, new Margins(10, 0, 0, 200)));

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

            horizontalContainer2.add(sizeSubTableLabel, new HorizontalLayoutData(0.2, 0, new Margins(10, 0, 0, 130)));
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

            externalResourceCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        externalResourceNameField.setEnabled(true);
//                        externalResourceSizeField.setEnabled(true);
//                        externalResourceSentField.setEnabled(true);
//                        externalResourceReceivedField.setEnabled(true);
//                    } else {
//                        externalResourceNameField.setEnabled(false);
//                        externalResourceSizeField.setEnabled(false);
//                        externalResourceSentField.setEnabled(false);
//                        externalResourceReceivedField.setEnabled(false);
//                    }
                }
            });


            TextField speedTestDownloadField = new TextField();
            TextField speedTestUploadField = new TextField();

            HorizontalLayoutContainer horizontalContainer3 = new HorizontalLayoutContainer();

            horizontalContainer3.add(externalResourceCheck, new HorizontalLayoutData(0.08, 0, new Margins(10, 0, 0, 0)));
            horizontalContainer3.add(externalResourceNameField, new HorizontalLayoutData(0.11, 0, new Margins(5, 0, 0, 5)));
            horizontalContainer3.add(externalResourceSizeField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceSentField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(externalResourceReceivedField, new HorizontalLayoutData(0.12, 0, new Margins(5, 0, 0, 20)));
            horizontalContainer3.add(speedTestDownloadField, new HorizontalLayoutData(0.20, 0, new Margins(5, 0, 0, 55)));
            horizontalContainer3.add(speedTestUploadField, new HorizontalLayoutData(0.17, 0, new Margins(5, 18, 0, 20)));

            container.add(horizontalContainer3, new VerticalLayoutData(1, 0, new Margins(20, 0, 0, marginLeft)));


        }

        return container;
    }
}
