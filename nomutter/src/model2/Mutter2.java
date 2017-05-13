package model2;

import java.io.Serializable;

public class Mutter2 implements Serializable {
	private String userName;       //カプセル化しておく
	private String text;           //カプセル化しておく
	
	public Mutter2() {}     //引数を持たないMutter()メソッドから呼び出された場合
	public Mutter2(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
}
