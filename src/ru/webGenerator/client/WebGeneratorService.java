package ru.webGenerator.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("WebGeneratorService")
public interface WebGeneratorService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use WebGeneratorService.App.getInstance() to access static instance of WebGeneratorServiceAsync
     */
    public static class App {
        private static WebGeneratorServiceAsync ourInstance = GWT.create(WebGeneratorService.class);

        public static synchronized WebGeneratorServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
