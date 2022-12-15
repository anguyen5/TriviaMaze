package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
/**
 * @author: An Nguyen
 * @version: 10/29/2022
 *
 */

/**
 * QASA class get questions, get correct answers, get hints for short answer question.
 */
public class QASA extends QA implements Serializable {
    Connection myConn;
    private String myQuesSA;
    private String myCorrAnsSA;
    private String myHint;

    private String myCategory;
    private int myId;

    public QASA(String theCate, int theId) {
        myCategory = theCate;
        myId = theId;
        connect();
    }

    public  QASA() {
        myQuesSA = "";
        myCorrAnsSA = "";
        myHint = "";
        myConn = null;
        connect();

    }

    private Connection connect() {
        String url = "jdbc:sqlite:Database_QA.db";

        try {
            myConn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return myConn;
    }

    public String getQuestion(String theCategory, int theId){
        myCategory = theCategory;
        myId = theId;
        String sql = "SELECT IDQuest, Category, Question "
                + "FROM tableSA WHERE IDQuest = ? AND Category = ?";
        String question = "";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, theId);
            pstmt.setString(2, theCategory);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                question = rs.getString("Question");
            }

            myQuesSA = question;
            return question;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return question;
    }

    public String getAnswer(String theCategory, int theId){
        myCategory = theCategory;
        myId = theId;
        String sql = "SELECT IDQuest,Category, CorrectAnswer "
                + "FROM tableSA WHERE IDQuest = ? AND Category = ?";
        String corrAns = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, theId);
            pstmt.setString(2, theCategory);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                corrAns = rs.getString("CorrectAnswer");
            }

            myCorrAnsSA = corrAns;
            return corrAns;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return corrAns;
    }


    public String getHintSA(String theCategory, int theId){
        String sql = "SELECT IDQuest,Category,Hints "
                + "FROM tableSA WHERE IDQuest = ? AND Category = ?";
        String hint = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, theId);
            pstmt.setString(2, theCategory);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                hint = rs.getString("Hints");
                myHint = hint;
            }

            return hint;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hint;
    }
}
