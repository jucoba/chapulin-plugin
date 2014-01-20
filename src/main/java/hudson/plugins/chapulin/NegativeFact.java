package hudson.plugins.chapulin;

import java.util.Random;

public class NegativeFact implements Fact {
	private static final Random RANDOM = new Random();

	 private static final String[] FACTS = {         
         "Calma, Calma, que no panda el cúnico",         
         "Silencio, Silencio... mis antenitas de vinil están detectando la presencia del enemigo",
         "!Oh! y ahora. Quien podrá ayudarnos ? ... Yoooo!!.  El Chapulin Colorado",
         "Lo hice intencionalmente para comprobar la capacidad de reacción del equipo",
         "Se aprovechan de mi nobleza",
         "Lo sospeché desde un principio",
         "Sí lo arreglo; sí lo arreglo; sí lo arreglo... (¡¡¡Pero ya!!!)",
         "¡Chanfle!, ¡¡Rechanfle!!, ¡¡¡Recontrachanfle!!!",
         "Lo que no tienes de menso, lo tienes de burro",
         "Un error lo comete cualquiera... Quinientos errores los comete cualquiera",
         "¡Me vas a destrozar mi build!"
         };
	
	@Override
	public String getMessage() {
		return FACTS[RANDOM.nextInt(FACTS.length)];
	}

}
