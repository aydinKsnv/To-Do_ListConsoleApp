package Service;

import Repository.TaskRepo;
import com.sun.source.util.TaskEvent;
import enums.TaskStatus;

import java.sql.*;

public class TaskService {


    public void saveTask(String description) {
        Connection connection = TaskRepo.createConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("insert into todotasks (isDone, description) values ('"+ TaskStatus.IN_PROGRESS.name() +"', '" + description + "')");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }



    public void showTask(){
        Connection connection = TaskRepo.createConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select case " +
                    "when isdone = '"+ TaskStatus.IN_PROGRESS +"' then '[Не выполено]'" +
                    "when isdone = '"+ TaskStatus.DONE +"' then '[Выполнено]' " +
                    "else isdone end as isdone, description" +
                    "from todotasks " +
                    "where isdone <> '"+ TaskStatus.DELETED.name() +"'");
            while (resultSet.next()){
                System.out.println(resultSet.getString("isdone") + " " + resultSet.getString("description"));
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void deleteTask(int id) {
        Connection connection = TaskRepo.createConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("update todotasks set isdone = '"+ TaskStatus.DELETED.name() +"' where isdone = '" + TaskStatus.IN_PROGRESS.name() + "' or isdone = '" + TaskStatus.DONE.name() + "' and  id = '"+ id +"'");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void editTask(int id, String newDescription){
        Connection connection = TaskRepo.createConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("update todotasks set description = '"+ newDescription +"' where id = '"+ id +"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void finishTask(int id){
        Connection connection = TaskRepo.createConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("update todotasks set isdone = '"+ TaskStatus.DONE.name() +"' where id = '"+ id +"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


