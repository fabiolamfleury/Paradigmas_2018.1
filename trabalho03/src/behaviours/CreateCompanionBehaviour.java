package behaviours;

import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.StaleProxyException;
import agents.AgentCompanion;
import agents.AgentStudent;
import jade.core.Agent;

public class CreateCompanionBehaviour extends OneShotBehaviour{

	private static final long serialVersionUID = -896018215576837891L;
	
	public CreateCompanionBehaviour(AgentStudent a) {
		super(a);
	}
	
	@Override
	public void action() {
		try {
			AgentCompanion studentCompanion = new AgentCompanion();
			this.getAgent().getContainerController().acceptNewAgent("Companion" + this.getAgent().getName(), 
					studentCompanion).start();
			
			((AgentStudent) this.getAgent()).setCompanion(studentCompanion.getAID());
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		
	}

}
