package xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by RzayevNM on 23-Jul-17.
 */
public class XMLReader {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@db_ip:1521:flxdb1", "username", "password");
        CallableStatement callableStatement = null;
        File folder = new File("C:\\Users\\rzayevnm\\Desktop\\2908");

        File[] files = folder.listFiles();

        for (File file : files)
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(":20:")){
                   System.out.println(line + " " + file.getName().toString());
                    String sql = "insert into nijat.mt102files (refno, filename) values (?,?)";
                    callableStatement = connection.prepareCall(sql);
                    callableStatement.setString(1,line);
                    callableStatement.setString(2,file.getName().toString());
                    callableStatement.execute();
                    callableStatement.close();

                }


            }
          //  System.out.println(line);
        }
    }
}
