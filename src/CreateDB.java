import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB
{
	public static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		//connection.createStatement().execute("DROP table words");
		//connection.createStatement().execute("create table words(title varchar(200),info varchar(10000))");
		connection.createStatement().execute("insert into words values ('Икономика','Икономиката се състои от икономическата система на дадена страна или определен регион, работните, капиталовите и земните ресурси, икономическите агенти, които социално участват в производството, обмяната, дистрибуцията и консумирането на стоки и услуги в тази област или регион.')"
				+ ",('Котка','Домашно животно')");
		System.out.println("Done");
	}
}
