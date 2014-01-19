package hudson.plugins.chapulin;

import junit.framework.TestCase;

public class ChapulinActionTest extends TestCase {

	private ChapulinAction action;

	public void setUp() {
		action = new ChapulinAction(Style.BAD_ASS,
				"Calma, que no panda el cúnico");
	}

	public void testAccessors() {
		assertEquals(Style.BAD_ASS, action.getStyle());
		assertEquals("Calma, que no panda el cúnico", action
				.getFact());
		assertEquals("El Chapulin Colorado", action.getDisplayName());
		assertNull(action.getIconFileName());
		assertEquals("chapulin", action.getUrlName());
	}
}
