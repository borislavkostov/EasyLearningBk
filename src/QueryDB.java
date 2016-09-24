import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDB
{
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	public static void main(String[] args) throws SQLException
	{
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet result =statement.executeQuery("select info from words");
		ResultSetMetaData resultSetMetadata = result.getMetaData();
		int columCount = resultSetMetadata.getColumnCount();

		while (result.next())
		{
			System.out.println("");
			for (int i = 1; i <= columCount; i++)
			{
				System.out.format("%20s",result.getString(i));
			}
		}
		if(statement != null)statement.close();
		if(connection != null)connection.close();
	}

}
