package agents;


import java.util.ArrayList;
import java.util.List;

import behaviours.MeetAllCompanionsBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import utils.Evaluation;
import utils.UtilsEvaluation;

public class AgentTeacher extends Agent{
	
	private static final long serialVersionUID = 3039621223253454417L;
	private String materia;
	
	public AgentTeacher(String materia) {
		this.materia = materia;
	}
	
	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentTeacher"); 
		register(sd);
		
		System.out.println(getName() + ": \t" + "Eu sou um professor, e preciso conhecer os Companions dos alunos da minha turma");
		MeetAllCompanionsBehaviour mCB = new MeetAllCompanionsBehaviour(this);
		addBehaviour(mCB);
		UtilsEvaluation utils = new UtilsEvaluation();
		
		// Random Content on Evaluation
		String firstContent = utils.selectContentFirstEvaluation();
		String secondContent = utils.selectContentFirstEvaluation();
		
		
		Evaluation firstEvaluation = new Evaluation(1);
		firstEvaluation.addContent(firstContent);
		firstEvaluation.addContent(secondContent);
		evaluationStatus(firstEvaluation.getIdEvaluatio(),firstEvaluation.getContent());
		
		Evaluation secondEvaluation = new Evaluation(2);
		firstContent = utils.selectContentSecoundEvaluation();
		secondContent = utils.selectContentSecoundEvaluation();
		secondEvaluation.addContent(firstContent);
		secondEvaluation.addContent(secondContent);
		evaluationStatus(secondEvaluation.getIdEvaluatio(),secondEvaluation.getContent());
	} 
	
	private void evaluationStatus(int evaluationID,List<String> contents) {
		
		System.out.println(getName() + ": \t" + "ID Prova " + evaluationID);
		System.out.println(getName() + ": \t" + "Conteúdos da Prova");
		
		for(String content : contents) {
			System.out.println(getName() + ": \t" + content);
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
