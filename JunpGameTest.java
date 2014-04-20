import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class JunpGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testForSuccess() {
		String testFile1 = "";
		ArrayList<Integer> inputData = new ArrayList<Integer>();
		inputData.add(1);
		inputData.add(2);
		inputData.add(3);
		
		JumpGame jp = new JumpGame();
		ArrayList<Integer> r = jp.jump(inputData);
		int[] test = new int[2];
		test[0]=0;
		test[1]=1;
		int[] verify = new int[r.size()];
		int count = 0;
		for(Integer i : r){
			verify[count] = i;
			count++;
		}
		assertArrayEquals(test, verify);
	}
	
	@Test
	public void testForFailure() {
		String testFile1 = "";
		ArrayList<Integer> inputData = new ArrayList<Integer>();
		inputData.add(2);
		inputData.add(1);
		inputData.add(0);
		JumpGame jp = new JumpGame();
		ArrayList<Integer> r = jp.jump(inputData);
		int[] test = new int[1];
		test[0]=-1;
		int[] verify = new int[r.size()];
		int count = 0;
		for(Integer i : r){
			verify[count] = i;
			count++;
		}
		assertArrayEquals(test, verify);
	}
	

}
