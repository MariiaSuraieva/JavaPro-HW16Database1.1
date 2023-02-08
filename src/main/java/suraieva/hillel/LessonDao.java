package suraieva.hillel;

import java.sql.*;
import java.util.ArrayList;

import static suraieva.hillel.DataBaseConnection.*;

public class LessonDao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Lesson lesson1 = new Lesson(1, "Знайомство з курсом", 1);
        Lesson lesson2 = new Lesson(2,"Инкапсуляция", 2);
        PreparedStatement ps = getOurPreparedStatement(getMyConnection(connectionURI,user,password));
        //lessonAdd(lesson1, ps);
        //lessonAdd(lesson2, ps);
        /*System.out.println(
                lessonGetById(2, ps)
        );*/
        /*System.out.println(
                lessonGetAll(ps)
        );*/
        //lessonDrop(2,ps);


    }

    public static void lessonAdd(Lesson lesson, PreparedStatement ps) throws SQLException{
        ps.setInt(1, 2);
        ps.setString(2, lesson.getName());
        ps.setString(3, "23.10.24");
        ps.setInt(4, lesson.getHomeworkId());
        ps.executeUpdate();

    }

    public static void lessonDrop(int lessonId, PreparedStatement ps) throws SQLException{
        ps.executeUpdate("delete from lessons where id= " + lessonId);
    }

    public static ArrayList<Lesson> lessonGetAll(PreparedStatement ps) throws SQLException{
        ArrayList<Lesson> lessonsArray = new ArrayList();
        ResultSet resultSet = ps.executeQuery("select id, name, homework_id from lessons");

        while (resultSet.next()) {
            Lesson lesson = new Lesson(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3));
            lessonsArray.add(lesson);
        }

        return lessonsArray;
    }


    public static Lesson lessonGetById(int lessonId, PreparedStatement ps) throws SQLException{
        ResultSet resultSet = ps.executeQuery("select id, name, homework_id from lessons");
        Lesson lesson1 = null;
        while (resultSet.next()) {
            lesson1 = new Lesson(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3));
            if(resultSet.getInt(1) == lessonId) break;
        }
        return lesson1;
    }

    public static PreparedStatement getOurPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement("INSERT INTO lessons" +
                "(id, name, updatedAT, homework_id) VALUES" +
                "(?,?,?,?);");
    }
}
