package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.dto.BasePage;
import hexlet.code.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,22,22,22,22,22,22,22,22,22,29,29,29,29,29,29,29,29,30,30,30,30,30,30,30,30,36,36,37,37,37,37,38,38,38,41,41,43,43,43,55};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <title>Анализатор страниц</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n          integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"\r\n          crossorigin=\"anonymous\">\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"\r\n            integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"\r\n            crossorigin=\"anonymous\"></script>\r\n</head>\r\n<body class=\"d-flex flex-column min-vh-100\">\r\n<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n    <div class=\"container-fluid\">\r\n        <a class=\"navbar-brand\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.mainPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.mainPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Анализатор страниц</a>\r\n        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\r\n                aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n            <span class=\"navbar-toggler-icon\"></span>\r\n        </button>\r\n        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n            <div class=\"navbar-nav\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.mainPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.mainPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.urlsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.urlsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Сайты</a>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</nav>\r\n<main class=\"flex-grow-1\">\r\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n        <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getColor());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\r\n            <p class=\"m-0\">");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("</p>\r\n            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n    <section>\r\n        ");
		jteOutput.setContext("section", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n    </section>\r\n</main>\r\n<footer class=\"footer border-top py-3 mt-5 bg-light\">\r\n    <div class=\"container-xl\">\r\n        <div class=\"text-center\">\r\n            created by\r\n            <a href=\"https://github.com/MenzurenkoKirill\" target=\"_blank\">Kirill Menzurenko</a>\r\n        </div>\r\n    </div>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
