package AuthService.entites;

import AuthService.entites.ApprovalGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval_routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String corpId;

    private String approvalRouteId; // Optional external or display ID

    private boolean isGlobalRule;

    private boolean isApproval; // Whether this route requires approval

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private String createdByUserId;

    private String approvedByUserId;

    private String approvalStatus;

    private String approvalComments;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_group_id")
    private ApprovalGroup approvalGroup;

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

}
