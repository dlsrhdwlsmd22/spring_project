package com.sts.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.vo.Shop_Member;

@Service
public class Shop_MemberDAO implements Shop_MemberService{
	
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public int insertMemberOne(Shop_Member Shop_member) {
		return sqlSession.insert("Shop_memberMapper.insertMemberOne", Shop_member);
	}

}