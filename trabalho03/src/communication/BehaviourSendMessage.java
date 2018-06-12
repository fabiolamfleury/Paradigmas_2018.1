package communication;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourSendMessage extends OneShotBehaviour{

	private String messageContent;
	
	public  BehaviourSendMessage(Agent agent, String messageContent) {
		super(agent);
		this.messageContent = messageContent;
	}
	
	
	@Override
	public void action() {
		
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.addReceiver(new AID("AgentStudent", AID.ISLOCALNAME));
		message.setLanguage("Português");
		message.setOntology("FeedBack");
		message.setContent(this.messageContent);
		myAgent.send(message);
	
	}
}
