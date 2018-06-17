package agents;

import java.util.ArrayList;
import java.util.List;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import utils.Evaluation;
import utils.UtilsEvaluation;

public class AgentStudent extends Agent{
	
	private static final long serialVersionUID = -6712087013514278403L;

	
	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentStudent"); 
		register(sd);
		
		List<String> contents = new ArrayList<String>();
		UtilsEvaluation utils = new UtilsEvaluation();
		
		// Set Student note
		double studantFirstNote = utils.generateRandomDouble(0, 10);
		Evaluation firstEvaluation = new Evaluation(1, contents,studantFirstNote);
		
		// Random Content on Evaluation
		String firstContent = utils.selectContentFirstEvaluation();
		String secondContent = utils.selectContentFirstEvaluation();
		
		firstEvaluation.setContent(firstContent);
		firstEvaluation.setContent(secondContent);
		
		evaluationStatus(firstEvaluation.getIdEvaluatio(),firstEvaluation.getContent());
		
		String note = String.valueOf(studantFirstNote);
		String messageFirstEvaluation = "Primeira prova nota "+ note;
		addBehaviour(new OneShotBehaviour(this) {
			
			@Override
			public void action() {
				
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				message.addReceiver(new AID("companion", AID.ISLOCALNAME));
				message.setLanguage("Português");
				message.setOntology("FeedBack");
				message.setContent(messageFirstEvaluation);
				myAgent.send(message);	

			}
		});
		double studantSecoundNote = utils.generateRandomDouble(0, 10);
		double multiply = utils.monitorinPerformanceResult(studantFirstNote);
		
		double noteAfterFeedBack = multiply * studantSecoundNote;
		Evaluation secound = new Evaluation(2, contents,noteAfterFeedBack);
		firstContent = utils.selectContentSecoundEvaluation();
		secondContent = utils.selectContentSecoundEvaluation();
		secound.setContent(firstContent);
		secound.setContent(secondContent);
		evaluationStatus(secound.getIdEvaluatio(),secound.getContent());

		String messageSecondEvaluation = "Segunda prova nota " + String.valueOf(noteAfterFeedBack);
		System.out.println(messageFirstEvaluation);
		
	}
	
	private void evaluationStatus(int evaluationID,List<String> contents) {
		
		System.out.println("ID Prova " + evaluationID);
		System.out.println("Conteúdos da Prova");
		
		for(String content : contents) {
			System.out.println(content);
		}	
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
