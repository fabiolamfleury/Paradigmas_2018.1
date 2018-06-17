package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class CheckStudentProgressBehaviour extends CyclicBehaviour{

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
		// TODO Auto-generated method stub
		
	}

}
