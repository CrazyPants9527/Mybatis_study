package net.togogo.mybatis.page;


public class Page {

	/**
	 * 当前页
	 */
	private int index = 1;

	/**
	 * 每页多少行
	 */
	private int size = 10;

	/**
	 * 总的记录数
	 */
	private int total;

	public Page(int index, int size, int total) {
		super();
		this.index = index;
		this.size = size;
		this.total = total;
	}

	public int start() {
		return (index - 1) * size;
	}

	public int rows() {
		return size;
	}

	public int getStart() {
		return (index - 1) * size;
	}

	public int getRows() {
		return size;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
