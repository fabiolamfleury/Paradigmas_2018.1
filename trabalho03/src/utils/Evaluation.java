package utils;

public class Evaluation {
	private String content;
	private int evaluationNumber;
	private double note;
	
	public Evaluation(String content, int evaluationNumber, double note) {
		super();
		this.content = content;
		this.evaluationNumber = evaluationNumber;
		this.note = note;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getEvaluationNumber() {
		return evaluationNumber;
	}

	public void setEvaluationNumber(int evaluationNumber) {
		this.evaluationNumber = evaluationNumber;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

}
