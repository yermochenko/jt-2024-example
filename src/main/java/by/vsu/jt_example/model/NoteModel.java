package by.vsu.jt_example.model;

import by.vsu.jt_example.domain.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NoteModel {
	private static final Map<Integer, Note> notes = new HashMap<>();
	static {
		notes.put(1, note(1, "qwe", null, d("2024-11-12"), false));
		notes.put(2, note(2, "asd", "12", d("2024-09-07"), true));
		notes.put(3, note(3, "zxc", "34", d("2024-10-15"), false));
		notes.put(4, note(4, "rty", null, d("2024-11-07"), false));
		notes.put(5, note(5, "fgh", null, d("2024-09-30"), true));
		notes.put(6, note(6, "vbn", null, d("2024-12-25"), false));
	}

	public static List<Note> read() {
		List<Note> result = new ArrayList<>(notes.values());
		result.sort(Comparator.comparingInt(Note::getId));
		return result;
	}

	private static Note note(Integer id, String title, String content, Date date, boolean done) {
		Note note = new Note();
		note.setId(id);
		note.setTitle(title);
		note.setContent(content);
		note.setDate(date);
		note.setDone(done);
		return note;
	}

	private static Date d(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(s);
		} catch(ParseException e) {
			return null;
		}
	}
}
