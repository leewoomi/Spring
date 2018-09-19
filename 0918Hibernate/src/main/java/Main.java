import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lee.dao.StudentDao;
import com.lee.domain.Student;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		StudentDao dao = context.getBean(StudentDao.class);

		List<Student> list = dao.list();
		for (Student student : list) {
			System.out.println(student);

		}
		// 데이터 1개 가져오기
		System.out.println("=========");
		System.out.println(dao.get(1));
		System.out.println(dao.get(11));

//		Student student = new Student();
//		
//		student.setNum(4);
//		student.setName("차은우");
//		student.setAge(26);
//		student.setAddress("경기도");
//		student.setPhone("01012345678");
//		student.setEmail("ggg@gmail.com");

//		dao.deleteStudent(student);
		// dao.updateStudent(student);
		// dao.insertStudent(student);
		context.close();

	}

}
