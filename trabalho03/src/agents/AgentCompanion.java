package agents;

import communication.BehaviourSendMessage;
import jade.core.Agent;


public class AgentCompanion extends Agent{
	
	protected void setup() {

		addBehaviour(new BehaviourSendMessage(this, "FeedBack da primeira prova"));
		
	}

}
