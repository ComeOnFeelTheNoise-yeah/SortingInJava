package Sort;

//버블 정렬의 Java 코드

import java.io.*;

class BubbleSort {
	
	// 버블 정렬의 최적화된 버전
	static void bubbleSort(int arr[], int n)
	{
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					
					// arr[j]와 arr[j+1]을 바꿉니다.
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// 두 개의 요소가 없는 경우
			// 내부 루프에 의해 교체된 후 중단
			if (swapped == false)
				break;
		}
	}

	// 배열을 출력하는 함수
	static void printArray(int arr[], int size)
	{
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// main문
	public static void main(String args[])
	{
		BubbleSort bs = new BubbleSort();
		int arr[] = { 7, 3, 5, 2, 6, 1, 4 };
		int n = arr.length;
		//초기 배열을 출력
		System.out.print("Bubble Sort 전 : ");
		printArray(arr, n);
		
		//정렬 함수 실행
		bubbleSort(arr, n);
		
		//정렬 함수 결과 출력
		System.out.print("Bubble Sort 후 : ");
		printArray(arr, n);
	}
}

/* 출력 결과
 * Bubble Sort 전 : 7 3 5 2 6 1 4
 * Bubble Sort 후 : 1 2 3 4 5 6 7 
 *
*/

