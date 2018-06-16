package agents;

import java.beans.FeatureDescriptor;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
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
			
			@Override
			public void action() {
				ACLMessage message = myAgent.receive();
				if (message != null) {			
					ACLMessage reply = message.createReply();
					String messageContent = message.getContent();
						if(messageContent.toLowerCase().contains("primeira")) {
							
							System.out.println(messageContent);
							String replyMessage = analyseFirstEvaluation(messageContent);
							
							reply.setPerformative(ACLMessage.INFORM);

							reply.setContent(replyMessage);
							myAgent.send(reply);
							super.getAgent().removeBehaviour(this);
						}
				}else {
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
    	int note = getNote(message);
    	String feedback = null;
    	if(note==0) {
    		 feedback = "Reforçar os estudos com realização de exercicios na plataforma \n" +
    						  "Comparecer na monitoria 2 vezes por semana \n" + 
    					      "Revisar o conteudo do moodle e aplicar os padrões em um trabalho a parte do da disciplina\n"+
    						  "Acompanhamento semana com o professor 1 vez por semana";
 
    	}else if(note>3 && note<5) {
    		 feedback = "Reforçar os estudos com realização de exercicios na plataforma \n" +
					  "Comparecer na monitoria 2 vezes por semana \n" + 
		              "Acompanhamento semana com o professor 1 vez por semana";
    	}else if(note> 5 && note<7) {
    		 feedback ="Reforçar os estudos dos padrões grasps\n"+ 
    					"Reforçar os estudos respondendo as questões da plataforma";
    	}else if(note>7 && note <9) {
    		feedback= "Reforçar os estudos com questões da plataforma";
    	}else {
    		feedback = "Manter a rotina de estudos";
    	}

    	return feedback;
    }
    
    
    private int getNote(String message) {
    	String [] split = message.split(" ");
    	int note = Integer.parseInt(split[3]);
    	System.out.println("aaaaaaaaaaaaa"+ note);
    	return note;
    }
}
