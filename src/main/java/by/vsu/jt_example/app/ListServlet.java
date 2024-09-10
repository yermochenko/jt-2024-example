package by.vsu.jt_example.app;

import by.vsu.jt_example.HttpRequest;
import by.vsu.jt_example.HttpResponse;
import by.vsu.jt_example.HttpServlet;

import java.util.List;

public class ListServlet implements HttpServlet {
	@Override
	public void service(HttpRequest req, HttpResponse res) {
		List<MyObject> objects = MyStorage.read();
		res.setStatusCode(200);
		res.setBody(objects.toString());
	}
}
