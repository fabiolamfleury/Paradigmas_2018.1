package behaviours;

import agents.AgentStudent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessageBehaviour extends OneShotBehaviour{
	private String content;
		public SendMessageBehaviour(AgentStudent a, String content) {
			super(a);
			this.content = content;
		}
		private static final long serialVersionUID = 1L;

		@Override
		public void action() {
			
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			message.addReceiver(((AgentStudent) myAgent).getCompanion());
			message.setLanguage("Português");
			message.setOntology("FeedBack");
			message.setContent(content);
			myAgent.send(message);	

		}
}
