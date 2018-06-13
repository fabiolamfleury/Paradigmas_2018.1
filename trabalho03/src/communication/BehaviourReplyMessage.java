package communication;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourReplyMessage extends OneShotBehaviour{
	
	private String reply;
	public BehaviourReplyMessage(Agent agent,String reply) {
		
		super(agent);
		this.reply = reply;
	
	}

	@Override
	public void action() {
		ACLMessage message = myAgent.receive();
		String content = message.getContent();
		ACLMessage reply = message.createReply();
		System.out.println(content);
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(this.reply);
		
		myAgent.send(reply);
	}

}
