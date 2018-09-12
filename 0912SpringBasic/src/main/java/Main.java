import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GoodDao;

import vo.GoodVO;

public class Main {

	public static void main(String[] args) {
		// GoodDao 인스턴스를 생성
		// GoodDao dao = new GoodDao();

		// GoodDao dao = GoodDaoFactory.create();

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodDao dao = context.getBean("goodDao", GoodDao.class);

		System.out.println(dao.hashCode());
		// 필요한 메소드 호출
		List<GoodVO> list = dao.getGood();
		// 메소드 호출 결과 출력
		for (GoodVO vo : list) {
			System.out.println(vo);
		}

		dao = context.getBean("goodDao", GoodDao.class);
		System.out.println(dao.hashCode());
		context.close();
	}

}
