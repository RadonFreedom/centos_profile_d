#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

#parse("File Header.java")

@WebServlet("")
public class ${NAME} extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        resp.setCharacterEncoding("UTF-8");
        String htmlTemplate =
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>%s</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "%s\n" +
                "</body>\n" +
                "</html>";
        String title = "${NAME}";
        String body = "";
        
        
        String html = String.format(htmlTemplate, title, body);
        PrintWriter out = resp.getWriter();
        out.println(html);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
