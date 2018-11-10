package vo;

import java.sql.Timestamp;

public class RecipeCommentVO {
    int commentId;
    int userId;
    int recipeId;
    String content;
    Timestamp writeTime;
    String nickname;
    int isEditor;
    String thumbnail;

    public RecipeCommentVO() {
    }

    public RecipeCommentVO(int commentId, int userId, int recipeId, String content, Timestamp writeTime, String nickname, int isEditor, String thumbnail) {
        this.commentId = commentId;
        this.userId = userId;
        this.recipeId = recipeId;
        this.content = content;
        this.writeTime = writeTime;
        this.nickname = nickname;
        this.isEditor = isEditor;
        this.thumbnail = thumbnail;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Timestamp writeTime) {
        this.writeTime = writeTime;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "RecipeCommentVO{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", recipeId=" + recipeId +
                ", content='" + content + '\'' +
                ", writeTime=" + writeTime +
                ", nickname='" + nickname + '\'' +
                ", isEditor=" + isEditor +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
