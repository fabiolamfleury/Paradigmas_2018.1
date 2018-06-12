package utils;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
	private int idEvaluation;
	private List<String> contents;
	private int note;
	
	public Evaluation(int idEvaluation,List<String> contents,  int note) {
		
		this.idEvaluation = idEvaluation;
		this.contents = contents;
		this.note = note;
	}

	public List<String> getContent() {
		return this.contents;
	}

	public void setContent(String content) {
		this.contents.add(content);
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

}
