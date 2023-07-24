package e.utils.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import e.utils.Vector2D;

/**
 * @author 1santo
 * 
 *         Class to test class Vetor2D
 *
 */

public class Vector2DTest {

	private Vector2D v1,v2,v3,v4,v5,v6;
	


	@Before
	public void setUp() throws Exception {
		v1=new Vector2D(1,1);
		v2=new Vector2D(0,0);
		v3=new Vector2D(3,5);
		v4=new Vector2D(-2,4);
		v5=v2;
		v6=new Vector2D(2,4);
		v6=null;
	}

	@Test
	public void testGetX() {
		Assert.assertNotNull(v4.getX()); 
		Assert.assertNull(v6.getX());	
	}
	
	@Test
	public void testPlus() {
		Assert.assertEquals(new Vector2D(7,6), v3.plus(v1));
		Assert.assertNull(v4);
	}
	
	@Test
	public void testMinus() {
		Assert.assertEquals(new Vector2D(884,889), v3.minus(v2));
		Assert.assertEquals(new Vector2D(2,-4), v2.minus(v4));
		Assert.assertEquals(new Vector2D(0,0), v2.minus(v5));
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("< >", v2.toString());
		Assert.assertEquals("<0,0>", v2.toString());
		Assert.assertEquals("<-2,4>", v4.toString());
	}
	

}
