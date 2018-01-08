package com.finessy.web.forum.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.connection.JDBCConnection;

public class RelatedQuestionsDAO {
	Connection connection = null;
	Connection con1 = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	PreparedStatement ps1 = null;
	ResultSet rs1 = null;

	
public ArrayList<RelatedQuestionsDTO> findRelatedQuestions(int questionId) throws ClassNotFoundException, SQLException{
		
		ArrayList<RelatedQuestionsDTO> relatedQDetails = new ArrayList<RelatedQuestionsDTO>();
		String name = null;
		
		try {
		connection = JDBCConnection.getConnection();
		con1 = JDBCConnection.getConnection();
		preparedStatement = connection.prepareStatement(QuesAnsSQL.FIND_RELATED_QUESTION_DETAILS);
		ps1 = con1.prepareStatement(QuesAnsSQL.FIND_NAME);
		preparedStatement.setInt(1, questionId);
		resultSet = preparedStatement.executeQuery();
		
		if(!resultSet.isBeforeFirst()) {
			relatedQDetails.add(null);
			return relatedQDetails;
		}
		while(resultSet.next()) {
			if(resultSet.getInt(1)==questionId) {
				continue;
			}
			ps1.setInt(1, resultSet.getInt(3));
			rs1 = ps1.executeQuery();
			while(rs1.next()) {
				 name = rs1.getString(1)+" "+rs1.getString(2);
			}
			RelatedQuestionsDTO dto = new RelatedQuestionsDTO(resultSet.getInt(1),resultSet.getInt(2),name,resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
			relatedQDetails.add(dto);
		}
		return relatedQDetails;
			
		}
		finally {
			JDBCConnection.closeConnection(rs1, ps1, con1);
			JDBCConnection.closeConnection(resultSet, preparedStatement, connection);
			
		}
	}
}

