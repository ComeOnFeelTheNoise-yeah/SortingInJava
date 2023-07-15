package Sort;

//선택 정렬 구현을 위한 자바 프로그램
import java.io.*;
public class SelectionSort
{
	void sort(int arr[])
	{
		int n = arr.length;

		// 정렬되지 않은 하위 배열의 경계를 하나씩 이동
		// n-1인 이유 : 정렬되지 않은 하위 배열의 경계를 이동하면서
		// 맨 마지막 요소까지 비교하지 않아도 되기 때문에 n-1까지만 반복
		for (int i = 0; i < n-1; i++)
		{
			// 정렬되지 않은 배열에서 최소 요소 찾기
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// 찾은 최소 요소를 첫 번째 요소(element)로 교체
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	// 배열을 출력하는 메소드
	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	//상단 코드를 테스트 할수 있는 구동 코드
	public static void main(String args[])
	{
		SelectionSort ob = new SelectionSort();
		int arr[] = { 7, 3, 5, 2, 6, 1, 4 };
		System.out.print("SelectionSort 전 : ");
		ob.printArray(arr);
		
		ob.sort(arr);
		System.out.print("SelectionSort 후 : ");
		ob.printArray(arr);
	}
}