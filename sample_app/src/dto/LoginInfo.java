package dto;

import java.io.Serializable;

/**
 * ユーザーmodelクラス
 *
 * @author miyata
 */
public class LoginInfo implements Serializable {
	private String loginId;			//ログインID
	private String loginPassword;	//パスワード
	private String userName;		//ユーザー名
	private String isDeleted;		//論理削除フラグ
	private String created;			//登録日時
	private String modified;		//更新日時
	private String createdId;		//登録者ID
	private String modifiedId;		//更新者ID

	/**
	 * ログインID取得
	 *
	 * @return loginId ログインIDを返す
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * パスワード取得
	 *
	 * @return loginPassword パスワードを返す
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * ユーザー名取得
	 *
	 * @return userName ユーザー名を返す
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 論理削除フラグ取得
	 *
	 * @return isDeleted 論理削除フラグを返す
	 */
	public String getDeleteFlag() {
		return isDeleted;
	}

	/**
	 * 登録日時取得
	 *
	 * @return created 登録日時を返す
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * 更新日時取得
	 *
	 * @return modified 更新日時を返す
	 */
	public String getModified() {
		return modified;
	}

	/**
	 * 登録者ID取得
	 *
	 * @return createdId 登録者IDを返す
	 */
	public String getCreatedId() {
		return createdId;
	}

	/**
	 * 更新者ID
	 *
	 * @return modifiedId 更新者IDを返す
	 */
	public String getModifiedId() {
		return modifiedId;
	}

	/**
	 * ログインID設定
	 *
	 * @param loginId
	 * @return なし
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワード設定
	 *
	 * @param loginPassword
	 * @return なし
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * ユーザー名設定
	 *
	 * @param userName
	 * @return なし
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 論理削除フラグ設定
	 *
	 * @param isDeleted
	 * @return なし
	 */
	public void setDeleteFlag(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 登録日時設定
	 *
	 * @param created
	 * @return なし
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * 更新日時設定
	 *
	 * @param modified
	 * @return なし
	 */
	public void setModified(String modified) {
		this.modified = modified;
	}

	/**
	 * 登録者ID設定
	 *
	 * @param createdId
	 * @return なし
	 */
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	/**
	 * 更新者ID設定
	 *
	 * @param modifiedId
	 * @return なし
	 */
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
}