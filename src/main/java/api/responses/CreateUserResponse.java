package api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private boolean success;
    private String accessToken;
    private String refreshToken;
    private User user;
}
