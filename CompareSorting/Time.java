

public class Time {
	
	public long beforeMs() {
		long beforeTime = System.currentTimeMillis();
		return beforeTime;
	}

	public void afterMs(long beforeTime) {
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
		System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
	}
	
}
