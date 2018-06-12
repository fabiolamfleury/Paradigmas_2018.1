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
	
	public String selectContentFirstEvaluation() {
		
		String [] possibleContents = {"Criador","Especialista na Informação","Baixo Acoplamento",
									 "Alta Coesão ","Controlador ","Polimorfismo","Fabricação",
									 "Invenção Pura ","Indireção","Variações Protegidas"};
		
		int index = generateRandomNumber(8);
		String content = possibleContents[index];
		return content;
	}
	
}
