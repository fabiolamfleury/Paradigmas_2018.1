package communication;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BehaviourMeetAllCompanions extends OneShotBehaviour { 
	
	private static final long serialVersionUID = 7268217846531384442L;
	
	private int n = 0; 
	
	// Construtor do behaviour. Necessário, pois passamos parâmetro. 
	public BehaviourMeetAllCompanions(Agent a) { 
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