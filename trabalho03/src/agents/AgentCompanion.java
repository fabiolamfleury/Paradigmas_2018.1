package agents;

import communication.BehaviourReceiverMessage;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class AgentCompanion extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -587032368657425161L;

	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentCompanion"); 
		register(sd);
		
		addBehaviour(new BehaviourReceiverMessage(this));	

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
