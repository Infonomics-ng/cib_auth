package AuthService.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostApprovalRouteRequest {

    @NotBlank(message = "Corporate ID is required")
    private String corpId;

    private boolean isGlobalRule;

    private boolean isApproval;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private String createdByUserId;

    private String approvedByUserId;

    private String approvalStatus;

    private String approvalComments;
}
