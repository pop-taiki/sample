package servlet.list;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import dto.LoginInfo;
import dto.MessageInfo;

/**
 * 一覧画面クラス
 *
 * @author miyata
 */
@WebServlet(name = "List", urlPatterns = {"/List"})
public class List extends HttpServlet implements Servlet {
	/**
	 * 一覧画面
	 * まずはセッションが切れていないか確認し、切れていた場合はログイン画面へ
	 * Daoクラスでメッセージ情報を全て検索してリクエストに保存しlist.jsp呼び出し
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @return なし
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();		//セッションを生成

		//セッションが切れている場合はログイン画面へ遷移
		LoginInfo login = (LoginInfo)session.getAttribute("user");
		if(login == null) {
			response.sendRedirect("./Login");
			return;
		}

		//Daoパターンでメッセージを取得
		MessageDao dao = new MessageDao();		//メッセージ情報Daoクラス生成
		ArrayList<MessageInfo> messageInfos = dao.findAll();	//メッセージを全て検索
		request.setAttribute("messages", messageInfos);			//リクエストにメッセージ情報保存

		//list.jspへ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/list/list.jsp").forward(request, response);
	}

	/**
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @return なし
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	}
}