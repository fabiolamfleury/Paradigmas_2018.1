package agents;

import java.util.ArrayList;
import java.util.List;

import communication.BehaviourReceiverMessage;
import communication.BehaviourSendMessage;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import utils.Evaluation;
import utils.UtilsEvaluation;

public class AgentStudent extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6712087013514278403L;

	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentStudent"); 
		register(sd);
		
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
		
		//Ações do primeiro feedback
		

	
	}
	
	private void evaluationStatus(int evaluationID, int note,List<String> contents) {
		
		System.out.println("ID Prova " + evaluationID);
		System.out.println("Conte�dos da Prova");
		
		for(String content : contents) {
			System.out.println(content);
		}
		
		System.out.println("Nota da prova " + note);		
	
	}
	
    void register( ServiceDescription sd)
    {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        dfd.addServices(sd);

        try {  
            DFService.register(this, dfd );  
        }
        catch (FIPAException fe) { fe.printStackTrace(); }
    }
}
