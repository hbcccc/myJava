package org.example.apo;



import org.example.apo.Service.DemoService;
import org.example.apo.factory.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo5")
public class DemoServceServlet extends HttpServlet {
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("hbc",33);
        demoService.sub("hbc",44);

        resp.getWriter().println("hello");

    }
}
