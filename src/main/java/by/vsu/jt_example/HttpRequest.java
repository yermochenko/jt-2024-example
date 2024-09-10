package by.vsu.jt_example;

import java.util.Map;

public class HttpRequest {
	private String url;
	private Map<String, String> params;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
