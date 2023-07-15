package Sort;

/* 코드 설명에 들어가기 앞서 Sorting관련 코드는 Geeks for Geeks 사이트를
	참고해서 만들어 졌다는 것을 밝힘. 직접 짜도 되지만 코드를 너무 조잡하게
	짜와서 잘 짜여진 코드를 직접 분석하고 수정하며 발전하고 싶었음. 
	개개인 마다 장단점이 있듯 필자, 한승주는 어떻게든 논리적으로 동작 
	가능하게하지만 정돈된 코드를 못짜는게 단점이니 잘 정돈하는 사람은 
	이 코드를 참고하지 말고 직접 작성하길 바람 */

// (작은 수 기준) 선택 정렬 구현을 위한 자바 프로그램
import java.io.*;
public class SelectionSort
{
	//sort method
	void sort(int arr[])
	{
		int n = arr.length;

		// outer for : 정렬되지 않은 하위 배열의 경계를 하나씩 이동
		// n-1인 이유 : j가 n번까지 다음 인덱스로 있어야 때문
		for (int i = 0; i < n-1; i++)
		{
			
			// min_idx는 0번 인덱스 부터 차례로 최소 요소를 찾기 위함
			// min_idx가 따로 선언된 이유는 아래 3줄코드인 temp에 설명
			int min_idx = i;
			
			// inner for : 정렬되지 않은 배열에서 최소 요소 찾기
			// inner for문의 j는 다음인덱스를 뜻함, i를 비교하기 위해 쓰여짐
			// inner for문이 다 돌고나서 outer for문이 돌기 떄문에
			// 전체 배열의 숫자를 비교하면서 가장 작은 수를 앞으로 보낼 수 있음
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// 가장작은수로 교체해주는 코드 3줄
			// 찾은 최소 요소를 첫 번째 요소(element)로 교체
			// 아닐경우엔 똑같은 값이 다시 들어감 min_idx = i
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