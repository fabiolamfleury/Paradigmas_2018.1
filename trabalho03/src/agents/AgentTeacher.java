package agents;

import behaviour.BehaviourMessage;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentTeacher extends Agent{
	
	
	protected void setup() {
		System.out.println("Eu sou o agente professor");
		addBehaviour(new BehaviourMessage(this,"huehue"));

	}
	
}