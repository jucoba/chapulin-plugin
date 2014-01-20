package hudson.plugins.chapulin;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class CordellWalkerRecorderTest extends TestCase {

	private FactGenerator mockedFactGenerator;
	private CordellWalkerRecorder recorder;

	@Override
	public void setUp() {
		mockedFactGenerator = mock(FactGenerator.class);
		recorder = new CordellWalkerRecorder(mockedFactGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesRoundhouseAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		
		PositiveFact positiveMockedFact = mock(PositiveFact.class);
		when(positiveMockedFact.getMessage()).thenReturn("No contaban com mi astucia");
		when(mockedFactGenerator.getRandomFact(Result.SUCCESS)).thenReturn(
				positiveMockedFact);

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof RoundhouseAction);
		assertEquals(Style.THUMB_UP, ((RoundhouseAction) action).getStyle());
		assertNotNull(((RoundhouseAction) action).getFact());
	}

	public void testPerformConBuildFallidoDebeRetornarLaImagenDeBadAssYUnaFraseDeBuildFallido()
			throws Exception {
		List<Action> actions = new ArrayList<Action>();
		AbstractBuild abstractBuildMock = mock(AbstractBuild.class);
		when(abstractBuildMock.getResult()).thenReturn(Result.FAILURE);
		when(abstractBuildMock.getActions()).thenReturn(actions);

		NegativeFact negativeMockedFact = mock(NegativeFact.class);
		when(negativeMockedFact.getMessage()).thenReturn("Calma, que no panda el cúnico");
		
		when(mockedFactGenerator.getRandomFact(Result.FAILURE)).thenReturn(
				negativeMockedFact);

		assertEquals(0, actions.size());

		recorder.perform(abstractBuildMock, mock(Launcher.class),
				mock(BuildListener.class));

		assertEquals(1, actions.size());
		assertTrue(actions.get(0) instanceof RoundhouseAction);
		assertEquals(Style.BAD_ASS, ((RoundhouseAction) actions.get(0))
				.getStyle());
		assertEquals("Calma, que no panda el cúnico",
				((RoundhouseAction) actions.get(0)).getFact());
	}
}
