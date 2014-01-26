package hudson.plugins.chapulin;

import java.util.Random;

public class PositiveFact implements Fact {
	
	private static final Random RANDOM = new Random();

	private static final String[] FACTS = {
        "No contaban con mi astucia",
        "Todos mis movimientos est&aacute;n fríamente calculados",        
        "El Chapulin Colorado no ha sido vencido jam&aacute;s",
        "S&iacute;ganme los buenos",
        "Es exactamente lo que iba yo a hacer",
        " ¡Eres lo m&aacute;ximo, Chapulín! "
        };
	
	@Override
	public String getMessage() {
		return FACTS[RANDOM.nextInt(FACTS.length)];
	}

}
