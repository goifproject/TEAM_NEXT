package vo;

public class RecipeListVO {
    int recipeId;
    String thumbnail;
    String title;
    String writer;
    String subtitle;
    int isEditor;
    int comments;
    int likes;

    public RecipeListVO() {
    }

    public RecipeListVO(int recipeId, String thumbnail, String title, String writer, String subtitle, int isEditor, int comments, int likes) {
        this.recipeId = recipeId;
        this.thumbnail = thumbnail;
        this.title = title;
        this.writer = writer;
        this.subtitle = subtitle;
        this.isEditor = isEditor;
        this.comments = comments;
        this.likes = likes;
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
        return "RecipeListVO{" +
                "recipeId=" + recipeId +
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