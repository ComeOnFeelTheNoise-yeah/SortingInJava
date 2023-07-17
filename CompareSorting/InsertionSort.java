

//삽입 정렬 구현을 위한 자바 프로그램
public class InsertionSort {
	/*삽입 정렬을 이용한 배열 정렬 기능*/
	void insertionSort(int arr[])
	{
		int n = arr.length;
		// i = 1, j = 0
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/* arr[0..i-1]의 요소를 이동
			키보다 큼, 현재 위치의 한 위치 앞으로*/
			// while이 사용된 이유: 조건에 해당될때만
			// 반복 하기 위함
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j --;
			}
			arr[j + 1] = key;
		}
	}

	/* 크기가 n인 배열을 출력하는 유틸리티 함수*/
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
	
};


