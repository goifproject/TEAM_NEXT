package vo;

public class MagzListVO {
    int magzId;
    String thumbnail;
    String title;
    String writer;
    String subtitle;
    int isEditor;
    int comments;
    int likes;

    public MagzListVO() {
    }

    public MagzListVO(int magzId, String thumbnail, String title, String writer, String subtitle, int isEditor, int comments, int likes) {
        this.magzId = magzId;
        this.thumbnail = thumbnail;
        this.title = title;
        this.writer = writer;
        this.subtitle = subtitle;
        this.isEditor = isEditor;
        this.comments = comments;
        this.likes = likes;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getIsEditor() {
        return isEditor;
    }

    public void setIsEditor(int isEditor) {
        this.isEditor = isEditor;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "MagzListVO{" +
                "magzId=" + magzId +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", isEditor=" + isEditor +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}