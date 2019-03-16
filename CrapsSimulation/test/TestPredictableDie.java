import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPredictableDie
{
	private PredictableDie pd;
	
	@Before
	public void setup() {
		//Make our die that we are going to use
		pd = new PredictableDie();
	}
	
	@Test
	public void test_predictable_die_one_value()
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		assertEquals(1,pd.getLastRoll());
	}
	
	@Test
	public void test_predictable_die_two_rolls()
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		pd.roll();
		assertEquals(2,pd.getLastRoll());
	}
	
	@Test
	public void test_predictable_die_1_values_wraparound()
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll(); //roll roll your roll die
		pd.roll();
		pd.roll();
		pd.roll();
		assertEquals(1,pd.getLastRoll());
	}
	
	@Test(expected=RuntimeException.class) //We should get an exception with an empty array
	public void test_predictable_die_empty_array()
	{
		pd.setThrowSequence(new int[] {});
		pd.roll(); 
	}
	
	@Test(expected=RuntimeException.class) //We should get an exception with an empty array
	public void test_predictable_die_null()
	{
		pd.setThrowSequence(null);
		pd.roll(); 
	}
	
	public void test_predictable_die_10_rolls()
	{
		int count = 10;
		int arr[] = new int[count]; //initialize to size of count
		
		assertEquals(10,count);
		
		for (int i=0;i<count;i++) {
			arr[i] = i; //set to next increment
		}
		
		assert(true);
			
		pd.setThrowSequence(arr);
		
		for (int i=0;i<count;i++) {	
			pd.roll();
			assertEquals(i,pd.getLastRoll());
		}		
	}
}
