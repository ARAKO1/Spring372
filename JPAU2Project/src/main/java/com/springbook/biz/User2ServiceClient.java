package com.springbook.biz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sun.media.sound.EmergencySoundbank;

public class User2ServiceClient {

	public static void main(String[] args) {
		//EntityManagerFactory생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAU2Project");
		
		//EntityManager생성
		EntityManager em = emf.createEntityManager(); 
				
		//transaction처리
		EntityTransaction tx = em.getTransaction();
		try{
			//transaction 시작
			tx.begin();
			
			UserVO user1 = new UserVO();
			user1.setId("kim");
			//회원존재여부 확인-find(클래스, 키);
			user1=em.find(UserVO.class, user1.getId());
			if(user1==null) {
				System.out.println("사용가능합니다.");
				user1 = new UserVO();
				user1.setId("kim");
				user1.setName("홍길동");
				user1.setPassword("1234");
				user1.setAddress("서울시");
				user1.setRole("user");
				//저장
				em.persist(user1);
				
			}
			else{ System.out.println("이미 존재하는 id입니다.");
			//DB에서 해당 정보 출력 
			user1=em.find(UserVO.class, "hong");
			user1.setPassword("3456");
			user1.setAddress("수원시");
			
			//수정처리
			em.merge(user1);//기존대로 있는데 바뀐부분만 update
			}
			
			//정보확인
			System.out.println(em.find(UserVO.class,user1.getId()));
			
			
			
			//DB반영처리
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			//되돌리기
			tx.rollback();
		}finally{
			em.close();//Entity매니저 해제
		}
		emf.close();

	}

}
