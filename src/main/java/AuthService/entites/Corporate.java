package AuthService.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "corporate")
public class Corporate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long corpId;

    @NotBlank
    @Column(nullable = false)
    private String corporatecd;

    @NotBlank
    @Column(nullable = false)
    private String corporatename;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createddate;

    private String approvedemail;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String companytype;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean active = true;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean soleproprietor = false;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String approvaltype;

    private String creationid;
    private String creationchannel;
    private String createdby;
    private String lastmodifiedby;

    private LocalDateTime lastmodifieddate;

    private Long rmid;
}