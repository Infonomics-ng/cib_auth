package AuthService.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "approval_groups")
@Data
@AllArgsConstructor
@Builder
public class ApprovalGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Corporate ID is required")
    private String corpId;

    @Column(nullable = false)
    private Boolean isApproval;

    private Boolean isGlobalRule;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private String createdByUserId;

    private String approvedByUserId;

    private String approvalStatus;

    private String approvalComments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "approval_group_approvers",
            joinColumns = @JoinColumn(name = "approval_group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> approvers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "approval_route_id")
    private ApprovalRoute approvalRoute;
}
