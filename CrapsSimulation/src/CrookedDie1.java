
public class CrookedDie1 extends Die
{
	public CrookedDie1()
	{
		CrapsGame.println("  CrookedDie1's constructor called.");
		
	}

	public int getLastRoll() // this OVERRIDES Die's getLastRoll(), replacing
								// it!
	{
		return 3;
	}

	public String toString() // this OVERRIDES Die's toString()
	{
		return "A CrookedDie1 always rolling 3, and... " + super.toString();
	}
	
	public static CrookedDie1 testStatic() {
		
		//Only implemented to test if static methods can be overridden
		return new CrookedDie1();		
	}

}
