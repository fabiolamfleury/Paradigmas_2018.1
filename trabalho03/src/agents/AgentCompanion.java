package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;


public class AgentCompanion extends Agent{
	
	private static final long serialVersionUID = -587032368657425161L;

	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentCompanion"); 
		register(sd);
		
		addBehaviour(new CyclicBehaviour(this) {
			
			@Override
			public void action() {
				ACLMessage message = myAgent.receive();
				if (message != null) {			
					
					String messageContent = message.getContent();
						if(messageContent.toLowerCase().contains("primeira")) {
							System.out.println(messageContent);
							super.getAgent().removeBehaviour(this);
						}
				}else {
					System.out.println("tetse");
					block();
				}
				
			}
		});	
		
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
    private String analyseFirstEvaluation(String message) {
    	
    	return null;
    }
}
