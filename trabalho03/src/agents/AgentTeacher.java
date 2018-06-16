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
	

	class meetingCompanions extends OneShotBehaviour { 
	
		private static final long serialVersionUID = 7268217846531384442L;
		
		private int n = 0; 
		
		// Construtor do behaviour. Necessário, pois passamos parâmetro. 
		public meetingCompanions(Agent a) { 
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
	            System.out.println(result.length-1 + " results" );

				AID[] agents = new AID[result.length];
	            for (int i=0; i<result.length-1; i++) {
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
		
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentCompanion"); 
		register(sd);
		
		meetingCompanions mC = new meetingCompanions(this); 
		addBehaviour(mC);
		
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
