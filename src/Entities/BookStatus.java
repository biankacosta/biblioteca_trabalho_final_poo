package Entities;

public enum BookStatus {
	DISPONIVEL(1),
	ALUGADO(2),
	INDISPONIVEL(3);
	
	private int code;

	BookStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

}
