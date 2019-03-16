import static org.junit.Assert.*;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
		
public class TestDie
{
	private Die d;
	
	@Before
	public void setup() {
		d = new Die();
	}
	
	@Test
	public void test_die_get_zero()
	{
		//since we haven't rolled the die, should get the lastroll as 0
		assertEquals(0,d.getLastRoll());
	}
	

	@Test
	public void test_die_greaterthanZero()
	{
		d.roll();
		//test to make sure we get an integer
		assertTrue(d.getLastRoll()>0);
	}
	
	@Test
	public void test_die_lessThanSeven()
	{
		d.roll();
		//test to make sure we get an integer
		assertTrue(d.getLastRoll()<7);
	}
	
	@Test
	public void test_die_get_validvalue()
	{
		int[] validValues = new int[] {1,2,3,4,5,6};
		d.roll();
		//test to make sure we get one of the valid values
		assertTrue(IntStream.of(validValues).anyMatch(i -> i == d.getLastRoll()));
	}
	
}
