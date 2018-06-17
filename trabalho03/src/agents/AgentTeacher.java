package agents;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class AgentTeacher extends Agent{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3039621223253454417L;
	
	class meetAllCompanionsBehaviour extends OneShotBehaviour { 
		
		private static final long serialVersionUID = 7268217846531384442L;
		
		private int n = 0; 
		
		// Construtor do behaviour. Necessário, pois passamos parâmetro. 
		public meetAllCompanionsBehaviour(Agent a) { 
			super(a); 
		}

		// Método action, obrigatório para comportamentos cíclicos.
		public void action() {
	        DFAgentDescription dfd = new DFAgentDescription();
	        ServiceDescription sd  = new ServiceDescription();
	        sd.setType("AgentCompanion");
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
			} catch (FIPAException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

		}
		
	} 
	
	protected void setup() {		
		System.out.println("Eu sou um professor, e preciso conhecer os Companions dos alunos da minha turma");
		meetAllCompanionsBehaviour mCB = new meetAllCompanionsBehaviour(this); 
		addBehaviour(mCB);
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentTeacher"); 
		register(sd);
	} 
	
    void register( ServiceDescription sd)
    {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        dfd.addServices(sd);

        try {  
            DFService.register(this, dfd );  
        }
        catch (FIPAException fe) { fe.printStackTrace(); }
    }
}
