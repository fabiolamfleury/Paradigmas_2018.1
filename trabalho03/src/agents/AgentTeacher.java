package agents;

import behaviour.BehaviourMessage;
import jade.core.Agent;

public class AgentTeacher extends Agent{
	
	
	protected void setup() {
		System.out.println("Eu sou o agente professor");
		addBehaviour(new BehaviourMessage(this, "teste"));
	
	
	}

	
}
