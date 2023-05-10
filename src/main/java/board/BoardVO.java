package board;

public class BoardVO {
	private int idx;
	private String mid;
	private String nickName;
	private String title;
	private String email;
	private String homePage;
	private String content;
	private int readNum;
	private String hostIp;
	private String openSw;
	private String wDate;
	private int good;
	private String goodMember;
	
	private int hour_diff; //시간 차이 계산 필드
	private int date_diff; //날짜 차이 계산 필드
	
	//이전글 / 다음글을 위한 변수 설정
	
	private int preIdx;
	private int nextIdx;
	private String preTitle;
	private String nextTitle;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getOpenSw() {
		return openSw;
	}

	public void setOpenSw(String openSw) {
		this.openSw = openSw;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getHour_diff() {
		return hour_diff;
	}

	public void setHour_diff(int hour_diff) {
		this.hour_diff = hour_diff;
	}


	public int getDate_diff() {
		return date_diff;
	}
	

	public void setDate_diff(int date_diff) {
		this.date_diff = date_diff;
	}


	public int getPreIdx() {
		return preIdx;
	}

	public void setPreIdx(int preIdx) {
		this.preIdx = preIdx;
	}

	public int getNextIdx() {
		return nextIdx;
	}

	public void setNextIdx(int nextIdx) {
		this.nextIdx = nextIdx;
	}

	public String getPreTitle() {
		return preTitle;
	}

	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}

	public String getNextTitle() {
		return nextTitle;
	}

	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}

	public String getGoodMember() {
		return goodMember;
	}

	public void setGoodMember(String goodMember) {
		this.goodMember = goodMember;
	}

	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", mid=" + mid + ", nickName=" + nickName + ", title=" + title + ", email=" + email
				+ ", homePage=" + homePage + ", content=" + content + ", readNum=" + readNum + ", hostIp=" + hostIp
				+ ", openSw=" + openSw + ", wDate=" + wDate + ", good=" + good + ", goodMember=" + goodMember + ", hour_diff="
				+ hour_diff + ", date_diff=" + date_diff + ", preIdx=" + preIdx + ", nextIdx=" + nextIdx + ", preTitle="
				+ preTitle + ", nextTitle=" + nextTitle + "]";
	}
	
		
}
