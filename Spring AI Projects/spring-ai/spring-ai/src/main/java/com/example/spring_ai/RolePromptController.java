package com.example.spring_ai;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_ai.service.RolePromptService;
import com.example.spring_ai.service.RoleReviewRequest;

@RestController
@RequestMapping("/api/role")
public class RolePromptController {

    private final RolePromptService rolePromptService;

    public RolePromptController(RolePromptService rolePromptService) {
        this.rolePromptService = rolePromptService;
    }

    @PostMapping("/review")
    public ResponseEntity<String> analyzeReview(
             @RequestBody RoleReviewRequest request) {

        return ResponseEntity.ok(
                rolePromptService.analyzeReview(request)
        );
    }
}