package Sort;

// 버킷 정렬을 사용하여 배열을 정렬하는 자바 프로그램
import java.util.*;
import java.util.Collections;

class BucketSort {

	// 버킷 정렬을 사용하여 크기 n의 arr[] 정렬 함수
	static void bucketSort(float arr[], int n)
	{
		if (n <= 0)
			return;

		
		/* 책에서는 LinkedList를 사용했지만
		   정렬에서 Vector를 사용하는 이유
		1. 동적 크기 조정
	  	2. 삽입 및 접근 효율성 : 데이터의 삽입 및 접근에 빠른 성능을 제공
		3. 정렬된 데이터 유지 : 데이터를 삽입한 순서를 유지, 각 버킷에서 정렬된 데이터를 유지함
		4. 편리한 인터페이스 : 버킷 정렬의 구현과 관련된 작업을 간소화하고 가독성을 높여줌 */
		
		/*@SuppressWarnings("unchecked") : 
			컴파일러의 경고 메시지를 무시하도록 지시하는 역할을 함
			사용 이유 : 제네릭 배열을 생성하는 부분에서 컴파일러
			 경고 메시지가 발생할 수 있어서 
			※ 주의 : 남용 금지*/
		
		// 1) n개의 빈 버킷 생성
		@SuppressWarnings("unchecked") //경고 제외
		Vector<Float>[] buckets = new Vector[n];

		for (int i = 0; i < n; i++) {
			buckets[i] = new Vector<Float>();
		}

		// 2) 다른 버킷에 배열 요소 넣기
		for (int i = 0; i < n; i++) {
			float idx = arr[i] * n;
			buckets[(int)idx].add(arr[i]);
		}

		// 3) 개별 버킷 정렬
		for (int i = 0; i < n; i++) {
			Collections.sort(buckets[i]);
		}

		// 4) 모든 버킷을 arr[]로 연결
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				arr[index++] = buckets[i].get(j);
			}
		}
	}

	// 구동 코드
	public static void main(String args[])
	{
		float arr[] = { (float)0.897, (float)0.565,
						(float)0.656, (float)0.1234,
						(float)0.665, (float)0.3434 };

		int n = arr.length;
		bucketSort(arr, n);

		System.out.println("Sorted array is ");
		for (float el : arr) {
			System.out.print(el + " ");
		}
	}
}

