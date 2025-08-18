import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/patnanasaideekshith";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL);

            Statement statement = conn.createStatement();
//
//             statement.executeUpdate("INSERT INTO student VALUES(1, 'Alice', 'New York')");
//            ResultSet rs1 = statement.executeQuery("SELECT * FROM student");
//            System.out.println("Statement Read:");
//            while (rs1.next()) {
//                System.out.println(rs1.getInt("id") + " " + rs1.getString("name") + " " + rs1.getString("city"));
//            }
//
//             PreparedStatement preparedStatement = conn.prepareStatement(
//                    "INSERT INTO student (id, name, city) VALUES (?, ?, ?)");
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "Bob");
//            preparedStatement.setString(3, "Los Angeles");
//            preparedStatement.executeUpdate();
//
//             PreparedStatement psSelect = conn.prepareStatement("SELECT * FROM student");
//            ResultSet rs2 = psSelect.executeQuery();
//            System.out.println("PreparedStatement Read:");
//            while (rs2.next()) {
//                System.out.println(rs2.getInt("id") + " " + rs2.getString("name") + " " + rs2.getString("city"));
//            }
//
//            CallableStatement callableStatement = conn.prepareCall("{call add_student(?, ?, ?)}");
//            callableStatement.setInt(1, 3);
//            callableStatement.setString(2, "Charlie");
//            callableStatement.setString(3, "Miami");
//            callableStatement.execute();

            ResultSet rs3 = statement.executeQuery("SELECT * FROM student");
            System.out.println("CallableStatement Read:");
            while (rs3.next()) {
                System.out.println(rs3.getInt("id") + " " + rs3.getString("name") + " " + rs3.getString("city"));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
