package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOModel {
    public int getTotalProduct(){
        try {
            String query = "select count(*) from products";
            Connection connectionHelper = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connectionHelper.prepareCall(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        DAOModel dao = new DAOModel();
        int count = dao.getTotalProduct();
        System.out.println(count);
    }
}
