package com.ll.sbb_misson_1.answer;

import com.ll.sbb_misson_1.question.Question;
import com.ll.sbb_misson_1.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}") // @GetMapping 과 동일한 역할을 하지만 POST 요청만 받음
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        // @RequestParam String content 답변으로 입력한 내용(content)를 얻기 위해 추가
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s",id);
    }
}
