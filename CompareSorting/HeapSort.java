

// Heap Sort를 구현한 Java 프로그램
// 장점 : 힙 정렬은 시간복잡도가 최선, 평균, 최악 모두
// O ( n l o g n ) O(nlogn) O(nlogn)인데다,
// 추가 메모리 할당도 없는 이론적으론 이상적인 알고리즘
public class HeapSort {

	// 힙 정렬 메소드
	public void heapSort(int arr[]) {
		int N = arr.length;

		// 힙 빌드(배열 재정렬)
		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		// 힙에서 요소를 하나씩 추출
		for (int i = N - 1; i > 0; i--) {
			// 현재 루트를 끝으로 이동
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// 감소된 힙에서 최대 heapify(힙화)를 호출
			heapify(arr, i, 0);
		}
	}

	// arr[]의 인덱스인 노드 i를 기반으로 하는 하위 트리를 힙화
	// N은 힙의 크기
	void heapify(int arr[], int N, int i) {
		int largest = i; // 가장 큰 요소를 루트로 초기화
		int l = 2 * i + 1; // 왼쪽 자식 = 2*i + 1
		int r = 2 * i + 2; // 오른쪽 자식 = 2*i + 2

		// 왼쪽 자식이 루트보다 크면
		if (l < N && arr[l] > arr[largest])
			largest = l;

		// 오른쪽 자식이 지금까지 가장 큰 요소보다 큰 경우
		if (r < N && arr[r] > arr[largest])
			largest = r;

		// 최대값이 루트가 아닌 경우
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// 영향을 받는 하위 트리를 재귀적으로 힙화
			heapify(arr, N, largest);
		}
	}

	/* 크기가 N인 배열을 출력하는 유틸리티 함수 */
	static void printArray(int arr[]) {
		int N = arr.length;

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// 구동 방법: Driver method
	public static void main(String args[]) {
		
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		
		int arr[] = { 7, 3, 5, 2, 6, 1, 4 };
		int N = arr.length;

		System.out.print("Heap Sort 전: ");
		printArray(arr);

		// HeapSort 객체를 생성하여 힙 정렬 수행
		HeapSort ob = new HeapSort();
		ob.heapSort(arr);

		System.out.print("Heap Sort 후: ");
		printArray(arr);
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
		System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
	}
}

/*	Heap Sort 전: 7 3 5 2 6 1 4 
	Heap Sort 후: 1 2 3 4 5 6 7 
	실행 시간(ms): 2
*/