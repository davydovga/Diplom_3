package api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResponse {
    private boolean success;
    private String accessToken;
    private String refreshToken;
    private User user;
}
