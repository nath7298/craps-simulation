//import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable PredictableDie objects, summing the value of the predefined rolls
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author Chris Nathan
 *
 */
 
public class PredictableDice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private PredictableDie die1;
	private PredictableDie die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public PredictableDice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new PredictableDie();
		this.die2 = new PredictableDie();
		//this.roll(); //commenting this out to mirror intialization behavior of die class
	}
	
	protected void setThrowSequence(int[] sequence1, int[] sequence2) {
		this.die1.setThrowSequence(sequence1);
		this.die2.setThrowSequence(sequence2);
	}


	public PredictableDice(PredictableDie die1, PredictableDie die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();

	}

	// static methods can go anywhere - but at end is standard

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		PredictableDice dice1 = new PredictableDice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice1.roll();
			StdOut.println(dice1);
			
			if (dice1.getLastRoll() == 2)
				doubleSkunkCount++;
		}

		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
}
