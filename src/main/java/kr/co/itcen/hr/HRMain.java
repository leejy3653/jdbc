package kr.co.itcen.hr;

import java.util.List;
import java.util.Scanner;

public class HRMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		String keyword = scanner.nextLine();
		scanner.close();
		// 직원 정보 생성(저장, C)
		// dao.insert(employeeVo)

		// 직원 검색 (이름, R)
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(keyword);

		// 직원 검색 (사번, R)
		// Employee Vo vo = dao.get(no);

		// 직원 정보 수정(U)
		// Boolean result = dao.update(vo);

		// 직원 삭제(D)
		// Boolean result = dao.delete(no);

		printEmployee(list);
	}

	private static void printEmployee(List<EmployeeVo> list) {
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

}
