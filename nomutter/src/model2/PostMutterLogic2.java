package model2;

import java.util.List;

public class PostMutterLogic2 {
	public void execute(Mutter2 mutter, List<Mutter2> mutterList) {
		mutterList.add(0, mutter);    //第一引数で格納位置（インデックス）、第二引数で格納するインスタンスを指定。
	}
}