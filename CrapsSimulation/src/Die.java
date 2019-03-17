
public class Die
{
	protected int lastRoll;

	public Die()
	{
		//this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}
	
	public void setLastRoll(int r) // setter method
	{

		this.lastRoll = r;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
	
	public static Die testStatic() {
	
		//Only implemented to test if static methods can be overridden
		return new Die();		
	}
	
	

}
