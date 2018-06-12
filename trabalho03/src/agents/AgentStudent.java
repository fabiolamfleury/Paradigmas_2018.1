package agents;

import java.util.ArrayList;
import java.util.List;

import jade.core.Agent;
import utils.Evaluation;
import utils.UtilsEvaluation;

public class AgentStudent extends Agent{
	
	protected void setup() {
		
		List<String> contents = new ArrayList<String>();
		UtilsEvaluation utils = new UtilsEvaluation();
		
		// Set Student note
		int studantFirstNote = utils.generateRandomNumber(10);
		Evaluation firstEvaluation = new Evaluation(1, contents,studantFirstNote);
		
		// Random Content on Evaluation
		String firstContent = utils.selectContentFirstEvaluation();
		String secondContent = utils.selectContentFirstEvaluation();
		
		firstEvaluation.setContent(firstContent);
		firstEvaluation.setContent(secondContent);
	
	}
}
