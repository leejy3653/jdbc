package kr.co.itcen.cdmall.dao.test;

import java.util.List;

import kr.co.itcen.cdmall.dao.ArtistDao;
import kr.co.itcen.cdmall.vo.ArtistVo;

public class ArtistDaoTest {

	public static void main(String[] args) {
		insertTest();

		selectTest();
	}

	public static void insertTest() {
		ArtistDao dao = new ArtistDao();
		ArtistVo vo1 = new ArtistVo();
		vo1.setName("아이유");
		dao.insert(vo1);

		ArtistVo vo2 = new ArtistVo();
		vo2.setName("BTS");
		dao.insert(vo2);

		ArtistVo vo3 = new ArtistVo();
		vo3.setName("소녀시대");
		dao.insert(vo3);
	}

	private static void selectTest() {
		ArtistDao dao = new ArtistDao();
		List<ArtistVo> list = dao.getList();
		for (ArtistVo vo : list) {
			System.out.println(vo);
		}

	}

}
