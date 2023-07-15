package Sort;

//Heap Sort 구현을 위한 Java 프로그램

public class HeapSort {

//힙 정렬 메소드
 public void sort(int arr[])
 {
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

 //arr[]의 인덱스인 노드 i를 기반으로 하는 하위 트리를 힙화
 //n은 힙의 크기
 void heapify(int arr[], int N, int i)
 {
     int largest = i; // 가장 큰 것을 루트로 초기화
     int l = 2 * i + 1; // 왼쪽 = 2*i + 1
     int r = 2 * i + 2; // 오른쪽 = 2*i + 2

     // 왼쪽 자식이 루트보다 크면
     if (l < N && arr[l] > arr[largest])
         largest = l;

     // 오른쪽 자식이 지금까지 가장 큰 것보다 큰 경우
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

 /* 크기가 n인 배열을 출력하는 유틸리티 함수(여러 가지 계산과 처리를 대신하는 일반함수) */
 static void printArray(int arr[])
 {
     int N = arr.length;

     for (int i = 0; i < N; ++i)
         System.out.print(arr[i] + " ");
     System.out.println();
 }

 // 구동 코드
 public static void main(String args[])
 {
     int arr[] = { 7, 3, 5, 2, 6, 1, 4 };
     int N = arr.length;

     System.out.print("힙 정렬 전 : ");
     printArray(arr);
     
     // 함수 호출
     HeapSort ob = new HeapSort();
     ob.sort(arr);

     System.out.print("힙 정렬 후 : ");
     printArray(arr);
 }
}