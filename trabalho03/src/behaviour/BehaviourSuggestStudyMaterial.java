package behaviour;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class BehaviourSuggestStudyMaterial extends OneShotBehaviour{
	
	private String performance;
	
	public BehaviourSuggestStudyMaterial(Agent agent, String performance) {
		super(agent);
		this.performance = performance;
	}
	
	
	@Override
	public void action() {
		String studantPerfomance = menagePerfomance(this.performance);
		System.out.println("Baseado no seu desempenho até o momento na disciplina de Desenho:");
		System.out.println("Sugiro:" + studantPerfomance);

	}

	private String menagePerfomance(String performanceStatus) {
		
		switch (performanceStatus) {
		case "Bom":
			return "Manter a rotina de estudos";
			
		//não sei o que sugerir
		case "Medio":
			return "Reforçar estudos com o alguma coisa";
		//não sei o que sugerir
		case "Ruim":
			return "Faz a disciplina de novo";
		//não sei o que sugerir
		default:
			return "Você não precisa estudar, vá jogar"; 
		}
	}
	
}
