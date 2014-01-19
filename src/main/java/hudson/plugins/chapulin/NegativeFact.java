package hudson.plugins.chapulin;

import java.util.Random;

public class NegativeFact implements Fact {
	private static final Random RANDOM = new Random();

	 private static final String[] FACTS = {         
         "Calma, Calma, que no panda el cúnico",         
         "Silencio, mis antenitas de vinil están detectando la presencia del enemigo",
         "Oh y ahora, quien podrá defendernos ? ... Yo !!.  El Chapulin Colorado"
         };
	
	@Override
	public String getMessage() {
		return FACTS[RANDOM.nextInt(FACTS.length)];
	}

}
