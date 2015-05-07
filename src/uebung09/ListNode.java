package uebung09;

public class ListNode {

	private Object content;
	private ListNode next = null;
	
	public ListNode(Object content, ListNode next) {
		this.content = content;
		this.next = next;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public ListNode getNext() {
		return this.next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
