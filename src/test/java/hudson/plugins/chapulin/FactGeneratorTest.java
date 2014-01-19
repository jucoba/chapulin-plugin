package hudson.plugins.chapulin;

import hudson.model.Result;
import junit.framework.TestCase;

public class FactGeneratorTest extends TestCase {

	private FactGenerator generator;

	public void setUp() {
		generator = new FactGenerator();
	}

	public void testRandomFailingResultGivesAtLeast2Facts() {
		String lastFact = null;
		for (int i = 0; i < 1000000; i++) {
			String currFact = generator.getRandomFact(Result.FAILURE).getMessage();
			if (lastFact != null && !lastFact.equals(currFact)) {
				return;
			}
			lastFact = currFact;
		}
		fail("Random should give at least 2 different facts in 1000000 tries.");
	}
	
	public void testRandomPositiveResultGivesAtLeast2Facts() {
		String lastFact = null;
		for (int i = 0; i < 1000000; i++) {
			String currFact = generator.getRandomFact(Result.SUCCESS).getMessage();
			if (lastFact != null && !lastFact.equals(currFact)) {
				return;
			}
			lastFact = currFact;
		}
		fail("Random should give at least 2 different facts in 1000000 tries.");
	}
	
	public void testGenerarFraseConBuildBuenoDebeDarUnaFrasePositiva() {
		Result result = Result.SUCCESS;
		
		Fact fact = generator.getRandomFact(result);
		assertTrue("The Fact is not PositiveFact", fact instanceof PositiveFact);
	}
	
	public void testGenerarFraseConBuildFallidoDebeDarUnaFraseNegativa() {
		Result result = Result.FAILURE;
		
		Fact fact = generator.getRandomFact(result);
		assertTrue("The Fact is not PositiveFact", fact instanceof NegativeFact);
	}
	
	public void testFactPositivoDebeRetornarUnMensaje()
	{
		Fact fact = new PositiveFact();
		assertTrue("El fact positivo no retornó ningún hecho",fact.getMessage() != "");
	}
	
	public void testFactNegativoDebeRetornarUnMensaje()
	{
		Fact fact = new PositiveFact();
		assertTrue("El fact positivo no retornó ningún hecho",fact.getMessage() != "");
	}
	
	
}
