package agents;

import java.util.ArrayList;
import java.util.List;

import communication.BehaviourReceiverMessage;
import communication.BehaviourSendMessage;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
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
	
		evaluationStatus(firstEvaluation.getIdEvaluatio(),firstEvaluation.getNote(),firstEvaluation.getContent());
		//Receber messagem partir desse momento aqui????/
		addBehaviour(new BehaviourSendMessage(this, "6",BehaviourSendMessage.AGENTCOMPANION));
		
		addBehaviour(new BehaviourReceiverMessage(this));
		
		//Ações do primeiro feedback
	
	}
	
	private void evaluationStatus(int evaluationID, int note,List<String> contents) {
		
		System.out.println("ID Prova " + evaluationID);
		System.out.println("Conteúdos da Prova");
		
		for(String content : contents) {
			System.out.println(content);
		}
		
		System.out.println("Nota da prova " + note);
		
	
	}
}
