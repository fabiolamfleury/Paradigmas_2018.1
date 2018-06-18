package agents;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class AgentCompanion extends Agent{
	
	private static final long serialVersionUID = -587032368657425161L;

	protected void setup() {
		ServiceDescription sd = new ServiceDescription(); 
		sd.setName(getName()); 
		sd.setType("AgentCompanion"); 
		register(sd);
		
		addBehaviour(new CyclicBehaviour(this) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage message = myAgent.receive();
				
				if (message != null) {
					ACLMessage reply = message.createReply();
					String messageContent = message.getContent();
					if(message.getPerformative() == ACLMessage.INFORM) {						
							System.out.println(getName() + ": \t" + messageContent);
							String replyMessage = analyseFirstEvaluation(messageContent);
							
							reply.setPerformative(ACLMessage.INFORM);

							reply.setContent(replyMessage);
							myAgent.send(reply);
					}
					else if (message.getPerformative() == ACLMessage.REQUEST) {
						reply.setPerformative(ACLMessage.INFORM);
						reply.setContent("O estudante tem ido as monitorias e estudados os conteúdos propostos de reforço.");
						myAgent.send(reply);
					}
				} else {
					block();
				}
				
			}
		});	
				
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
    
    
    private String analyseFirstEvaluation(String message) {
    	double note = getNote(message);
    	String feedback = null;
    	if(note==0) {
    		 feedback = "Reforçar os estudos com realização de exercicios na plataforma \n" +
    						  "\t\tComparecer na monitoria 2 vezes por semana \n" + 
    					      "\t\tRevisar o conteudo do moodle e aplicar os padrões em um trabalho a parte do da disciplina\n"+
    						  "\t\tAcompanhamento semana com o professor 1 vez por semana";
    		 System.out.println(getName() + ": \t" + feedback);
    	}else if(note>0 && note<5) {
    		 feedback = "Reforçar os estudos com realização de exercicios na plataforma \n" +
					  "\t\tComparecer na monitoria 2 vezes por semana \n" + 
		              "\t\tAcompanhamento semana com o professor 1 vez por semana";
    		 System.out.println(getName() + ": \t" + feedback);
    	}else if(note>=5 && note<7) {
    		 feedback ="Comparecer na monitoria 2 vezes por semana \n"+ 
    					"\t\tReforÃ§ar os estudos respondendo as questões da plataforma";
    	}else if(note>=7 && note <9) {
    		feedback= "Reforçar os estudos com questÃµes da plataforma";
    		System.out.println(getName() + ": \t" + feedback);
    	}else {
    		feedback = "Manter a rotina de estudos";
    		System.out.println(getName() + ": \t" + feedback);
    	}
    		
    	return feedback;
    }
    
    private double getNote(String message) {
    	String [] split = message.split(" ");
    	double note = Double.parseDouble(split[3]);
    	return note;
    }
}
