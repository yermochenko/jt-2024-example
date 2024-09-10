package by.vsu.jt_example.app;

public class MyObject {
	private Long id;
	private String abc;
	private Integer xyz;
	private boolean mnk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public Integer getXyz() {
		return xyz;
	}

	public void setXyz(Integer xyz) {
		this.xyz = xyz;
	}

	public boolean isMnk() {
		return mnk;
	}

	public void setMnk(boolean mnk) {
		this.mnk = mnk;
	}

	@Override
	public String toString() {
		return "MyObject{" +
				"id=" + getId() +
				", abc='" + getAbc() + '\'' +
				", xyz=" + getXyz() +
				", mnk=" + isMnk() +
				'}';
	}
}
