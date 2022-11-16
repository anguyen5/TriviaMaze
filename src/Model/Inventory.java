package Model;
import java.sql.*;

public abstract class Inventory {
    public String myUrl;
    public Connection conn;
    public String myFileName;

    public Inventory() {
        myUrl = "jdbc:sqlite:";
        conn = null;
        myFileName = "";
    }

    public Inventory(String theFileName) {
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(myUrl);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void createDB(String theFileNameDB) {
        myFileName = myUrl + theFileNameDB;
        try {
            conn = DriverManager.getConnection(myFileName);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("A new database has been created.");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void connection(){
        try {
            // db parameters
            // create a connection to the database
            myFileName = "jdbc:sqlite:Database_QA.db";
            conn = DriverManager.getConnection(myFileName);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableMC() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tableMC (\n"
                + " IDQuest integer PRIMARY KEY,\n"
                + " Category  text NOT NULL,\n"
                + " Question text NOT NULL,\n"
                + " ChoiceA text NOT NULL,\n"
                + " ChoiceB text NOT NULL,\n"
                + " ChoiceC text NOT NULL,\n"
                + " ChoiceD text NOT NULL,\n"
                + " CorrectAnswer text NOT NULL,\n"
                + " capacity real\n"
                + ") ";

        try {
            /* Connection conn = DriverManager.getConnection(myFileName);*/
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("created tableMC");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableTF() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tableTF (\n"
                + " IDQuest text PRIMARY KEY,\n"
                + " Category text NOT NULL,\n"
                + " Question text NOT NULL,\n"
                + " ChoiceA text NOT NULL,\n"
                + " ChoiceB text NOT NULL,\n"
                + " CorrectAnswer text NOT NULL,\n"
                + " capacity real\n"
                + ");";

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("created tableTF");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createTableSA() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tableSA (\n"
                + " IDQuest text PRIMARY KEY,\n"
                + " Category text NOT NULL,\n"
                + " Question text NOT NULL,\n"
                + " CorrectAnswer text NOT NULL,\n"
                + " Hints text  NULL,\n"
                + " capacity real\n"
                + ");";

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("created tableSA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void insertTableMC();
    public abstract void insertTableTF();
    public abstract void insertTableSA();

}
