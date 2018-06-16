package utils;

import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.leap.Properties;
import jade.core.Runtime;

import agents.AgentCompanion;
import agents.AgentStudent;
public class Run {
	public static void main(String[] args) {
	    Properties pp = new Properties();
	    pp.setProperty(Profile.GUI, Boolean.TRUE.toString());
	    Profile p = new ProfileImpl(pp);
	    AgentContainer ac = jade.core.Runtime.instance().createMainContainer(p);
	    try {
	        ac.acceptNewAgent("Companion", new AgentCompanion()).start();
	        ac.acceptNewAgent("Student", new AgentStudent()).start();
	    } catch (StaleProxyException e) {
	        throw new Error(e);
	    }
	}
}
