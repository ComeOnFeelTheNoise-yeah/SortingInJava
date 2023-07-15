package Sort;

/* 이 코드가 버블 정렬의 최적화된 버전인 이유

   일반 버블 정렬 : 매 반복마다 인접한 
   두 요소를 비교하고 필요한 경우 교환하는 과정을 반복
   
   최적화된 버블 정렬 : 한 번의 완전한 반복을 
   수행할 때마다 가장 큰 요소가 배열의 마지막으로 이동
   
   이해 안되면 코드 ㄱㄱ
   */

/* 참고 ! BubbleSort의 코드 내의 static 으로 선언된 부분은
   객체를 생성하지 않고 직접 호출 하기 위함 !
   BunleSort 객체의 상태를 변경하지 않고 매개변수로 전달된 배열을 정렬하는
   기능만을 수행하므로, 객체의 인스턴트에 의존하지 않는 static 메소드로 정의
   되는 것을 선택  
 */

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
					
					// arr[j]와 arr[j+1]을 바꿈
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

