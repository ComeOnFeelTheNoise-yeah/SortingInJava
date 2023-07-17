

//계수 정렬의 자바 구현

import java.io.*;
import java.util.Arrays;

public class CountingSort {
 void countingSort(int arr[])
 {
     int n = arr.length;
    
     //min max를 구해 size를 정함
     int max = Arrays.stream(arr).max().getAsInt(); //Stream: 타입이 T
     int min = Arrays.stream(arr).min().getAsInt();
     int size = max - min + 1;

  // arr을 정렬할 출력 숫자 배열
     int output[] = new int[n];

     // 개인의 카운트를 저장할 카운트 배열 생성
     // 숫자 및 카운트 배열을 0으로 초기화
     int count[] = new int[size];
     for (int i = 0; i < size; ++i)
         count[i] = 0;

     // 각 숫자 카운트 저장
     for (int i = 0; i < n; ++i)
    	 count[arr[i] - min]++;

     // count[i]가 이제 출력 배열에서 
     // 이 숫자 실제 위치를 포함하도록 count[i]를 변경
     for (int i = 1; i < size -1 ; ++i)
         count[i] += count[i - 1];

     // 출력 숫자 배열 빌드
     // 안정적으로 만들기 위해 역순으로 작동
     for (int i = n - 1; i >= 0; i--) {
    	 output[count[arr[i] - min] - 1] = arr[i];
    	 count[arr[i] - min]--;
     }

     // 출력 배열을 arr에 복사하여 이제 arr에 정렬된 숫자가 포함
     for (int i = 0; i < n; ++i)
         arr[i] = output[i];
 }
 
//배열을 출력하는 함수
	static void printArray(int arr[], int size)
	{
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
 
 
}