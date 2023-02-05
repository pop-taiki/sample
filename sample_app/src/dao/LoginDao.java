package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.LoginInfo;

/**
 * ログイン情報のDaoクラス
 *
 * @author miyata
 *
 */
public class LoginDao {
	private static final String url = "jdbc:mysql://localhost/sample_app";	//接続文字列
	private static final String user = "root";			//接続ユーザー
	private static final String password = "root";		//接続パスワード

	private static Connection conn = null;				//Connectionクラス
	private static PreparedStatement pstmt = null;		//Statementクラス
	private static ResultSet rs = null;					//ResultSetクラス

	/**
	 * 全てのログイン情報を検索
	 *
	 * @return users 検索した全てのログイン情報を取得
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<LoginInfo> findAll() {
		ArrayList<LoginInfo> loginInfos = new ArrayList<LoginInfo>();	//ログイン情報生成

		//SQL文
		//全てのカラム情報を取り出す
		String sql =
				"SELECT login_id, login_password, user_name, is_deleted, created, " +
						"modified, created_id, modified_id " +
				"FROM login_info";

		/*
		 * DB接続/参照/終了
		 * 全てのログイン情報をusersに追加
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); 	//ドライバクラスのロード

			conn = DriverManager.getConnection(url, user, password);	//Connectionクラス生成
			pstmt = conn.prepareStatement(sql);			//Statementクラス生成
			rs = pstmt.executeQuery();					//ResultSetクラス生成

			while(rs.next()) {
				//レコード取得
				LoginInfo login = new LoginInfo();
				login.setLoginId(rs.getString("login_id"));				//ログインIDを取得
				login.setLoginPassword(rs.getString("login_password"));	//パスワードを取得
				login.setUserName(rs.getString("user_name"));			//ユーザー名を取得
				login.setDeleteFlag(rs.getString("is_deleted"));		//論理削除フラグを取得
				login.setCreated(rs.getString("created"));				//登録日時を取得
				login.setModified(rs.getString("modified"));			//更新日時を取得
				login.setCreatedId(rs.getString("created_id"));			//登録者IDを取得
				login.setModifiedId(rs.getString("modified_id"));		//更新者IDを取得
				//usersに追加
				loginInfos.add(login);
			}
		} catch(SQLException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			//終了処理
			//ResultSet終了
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
				rs = null;
			}
			//PreparedStatement終了
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
				pstmt = null;
			}
			//Connection終了
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
				conn = null;
			}
		}

		return loginInfos;
	}

	/**
	 * 入力されたログインID・パスワードからログイン情報を取得
	 *
	 * @param loginId
	 * @param loginPassword
	 * @return user ログインID・パスワード両方とも一致したログイン情報を取得(nullも返す)
	 */
	public LoginInfo findLogin(String loginId, String loginPassword) {
		LoginInfo loginInfo = null;	//モデル

		//SQL文
		//ログインIDとパスワードが一致するレコードを取得
		String sql =
				"SELECT login_id, login_password, user_name, is_deleted, created, modified, " +
						"created_id, modified_id " +
				"FROM login_info " +
				"WHERE login_id=? AND login_password=?";

		/*
		 * DB接続/参照/終了
		 * userに検索条件と一致したログインID・パスワードを格納
		 */
		try{
			Class.forName("com.mysql.jdbc.Driver"); 			//ドライバクラスのロード

			conn = DriverManager.getConnection(url, user, password);	//Connectionクラス生成
			pstmt = conn.prepareStatement(sql);			//PreparedStatementクラス生成
			pstmt.setString(1, loginId);				//1番目のパラメータを設定
			pstmt.setString(2, loginPassword);			//2番目のパラメータを設定
			rs = pstmt.executeQuery();					//ResultSetクラス生成

			//検索結果が見つかった場合
			if(rs.next()) {
				//ユーザー情報取得
				loginInfo = new LoginInfo();
				loginInfo.setLoginId(rs.getString("login_id"));				//ログインIDを設定
				loginInfo.setLoginPassword(rs.getString("login_password"));	//パスワードを設定
				loginInfo.setUserName(rs.getString("user_name"));		//ユーザー名を設定
				loginInfo.setDeleteFlag(rs.getString("is_deleted"));	//論理削除フラグ設定
				loginInfo.setCreated(rs.getString("created"));			//登録日時を設定
				loginInfo.setModified(rs.getString("modified"));		//更新日時を設定
				loginInfo.setCreatedId(rs.getString("created_id"));		//登録者IDを設定
				loginInfo.setModifiedId(rs.getString("modified_id"));	//更新者IDを設定
			}
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			//終了処理
			//ResultSet終了
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
				rs = null;
			}
			//PreparedStatement終了
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
				pstmt = null;
			}
			//Connection終了
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
				conn = null;
			}
		}

		return loginInfo;
	}
}