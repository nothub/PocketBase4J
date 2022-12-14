package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.HttpClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.LogStats;
import lol.hub.pocketbase.models.Page;
import lol.hub.pocketbase.models.RequestLog;

import java.util.List;

/**
 * <a href="https://pocketbase.io/docs/api-logs/">api docs</a>
 */
public class LogService extends BaseService {
    public LogService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    // TODO: GET "/api/logs/requests/:id"

    public Page<RequestLog> listRequestLogs() throws ApiError {
        return http.getJson("/api/logs/requests", TypeToken.getParameterized(Page.class, RequestLog.class).getType());
    }

    public List<LogStats> requestLogsStatistics() throws ApiError {
        return http.getJson("/api/logs/requests/stats", TypeToken.getParameterized(List.class, LogStats.class).getType());
    }
}
