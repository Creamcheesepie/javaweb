package homeStudy.pageProcess;

public class HsBoardVO {
	private int idx;
	private String mid;
	private int deletekey;
	private String title;
	private String article;
	private String createDate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getDeletekey() {
		return deletekey;
	}
	public void setDeletekey(int deletekey) {
		this.deletekey = deletekey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", mid=" + mid + ", deletekey=" + deletekey + ", title=" + title + ", article="
				+ article + ", createDate=" + createDate + ", getIdx()=" + getIdx() + ", getMid()=" + getMid()
				+ ", getDeletekey()=" + getDeletekey() + ", getTitle()=" + getTitle() + ", getArticle()=" + getArticle()
				+ ", getCreateDate()=" + getCreateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
