package communication;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourReceiverMessage extends OneShotBehaviour{

	public BehaviourReceiverMessage(Agent agent) {
		super(agent);
	}

	
	public void action() {
		ACLMessage message = myAgent.receive() ;
		if(message!=null) {
			String messageContent = message.getContent();	
		}
	}
}
