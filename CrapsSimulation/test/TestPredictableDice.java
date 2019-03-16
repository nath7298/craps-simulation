import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPredictableDice
{
	private PredictableDice pd;
	private PredictableDie d1;
	private PredictableDie d2;
	
	@Before
	public void setup() {
		//Make our pair of dies (dice) that we are going to use
		d1 = new PredictableDie();
		d2 = new PredictableDie();
		pd = new PredictableDice(d1,d2);
	}
	
	@Test
	public void test_predictable_die_one_value()
	{
		//Set throw sequence of the pair
		pd.setThrowSequence(new int[] {1,2,3},new int[] {4,5,6});
		pd.roll();
		assertEquals(5,pd.getLastRoll());
	}
	
	@Test
	public void test_predictable_die_two_rolls()
	{
		pd.setThrowSequence(new int[] {1,2,3},new int[] {4,5,6});
		pd.roll();
		pd.roll();
		assertEquals(7,pd.getLastRoll());
	}
	
	@Test
	public void test_predictable_die_1_values_wraparound()
	{
		pd.setThrowSequence(new int[] {1,2,3},new int[] {4,5,6});
		pd.roll(); //roll roll your roll die
		pd.roll();
		pd.roll();
		pd.roll();
		assertEquals(5,pd.getLastRoll());
	}
	
	@Test(expected=RuntimeException.class) //We should get an exception with an empty array
	public void test_predictable_die_empty_array()
	{
		pd.setThrowSequence(new int[] {},new int[] {});
		pd.roll(); 
	}
	
	@Test(expected=RuntimeException.class) //We should get an exception with an empty array
	public void test_predictable_die_null()
	{
		pd.setThrowSequence(null,null);
		pd.roll(); 
	}
	
}
