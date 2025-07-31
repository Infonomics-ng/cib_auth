package AuthService.controllers;

import AuthService.dtos.requests.PostApprovalRouteRequest;
import AuthService.dtos.requests.PutApprovalRouteRequest;
import AuthService.dtos.responses.ApprovalRouteResponse;
import AuthService.services.ApprovalRouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approval-routes")
@RequiredArgsConstructor
public class ApprovalRouteController {
    @Autowired
    private final ApprovalRouteService approvalRouteService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody PostApprovalRouteRequest dto) {
        approvalRouteService.createApprovalRoute(dto);
        return ResponseEntity.ok("Approval route created");
    }

    @GetMapping
    public ResponseEntity<List<ApprovalRouteResponse>> getAllApprovalRoutes() {
        return ResponseEntity.ok(approvalRouteService.getAllApprovalRoutes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprovalRouteResponse> getApprovalRouteById(@PathVariable Long id) {
        return ResponseEntity.ok(approvalRouteService.getApprovalRouteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody PutApprovalRouteRequest dto) {
        approvalRouteService.updateApprovalRoute(id, dto);
        return ResponseEntity.ok("Approval route updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        approvalRouteService.deleteApprovalRoute(id);
        return ResponseEntity.noContent().build();
    }
}
