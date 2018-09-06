import java.util.Arrays;
import java.util.Random;

public class BinarySearchTree {
	
	public static void swap(int [] a, int i, int j) {
		int k=a[j];
		a[j]=a[i];
		a[i]=k;
	}

	public static void sort(int[] a) {
		for(int i=0;i<a.length-1;++i)
			for(int j=i+1;j<a.length;++j)
				if(a[i]>a[j])
					swap(a,i,j);
	}

	public static int search1(int[] a,int value) {
		for(int i=0;i<a.length;++i) {
			if(a[i]==value)
				return i;
		}
		return -1;
	}
	
	public static int search2(int[] a,int value) {
		int start=0;
		int end=a.length-1;
		while(start<=end) {
			int middle=(start+end)/2;
			if(a[middle]<value) {
				start=middle+1;
			}
			else if(a[middle]>value) {
				end=middle-1;
			}
			else
				return middle;
		}
		return -1;
	}
	
	public static int search3(int[] a,int value) {
		return search3(a,value,0,a.length-1);
	}
	
	public static int search3(int a[],int value,int start,int end) {
		while(start<=end) {
			int middle=(start+end)/2;
			if(a[middle]<value) {
				return search3(a,value,middle+1,end);
			}
			else if(a[middle]>value) {
				return search3(a,value,start,middle-1);
			}
			else
				return middle;
		}
		return -1;
	}
	public static void main(String[] args) {
		Random random=new Random();
		int[] a=new int[10];
		for(int i=0;i<a.length;++i) {
			a[i]=random.nextInt(20);
		}
		sort(a);
		System.out.println(Arrays.toString(a));
		
		for(int i=0;i<30;++i) {
			int value=random.nextInt(20);
			int v1=search1(a,value);
			int v2=search2(a,value);
			int v3=search3(a,value);
			if((v1==-1 && v2==-1 && v3==-1) || (value==a[v1] && value==a[v2] && value==a[v3])) {
				System.out.println("OK:"+value+" "+"v1="+v1+" "+"v2="+v2+" "+"v3="+v3);
			}
			else {
				System.out.println("Error:"+value+" "+"v1="+v1+" "+"v2="+v2+" "+"v3="+v3);
			}
			System.out.println("done");
		}
	}

}
