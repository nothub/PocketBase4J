package lol.hub.pocketbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lol.hub.pocketbase.services.*;

import java.net.URI;
import java.net.URISyntaxException;

public class PocketbaseClient {
    public final AuthService auth;
    public final AdminService admins;
    public final CollectionService collections;
    public final FileService files;
    public final LogService logs;
    public final RealtimeService realtime;
    public final RecordService records;
    public final SettingService settings;
    public final UserService users;

    public PocketbaseClient(String host, int port, boolean insecure) {
        HttpClient http = new HttpClient(buildBaseUri(host, port, insecure));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        this.admins = new AdminService(http, gson);
        this.users = new UserService(http, gson);
        this.auth = new AuthService(http, gson, admins, users);
        this.collections = new CollectionService(http, gson);
        this.files = new FileService(http, gson);
        this.logs = new LogService(http, gson);
        this.realtime = new RealtimeService(http, gson);
        this.records = new RecordService(http, gson);
        this.settings = new SettingService(http, gson);
    }

    private static URI buildBaseUri(String host, int port, boolean insecure) {
        String protocol = insecure ? "http" : "https";
        try {
            return new URI(protocol + "://" + host + ":" + port + "/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
