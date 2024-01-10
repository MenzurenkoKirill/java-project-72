package gg.jte.generated.ondemand.urls;
import hexlet.code.Utils;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,8,8,10,10,10,15,15,15,19,19,19,23,23,23,28,28,28,28,28,28,28,28,40,40,42,42,45,45,45,48,48,48,51,51,51,54,54,54,57,57,57,60,60,60,63,63,65,65,68,68,68};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"container-lg mt-5\">\r\n        <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\r\n        <table class=\"table table-bordered table-hover mt-3\">\r\n            <tbody>\r\n            <tr>\r\n                <td>ID</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Имя</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Дата создания</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(Utils.timeFormat(page.getUrl().getCreatedAt()));
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            </tbody>\r\n        </table>\r\n        <h2 class=\"mt-5\">Проверки</h2>\r\n        <form method=\"post\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.urlChecksPath(page.getUrl().getId()))) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.urlChecksPath(page.getUrl().getId()));
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n            <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n        </form>\r\n        <table class=\"table table-bordered table-hover mt-3\">\r\n            <thead>\r\n            <th class=\"col-1\">ID</th>\r\n            <th class=\"col-1\">Код ответа</th>\r\n            <th>title</th>\r\n            <th>h1</th>\r\n            <th>description</th>\r\n            <th class=\"col-2\">Дата проверки</th>\r\n            </thead>\r\n            ");
				if (!page.getUrlChecks().isEmpty()) {
					jteOutput.writeContent("\r\n                <tbody>\r\n                ");
					for (var urlCheck : page.getUrlChecks()) {
						jteOutput.writeContent("\r\n                    <tr>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getId());
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getStatusCode());
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getTitle());
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getH1());
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getDescription());
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(Utils.timeFormat(urlCheck.getCreatedAt()));
						jteOutput.writeContent("\r\n                        </td>\r\n                    </tr>\r\n                ");
					}
					jteOutput.writeContent("\r\n                </tbody>\r\n            ");
				}
				jteOutput.writeContent("\r\n        </table>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
