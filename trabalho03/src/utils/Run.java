package utils;

import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.leap.Properties;
import agents.AgentCompanion;
import agents.AgentStudent;
import agents.AgentTeacher;

public class Run {
	public static void main(String[] args) {
	    Properties pp = new Properties();
	    pp.setProperty(Profile.GUI, Boolean.TRUE.toString());
	    Profile p = new ProfileImpl(pp);
	    AgentContainer ac = jade.core.Runtime.instance().createMainContainer(p);
	    try {
	        ac.acceptNewAgent("Alberto", new AgentStudent("130000001")).start();
	        ac.acceptNewAgent("Joana", new AgentStudent("1200000001")).start();
	        ac.acceptNewAgent("ProfessorAfonso", new AgentTeacher("Desenho")).start();
	    } catch (StaleProxyException e) {
	        throw new Error(e);
	    }
	}
}
