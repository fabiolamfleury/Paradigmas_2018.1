package behaviour;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourMessage extends OneShotBehaviour{

	private String messageContent;
	
	public  BehaviourMessage(Agent agent,String messageContent) {
		super(agent);
		this.messageContent = messageContent;
	
	}
	@Override
	public void action() {
		
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.addReceiver(new AID("estudante",AID.ISLOCALNAME));
		message.setLanguage("Português");
		message.setOntology("teste");
		message.setContent(this.messageContent);
		myAgent.send(message);
	
	}

}
