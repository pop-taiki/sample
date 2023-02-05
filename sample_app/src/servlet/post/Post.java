package servlet.post;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import dto.LoginInfo;

/**
 * 投稿画面クラス
 *
 * @author miyata
 */
@WebServlet(name = "Post", urlPatterns = {"/Post"})
public class Post extends HttpServlet implements Servlet{
	/**
	 * 投稿画面
	 * まずはセッションが切れていないか確認し、切れていた場合はログイン画面へ
	 * 切れていなかった場合はpost.jspを呼び出し
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
		HttpSession session = request.getSession();		//セッション生成

		//セッションが切れている場合はログイン画面へ遷移
		LoginInfo login = (LoginInfo)session.getAttribute("user");
		if(login == null) {
			response.sendRedirect("./Login");
			return;
		}

		//問題がなければpost.jspへ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/post/post.jsp").forward(request, response);
	}

	/**
	 * 投稿処理
	 * まずはセッションが切れていないか確認し、切れていた場合はログイン画面へ
	 * post.jspのフォームで入力された値を受け取り、Daoクラスの引数に渡してDB挿入
	 * その後、一覧画面へ
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

		//セッションが切れている場合はログイン画面へ遷移
		LoginInfo login = (LoginInfo)session.getAttribute("user");
		if(login == null) {
			response.sendRedirect("./Login");
			return;
		}

		//フォームの値を取得
		request.setCharacterEncoding("UTF-8");				//UTF-8にエンコーディング
		String loginId = login.getLoginId();				//ログインID取得
		String message = request.getParameter("message");	//メッセージ取得

		//Daoパターンでコメントを挿入
		MessageDao dao = new MessageDao();		//Daoクラス生成
		dao.insertMessage(loginId, message);	//挿入処理

		//一覧画面へ遷移
		response.sendRedirect("./List");
	}
}