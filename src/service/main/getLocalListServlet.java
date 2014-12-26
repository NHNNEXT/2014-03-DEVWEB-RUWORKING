package service.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GetLocalList.ruw")
public class getLocalListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MainModel mainModel = new MainModel();
		List localInfoList = mainModel.getLocalInfo();
		int totalPercent = mainModel.getTotalPercent();
		ArrayList <Object> result = new ArrayList<Object>();
		
		result.add(totalPercent);
		result.add(localInfoList);
		
		response.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(result));
		
	}
}
