package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.model.Url;
import hexlet.code.NamedRoutes;
import io.javalin.http.NotFoundResponse;

import javax.naming.Context;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class UrlsController {
    public static void showMainPage(Context ctx) {
        var page = new BasePage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setColor(ctx.consumeSessionAttribute("color"));
        ctx.render("main.jte", Collections.singletonMap("page", page));
    }
    public  static void createUrl(Context ctx) {
        var inputName = ctx.formParamAsClass("url", String.class).getOrDefault(null);
        Url inputUrl = null;
        try {
            inputUrl = new Url(inputName);
        } catch (MalformedURLException e) {
            ctx.sessionAtribute("flash", "Некорректный URL");
            ctx.sessionAttribute("color", "danger");
            ctx.redirect(NamedRoutes.mainPath());
        }
        if (inputUrl != null) {
            String protocol = inputUrl.getProtocol();
            String authority = inputUrl.getAuthority();
            var name = String.format("%s://%s", protocol, authority);
            var url = new Url(name);
            var uniqueness = UrlRepository.getUrls().stream().noneMatch(entity ->
                    entity.getName.equals(name));
            if (uniqueness) {
                UrlRepository.save(url);
                ctx.sessionAttribute("flash", "Страница усрешно добавлена");
                ctx.sessionAttribute("color", "success");
                ctx.redirect(NamedRoutes.urlsPath());
            } else {
                ctx.sessionAttribute("flash", "Страница не существует");
                ctx.sessionAttribute("color", "info");
                ctx.redirect(NamedRoutes.urlPath());
            }
        }
    }
    public static void showUrls(Context ctx) {
        var urls = UrlRepository.getUrls();
        var page = new UrlsPage(urls);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setColor(ctx.consumeSessionAttribute("color"));
        ctx.render("urls/index.jte", Collections.singletonMap("page", page));
    }
    public static void showUrl(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        var url = UrlsRepository.findById(id).orElseThrow(() ->
                new NotFoundResponse(String.format("Url with id = %s not found", id)));
        var page = new UrlPage(url);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setColor(ctx.consumeSessionAttribute("color"));
        ctx.render("urls/show.jte", Collections.singletonMap("page", page));
    }
}
