package communication;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourReceiverMessage extends CyclicBehaviour{

	public BehaviourReceiverMessage(Agent agent) {
		super(agent);
	}

	public void action() {
		ACLMessage message = myAgent.receive();
		if(message!=null) {
			String content = message.getContent();
				
				System.out.println("O " + message.getSender().getName());
				System.out.println("disse"+content);
			
		}else {
			block();
		}
	}
}
