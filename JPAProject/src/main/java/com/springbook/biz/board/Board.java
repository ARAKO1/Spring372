package com.springbook.biz.board;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity//VO에 @Entity 어노테이션 설정시 속성에 @Id어노테이션을 가진 속성이 존재해야함.
@Table(name="UrBoard")//Object,Relation(table)매핑
@SequenceGenerator(
		name="board_seq",//시퀀스 제너레이터 이름
		sequenceName="board_seq",//DB 시퀀스 이름
		initialValue=1,//시작값 
		allocationSize=1// 메모리 할당 사이즈
		)
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//속성
	@Id//키 어노테이션
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="board_seq")//자동생성 어노테이션
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)//DB의 date타입 매핑 어노테이션
	private Date regDate= new Date();
	private int ctn;
	
	//생성자
	public Board() {}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCtn() {
		return ctn;
	}

	public void setCtn(int ctn) {
		this.ctn = ctn;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", ctn=" + ctn + "]";
	}
   
	
}
