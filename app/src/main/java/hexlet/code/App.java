package hexlet.code;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.start(getPort());
        app.get("/", ctx -> ctx.result("Hello World"));
        return app;
    }
    public static void main(String[] args) {
        getApp();
    }
}