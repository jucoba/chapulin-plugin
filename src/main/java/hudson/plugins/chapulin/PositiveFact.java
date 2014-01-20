package hudson.plugins.chapulin;

import java.util.Random;

public class PositiveFact implements Fact {
	
	private static final Random RANDOM = new Random();

	private static final String[] FACTS = {
        "No contaban con mi astucia",
        "Todos mis movimientos están fríamente calculados",        
        "El Chapulin Colorado no ha sido vencido jamás",
        "Síganme los buenos",
        "Es exactamente lo que iba yo a hacer",
        " ¡Eres lo máximo, Chapulín! "
        };
	
	@Override
	public String getMessage() {
		return FACTS[RANDOM.nextInt(FACTS.length)];
	}

}
