package denis.ansah.POJO;

import java.util.concurrent.ThreadLocalRandom; 


public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int i = 0; i < 100; i++) { System.out.println(new Date().getTime()); }
		for(int i = 0; i < 100; i++) { 
//			long max = new Date().getTime();
	        int d = ThreadLocalRandom.current().nextInt(); 
	        d = Math.abs(d);
			System.out.println(d); 
		}
		
	}

}
