package vo;

import java.sql.Timestamp;

public class RecipeVO {
    int recipeId;
    String thumbnail;
    String title;
    Timestamp writeDate;
    int likes;
    String content;
    String subtitle;
    int comments;
    int levels;
    String nickname;
    int isEditor;
    String userThumb;

    public RecipeVO() {
    }

    public RecipeVO(int recipeId, String thumbnail, String title, Timestamp writeDate, int likes, String content, String subtitle, int comments, int levels, String nickname, int isEditor, String userThumb) {
        this.recipeId = recipeId;
        this.thumbnail = thumbnail;
        this.title = title;
        this.writeDate = writeDate;
        this.likes = likes;
        this.content = content;
        this.subtitle = subtitle;
        this.comments = comments;
        this.levels = levels;
        this.nickname = nickname;
        this.isEditor = isEditor;
        this.userThumb = userThumb;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
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

    public String getUserThumb() {
        return userThumb;
    }

    public void setUserThumb(String userThumb) {
        this.userThumb = userThumb;
    }

    @Override
    public String toString() {
        return "RecipeVO{" +
                "recipeId=" + recipeId +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", writeDate=" + writeDate +
                ", likes=" + likes +
                ", content='" + content + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", comments=" + comments +
                ", levels=" + levels +
                ", nickname='" + nickname + '\'' +
                ", isEditor=" + isEditor +
                ", userThumb='" + userThumb + '\'' +
                '}';
    }
}
