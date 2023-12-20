package hexlet.code;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.dto.BasePage;
import hexlet.code.repository.BaseRepository;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
public class App {
    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() throws IOException, SQLException {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getJdbcUrl());
        var dataSource = new HikariDataSource(hikariConfig);
        var sql = getResourceFileAsString("schema.sql");
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        JavalinJte.init(createTemplateEngine());
        app.get("/", ctx -> {
            var page = new BasePage();
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setColor(ctx.consumeSessionAttribute("color"));
            ctx.render("main.jte", Collections.singletonMap("page", page));
        });
        return app;
    }
    public static void main(String[] args) throws SQLException, IOException {
        var app = getApp();
        app.start(getPort());
    }
    private static String getJdbcUrl() {
        return System.getenv()
                .getOrDefault("JDBC_DATABASE_URL", "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");
    }
    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        return templateEngine;
    }
    private static String getResourceFileAsString(String fileName) {
        InputStream is = getResourceFileAsInputStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    private static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = App.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
