package by.vsu.jt_example.controller;

import by.vsu.jt_example.domain.Note;
import by.vsu.jt_example.model.NoteModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MainController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Note> notes = NoteModel.read();
		req.setAttribute("notes", notes);
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}
