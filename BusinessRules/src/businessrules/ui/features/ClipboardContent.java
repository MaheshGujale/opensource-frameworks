package businessrules.ui.features;

public class ClipboardContent {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private String type;
	private Object businessObject;

	public ClipboardContent(String name, int x, int y, int width, int height, String type, Object businessObject) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.setWidth(width);
		this.setHeight(height);
		this.type = type;
		this.businessObject = businessObject;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the businessObject
	 */
	public Object getBusinessObject() {
		return businessObject;
	}

	/**
	 * @param businessObject
	 *            the businessObject to set
	 */
	public void setBusinessObject(Object businessObject) {
		this.businessObject = businessObject;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the height to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}