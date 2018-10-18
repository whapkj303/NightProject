package kr.co.joda.myboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.joda.myboard.domain.BoardVO;
import kr.co.joda.myboard.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // 모든 의존 객체를 생성자로 받겠다. - lombok의 기능
public class BoardServiceImpl implements BoardService {

	// Spring 4.3 버전 미만에서는 @Autowired 를 붙여줘야 함
	// @Autowired -> 4.3 버전 미만일 시 붙여줄 것
	// @Setter(onMethod_=@Autowired) @AllArgsConstructor 어노테이션을 안쓸 때
	// 어노테이션을 붙인것들을 빈으로 만들어주는 component-scan -> root-context.xml에서 설정
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
