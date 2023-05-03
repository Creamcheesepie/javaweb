package homeStudy.pageProcess;

public class HsBoardVO {
	private int idx;
	private String mid;
	private int deletekey;
	private String title;
	private String article;
	private String createDate;
	private String hostIp;
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
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	
	@Override
	public String toString() {
		return "HsBoardVO [idx=" + idx + ", mid=" + mid + ", deletekey=" + deletekey + ", title=" + title + ", article="
				+ article + ", createDate=" + createDate + ", hostIp=" + hostIp + "]";
	}
	
	
	
}
