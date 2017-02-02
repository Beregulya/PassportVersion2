import java.sql.*;

public class Base {

    private final static String URL = "jdbc:mysql://localhost:3306/Passport";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private static int id;

    protected final static String INSERT_NEW = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";
    protected final static String SELECT_ALL = "SELECT * FROM Users";

    public static Connection connectBase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(SELECT_ALL);
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                int res = set.getInt("id");
                if (res > id)
                    id = res;
            }
            id++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int getId() {
        return id;
    }

}
