package Entities;

public abstract class BaseModel {
	
	private static long idCounter = 0;
	private final long id;
	
	public BaseModel() {
		this.id = generateId();
	}
	
	private static synchronized long generateId() {
        return ++idCounter;
    }

	public long getId() {
		return id;
	}

}
