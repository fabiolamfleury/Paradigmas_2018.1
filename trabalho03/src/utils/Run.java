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
	        ac.acceptNewAgent("Companion", new AgentCompanion()).start();
	        ac.acceptNewAgent("Companion2", new AgentCompanion()).start();
	        ac.acceptNewAgent("Student1", new AgentStudent()).start();
	        ac.acceptNewAgent("Student2", new AgentStudent()).start();
	        ac.acceptNewAgent("Teacher", new AgentTeacher()).start();
	    } catch (StaleProxyException e) {
	        throw new Error(e);
	    }
	}
}
