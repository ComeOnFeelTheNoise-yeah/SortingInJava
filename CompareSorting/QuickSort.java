

//자바로 QuickSort 구현
import java.io.*;

public class QuickSort {

	// 두 요소를 교환하는 유틸리티 함수
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// 이 함수는 마지막 요소를 피벗으로 사용하고,
	// 피벗 요소를 정렬된 배열의 올바른 위치에 배치하고, 
	// 모든 작은 요소는 피벗 왼쪽에, 
	// 모든 큰 요소는 피벗 오른쪽에 배치
	static int partition(int[] arr, int low, int high)
	{
		// 피벗 선택
		int pivot = arr[high];

		// 더 작은 요소의 인덱스와 
		// 지금까지 찾은 피벗의 올바른 위치를 나타냄
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// 현재 요소가 피벗보다 작은 경우
			if (arr[j] < pivot) {

				// 작은 요소의 인덱스 증가
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	// QuickSort를 구현하는 메인 함수
	// arr[] --> 정렬할 배열,
	// 낮음 --> 시작 인덱스,
	// 높음 --> 끝 인덱스
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			// pi는 분할 인덱스, arr[p]는 이제 올바른 위치에 있음
			int pi = partition(arr, low, high);

			// 파티션 전과 파티션 후 요소를 별도로 정렬
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	// 정렬된 배열을 출력
	public static void printArr(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}

	// 구동 코드
	public static void main(String[] args)
	{
		int[] arr = { 7, 3, 5, 2, 6, 1, 4 };
		
		System.out.print("QuickSort 전 : ");
		printArr(arr);
		
		int N = arr.length;

		// 메소드 호출
		quickSort(arr, 0, N - 1);
		System.out.print("QuickSort 후 : ");
		printArr(arr);
	}
}
