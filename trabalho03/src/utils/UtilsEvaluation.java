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
		String [] possibleContents = {"Criação","Estruturais","Comportamentais"};

		int index = generateRandomNumber(2);
		String content = possibleContents[index];
		return content;
	}
	
	public int questionResult() {
		int rightQuestion = generateRandomNumber(25);
		System.out.println("O numero de questões corretas foram " + rightQuestion);
		return rightQuestion;
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
	
	public int monitorinPerformanceResult() {
		return 0;
	}
	 
}
