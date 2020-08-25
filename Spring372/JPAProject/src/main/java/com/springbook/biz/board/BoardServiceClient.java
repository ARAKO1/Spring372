package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//JPA Board테스트
public class BoardServiceClient {

	public static void main(String[] args) {
	//EntityManager생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
	//Transaction 생성
		EntityTransaction tx  = em.getTransaction();
	//Transaction 시작
		try{
			tx.begin();//tx시작
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA글 등록 잘 되네요.");
			
			//글 등록
			em.persist(board);//객체저장
			

			//글 목록 조회
			String jpql="select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for(Board b:boardList){
				System.out.println("---->"+b);
			}
			
			//글 내용 조회
			//find(클래스, seq 번호)
			Board board2 = em.find(Board.class, 1);
			System.out.println("board상세조회:" +board2);
			
			//글 수정
			Board boardUpdate = new Board();
			boardUpdate.setSeq(1);
			boardUpdate.setTitle("수정된 제목");
			boardUpdate.setContent("수정된 내용");
			boardUpdate.setWriter("수정된 작성자");
			
			em.merge(boardUpdate);//수정메소드 merge(객체)
			
			//글삭제처리
			em.remove(em.find(Board.class, 2));//삭제메소드 remove(객체)
			
			//Transaction commit;
			tx.commit();
	}catch(Exception e){
		e.printStackTrace();
		//Transaction rollback;
		tx.rollback();
	}finally{
		em.close();//EntityManager 해제
	}
	emf.close();//EntityManagerFactory 해제
	}
}
