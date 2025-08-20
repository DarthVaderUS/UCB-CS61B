package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import browser.NgordnetQuery;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ngrams.NGramMap;

public class HistoryTextHandler implements HttpHandler {
    // Assume history is stored in a static List<String> in CommandHistory class
    // public static List<String> CommandHistory.history;
    private static final List<String> history = new ArrayList<>();

    public HistoryTextHandler(NGramMap ngm) {


    }

    public static void add(String command) {
        history.add(command);
    }

    public static List<String> getHistory() {
        return history;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;
        if ("GET".equals(exchange.getRequestMethod())) {
            // Get history from CommandHistory
            List<String> history = getHistory();
            response = String.join("\n", history);
            exchange.sendResponseHeaders(200, response.getBytes().length);
        } else {
            response = "Method Not Allowed";
            exchange.sendResponseHeaders(405, response.getBytes().length);
        }
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();
    }

    public String handle(NgordnetQuery query) {
        // This method should handle the NgordnetQuery and return a string representation
        // of the history or any other relevant information based on the query.
        // For now, we will just return a placeholder string.

        StringBuilder result = new StringBuilder();
        result.append("Words: ").append(query.words()).append("\n");
        result.append("Start Year: ").append(query.startYear()).append("\n");
        result.append("End Year: ").append(query.endYear()).append("\n");

        // Here you would typically process the query and append results to the result string.

        return result.toString();
    }
}

