package vo;

import java.sql.Timestamp;

public class UserVO {
    private int userId;
    private String id;
    private String password;
    private String nickname;
    private int isEditor;
    private Timestamp enterDate;

    public UserVO() { }

    public UserVO(int userId, String id, String password, String nickname, int isEditor, Timestamp enterDate) {
        this.userId = userId;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.isEditor = isEditor;
        this.enterDate = enterDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIsEditor() {
        return isEditor;
    }

    public void setIsEditor(int isEditor) {
        this.isEditor = isEditor;
    }

    public Timestamp getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", isEditor=" + isEditor +
                ", enterDate=" + enterDate +
                '}';
    }
}
