package ru.webGenerator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.webGenerator.client.WebGeneratorService;

public class WebGeneratorServiceImpl extends RemoteServiceServlet implements WebGeneratorService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}