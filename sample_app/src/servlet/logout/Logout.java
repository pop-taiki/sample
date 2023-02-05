package servlet.logout;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログアウトクラス
 *
 * @author miyata
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet implements Servlet {
	/**
	 * ログアウト画面
	 * セッションを破棄してログイン画面へ
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
		session.invalidate();							//セッション破棄

		//ログイン画面へ遷移
		response.sendRedirect("./Login");
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