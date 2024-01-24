package hexlet.code;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.controller.UrlChecksController;
import hexlet.code.controller.UrlsController;
import hexlet.code.repository.BaseRepository;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.SQLException;

@Slf4j
public class App {
    public static Javalin getApp() throws SQLException, IOException {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(Utils.getJdbcUrl());
        var dataSource = new HikariDataSource(hikariConfig);
        var sql = Utils.readResourceFile("schema.sql");
        log.info(sql);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        JavalinJte.init(Utils.createTemplateEngine());
        app.get(NamedRoutes.mainPath(), UrlsController::showMainPage);
        app.get(NamedRoutes.urlsPath(), UrlsController::showUrls);
        app.get(NamedRoutes.urlPath("{id}"), UrlsController::showUrl);
        app.post(NamedRoutes.urlsPath(), UrlsController::createUrl);
        app.post(NamedRoutes.urlChecksPath("{id}"), UrlChecksController::makeCheck);
        return app;
    }
    public static void main(String[] args) throws SQLException, IOException {
        var app = getApp();
        app.start(Utils.getPort());
    }
}
