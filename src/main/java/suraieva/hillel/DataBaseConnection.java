package suraieva.hillel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    static String user = "root";
    static String password = "rootroot";
    static String connectionURI = "jdbc:mysql://localhost:3306/lessons_with_homeworks";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = getMyConnection(connectionURI, user, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into lessons_with_homeworks.lessons (name, homework_id) values (lesson.getName(),1)");

        /*statement.executeUpdate("CREATE TABLE IF NOT EXISTS lessons " +
                "(id INT NOT NULL AUTO_INCREMENT," +
                " name CHAR(20) NOT NULL, " +
                "updatedAT DATE," +
                "homework_id INT, " +
                "PRIMARY KEY (id))");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS homeworks " +
                "(id INT NOT NULL AUTO_INCREMENT, " +
                "name CHAR(20) NOT NULL," +
                "description CHAR(30)," +
                " PRIMARY KEY (id) )");*/

        //closeConnection(connection);
    }



    public static Connection getMyConnection(String connectionURI, String user, String password ) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(connectionURI, user, password);
        System.out.println("Connected");

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
        System.out.println("Disconnected");
    }
}
