package agents;

import behaviour.BehaviourMessage;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.introspection.ACLMessage;

public class AgentTeacher extends Agent{
	
	
	protected void setup() {
		System.out.println("Eu sou o agente professor");
		addBehaviour(new BehaviourMessage(this, "teste"));
	
	
	}

	
}
