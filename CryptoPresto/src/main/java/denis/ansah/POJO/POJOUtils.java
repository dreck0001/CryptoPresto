package denis.ansah.POJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import denis.ansah.DAO.DAO;

public class POJOUtils {
	public int addUser(int id, String firstname, String lastname, String username, String password, String dateCreated){
        Connection connection = null;
        int result = 0;
        try {
            DAO dao = new DAO();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "INSERT INTO users (id,firstname,lastname,username,password,dateCreated) VALUES (?,?,?,?,?,?)";
            result = queryRunner.update(connection, query, id,firstname,lastname,username,password,dateCreated);
        } catch (Exception e) {
            Logger.getLogger(POJOUtils.class.getName()).log(Level.SEVERE, null, e);
            result =0;
        }
        return result;
    }
	public int updateUser(int id, String firstname, String lastname, String username, String password, String dateCreated){
        Connection connection = null;
        int result = 0;
        try {
            DAO dao = new DAO();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "UPDATE users set firstname = ?, lastname = ?, username = ? where id = ? ";
            result = queryRunner.update(connection, query,firstname,lastname,username, id);
        } catch (Exception e) {
            Logger.getLogger(POJOUtils.class.getName()).log(Level.SEVERE, null, e);
            result =0;
        }
        return result;
    }
	
	public User getUser(String username, String password) {
		Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            DAO dao = new DAO();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<User>> handler = new BeanListHandler<>(User.class);
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            List<User> users = queryRunner.query(connection, query, handler);
            if (!users.isEmpty()) { user = users.get(0); }
        } catch (Exception e) {
            Logger.getLogger(POJOUtils.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        }
        return user;
	}
	
	
//	Bank
	
	public int addBank(int id, int userId, String bankName, String type, int routingNumber, int accountNumber){
        Connection connection = null;
        int result = 0;
        try {
            DAO dao = new DAO();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "INSERT INTO bankAccounts (id,userId,bankName,type,routingNumber,accountNumber) VALUES (?,?,?,?,?,?)";
            result = queryRunner.update(connection, query, id,userId,bankName,type,routingNumber,accountNumber);
        } catch (Exception e) {
            Logger.getLogger(POJOUtils.class.getName()).log(Level.SEVERE, null, e);
            result =0;
        }
        return result;
    }
	
	public List<Bank> getBanks(int userId) {
		Connection connection = null;
        PreparedStatement statement = null;
        List<Bank> banks = null;
        try {
            DAO dao = new DAO();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Bank>> handler = new BeanListHandler<>(Bank.class);
            String query = "SELECT * FROM bankAccounts WHERE userId = " + userId;
            List<Bank> banksReturned = queryRunner.query(connection, query, handler);
            if (!banksReturned.isEmpty()) { banks = banksReturned; }
        } catch (Exception e) {
            Logger.getLogger(POJOUtils.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        }
        return banks;
	}
}
