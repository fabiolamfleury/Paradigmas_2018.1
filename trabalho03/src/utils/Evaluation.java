package utils;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
	private int idEvaluation;
	private List<String> contents;
	
	public Evaluation(int idEvaluation) {
		
		this.idEvaluation = idEvaluation;
		this.contents = new ArrayList<String>();
	}
	
	public int getIdEvaluatio() {
		return this.idEvaluation;
	}
	
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	
	public List<String> getContent() {
		return this.contents;
	}

	public void addContent(String content) {
		this.contents.add(content);
	}


}
