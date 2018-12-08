package Sort;
/**
 * 
 * @author 英莉莉
 * 2018 12 05
 */
public class Sort {
	//归并排序,时间复杂度稳定为nlogn(无论好坏),空间复杂度为n。
	private void merge_sort(int[] a, int low, int middle, int high) {
		int i, k;
		int[] temp = new int[high - low + 1];
		int left_low = low;
		int left_high = middle;
		int right_low = middle + 1;
		int right_high = high;
		for(k = 0; left_low <= left_high && right_low <= right_high; k++) {
			if(a[left_low] <= a[right_low]) {
				temp[k] = a[left_low++];
			}else temp[k] = a[right_low++];
		}
		//判断哪一边多余了，多余的直接加入到数组里面
		if(left_low <= left_high) {
			for(i = left_low; i <= left_high; i++) {
				temp[k++] = a[i];
			}
		}
		if(right_low <= right_high) {
			for(i = right_low; i <= right_high; i++) {
				temp[k++] = a[i];
			}
		}
		for(i = 0; i < high - low + 1; i++) {
			a[low + i] = temp[i];
		} 
	}
	private void mergeSort(int[] a, int first, int last) {
		int mid = 0;
		if(last > first) {
			mid = (last + first)/2;
			mergeSort(a, mid + 1, last);
			mergeSort(a, first, mid);
			merge_sort(a, first, mid, last);
		}
	}
	//插入排序 时间复杂度平均为n2，最好为n，空间复杂度为1
	private void InsertSort(int[] a) {
		int preIndex, current;
		for(int i = 0; i < a.length; i++) {
			preIndex = i - 1;
			current = a[i];//存储下一个元素，来进行扫描
			//直到数组的尽头，或则是遇到了比它小的数
			while(preIndex >= 0 && a[preIndex] > current) {
				a[preIndex + 1] = a[preIndex];
				preIndex--;
			}
			a[preIndex + 1] = current;
		}
	}
	//快速排序
	public static void quickSort(int[] a, int p, int q) {
		/**
		 * i，j为两个下标指针
		 * i从左向右扫描直到遇到比基准值大的数
		 * j从右向左遍历直到遇到比基准值小的数
		 */
		int i = p;
		int j = q;
		int temp = a[p]; //基准值
		while( i < j) {
			while(a[j] >= temp && j > i ) j--;//跳过比基准值大的数向左扫描
			//遇到了比基准值小的数 将其与指针i指向的数交换
			if(j > i) {
				a[i] = a[j];
				i++;
				while(a[i] <= temp && i < j ) i++;//跳过大于基准值的数
				if( i < j ) {
					a[j] = a[i];
					j--;
				}
			}
		}
		a[i] = temp;
		//已经分为了两个部分，对两个部分在此进行排序
		//因为此时i=j且a[i] = a[j] = temp
 		if( p < (i - 1)) quickSort(a, p, i - 1);
		if((j+1) < q) quickSort(a, j+1, q);
	}
	public static void main(String[] args) {
		int[] a = {1 , 4, 7, 2, 10 ,20, 11, 27};
		Sort s = new Sort();
		//s.mergeSort(a, 0, a.length - 1);
		//s.InsertSort(a);
		quickSort(a, 0, a.length-1);
		for(int i : a)
		{
			System.out.println(i);
		}
	}
}
