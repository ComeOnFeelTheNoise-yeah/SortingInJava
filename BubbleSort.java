package Sort;

/* 이 코드가 버블 정렬의 최적화된 버전인 이유

   일반 버블 정렬 : 매 반복마다 인접한 
   두 요소를 비교하고 필요한 경우 교환하는 과정을 반복
   
   최적화된 버블 정렬 : 한 번의 완전한 반복을 
   수행할 때마다 가장 큰 요소가 배열의 마지막으로 이동
   
   */

/* 참고 ! BubbleSort의 코드 내의 method들이 static 으로 선언됨
   객체를 생성하지 않고 직접 호출 하기 위함 !
   
   BubbleSort 객체의 상태를 변경하지 않고 매개변수로 전달된 배열을 정렬하는
   기능만을 수행하므로, 객체의 인스턴트에 의존하지 않는 static 메소드로 정의
   되는 것을 선택  
   ->
   멤버 변수에 접근하거나 수정하는 것이 없음
   따라서 bubbleSort 메소드는 독립적으로 동작
   객체의 상태에 영향을 주지 않음
   이와 같은 방식으로 메소드를 구현하는 것은
   메소드의 독립성과 재사용성을 높이는데 도움이 됨
   ->
   주어진 배열을 정렬하는 기능을 수행하는데 집중
   객체의 상태를 변경하는 부분을 처리하지 않음 
   코드의 가독성과 유지보수성을 향상
 */

//버블 정렬의 Java 코드

import java.io.*;

class BubbleSort {
	
	// 버블 정렬의 최적화된 버전
	static void bubbleSort(int arr[], int n)
	{
		int i, j, temp;
		//swapped : 교환, 바꾼의 의미로
		// 바꾼것 = true or false
		boolean swapped;
		
		//outer loop : SelectionSort와 마찬가지로
		// n - 1 이전 까지만 반복
		for (i = 0; i < n - 1; i++) {
			//바꾸지 않음
			swapped = false;
			// inner loop : n - i -1 은 
			// 현재 정렬되지 않은 부분의 마지막 요소의 인덱스
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					
					// arr[j]와 arr[j+1]을 바꿈
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// 두 개의 요소가 없는 경우 : 정렬된 상태
			// inner loop의 if문에 들어가지 못한 상태
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

