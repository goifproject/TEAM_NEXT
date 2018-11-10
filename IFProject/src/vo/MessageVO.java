package vo;

public class MessageVO {
	private boolean state;
	private String msg;
	
	public MessageVO() {}
	
	public MessageVO(boolean state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
