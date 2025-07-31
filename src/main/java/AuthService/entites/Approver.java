package AuthService.entites;

import AuthService.entites.ApprovalGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "approvers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Approver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Corporate ID is required")
    private String corpId;

    @NotBlank(message = "User ID is required")
    private String userId;  // Reference to the user acting as approver

    private String jobTitle;

    private String department;

    private boolean isActive = true;

    private String createdBy;

    private String approvedBy;

    private String approvalStatus;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_group_id")
    private ApprovalGroup approvalGroup;
}
