import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lee.mybatis.dao.BooksDao;
import com.lee.mybatis.domain.BooksVO;

public class Main {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		BooksDao dao = context.getBean(BooksDao.class);

//		List<BooksVO> list = dao.booklist();
//		for (BooksVO vo : list) {
//			System.out.println(vo);
//		}

//		//code를 가지고 데이터를 조회하는 메소드 호출 
//	 BooksVO vo = dao.selectbook("a103");
//	 System.out.println(vo);
//	 
//	 vo = dao.selectbook("a54");
//	 System.out.println(vo);

		Scanner sc = new Scanner(System.in);
		// primary key를 입력받는 경우에는
		// 반드시 중복 체크를 해야 합니다.
		String code = "";
		while (true) {
			System.out.print("code를 입력해 주세요 : ");
			code = sc.nextLine();
			BooksVO vo = dao.selectbook(code);
			if (vo == null) {
				break;
			}

			System.out.println(code + "는 사용 불 가능한 code 입니다.");
		}
		
		
		System.out.print("책제목:");
		String subject = sc.nextLine();
		System.out.print("가격:");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("설명:");
		String description = sc.nextLine();
	
		
		
	BooksVO newVO = new BooksVO();
	newVO.setCode(code);
	newVO.setSubject(subject);
	newVO.setPrice(price);
	newVO.setDescription(description);
	
	//select 이외의 구문은 영향받은 행의 개수를 리턴 
	int result = dao.insertproc(newVO);
	
	System.out.println(result);

		sc.close();

		context.close();
	}

}
