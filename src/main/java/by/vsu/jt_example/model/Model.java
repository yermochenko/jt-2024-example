package by.vsu.jt_example.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Model {
	private final static String[] colors = {"#800", "#880", "#080", "#088", "#008", "#808", "#888"};
	private final static Random rnd = new Random();

	public static String readRandomMessage() throws IOException {
		List<String> messages = new ArrayList<>();
		String message;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("messages.txt")), StandardCharsets.UTF_8))) {
			while((message = br.readLine()) != null) {
				messages.add(message);
			}
		}
		return messages.get(rnd.nextInt(messages.size()));
	}

	public static String readRandomColor() {
		return colors[rnd.nextInt(colors.length)];
	}
}
