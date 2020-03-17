import java.util.Scanner;

//입출력 예제
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // System.in 콘솔창에서 입력하는 어떠한 데이터같은것을 의미함
		System.out.println("정수를 입력하세요 : ");
		int i = sc.nextInt();
		System.out.println("입력된 정수"+ i + "입니다");
		sc.close();
		
	}

}
