package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.MessageInfo;

/**
 * メッセージ情報のDaoクラス
 *
 * @author miyata
 *
 */
public class MessageDao {
	private static final String url = "jdbc:mysql://localhost/sample_app?useUnicode=true&characterEncoding=utf8";	//接続文字列
	private static final String user = "root";			//接続ユーザー
	private static final String password = "root";		//接続パスワード

	private static Connection conn = null;				//Connectionクラス
	private static PreparedStatement pstmt = null;		//Statementクラス
	private static ResultSet rs = null;					//ResultSetクラス

	/**
	 * 全てのメッセージを降順に取得
	 *
	 * @return メッセージ
	 */
	public ArrayList<MessageInfo> findAll() {
		ArrayList<MessageInfo> messageInfos = new ArrayList<MessageInfo>();		//メッセージmodel

		//SQL文
		//ログイン情報とメッセージ情報のログインIDが一致するレコードの
		//ユーザー名/コメント/投稿日のレコードを降順に取得
		String sql =
				"SELECT l.user_name, m.message, m.posted " +
				"FROM login_info l JOIN message_info m " +
				"ON l.login_id=m.login_id " +
				"ORDER BY m.posted DESC";

		/*
		 * DB接続/参照/終了
		 * メッセージ情報を取得
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); 	//ドライバクラスのロード

			conn = DriverManager.getConnection(url, user, password);	//Connectionクラス生成
			pstmt = conn.prepareStatement(sql);			//Statementクラス生成
			rs = pstmt.executeQuery();					//ResultSetクラス生成

			//検索結果が見つかった場合
			while(rs.next()){
				//レコード取得
				MessageInfo message = new MessageInfo();
				message.setUserName(rs.getString("user_name"));		//ユーザー名を取得
				message.setMessage(rs.getString("message"));		//コメントを取得
				String posted = rs.getString("posted");				//投稿日を取得
				message.setPosted(formatDate(posted));				//日付をフォーマット
				//messagesに追加
				messageInfos.add(message);
			}
		} catch(SQLException e) {
		} catch (ClassNotFoundException e) {
		} catch (ParseException e) {
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

		return messageInfos;
	}

	/**
	 * 投稿されたコメントをメッセージ情報に挿入
	 *
	 * @param loginId
	 * @param message
	 * @return なし
	 */
	public void insertMessage(String loginId, String message) {
		//SQL文
		//メッセージ情報を挿入
		String sql =
				"INSERT INTO message_info VALUES(?, ?, sysdate(), 0, sysdate(), sysdate(), ?, ?)";

		/*
		 * DB接続/挿入/終了
		 * メッセージ挿入
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); 			//ドライバクラスのロード

			conn = DriverManager.getConnection(url, user, password);	//Connectionクラス生成
			pstmt = conn.prepareStatement(sql);		//PreparedStatementクラス生成
			pstmt.setString(1, loginId);			//1番目のパラメータ(投稿者ID)を設定
			pstmt.setString(2, message);			//2番目のパラメータ(コメント)を設定
			pstmt.setString(3, loginId);			//3番目のパラメータ(登録者ID)を設定
			pstmt.setString(4, loginId);			//4番目のパラメータ(更新者ID)を設定
			pstmt.executeUpdate();					//INSERT文実行
		} catch(SQLException e){
		} catch (ClassNotFoundException e) {
		} finally {
			//終了処理
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
	}

	/**
	 * 日付をyyyy年mm月dd日 HH時mm分にフォーマット
	 *
	 * @param posted
	 * @return posted フォーマットされた日付
	 * @throws ParseException
	 */
	private String formatDate(String posted) throws ParseException {
		//フォーマットパターン指定
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format1.parse(posted);
		//フォーマットパターン変更
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
		posted = format2.format(date);

		return posted;
	}
}