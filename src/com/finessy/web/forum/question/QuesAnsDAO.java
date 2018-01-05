package com.finessy.web.forum.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.commonDAO.CommonDAO;

public class QuesAnsDAO {
	Connection connection = null;
	Connection con1 = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	PreparedStatement ps1 = null;
	ResultSet rs1 = null;
	
	
	
	public ArrayList<Integer> findAnswerIDs(int questionId) throws ClassNotFoundException, SQLException {
		
		ArrayList<Integer> answerIDArrayList = new ArrayList<Integer>();
		try {
			
			connection = CommonDAO.getConnection();
			preparedStatement = connection.prepareStatement(QuesAnsSQL.FIND_ANSWER_ID);
			preparedStatement.setInt(1, questionId);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.isBeforeFirst() ) { 
				answerIDArrayList.add(0);
				return answerIDArrayList;
			} 
			
			while(resultSet.next()) {
				answerIDArrayList.add(resultSet.getInt(1));
			}
			return answerIDArrayList;
			
		}finally {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
	}
	
public ArrayList<QuesAnsDTO> findAnswerDetails(int questionID) throws ClassNotFoundException, SQLException {
		
		ArrayList<Integer> answerIDArrayList = new ArrayList<Integer>();
		answerIDArrayList = findAnswerIDs(questionID);
		ArrayList<QuesAnsDTO> answerList = new ArrayList<QuesAnsDTO>();
		String name = null;
		
		try { 
			connection = CommonDAO.getConnection();
			con1 = CommonDAO.getConnection();
			preparedStatement = connection.prepareStatement(QuesAnsSQL.FIND_ANSWER_DETAILS);
			ps1 = con1.prepareStatement(QuesAnsSQL.FIND_NAME);
			
			for(Integer i: answerIDArrayList) {
				preparedStatement.setInt(1, i);
				resultSet = preparedStatement.executeQuery();
				
				if(!resultSet.isBeforeFirst()) {
					answerList.add(null);
					return answerList;
				}
			
				while(resultSet.next()) {
					
				ps1.setInt(1,resultSet.getInt(2) );
					rs1 = ps1.executeQuery();
				while(rs1.next()) {
					 name = rs1.getString(1)+" "+rs1.getString(2);
				}
					
				QuesAnsDTO answers = new QuesAnsDTO(resultSet.getInt(1),name,resultSet.getString(3),resultSet.getString(4));
				answerList.add(answers);
				}	
			}
		}finally {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(connection!=null) {
				connection.close();
			}
			if(rs1!=null) {
				rs1.close();
			}
			if(ps1!=null) {
				ps1.close();
			}
			if(con1!=null) {
				con1.close();
			}
			
		}
		return answerList;
	}
		
//	public ArrayList<Integer> findRelatedQuestionIDs(int questionId) throws ClassNotFoundException, SQLException {
//		
//		ArrayList<Integer> relatedQuestionIDs = new ArrayList<Integer>();
//		try {
//			
//			connection = CommonDAO.getConnection();
//			preparedStatement = connection.prepareStatement(QuesAnsSQL.FIND_RELATED_QUESTIONIDs);
//			preparedStatement.setInt(1, questionId);
//			resultSet = preparedStatement.executeQuery();
//			
//			if (!resultSet.isBeforeFirst() ) { 
//				relatedQuestionIDs.add(0);
//				return relatedQuestionIDs;
//			} 
//			
//			while(resultSet.next()) {
//				relatedQuestionIDs.add(resultSet.getInt(1));
//			}
//			return relatedQuestionIDs;
//			
//		}finally {
//			if(resultSet!=null) {
//				resultSet.close();
//			}
//			if(preparedStatement!=null) {
//				preparedStatement.close();
//			}
//			if(connection!=null) {
//				connection.close();
//			}
//		}
//	}
	
	
	
	
}