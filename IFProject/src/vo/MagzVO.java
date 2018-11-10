package vo;

import java.sql.Timestamp;

public class MagzVO {
    int magzId;
    String thumbnail;
    String title;
    Timestamp writeDate;
    int likes;
    String content;
    String subtitle;
    int comments;
    String nickname;
    int isEditor;
    String userThumb;

    public MagzVO() {
    }

    public MagzVO(int magzId, String thumbnail, String title, Timestamp writeDate, int likes, String content, String subtitle, int comments, String nickname, int isEditor, String userThumb) {
        this.magzId = magzId;
        this.thumbnail = thumbnail;
        this.title = title;
        this.writeDate = writeDate;
        this.likes = likes;
        this.content = content;
        this.subtitle = subtitle;
        this.comments = comments;
        this.nickname = nickname;
        this.isEditor = isEditor;
        this.userThumb = userThumb;
    }

    public int getMagzId() {
        return magzId;
    }

    public void setMagzId(int magzId) {
        this.magzId = magzId;
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
        return "MagzVO{" +
                "magzId=" + magzId +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", writeDate=" + writeDate +
                ", likes=" + likes +
                ", content='" + content + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", comments=" + comments +
                ", nickname='" + nickname + '\'' +
                ", isEditor=" + isEditor +
                ", userThumb='" + userThumb + '\'' +
                '}';
    }
}
