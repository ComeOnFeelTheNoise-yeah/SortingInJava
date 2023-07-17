package Sort;

// Shell Sort의 Java 코드입니다.
// 장점 : 연속적이지 않은 부분 리스트에서 자료의 교환이 일어나면 더 큰 거리를 이동함
// 따라서 교환되는 요소들이 삽입 정렬보다는 최종 위치에 있을 가능성이 높아짐

class ShellSort {
	/* 크기가 n인 배열을 출력하는 유틸리티 함수 */
	static void printArray(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	/* Shell Sort를 사용하여 배열을 정렬하는 기능 */
	void sort(int array[]) {
		int n = array.length;

		// 큰 간격으로 시작한 후, 간격을 줄입니다.
		// 간격은 전체 길이를 2로 나눈 값부터 시작해서 1이 될 때까지 절반씩 줄여나갑니다.
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// 해당 간격 크기에 대해 간격 삽입 정렬을 수행합니다.
			// 첫 번째 간격 요소 array[0..gap-1]은 이미 정렬되어 있는 상태로,
			// 하나 이상의 요소를 계속 추가하여 전체 배열이 간격 정렬될 때까지 진행합니다.
			for (int i = gap; i < n; i += 1) {
				// 간격이 있는 요소에 array[i]를 추가합니다.
				// array[i] 값을 temp에 임시로 저장한 후, 인덱스 i 위치를 빈 상태로 만듭니다.
				int temp = array[i];

				// 이전 간격 정렬 요소를 다음 위치까지 이동시킵니다.
				// array[i]의 올바른 위치를 찾습니다.
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
					array[j] = array[j - gap];

				// temp(원본 array[i])를 올바른 위치에 넣습니다.
				array[j] = temp;
			}
		}
	}

	// 구동 방법: Driver method
	public static void main(String args[]) {
		
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		
		int array[] = { 7, 3, 5, 2, 6, 1, 4 };
		System.out.print("Shell Sort 전 : ");
		printArray(array);

		ShellSort ob = new ShellSort();
		ob.sort(array);

		System.out.print("Shell Sort 후 : ");
		printArray(array);
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
		System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
	}
}

/*	Shell Sort 전 : 7 3 5 2 6 1 4 
	Shell Sort 후 : 1 2 3 4 5 6 7 
	실행 시간(ms): 1
	
	MergeSort나 HeapSort보다 빠르게 나옴
*/