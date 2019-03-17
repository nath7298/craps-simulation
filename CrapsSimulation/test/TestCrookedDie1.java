import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class TestCrookedDie1
{

	@Test
	void test_crooked_die_roll()
	{
		CrookedDie1 d = new CrookedDie1();
		d.roll();
		//Crooked Die 1 always returns 3
		assertEquals(3,d.getLastRoll());
	}
	

}
