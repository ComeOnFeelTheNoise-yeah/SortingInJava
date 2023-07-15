package Sort;

//Shell Sort 의 Java 코드
class ShellSort
{
	/* 크기가 n인 배열을 출력하는 유틸리티 함수*/
	static void printArray(int array[])
	{
		int n = array.length;
		for (int i=0; i<n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	/*셸 정렬을 배열을 사용해서 만든 기능*/
	int sort(int array[])
	{
		int n = array.length;

		// 큰 간격으로 시작한다음, 간격을 줄인다
		// (추가)간격은 전체길이 나누기 2; 간격이 영보다 클때까지; 간격을 2싹 나눠가면서
		for (int gap = n/2; gap > 0; gap /= 2)
		{
			// 이 간격 크기에 대해 간격 삽입 정렬을 수행합니다.
			// 첫 번째 간격 요소 a[0..gap-1]은
			// 이미 간격이 있는 순서로, 하나 이상의 요소를 계속 추가합니다.
			// 전체 배열이 갭 정렬될 때까지
			//(추가) i++을 해도 되지만 통일성있게
			for (int i = gap; i < n; i += 1) 
			{
				// 간격이 있는 요소에 array[i]를 추가합니다.  
				// 임시로 array[i]를 저장하고 다음에 구멍을 만듭니다.
				// 위치 i
				int temp = array[i];

				// 이전 갭 정렬 요소를 다음까지 이동합니다.
				// a[i]의 올바른 위치를 찾았습니다.
				// j를 밖으로 뺸 이유 : outer for문 에서 쓰기 위함
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
					array[j] = array[j - gap];

				// temp(원본 a[i])를 올바른 위치에 넣습니다.
				// 위치
				array[j] = temp;
			}
		}
		return 0;
	}

	// 구동 방법 : Driver method
	public static void main(String args[])
	{
		int array[] = {12, 34, 54, 2, 3};
		System.out.println("shell sorting 전");
		printArray(array);

		ShellSort ob = new ShellSort();
		ob.sort(array);

		System.out.println("shell sorting 후");
		printArray(array);
	}
}
/*|출처| Rajat Mishra |수정| 한승주 */
