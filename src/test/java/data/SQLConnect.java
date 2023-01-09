package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnect {
    private SQLConnect() {

    }

    private static QueryRunner runner = new QueryRunner();

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static DataHelper.VerificationCode getVerifyCode() {
        var codeSQL = "select\n" +
                "       ac.code,\n" +
                "       ac.created,\n" +
                "       ac.id,\n" +
                "       ac.user_id\n" +
                "from\n" +
                "       auth_codes ac\n" +
                "order by ac.created desc LIMIT 1";
        try (var connect = connect()) {
            var codeRunner = runner.query(connect, codeSQL, new ScalarHandler<String>());
            return new DataHelper.VerificationCode(codeRunner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    public static void clearAllTables() {
        var conn= connect();
        runner.execute(conn,"DELETE FROM card_transactions");
        runner.execute(conn,"DELETE FROM auth_codes");
        runner.execute(conn,"DELETE FROM cards");
        runner.execute(conn,"DELETE FROM users");
    }

}

