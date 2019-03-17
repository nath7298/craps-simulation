import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class TestCrookedDie2
{

	@Test
	void test_crooked_die2_roll()
	{
		CrookedDie2 d = new CrookedDie2();
		d.setLastRoll(1);
		d.roll();
		//Crooked Die 2 always increments to the next integer (up to 6)
		assertEquals(2,d.getLastRoll());
	}
	
	
	@Test
	void test_crooked_die2_roll_wraparound()
	{
		CrookedDie2 d = new CrookedDie2();
		d.setLastRoll(5);
		d.roll();
		d.roll();
		//Crooked Die 2 always increments to the next integer (up to 6)
		assertEquals(1,d.getLastRoll());
	}

}
