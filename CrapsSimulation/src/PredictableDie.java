
/**
 * Predictable die is inherited from Die. It allows for a user to pre-define a sequence of roll values
 * so testing can be done on the Die class to confirm proper behavior without getting random roll values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author Chris Nathan
 *
 */

public class PredictableDie extends Die
{
	private int[] throwSequence = {};
	private int nextInSequence = 0;
	
	public PredictableDie(int[] sequence) {
		if (sequence==null || sequence.length==0) {
			throw new RuntimeException();
		}
		this.throwSequence = sequence;		
	}
	
	public PredictableDie() { 
		this.throwSequence = null;
	}
	
	public void roll() {
		
		if (throwSequence == null) {
			throw new RuntimeException("null initializer");
		}
			
		if (nextInSequence==throwSequence.length) {
			nextInSequence = 0;
		}
		lastRoll = throwSequence[nextInSequence];
		nextInSequence++;
	}
	
	protected void setThrowSequence(int[] sequence) {
		this.throwSequence = sequence;
		nextInSequence =0; //need to reset this each time a new throw sequence is defined
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
