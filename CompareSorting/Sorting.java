import java.util.Random;
import java.util.Scanner;

public class Sorting {
	SelectionSort s1;
	BubbleSort s2;
	InsertionSort s3;
	MergeSort s4;
	QuickSort s5;
	HeapSort s6;
	ShellSort s7;
	CountingSort s8;
	RadixSorting s9;
	BucketSort s10;
	Time t;

	public Sorting() {
		s1 = new SelectionSort();
		s2 = new BubbleSort();
		s3 = new InsertionSort();
		s4 = new MergeSort();
		s5 = new QuickSort();
		s6 = new HeapSort();
		s7 = new ShellSort();
		s8 = new CountingSort();
		s9 = new RadixSorting();
		s10 = new BucketSort();
		t = new Time();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Sorting sort = new Sorting();
	

		Random random = new Random(); // 랜덤 객체 생성(디폴트 시드값 : 현재시간)
		int arr[] = new int[500];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}

		boolean exit = false;
		long before;

		while (exit == false) {
			System.out.println("\n1. Selection Sort\n2. Bubble Sort\n3. Insertion Sort\n"
					+ "4. Merge Sort\n5. Quick sort\n6. Heap Sort\n7. Shell Sort\n"
					+ "8. Counting Sort\n9. Radix Sorting \n10. Bucket Sort\n11. exit\n");
			
			
			int btn = sc.nextInt();
			
			switch (btn) {
			case 1:
				System.out.print("Selection Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s1.selectionSort(arr);
				sort.s1.printArray(arr);
				sort.t.afterMs(before);
				break;
			case 2:
				System.out.print("Bubble Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s2.bubbleSort(arr, arr.length);
				sort.s2.printArray(arr, arr.length);
				sort.t.afterMs(before);
				break;
			case 3:
				System.out.print("Insertion Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s3.insertionSort(arr);
				sort.s3.printArray(arr);
				sort.t.afterMs(before);
				break;
			case 4:
				System.out.print("Merge Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s4.mergeSort(arr, 0, arr.length - 1);
				sort.s4.printArray(arr);;
				sort.t.afterMs(before);
				break;
			case 5:
				System.out.print("Quick Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s5.quickSort(arr, 0, arr.length - 1);
				sort.s5.printArr(arr);;
				sort.t.afterMs(before);
				break;
			case 6:
				System.out.print("Heap Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s6.heapSort(arr);
				sort.s6.printArray(arr);
				sort.t.afterMs(before);
				break;
			case 7:
				System.out.print("Shell Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s7.shellSort(arr);
				sort.s7.printArray(arr);
				sort.t.afterMs(before);
				break;
			case 8:
				System.out.print("Counting Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s8.countingSort(arr);
				sort.s8.printArray(arr, arr.length);
				sort.t.afterMs(before);
				break;
			case 9:
				System.out.print("Radix Sort 후 : ");
				before = sort.t.beforeMs();
				sort.s9.radixSort(arr, arr.length);
				sort.s9.print(arr, arr.length);
				sort.t.afterMs(before);
				break;
			case 10:
				System.out.print("Bucket Sort 후 : ");
				before = sort.t.beforeMs();
				
				
				float [] fArr = new float [arr.length];
				
				for(int i = 0; i < arr.length; i++) {
					//소수점으로 만들어 주기
					fArr[i] = (float)arr[i]/100;
					System.out.print(fArr[i]+ " ");
				}
				
				sort.s10.bucketSort(fArr, fArr.length);
				sort.s10.printArray(fArr);
				sort.t.afterMs(before);
				break;
			default:
				System.out.println(" 종료 ");
				exit = true;
				break;
			}
		}
	}
}
