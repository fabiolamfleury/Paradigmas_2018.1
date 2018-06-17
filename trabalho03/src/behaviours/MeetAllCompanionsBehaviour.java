package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class MeetAllCompanionsBehaviour extends OneShotBehaviour{
		
		private static final long serialVersionUID = 7268217846531384442L;
		
		private int n = 0; 
		

		public MeetAllCompanionsBehaviour(Agent a) { 
			super(a); 
		}


		public void action() {
	        DFAgentDescription dfd = new DFAgentDescription();
	        ServiceDescription sd  = new ServiceDescription();
	        sd.setType("AgentStudent");
	        dfd.addServices(sd);
	        
	        DFAgentDescription[] result;
			SearchConstraints all = new SearchConstraints();
			all.setMaxResults(new Long(-1));
			try {
				result = DFService.search(this.getAgent(), dfd, all);
	            System.out.println(result.length + " results" );

				AID[] agents = new AID[result.length];
	            for (int i=0; i<result.length; i++) {
	                agents[i] = result[i].getName();
	                System.out.println(agents[i]);
	            }
	            
	            this.getAgent().addBehaviour(new CheckStudentProgressBehaviour(this.getAgent(), agents));
			} catch (FIPAException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

		}
		
	

}
