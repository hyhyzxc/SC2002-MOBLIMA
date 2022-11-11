package moblima.Entity;

public enum MovieType {
	REGULAR("Regular"),
	BLOCKBUSTER("Blockbuster"), 
	THREED("3D");
	
	/**
	 * MovieType's Name.
	 */
	private String name;
	
	/**
	 * Creates new MovieType with given name
	 * @param name this MovieType's Name.
	 */
	private MovieType(String name) {
		this.name = name;
	}
	
	/**
	 * Gets this MovieType's Name.
	 * @return this MovieType's Name.
	 */
	public String getName() {
		return this.name;
	}
}
