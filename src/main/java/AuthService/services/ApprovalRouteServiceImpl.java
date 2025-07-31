package AuthService.services;

import AuthService.dtos.requests.PostApprovalRouteRequest;
import AuthService.dtos.requests.PutApprovalRouteRequest;
import AuthService.dtos.responses.ApprovalRouteResponse;
import AuthService.entites.ApprovalRoute;
import AuthService.repositories.ApprovalRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApprovalRouteServiceImpl implements ApprovalRouteService {

    private final ApprovalRouteRepository repository;

    @Override
    public void createApprovalRoute(PostApprovalRouteRequest request) {
        ApprovalRoute entity = mapToEntity(request);
        mapToDto(repository.save(entity));
    }

    @Override
    public List<ApprovalRouteResponse> getAllApprovalRoutes() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApprovalRouteResponse getApprovalRouteById(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("ApprovalRoute not found"));
    }

    @Override
    public void updateApprovalRoute(Long id, PutApprovalRouteRequest request) {
        ApprovalRoute existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ApprovalRoute not found"));

        existing.setCorpId(request.getCorpId());
        existing.setGlobalRule(request.isGlobalRule());
        existing.setApproval(request.isApproval());
        existing.setStartAmount(request.getStartAmount());
        existing.setEndAmount(request.getEndAmount());
        existing.setCreatedByUserId(request.getCreatedByUserId());
        existing.setApprovedByUserId(request.getApprovedByUserId());
        existing.setApprovalStatus(request.getApprovalStatus());
        existing.setApprovalComments(request.getApprovalComments());

        mapToDto(repository.save(existing));
    }

    @Override
    public void deleteApprovalRoute(Long id) {
        repository.deleteById(id);
    }

    // === Mapping Methods ===

    private ApprovalRouteResponse mapToDto(ApprovalRoute entity) {
        return ApprovalRouteResponse.builder()
                .id(entity.getId())
                .corpId(entity.getCorpId())
                .isGlobalRule(entity.isGlobalRule())
                .isApproval(entity.isApproval())
                .startAmount(entity.getStartAmount())
                .endAmount(entity.getEndAmount())
                .createdByUserId(entity.getCreatedByUserId())
                .approvedByUserId(entity.getApprovedByUserId())
                .approvalStatus(entity.getApprovalStatus())
                .approvalComments(entity.getApprovalComments())
                .build();
    }

    private ApprovalRoute mapToEntity(PostApprovalRouteRequest request) {
        return ApprovalRoute.builder()
                .corpId(request.getCorpId())
                .isGlobalRule(request.isGlobalRule())
                .isApproval(request.isApproval())
                .startAmount(request.getStartAmount())
                .endAmount(request.getEndAmount())
                .createdByUserId(request.getCreatedByUserId())
                .approvedByUserId(request.getApprovedByUserId())
                .approvalStatus(request.getApprovalStatus())
                .approvalComments(request.getApprovalComments())
                .build();
    }
}
