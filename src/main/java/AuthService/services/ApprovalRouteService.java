package AuthService.services;

import AuthService.dtos.requests.PostApprovalRouteRequest;
import AuthService.dtos.requests.PutApprovalRouteRequest;
import AuthService.dtos.responses.ApprovalRouteResponse;

import java.util.List;

public interface ApprovalRouteService {
    void createApprovalRoute(PostApprovalRouteRequest dto);
    List<ApprovalRouteResponse> getAllApprovalRoutes();
    ApprovalRouteResponse getApprovalRouteById(Long id);
    void updateApprovalRoute(Long id, PutApprovalRouteRequest dto);
    void deleteApprovalRoute(Long id);
}
