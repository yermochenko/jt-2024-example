package by.vsu.jt_example;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Properties props = new Properties();
		props.load(new FileInputStream("web.properties"));
		while(true) {
			System.out.print("url    > ");
			HttpRequest req = new HttpRequest();
			String url = in.nextLine();
			req.setUrl(url);
			System.out.print("params > ");
			String params = in.nextLine();
			if(!params.isEmpty()) {
				Map<String, String> paramsMap = new HashMap<>();
				String[] pairs = params.split("&");
				for(String pair : pairs) {
					String[] keyValue = pair.split("=");
					if(keyValue.length == 2) {
						paramsMap.put(keyValue[0], keyValue[1]);
					} else {
						throw new RuntimeException("Invalid parameter \"" + pair + "\"");
					}
				}
				req.setParams(paramsMap);
			}
			HttpResponse resp = new HttpResponse();
			String className = props.getProperty(url);
			try {
				Class<?> c = Class.forName(className);
				HttpServlet s = (HttpServlet) c.getConstructor().newInstance();
				s.service(req, resp);
				System.out.println("Result is:");
				System.out.println(resp);
			} catch(ClassNotFoundException e) {
				System.out.printf("Invalid handler for url \"%s\" (%s)\n", url, className);
			} catch(NoSuchMethodException e) {
				System.out.printf("There is no default constructor in class %s\n", className);
			} catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
				System.out.printf("Can't create object of class %s\n", className);
			} catch(ClassCastException e) {
				System.out.printf("Class %s not implement interface by.vsu.jt_example.HttpServlet\n", className);
			}
		}
	}
}
