package org.example.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.Service.demoService;
import org.example.Service.impl.demoServiceImpl;

import java.util.List;
@WebServlet(urlPatterns = "/demoIOC")
public class demoServlet1 extends HttpServlet {
    demoService ds = new demoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaaaaaaaaaa");
        resp.getWriter().println(ds.getList().toString());
    }
}
