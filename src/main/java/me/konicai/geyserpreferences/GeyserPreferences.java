package me.konicai.geyserpreferences;

import org.geysermc.geyser.GeyserImpl;
import org.geysermc.geyser.api.connection.GeyserConnection;
import org.geysermc.geyser.api.event.Subscribe;
import org.geysermc.geyser.api.event.connection.ConnectionEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserShutdownEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.session.GeyserSession;

public class GeyserPreferences implements Extension {

    private GeyserImpl geyser;
    private DataHandler dataHandler;

    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
        this.geyser = GeyserImpl.getInstance();
        dataHandler.start();
    }


    @Subscribe
    public void onConnection(ConnectionEvent event) {
        GeyserConnection connection = event.connection();
        GeyserSession session = (GeyserSession) connection;
        String xuid = session.xuid();
    }

    @Subscribe
    public void onShutdown(GeyserShutdownEvent event) {
        dataHandler.stop();
    }
}
