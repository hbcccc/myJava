import apo.Service.DemoService;
import apo.factory.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo5")
public class DemoServceServlet extends HttpServlet {
//    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
//
//        resp.getWriter().println(demoService.findAll().toString());
        resp.getWriter().println("hello");

    }
}
