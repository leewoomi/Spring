import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.GoodDao;
import com.mybatis.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		GoodDao dao = context.getBean(GoodDao.class);

		System.out.println(dao);

		Good g = new Good();
		g.setCode(7);
		g.setName("수박");
		g.setPrice(400);
		g.setDescription("수박");
		dao.insertgood(g);
		
		
		List<Good> list = dao.list();

		for (Good good : list) {
			System.out.println(good);
		}
		// System.out.println(dao.list());

		context.close();

	}

}
