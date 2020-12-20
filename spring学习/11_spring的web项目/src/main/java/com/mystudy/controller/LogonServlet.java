package com.mystudy.controller;

import com.mystudy.entity.Student;
import com.mystudy.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求参数信息
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        //从spring容器中得到service对象
        /*String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);*/

        WebApplicationContext context = null;
        /*String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        //获取ServletContext中的容器对象
        Object attr = getServletContext().getAttribute(key);
        if (attr != null) {
            context = (WebApplicationContext) attr;
        }*/


        //使用spring中的方法，获取容器对象
        ServletContext sc = getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        System.out.println("容器的对象信息========="+context);
        StudentService service = (StudentService) context.getBean("service");
        Student student = new Student();
        student.setId(Integer.valueOf(id));
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        int res = service.addStudent(student);
        if (res == 1) {
            request.setAttribute("key","注册成功");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }else {
            request.setAttribute("key","注册成功");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
