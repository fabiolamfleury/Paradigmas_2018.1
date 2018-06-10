package agents;

import behaviour.BehaviourSuggestStudyMaterial;
import jade.core.Agent;

public class AgentStudent extends Agent{
	
	protected void setup() {
		
		System.out.println("Eu sou o agente do aluno Vai dar não ");
		
		addBehaviour(new BehaviourSuggestStudyMaterial(this,"Ruim"));
	
	}
}
