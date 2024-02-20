package com.springstudy.ch02.annotation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springstudy.ch02.dao.MemberDAO;
import com.springstudy.ch02.domain.Member;

//@Component
@Repository
public class MemberDAOImpl implements MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 스프링이 제공하는 DriverManagerDataSource 객체 타입의 멤버 선언 - 실무에서는 테스트용으로 씀
	private DriverManagerDataSource dataSource;
	
	
	// 생성자 주입을 지우면 기본 생성자가 없기때문에 하나 만들어줘야함
	public MemberDAOImpl() {}
	
	// 생성자 주입일 때(Constructor)
	// 스프링이 제공하는 DriverManagerDataSource 객체를 주입받는 생성자 필요
	@Autowired
	public MemberDAOImpl(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	// 셋터 주입일 때(Property)
	// 스프링이 제공하는 DriverManagerDataSource 객체를 주입받는 셋터 메서드 필요
	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}
		
	
	@Override
	public ArrayList<Member> getMemberList() {
		
		String selectAllMember = "SELECT * FROM member;";
		ArrayList<Member> memberList = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(selectAllMember);
			rs = pstmt.executeQuery();
			
			memberList = new ArrayList<Member>();
			
			while(rs.next()) {
				
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getTimestamp("reg_date"));
				
				memberList.add(member);
			}			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {			
			try {				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch(SQLException e) { }
		}
		return memberList;
	}

}
