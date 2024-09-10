package by.vsu.jt_example;

public class HttpResponse {
	private int statusCode;
	private String body;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "HttpResponse{" +
				"statusCode=" + getStatusCode() +
				", body='" + getBody() + '\'' +
				'}';
	}
}
