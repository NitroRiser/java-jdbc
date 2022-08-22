package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                "UPDATE seller SET BaseSalary = BaseSalary + ? "
                + "WHERE (DepartmentId = ?)"
            );

            st.setDouble(1, 200);
            st.setInt(2, 2);
            
            int rows = st.executeUpdate();

            System.out.println("Done! " + rows + " rows affected!");

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
