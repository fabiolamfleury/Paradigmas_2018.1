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
		int studantFirstNote = utils.generateRandomNumber(10);
		Evaluation firstEvaluation = new Evaluation(1, contents,studantFirstNote);
	
	}
}
