package jp.demo.model;

import java.util.List;

import jp.demo.dao.MuttersDAO;

public class GetMutterListLogic {
	public List<Mutter> execute() {
		MuttersDAO dao = new MuttersDAO();// MuttersDAO をインスタンス化
		List<Mutter> mutterList = dao.findAll();// findAll() を呼び出し
		return mutterList;
	}

}
