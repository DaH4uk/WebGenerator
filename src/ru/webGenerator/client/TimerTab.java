package ru.webGenerator.client;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by DaH4uk on 28.02.2016.
 */
public class TimerTab implements IsWidget {

    private VerticalLayoutContainer container;
    private int marginLeft = WebGenerator.marginLeft;


    @Override
    public Widget asWidget() {
        if (container == null) {
            container = new VerticalLayoutContainer();
            container.setStyleName("borders");


            final Map<TabPanel, Integer> tabPanels = new HashMap<TabPanel, Integer>(2); // map tab panels to index count
            tabPanels.put(getTabPanel(), 0);


            for (Iterator<Entry<TabPanel, Integer>> it = tabPanels.entrySet().iterator(); it.hasNext();) {
                final TabPanel tabPanel = it.next().getKey();

                TextButton add = new TextButton("Добавить напоминание");
                add.addSelectHandler(new SelectHandler() {
                    @Override
                    public void onSelect(SelectEvent event) {
                        int index = tabPanels.get(tabPanel) + 1;
                        tabPanels.put(tabPanel, index);
                        addTab(tabPanel, index);
                        tabPanel.setActiveWidget(tabPanel.getWidget(tabPanel.getWidgetCount() - 1));
                    }
                });


                final ToggleButton toggleCloseBtn = new ToggleButton("Включить для выбранной вкладки кнопку Закрытия");
                toggleCloseBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                    @Override
                    public void onValueChange(ValueChangeEvent<Boolean> event) {
                        Widget widget = tabPanel.getActiveWidget();
                        if (widget != null) {
                            TabItemConfig tabConfig = tabPanel.getConfig(widget);
                            tabConfig.setClosable(event.getValue());
                            tabPanel.update(widget, tabConfig);
                        }
                    }
                });

                ButtonBar bb = new ButtonBar();
                bb.add(add);
                bb.add(toggleCloseBtn);

                tabPanel.setAnimScroll(true);
                tabPanel.setTabScroll(true);
                tabPanel.setCloseContextMenu(true);

                for (int j = 0; j < 2; j++) {
                    int index = tabPanels.get(tabPanel) + 1;
                    tabPanels.put(tabPanel, index);
                    addTab(tabPanel, index);
                }

                tabPanel.setActiveWidget(tabPanel.getWidget(1));

                tabPanel.addSelectionHandler(new SelectionHandler<Widget>() {
                    @Override
                    public void onSelection(SelectionEvent<Widget> event) {
                        toggleCloseBtn.setValue(tabPanel.getConfig(event.getSelectedItem()).isClosable());
                    }
                });

                container.add(bb, new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(0, 0, 10, 0)));
                container.add(tabPanel, new VerticalLayoutContainer.VerticalLayoutData(1, 0.5));
                if (it.hasNext()) {
                    container.add(new HTML(), new VerticalLayoutContainer.VerticalLayoutData(1, 20));
                }
            }

        }
        return container;
    }
    protected TabPanel getTabPanel() {
        return new TabPanel();
    }

    private void addTab(TabPanel tabPanel, int index) {
        Label item = new Label("Tab Body " + index);
        item.addStyleName("label-text");
        tabPanel.add(item, new TabItemConfig("New Tab " + index, index != 1));
    }
}
