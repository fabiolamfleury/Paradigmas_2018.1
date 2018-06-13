package agents;

import communication.BehaviourReceiverMessage;
import communication.BehaviourReplyMessage;
import jade.core.Agent;


public class AgentCompanion extends Agent{
	
	protected void setup() {
		
		addBehaviour(new BehaviourReceiverMessage(this));
		//addBehaviour(new BehaviourReplyMessage(this, "hue"));
	}

}
