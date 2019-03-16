import static org.junit.Assert.*;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
		
public class TestDice
{
	private Dice d;
	
	@Before
	public void setup() {
		d = new Dice();
	}
	
	@Test
	public void test_dice_get_zero()
	{
		//since we haven't rolled the dice, should get the lastroll as 0
		assertEquals(0,d.getLastRoll());
	}
	

	@Test
	public void test_dice_greaterthanZero()
	{
		d.roll();
		//test to make sure a value greater than 0
		assertTrue(d.getLastRoll()>0);
	}
	
	@Test
	public void test_dice_lessThanSeven()
	{
		d.roll();
		//test to make sure a value less than 13
		assertTrue(d.getLastRoll()<13);
	}
	
	@Test
	public void test_dice_get_validvalue()
	{
		int[] validValues = new int[] {2,3,4,5,6,7,8,9,10,11,12};
		d.roll();
		//test to make sure we get one of the valid values
		assertTrue(IntStream.of(validValues).anyMatch(i -> i == d.getLastRoll()));
	}
	
}
