package com.ll.sbb_misson_1.question;

import com.ll.sbb_misson_1.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    // 고유 번호 , id 속성을 기본 키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 데이터를 저장할 때 1씩 자동 증가
    // strategy 고유번호 생성
    // GenerationType.IDENTITY 해당 컬럼만 독립적인 시퀀스 생성
    private Integer id;

    @Column(length = 200)
    // 엔티티 속성 = 테이블 컬럼명, 세부설정을 위해 사용, 길이제한 200
    private String subject;

    @Column(columnDefinition = "TEXT")
    // 속성 정의, 글자 수를 제한할 수 없는 경우 사용
    private String content;

    private LocalDateTime createDate;
    //컬럼명 create_date로 바뀜

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // 질문 하나, 답변 많이
    private List<Answer> answerList;
}
