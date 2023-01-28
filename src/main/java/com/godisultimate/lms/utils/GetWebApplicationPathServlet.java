package com.godisultimate.lms.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetWebApplicationPathServlet extends HttpServlet {

    public GetWebApplicationPathServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/");
        PrintWriter writer = res.getWriter();
        writer.println("Application path: " + path);
    }
}
