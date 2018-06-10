package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class AgentCompanion extends Agent{
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			
			@Override
			public void action() {
			
				ACLMessage message = myAgent.receive();
				if(message!=null) {
					String content = message.getContent();
					if(content.equalsIgnoreCase("teste")) {
						
						System.out.println("O agent" + message.getSender().getName());
					
					}
				}else {
					block();
				}
			}
		});
	}

}
