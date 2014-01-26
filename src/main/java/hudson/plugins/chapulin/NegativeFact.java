package hudson.plugins.chapulin;

import java.util.Random;

public class NegativeFact implements Fact {
	private static final Random RANDOM = new Random();

	 private static final String[] FACTS = {         
         "Calma, Calma, que no panda el c&uacute;nico",         
         "Silencio, Silencio... mis antenitas de vinil est&aacute;n detectando la presencia del enemigo",
         "!Oh! y ahora. Quien podrá ayudarnos ? ... Yoooo!!.  El Chapulin Colorado",
         "Lo hice intencionalmente para comprobar la capacidad de reacci&oacute;n del equipo",
         "Se aprovechan de mi nobleza",
         "Lo sospech&eacute; desde un principio",
         "Si lo arreglo; si lo arreglo; si lo arreglo... (¡¡¡Pero ya!!!)",
         "¡Chanfle!, ¡¡Rechanfle!!, ¡¡¡Recontrachanfle!!!",
         "Lo que no tienes de menso, lo tienes de burro",
         "Un error lo comete cualquiera... Quinientos errores los comete cualquiera"         
         };
	
	@Override
	public String getMessage() {
		return FACTS[RANDOM.nextInt(FACTS.length)];
	}

}
