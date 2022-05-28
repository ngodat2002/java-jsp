package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.entity.User;
import com.maiyeuem.tdsports.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MYSQLUserModel implements UserModel{

    @Override
    public User save(User user) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into user " +
                    "(id, name,email,phone,address,image,password,dob,createdAt,updatedAt,status) "+
                    "values " +
                    "(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getImage());
            preparedStatement.setString(7,user.getPassword());
            preparedStatement.setString(8,user.getDob().toString());
            preparedStatement.setString(9,user.getCreatedAt().toString());
            preparedStatement.setString(10,user.getUpdatedAt().toString());
            preparedStatement.setInt(11,user.getStatus());
            System.out.println("Connection success");
            preparedStatement.execute();
            return  user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> list =  new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from user where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String email =resultSet.getString("email");
                String phone =resultSet.getString("phone");
                String address =resultSet.getString("address");
                String image =resultSet.getString("image");
                String password =resultSet.getString("password");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());

                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                User user = new User(id,name,email,phone,address,image,password,dob,createdAt,updatedAt,status);
                list.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from user where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString("name");
                String email =resultSet.getString("email");
                String phone =resultSet.getString("phone");
                String address =resultSet.getString("address");
                String image =resultSet.getString("image");
                String password =resultSet.getString("password");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());

                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                user = new User(id,name,email,phone,address,image,password,dob,createdAt,updatedAt,status);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(int id, User updateUser) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update user " +
                    "set id = ?, name = ?, email = ?, phone = ?, address = ?, image = ?, password = ? , dob = ? , createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,updateUser.getId());
            preparedStatement.setString(2,updateUser.getName());
            preparedStatement.setString(3,updateUser.getEmail());
            preparedStatement.setString(4,updateUser.getPhone());
            preparedStatement.setString(5,updateUser.getAddress());
            preparedStatement.setString(6,updateUser.getImage());
            preparedStatement.setString(7,updateUser.getPassword());
            preparedStatement.setString(8,updateUser.getDob().toString());
            preparedStatement.setString(9,updateUser.getCreatedAt().toString());
            preparedStatement.setString(10,updateUser.getUpdatedAt().toString());
            preparedStatement.setInt(11,updateUser.getStatus());
            preparedStatement.setInt(12,id);
            System.out.println("Connection success");
            return updateUser;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection =  ConnectionHelper.getConnection();
            String sqlQuery = "update user " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,-1);
            preparedStatement.setInt(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
