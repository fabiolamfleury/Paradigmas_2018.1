package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class UtilsEvaluation {

	
	public UtilsEvaluation() {
		
	}
	
	public int generateRandomNumber(int range) {
		Random rand = new Random();
		return  rand.nextInt(range);
	}
	public double generateRandomDouble(int min, int max) {
		Random r = new Random();
		double randomValue = min + (max - min) * r.nextDouble();
		return randomValue;

	}
	
	public String selectContentFirstEvaluation() {
		
		String [] possibleContents = {"Criador","Especialista na Informação","Baixo Acoplamento",
									 "Alta Coesão ","Controlador ","Polimorfismo","Fabricação",
									 "Invenção Pura ","Indireção","Variações Protegidas"};
		
		int index = generateRandomNumber(8);
		String content = possibleContents[index];
		return content;
	}
	
	
	//Logic for secund evaluation
	public String selectContentSecoundEvaluation() {
		String [] possibleContents = {"Criacionais","Estruturais","Comportamentais"};

		int index = generateRandomNumber(2);
		String content = possibleContents[index];
		return content;
	}
	
	public int rightQuestionResult() {
		int rightQuestion = generateRandomNumber(25);
		System.out.println("O numero de questÃµes corretas foram " + rightQuestion);
		return rightQuestion;
	}
	
	public double questionResultMultiply(int questions) {
		if(questions == 0) {
			return 1;
		}else if(questions<5 ) {
			return 1.05;
		}else if(questions>5 && questions<10) {
			return 1.1;
		}else if(questions>10 && questions<15) {
			return 1.15;
		}else if(questions>15 && questions<25) {
			return 1.20;
		}else {
			return 1.25;
		}
	}
	
	public double monitoring(int perfomance) {
		
		if(perfomance==0) {
			return 1;
		}else if(perfomance==1) {
			return 1.05;
		}else if(perfomance==2){
			return 1.1;
		}else {
			return 1.15;
		}
		
	}
	
	public int teacherPerfomance() {
		int performance = generateRandomNumber(4);
		if(performance==0) {
			System.out.println("Desempenho com o professor Ruim");
		
		}else if(performance==1) {
			System.out.println("Desempenho com o professor regular");
		
		}else if(performance==2){
			System.out.println("Desempenho com o professor bom");
		
		}else {
			System.out.println("Desempenho com o professor excelente");
		}
		return performance;
	}
	
	public int monitorPerfomance() {
		int performance = generateRandomNumber(4);
		if(performance==0) {
			System.out.println("Desempenho com o Monitor Ruim");
		
		}else if(performance==1) {
			System.out.println("Desempenho com o Monitor regular");
		
		}else if(performance==2){
			System.out.println("Desempenho com o Monitor bom");
		
		}else {
			System.out.println("Desempenho com o Monitor excelente");
		}
		return performance;
	}
	
	public double monitorinPerformanceResult(double grade) {
		
		if(grade==0) {
			int teachePermance = teacherPerfomance();
			int monitorPermance = monitorPerfomance();
			double teacheResult = monitoring(teachePermance);  
			double monitorResult = monitoring(monitorPermance);		
			int rightQuestions = rightQuestionResult();
			double multiplyQuestions = questionResultMultiply(rightQuestions);
			return teacheResult * monitorResult * multiplyQuestions;
			
		}else if(grade>0 && grade<5) {
			int teachePermance = teacherPerfomance();
			int monitorPermance = monitorPerfomance();
			double teacheResult = monitoring(teachePermance);  
			double monitorResult = monitoring(monitorPermance);		
			int rightQuestions = rightQuestionResult();
			double multiplyQuestions = questionResultMultiply(rightQuestions);
			return  teacheResult * monitorResult * multiplyQuestions;
			
		}else if(grade>=5 && grade<7) {
			int rightQuestions = rightQuestionResult();
			int monitorPermance = monitorPerfomance();
			double monitorResult = monitoring(monitorPermance);		
			double multiplyQuestions = questionResultMultiply(rightQuestions);
			
			return  monitorResult * multiplyQuestions;
		}else if(grade>=7 && grade <9) {
			int rightQuestions = rightQuestionResult();
			double multiplyQuestions = questionResultMultiply(rightQuestions);
			return   multiplyQuestions;
	
		}else {
			
			System.out.println("mantenha o desempenho");
			return 1;
		}
	   		
   }
}
	 

