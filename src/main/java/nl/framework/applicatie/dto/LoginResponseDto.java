package nl.framework.applicatie.dto;

public class LoginResponseDto {

	private long id;
	
	private String token;
	
	public LoginResponseDto() {
		
	}
	
	public LoginResponseDto(long id, String token) {
		super();
		this.id = id;
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
