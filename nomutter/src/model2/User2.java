package model2;

import java.io.Serializable;       //オブジェクトはそのままストリームに書き出して読み込むことが出来ないので、読み書きできる形に変換する

//Serializableインターフェース（接点）をimplement（実装）する
//親インターフェースで未定だった各メソッドの内容をオーバーライドして実装し確定させる。この場合、Serializableをオーバーライドしてnameとpassを実装する
//implementsは曖昧なクラスを継承、extendsは具体的なクラスを継承、と一旦理解しておく
//なお、implementsを使用するのはそのクラス全体で実装する場合のみ。一部のメソッドで使用するだけの場合は必要なし
public class User2 implements Serializable {
	private String name;         //カプセル化しておく
	private String pass;         //カプセル化しておく
	
	public User2() {}     //引数を持たないUser()メソッドから呼び出された場合
	public User2(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
}
