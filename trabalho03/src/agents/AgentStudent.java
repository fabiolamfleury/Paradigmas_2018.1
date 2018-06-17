package agents;

import java.util.ArrayList;
import java.util.List;

import behaviours.CreateCompanionBehaviour;
import behaviours.SendMessageBehaviour;
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
	private String matricula;
	private AID companion;
	
	public AgentStudent(String matricula) {
		this.matricula = matricula;
	}
	
	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentStudent"); 
		register(sd);
		
		addBehaviour(new CreateCompanionBehaviour(this));

		UtilsEvaluation utils = new UtilsEvaluation();
		
		// Set Student note
		double studentFirstGrade = utils.generateRandomDouble(0, 10);		
		String grade = String.valueOf(studentFirstGrade);
		String messageFirstEvaluation = "Primeira prova nota "+ grade;
		
		addBehaviour(new SendMessageBehaviour(this, messageFirstEvaluation));
		
		double studantSecoundNote = utils.generateRandomDouble(0, 10);
		double multiply = utils.monitorinPerformanceResult(studentFirstGrade);
		
		double noteAfterFeedBack = multiply * studantSecoundNote;

		String messageSecondEvaluation = "Segunda prova nota " + String.valueOf(noteAfterFeedBack);
		addBehaviour(new SendMessageBehaviour(this, messageSecondEvaluation));
		
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

	public void setCompanion(AID companion) {
		this.companion = companion;
	}
	
	public AID getCompanion(){
		return this.companion;
	}
	
}
