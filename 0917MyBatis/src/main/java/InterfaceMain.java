import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lee.mybatis.dao.BooksInterface;
import com.lee.mybatis.domain.BooksVO;

public class InterfaceMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		BooksInterface booksInterface = context.getBean(BooksInterface.class);

//		List<BooksVO> list = booksInterface.listbooks();
//		for (BooksVO vo : list) {
//			System.out.println(vo);
//		}
		
		BooksVO vo = booksInterface.selectbook("101");
		System.out.println(vo);

		
		context.close();
	}

}
