package Sort;

//계수 정렬의 자바 구현

import java.io.*;

class CountingSort {
 void sort(char arr[])
 {
     int n = arr.length;

  // arr을 정렬할 출력 문자 배열
     char output[] = new char[n];

     // 개인의 카운트를 저장할 카운트 배열 생성
     // 문자 및 카운트 배열을 0으로 초기화
     int count[] = new int[256];
     for (int i = 0; i < 256; ++i)
         count[i] = 0;

     // 각 문자의 카운트 저장
     for (int i = 0; i < n; ++i)
         ++count[arr[i]];

     // count[i]가 이제 출력 배열에서 
     // 이 문자의 실제 위치를 포함하도록 count[i]를 변경
     for (int i = 1; i <= 255; ++i)
         count[i] += count[i - 1];

     // 출력 문자 배열 빌드
     // 안정적으로 만들기 위해 역순으로 작동
     for (int i = n - 1; i >= 0; i--) {
         output[count[arr[i]] - 1] = arr[i];
         --count[arr[i]];
     }

     // 출력 배열을 arr에 복사하여 이제 arr에 정렬된 문자가 포함
     for (int i = 0; i < n; ++i)
         arr[i] = output[i];
 }

 // 구동 코드
 public static void main(String args[])
 {
     CountingSort ob = new CountingSort();
     char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                    'r', 'g', 'e', 'e', 'k', 's' };

     // 함수 호출
     ob.sort(arr);

     System.out.print("Sorted character array is ");
     for (int i = 0; i < arr.length; ++i)
         System.out.print(arr[i]);
 }
}