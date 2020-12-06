package denis.ansah.DAO;

import org.apache.commons.dbutils.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    static final String user = "root";
    static final String pass = "oomyoomy";
	static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/CryptoPresto";

    private Connection connection;

    public Connection getConnection() throws Exception {
        try {
            DbUtils.loadDriver(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
        return this.connection;
    }
}
