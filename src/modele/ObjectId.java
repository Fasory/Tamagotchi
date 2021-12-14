package modele;

import java.io.Serializable;
import java.util.UUID;

public abstract class ObjectId implements Serializable {
	
	private final UUID id;
	
	protected ObjectId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
}
