package servlet2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2.Mutter2;
import model2.PostMutterLogic2;
import model2.User2;

@WebServlet("/Main2")
public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//つぶやきリストをアプリケーションスコープから取得
		//全ユーザーで利用したいインスタンスはアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter2> mutterList = (List<Mutter2>) application.getAttribute("mutterList");
		//取得できなかった場合（空の場合）は、つぶやきリストを新規作成してアプリケーションスコープに保存
		if(mutterList == null) {
			mutterList = new ArrayList<Mutter2>();
			application.setAttribute("mutterList", mutterList);
		}
		
		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User2 loginUser = (User2) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/nomutter/");   //デフォルトページに戻る
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("main2.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力値チェック
		if(text != null && text.length() != 0) {
			//アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			List<Mutter2> mutterList = (List<Mutter2>) application.getAttribute("mutterList");
			
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User2 loginUser = (User2) session.getAttribute("loginUser");
			
			//つぶやきをつぶやきリストに追加
			Mutter2 mutter = new Mutter2(loginUser.getName(), text);
			PostMutterLogic2 postMutterLogic = new PostMutterLogic2();
			postMutterLogic.execute(mutter, mutterList);
			
			//アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList", mutterList);
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("main2.jsp");
		dispatcher.forward(request, response);
	}
}
