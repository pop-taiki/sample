package dto;

import java.io.Serializable;

/**
 * メッセージmodelクラス
 *
 * @author miyata
 */
public class MessageInfo implements Serializable{
	private String loginId;		//ログインID
	private String userName;	//ユーザー名
	private String message;		//コメント
	private String posted;		//投稿日時
	private String isDeleted;	//論理削除フラグ
	private String created;		//登録日時
	private String modified;	//更新日時
	private String createdId;	//登録者ID
	private String modifiedId;	//更新者ID

	/**
	 * ログインID取得
	 *
	 * @return loginId ログインIDを返す
	 */
	public String getLoginId() {
		return loginId;
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
	 * コメント取得
	 *
	 * @return message コメントを返す
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 投稿日時取得
	 *
	 * @return posted 投稿日時を返す
	 */
	public String getPosted() {
		return posted;
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
	 * 更新者ID取得
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
	 * ユーザー名設定
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * コメント設定
	 *
	 * @param message
	 * @return なし
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 投稿日時設定
	 *
	 * @param posted
	 * @return なし
	 */
	public void setPosted(String posted) {
		this.posted = posted;
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