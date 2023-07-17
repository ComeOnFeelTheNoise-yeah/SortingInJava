

//Java로 기수 정렬 구현

import java.io.*;
import java.util.*;

class RadixSorting {

	// arr[]에서 최대값을 얻기 위한 유틸리티 함수
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	//exp가 나타내는 숫자에 따라 arr[]의 카운팅 정렬을 하는 함수
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// 발생 횟수를 count[]에 저장
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// count[i]가 이제 output[]에서 이 숫자의 
		// 실제 위치를 포함하도록 count[i]를 변경
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// 출력 배열 빌드
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// 출력 배열을 arr[]에 복사하여 arr[]에 현재 숫자에 따라 
		// 정렬된 숫자가 포함되도록 함
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// 기수 정렬을 사용하여 크기 n의 arr[]를 정렬하는 주요 함수
	static void radixSort(int arr[], int n) {
		// 자릿수를 알기 위해 최대 수를 찾음
		int m = getMax(arr, n);

		// 모든 숫자에 대해 카운팅 정렬을 수행
		// 숫자를 전달하는 대신 exp가 전달됌
	    // exp는 10^i입니다. i는 현재 숫자
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	// 배열을 출력하는 유틸리티 함수
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}

	// main이라는 구동 메소드
	public static void main(String[] args) {
		int arr[] = { 7, 3, 5, 2, 6, 1, 4 };
		int n = arr.length;
		System.out.print("radixsort 전 : ");
		print(arr, n);
		
		// 함수 호출
		radixSort(arr, n);
		System.out.print("radixsort 후 : ");
		print(arr, n);
	}
}