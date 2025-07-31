package AuthService.clients;

import AuthService.entites.Corporate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "foundation", url="http://localhost:8081")
public interface CorporateClient {
    @GetMapping("/corporate/{corpId}")
    Corporate getCorpByCorpId(@PathVariable("corpId") Long corpId);
}
