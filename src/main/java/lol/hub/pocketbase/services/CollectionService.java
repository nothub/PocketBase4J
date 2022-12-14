package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

/**
 * <a href="https://pocketbase.io/docs/api-collections/">api docs</a>
 */
public class CollectionService extends BaseService {
    public CollectionService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
	GET    "/api/collections"
	POST   "/api/collections"
	GET    "/api/collections/:collection"
	PATCH  "/api/collections/:collection"
	DELETE "/api/collections/:collection"
	PUT    "/api/collections/import"
     */

}
