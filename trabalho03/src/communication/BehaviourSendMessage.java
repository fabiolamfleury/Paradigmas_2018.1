package communication;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourSendMessage extends OneShotBehaviour{
	
	public static final String AGENTSTUDENT= "agentStudent";
	public static final String AGENTCOMPANION ="companion";
	private String messageContent;
	private String receiver;
	public  BehaviourSendMessage(Agent agent, String messageContent, String receiver) {
		super(agent);
		this.messageContent = messageContent;
		this.receiver = receiver;
	}
	
	
	@Override
	public void action() {
		
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		message.addReceiver(new AID(this.receiver, AID.ISLOCALNAME));
		message.setLanguage("Português");
		message.setOntology("FeedBack");
		message.setContent(this.messageContent);
		myAgent.send(message);
	
	}
}
