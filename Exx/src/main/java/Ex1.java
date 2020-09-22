import java.util.Arrays;
import java.util.Random;

//双色球
public class Ex1 {
	public static void main(String[] args) {
		Random ran = new Random();
		int blue = ran.nextInt(16) +1;
		System.out.println("蓝球是：" + blue);
		
		int[] reds = new int[6];
		for(int i = 0;i<reds.length;i++){
			reds[i] = ran.nextInt(33) +1;
			//确保蓝球不重复
			for(int j = 0;j<i;j++){
				if (reds[i] == reds[j]){
					i = i -1;
					break;
				}
			}
			
		}
		System.out.println("红球：" + Arrays.toString(reds));
	}
}
