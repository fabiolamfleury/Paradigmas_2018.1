package communication;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourReceiverMessage extends CyclicBehaviour {
	private static final long serialVersionUID = 7768217846531384442L;

	public BehaviourReceiverMessage(Agent agent) {
		super(agent);

	}

	public void action() {
		ACLMessage message = super.getAgent().receive();
		if (message != null) {			
			String messageContent = message.getContent();
			System.out.println(messageContent);
			System.out.println("deu bom");
			super.getAgent().removeBehaviour(this);
		}else {
			block(10);
		}

	}
}
