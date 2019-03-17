import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInheritance
{

	@Test
	void test_crookeddie1_inheritance()
	{
		//A crookedDie1 always returns a 3
		Die myDie = new CrookedDie1();
		assertEquals(3,myDie.getLastRoll());
	}
	
	@Test
	void test_crookeddie2_inheritance()
	{
		//A crookedDie2 allows for assigning a roll
		Die myDie = new CrookedDie2(); 
		myDie.setLastRoll(4);
		assertEquals(4,myDie.getLastRoll());
	}
	
	@Test
	void test_crookeddie2_inheritance_increment()
	{
		//A crookedDie2 always increments
		Die myDie = new CrookedDie2();
		myDie.setLastRoll(4);
		myDie.roll();
		assertEquals(5,myDie.getLastRoll());
	}
	
	@Test
	void test_crookeddie1_static_overriding()
	{
		//Even though we declare the object as a die. The overloaded static method will return a crooked die
		Die myDie = new CrookedDie1();
		myDie.testStatic().setLastRoll(1); //if the overloaded constructor returned a die, then the following test would fail.
		assertEquals(3,myDie.getLastRoll());
	}

}
