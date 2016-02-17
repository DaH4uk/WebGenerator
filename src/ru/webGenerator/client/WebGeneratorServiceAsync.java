package ru.webGenerator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WebGeneratorServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
