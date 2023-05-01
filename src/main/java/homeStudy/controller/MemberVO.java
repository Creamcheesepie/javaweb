package homeStudy.controller;

public class MemberVO {
	private int idx;
	private String mid;
	private String pwd;
	private String name;
	private String nickName;
	private String createDate;
	private String lastLoginDate;
	private int totalLoginCount;
	private int point;
	private String memberGrade;
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public int getTotalLoginCount() {
		return totalLoginCount;
	}
	public void setTotalLoginCount(int totalLoginCount) {
		this.totalLoginCount = totalLoginCount;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", mid=" + mid + ", pwd=" + pwd + ", name=" + name + ", nickName=" + nickName
				+ ", createDate=" + createDate + ", lastLoginDate=" + lastLoginDate + ", totalLoginCount="
				+ totalLoginCount + ", point=" + point + ", memberGrade=" + memberGrade + "]";
	}
	

}
