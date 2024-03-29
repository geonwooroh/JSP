package com.codingbox.web.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.codingbox.web.mybatis.SqlMapConfig;

@WebServlet("/insert")
public class B2 extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println(req.getParameter("data1"));
        System.out.println(req.getParameter("data2"));
    	
    	
    	int intdata = Integer.parseInt(req.getParameter("data1"));
        String strdata = req.getParameter("data2");
        
        
        SqlSessionFactory factory = SqlMapConfig.getFactory();
        SqlSession sqlsession = factory.openSession(true);
        
        HashMap<String,Object>datas = new HashMap<>();
        datas.put("intdata", intdata);
        datas.put("strdata", strdata);
        
        int result = 0;
        result = sqlsession.insert("",datas);
        
        if(result != 0 ) {
        	req.setAttribute("result", "추가 성공!");
        }else {
        	req.setAttribute("result", "추가 실패!");
        }
        req.getRequestDispatcher("c.jsp").forward(req, resp);
    }
}
    
    
        
















