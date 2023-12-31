package Sort;

//병합 정렬을 위한 자바 프로그램
//장점 : 최선의 경우에도, 최악의 경우에도 O(nlog₂n)의 시간이 소요
import java.io.*;

class MergeSort {

	// arr[]의 두 하위 배열을 병합
	// 첫 번째 하위 배열은 arr[l..m] l:left m:mid
	// 두 번째 하위 배열은 arr[m+1..r] r:right
	void merge(int arr[], int l, int m, int r)
	{
		// 병합할 두 하위 배열의 크기 찾기
		int n1 = m - l + 1;
		int n2 = r - m;

		// 임시 배열 생성
		int L[] = new int[n1];
		int R[] = new int[n2];

		// 임시 배열에 데이터 복사
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// 임시 배열 병합

		// 첫 번째 및 두 번째 하위 배열의 초기 인덱스
		int i = 0, j = 0;

		// 병합된 하위 배열의 초기 인덱스
		// 새로운 요소가 삽입되어야 할 위치를 가리키는 역할
		// 병합 과정에서 작은 요소를 원래 배열에 복사하는 위치를 지정
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// L[]의 나머지 요소가 있는 경우 복사
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// R[]의 나머지 요소가 있는 경우 복사
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}

	// merge()를 사용하여 arr[l..r]을 정렬하는 메인 함수
	void sort(int arr[], int l, int r)
	{
		//같거나 작으면 배열에 한 값만있어 sort할 필요 없거나 이상한 것
		if (l < r) {

			// 중간점 찾기
			int m = l + (r - l) / 2;

			// 전반부와 후반부 정렬
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// 정렬된 절반 병합
			merge(arr, l, m, r);
		}
	}

	// 크기 n의 배열을 출력하는 유틸리티 함수
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// 구동 코드
	public static void main(String args[])
	{
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		
		int arr[] = { 4, 7, 2, 5, 3, 1, 6 };

		System.out.print("MergeSort Sort 전 : ");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.print("MergeSort Sort 후 : ");
		printArray(arr);
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
		System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
	}
}

/*	MergeSort Sort 전 : 4 7 2 5 3 1 6 
	MergeSort Sort 후 : 1 2 3 4 5 6 7 
	실행 시간(ms): 2
 */