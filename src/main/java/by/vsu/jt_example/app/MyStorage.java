package by.vsu.jt_example.app;

import java.util.*;

public class MyStorage {
	private static final Map<Long, MyObject> myObjects = new HashMap<>();
	static {
		create(build("qwerty", 123, true));
		create(build("asdfgh", 456, false));
		create(build("zxcvbn", 789, true));
	}

	public static void create(MyObject obj) {
		Long id = myObjects.keySet().stream().max(Long::compare).orElse(0L) + 1;
		obj.setId(id);
		myObjects.put(id, obj);
	}

	public static List<MyObject> read() {
		return myObjects.entrySet().stream()
				.map(Map.Entry::getValue)
				.sorted(Comparator.comparing(MyObject::getAbc).thenComparingInt(MyObject::getXyz))
				.toList();
	}

	public static MyObject read(Long id) {
		return myObjects.get(id);
	}

	public static void update(MyObject obj) {
		if(myObjects.containsKey(obj.getId())) {
			myObjects.put(obj.getId(), obj);
		}
	}

	public static void delete(Long id) {
		myObjects.remove(id);
	}

	private static MyObject build(String abc, Integer xyz, boolean mnk) {
		MyObject myObject = new MyObject();
		myObject.setAbc(abc);
		myObject.setXyz(xyz);
		myObject.setMnk(mnk);
		return myObject;
	}
}
