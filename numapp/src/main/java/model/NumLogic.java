package model;

public class NumLogic {
	public void execute(Num num) {
		String nums = num.getNumbers();
		String[] numsArr = nums.split(",");
		num.setCount(numsArr.length);
		int max,min,sum;
		max=min=sum=Integer.parseInt(numsArr[0]);
		for(int i = 1; i<numsArr.length; i++) {
			int n = Integer.parseInt(numsArr[i]);
			if(max < n) {
				max = n;
			}
			if(min > n) {
				min = n;
			}
			sum += n;
			
			num.setMaxNum(max);
			num.setMinNum(min);
			num.setSum(sum);
		}
	}
	
	/*
	public static void split(Num num) {
		String str = num.getNumbers();
		String[] data = str.split(",");
		int[] nums = new int[data.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(data[i]);
		}
		num.setNums(nums);
	}
	
	public static void count(Num num) {
		int[] nums = num.getNums();
		int count = nums.length;
		num.setCount(count);
	}
	
	public static void max(Num num) {
		int[] nums = num.getNums();
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] < nums[j]){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		num.setMaxNum(nums[0]);
	}

	public static void min(Num num) {
		int[] nums = num.getNums();
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] > nums[j]){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		num.setMinNum(nums[0]);
	}
	public static void sum(Num num) {
		int[] nums = num.getNums();
		int sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
		}
		num.setSum(sum);
	}
	*/
}
