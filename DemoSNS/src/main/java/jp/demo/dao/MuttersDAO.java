package jp.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.demo.model.Mutter;



/**
 * MUTTERSテーブルを担当するDAO
 * 全レコード取得とレコード追加のメソッドを持つ
 */

public class MuttersDAO {
	//データベース接続に使用する情報
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/murmur?characterEncoding=UTF-8";//スキーマ名注意
	private final String DB_USER = "root";
	private final String DB_PASS = "adminadmin";
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		//JDBCドライバを読み込む
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){
			
			//SELECT文の準備
			String sql = "SELECT ID, NAME,TEXT FROM MUTTERS ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			
			//SELECT文の結果をArryListに格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // 失敗時も空のリストを返す
			
		}
		return mutterList;
	}
	/**
	 * javadocに説明が入れられるよここがタイトル的なとこ
	 * @param mutter
	 * @return
	 */
	public boolean create(Mutter mutter) {
		//JDBCドライバを読み込む
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER, DB_PASS)) {
					
					//INSERT文の準備
					String sql ="INSERT INTO MUTTERS(NAME,TEXT) VALUES(?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,mutter.getUserName());
					pStmt.setString(2,mutter.getText());
					
					//INSERT文を実行
					int result = pStmt.executeUpdate();
					return result == 1;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("データベースエラー: " + e.getMessage(), e);
				}
				
	}
			
}
