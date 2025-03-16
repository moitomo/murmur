package jp.demo.model;

import jp.demo.dao.MuttersDAO;

public class PostMutterLogic {

		public void execute(Mutter mutter) {
			MuttersDAO dao = new MuttersDAO(); //DAOで投稿内容を取得
			dao.create(mutter);
		}
	
}
