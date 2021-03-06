package com.company.db;
import com.company.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;


public class FullInfoConnector {
    private  static  final String SELECT_ALL="select * from flight f join cities c on f.citi_to_id=c.id join airplanes a on f.airplane_id=a.id";
    public  static List<Flight> getAll() throws SQLException{

        List<Flight> result= new ArrayList<>();
        Connection connection= DbConnector.getConnection();
        try
            (PreparedStatement statement=connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet=statement.executeQuery();
                 ){
            while (resultSet.next()){
                System.out.println("День:"+resultSet.getDate("day")+"-"+" Время:"+resultSet.getTime("date_time")
                        +"-"+resultSet.getInt("citi_from_id")
                        +"-"+resultSet.getInt("citi_to_id")
                        +"-"+resultSet.getInt("airplane_id")+
                        "-"+" Город:"+resultSet.getString("name")+
                        "-"+" Модель:"+resultSet.getString("model"));
            }
        }


        return result;
    }

}
