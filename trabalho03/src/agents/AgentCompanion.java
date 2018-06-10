package agents;

import behaviour.BehaviourReceiverMessage;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


public class AgentCompanion extends Agent{
	
	protected void setup() {
		addBehaviour(new BehaviourReceiverMessage(this)) ;	
	
	}

}
