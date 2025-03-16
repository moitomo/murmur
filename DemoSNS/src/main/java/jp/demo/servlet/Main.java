package jp.demo.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.demo.model.GetMutterListLogic;
import jp.demo.model.Mutter;
import jp.demo.model.PostMutterLogic;
import jp.demo.model.User;


/**
 * Servlet implementation class Main	
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//投稿リストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList",  mutterList);
		
		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser =(User)session.getAttribute("loginUser");
		
		if (loginUser == null) { //ログインしてないなら
			//indexへリダイレクト
			response.sendRedirect("index.jsp");
		} else { //ログイン済みなら
			//mainへフォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request,  response);
		}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力値チェック
		if(text != null && text.length() !=0) {
			
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//つぶやきを作成してつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","！つぶやきが入力されていません");
		}
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request,  response);
		}
	

}
