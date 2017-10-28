package demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO (Data Transfer Object)
 * 1. Entity -> DTO class (service layer) -> REST API -> Frontend
 * UserEntity (id, username, password, firstName, lastName) -> User (DTO) (id, username, password) -> REST API -> client
 * 2. Client -> backend -> service layer -> repository -> persistence
 * User (DTO) (userId, username, address) -> service layer (convert to appropriate entities/dto) -> repository persist entities
 */

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CurrentPosition {

    private String runningId;
    private Point location;
    private RunnerStatus runnerStatus = RunnerStatus.NONE;
    private Double speed;
    private Double heading;
    private MedicalInfo medicalInfo;

}
