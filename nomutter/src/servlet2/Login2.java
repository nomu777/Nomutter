package servlet2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2.LoginLogic2;
import model2.User2;

@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメーターを取得する
		//jspに入力された値はパラメーターで取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//User2インスタンスの生成
		User2 user = new User2(name, pass);
		
		//ログイン処理
		LoginLogic2 loginLogic = new LoginLogic2();
		boolean isLogin = loginLogic.execute(user);   //User2内のユーザー情報をexecuteメソッドに渡して呼び出し、結果をisLoginに格納
		
		//ログイン成功時の処理
		if(isLogin) {
			//ユーザー情報をセッションスコープに保存
			//リクエストスコープに保存したインスタンスは、そのリクエスト終了とともに消滅してしまい繰り返しリクエスト出来ないため、セッションスコープに保存する
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);    //左の""内は属性名、右は保存するインスタンスを記述。左の第１引数はString型。
		}
		//次の画面を呼び出す際はフォワードを利用
		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginResult2.jsp");
		dispatcher.forward(request, response);
	}
}

