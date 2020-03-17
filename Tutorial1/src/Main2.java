import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

	//파일 입출력
	public static void main(String[] args) {
		File file = new File("input.txt");// input.txt파일을 읽어와서 파일번수가 처리할수 있도록 해준단 의미
		try {
			Scanner sc = new Scanner(file); //빨간줄뜬건. 파일이 없고나,파일을 읽을수 없는 상황일때의 예외처리를 필수 권고. try/catch
			while(sc.hasNextInt()) {//sc가 현재 다을으로 읽을 정수가 있는지
				System.out.println(sc.nextInt() * 100);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("파일을 읽어오는 도중에 오류가 발생했다.");
		} 
	}
}
