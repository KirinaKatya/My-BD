package net.codejava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import org.h2.jdbcx.JdbcDataSource;
import java.sql.ResultSet;
 
public class Programm {

	public static void main(String[] args) throws SQLException {
	    Connection connection = DriverManager.getConnection("jdbc:h2:~/mybd", "sa", "");

	    Statement st = connection.createStatement();

	    st.execute("DROP TABLE CHARACTERS IF EXISTS");
	    st.execute("CREATE TABLE CHARACTERS(ID INT PRIMARY KEY, NAME VARCHAR(255), TALENT VARCHAR(255), ELEMENT VARCHAR(255)) ;");

	    st.execute("INSERT INTO CHARACTERS VALUES(1, 'Qiqi', 'Skill', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(2, 'Eula', 'Normal Attack', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(3, 'Bennet', 'Elemental Burst', 'Pyro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(4, 'Albedo', 'Skill', 'Geo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(5, 'Al Haitham', 'Elemental Burst', 'Dendro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(6, 'Ayaka', 'Normal Attack', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(7, 'Ayato', 'Skill', 'Gydro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(8, 'Hiangling', 'Elemental Burst', 'Pyro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(9, 'Mona', 'Elemental Burst', 'Gydro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(10, 'Ganyu', 'Normal Attack', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(11, 'Ayaka', 'Skill', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(12, 'Ayaka', 'Elemental Burst', 'Cryo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(13, 'Kazuha', 'Skill', 'Anemo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(14, 'Kazuha', 'Elemental Burst', 'Anemo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(15, 'Tignari', 'Normal Attack', 'Dendro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(16, 'Diluc', 'Skill', 'Pyro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(17, 'Jean', 'Elemental Burst', 'Anemo');");
	    st.execute("INSERT INTO CHARACTERS VALUES(18, 'Razor', 'Normal Attack', 'Electro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(19, 'Hu Tao', 'Skill', 'Pyro');");
	    st.execute("INSERT INTO CHARACTERS VALUES(20, 'Xiao', 'Elemental Burst', 'Anemo');");
	    

	    ResultSet result = st.executeQuery("SELECT * FROM CHARACTERS");

	    System.out.println("Initial DataBase of characters in Genshin:");
	    printResultSet(result);

	    result = st.executeQuery("SELECT * FROM CHARACTERS WHERE NAME = 'Ayaka'");

	    System.out.println("\nEnter only 'Ayaka':");
	    printResultSet(result);
	    
	    result = st.executeQuery("SELECT * FROM CHARACTERS WHERE TALENT = 'Normal Attack'");
	    
	    System.out.println("\nEnter only 'Normal Attack':");
	    printResultSet(result);
	    
	    result = st.executeQuery("SELECT * FROM CHARACTERS WHERE ELEMENT = 'Pyro'");
	    
	    System.out.println("\nEnter only 'Pyro':");
	    printResultSet(result);
	}
	    
	public static void printResultSet(ResultSet result) throws SQLException {
	    String id, name, talent, element;
	    System.out.printf("%3s | %-15s | %-20s | %-10s \n", "ID", "NAME", "TALENT", "ELEMENT");
	    while (result.next()) {
	        id = result.getString("ID");
	        name = result.getString("NAME");
	        talent = result.getString("TALENT");
	        element = result.getString("ELEMENT");

	        System.out.printf("%3s | %-15s | %-20s | %-10s \n", id, name, talent, element);
	    }
	}
}