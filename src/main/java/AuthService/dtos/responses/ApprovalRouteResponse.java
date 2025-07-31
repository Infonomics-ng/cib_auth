package AuthService.dtos.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalRouteResponse {
    public Long id;
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
