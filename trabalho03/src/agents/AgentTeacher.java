package agents;


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

public class AgentTeacher extends Agent{
	
	private static final long serialVersionUID = 3039621223253454417L;
	private String materia;
	
	public AgentTeacher(String materia) {
		this.materia = materia;
	}
	protected void setup() {		
		System.out.println("Eu sou um professor, e preciso conhecer os Companions dos alunos da minha turma");
		MeetAllCompanionsBehaviour mCB = new MeetAllCompanionsBehaviour(this); 
		addBehaviour(mCB);
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentTeacher"); 
		register(sd);
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
