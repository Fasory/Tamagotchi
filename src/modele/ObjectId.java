package modele;

import java.util.UUID;

public abstract class ObjectId {
	protected UUID id;
	
	protected ObjectId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
}
