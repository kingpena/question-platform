package com.demo.question_platform.question;

import com.demo.question_platform.Exception.NotFoundException;
import com.demo.question_platform.vote.VoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Long> createQuestion(@RequestBody Question question) {
        Long id = questionService.insertQuestion(question);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        Question question = questionService.getQuestion(id)
                .orElseThrow(() -> new NotFoundException("Question not found"));
        return ResponseEntity.ok(question);
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<VoteResponse> vote(@PathVariable Long id, @RequestParam Long answerId) {
        VoteResponse response = questionService.vote(id, answerId);
        return ResponseEntity.ok(response);
    }
}

