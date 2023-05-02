
public class rearranger {

	public static void main(String[] args) {
		int[] arr = {0,1,1,0,1,2,1,2,0,0,0,1};
		int base = 0;
		for(int xx = 0; xx<arr.length;xx++) {
		for(int x = 0; x<arr.length-1;x++) {
			if(arr[x]>arr[x+1]) {
				base = arr[x];
				arr[x] = arr[x+1];
				arr[x+1] = base;
			}
		}
	}
		for(int xxx = 0; xxx<arr.length; xxx++) {
			System.out.print(arr[xxx]);
		}

}
}
