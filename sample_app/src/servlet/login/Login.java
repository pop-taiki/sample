package servlet.login;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dto.LoginInfo;

/**
 * ログイン画面クラス
 *
 * @author miyata
 */
@WebServlet(name = "Login", urlPatterns = {"/"})
public class Login extends HttpServlet implements Servlet {
	/**
	 * ログイン画面
	 * login.jspを呼び出して、フォームボタン押下でdoPostメソッドへ
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @return なし
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//login.jspへ遷移
		request.getRequestDispatcher("/WebContent/WEB-INF/jsp/login/login.jsp").forward(request, response);
	}

	/**
	 * ログイン処理
	 * login.jspのフォームの値を受け取り、Daoクラスでログイン情報を検索
	 * ログイン情報が見つからなかった場合はlogin.jspに戻る
	 * ログイン情報が見つかった場合は一覧画面へ
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @return なし
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();		//セッション生成

		//入力フォームの値を取得
		request.setCharacterEncoding("UTF-8");			//UTF-8にエンコーディング
		String loginId       = request.getParameter("loginId");			//ログインID取得
		String loginPassword = request.getParameter("loginPassword");	//ログインPASS取得

		//Daoパターンからログイン情報を取得
		LoginDao dao = new LoginDao();									//Daoクラス生成
		LoginInfo loginInfo = dao.findLogin(loginId, loginPassword);	//入力された値でログイン情報検索

		/*
		 * ログイン情報が取得できなかった場合はリクエストにエラーメッセージを保存して
		 * ログイン画面へ戻る
		 */
		if(loginInfo == null) {
			request.setAttribute("message", "IDまたはパスワードが違います");		//リクエストにログイン実行失敗保存
			request.getRequestDispatcher("/WebContent/WEB-INF/jsp/login/login.jsp").forward(request, response);
			return;
		}

		/*
		 * ログイン情報が取得できた場合はセッションにログインIDとユーザー名を保存して
		 * 一覧画面へ遷移
		 */
		LoginInfo user = new LoginInfo();			//ログインIDとユーザー名のみ格納するクラス
		user.setLoginId(loginInfo.getLoginId());	//ログインIDを格納
		user.setUserName(loginInfo.getUserName());	//ユーザー名を格納
		session.setAttribute("user", user);			//ログイン情報をセッションに保存
		response.sendRedirect("./List");			//一覧画面へ遷移
	}
}