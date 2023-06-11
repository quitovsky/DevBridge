package qtv.devbridge.web;

import qtv.devbridge.web.handlers.ExecuteHandler;
import qtv.devbridge.web.handlers.ReloadHandler;

public class Handlers {

    public Handlers() {
        new ReloadHandler();
        new ExecuteHandler();
    }

}
