package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class CheckStudentProgressBehaviour extends OneShotBehaviour{

	/**
	 * 
	 */
	private AID[] companions;
	
	private static final long serialVersionUID = -4956502801288020171L;
	
	public CheckStudentProgressBehaviour(Agent a, AID[] companions) {
		super(a);
		this.companions = companions;
	}
	
	@Override
	public void action() {
		for (AID aid : companions) {
			ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
			message.addReceiver(aid);
			message.setLanguage("Português");
			message.setOntology("Acompanhamento");
			String mensagem = "Como andam os estudos do estudante que você está acompanhando?";
			System.out.println(myAgent.getName() + ": \t enviando mensagem para acompanhar estudante para o companion: " + aid);
			message.setContent(mensagem);
			myAgent.send(message);	
		}	
	}

}
