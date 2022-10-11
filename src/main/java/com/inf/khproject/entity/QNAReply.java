package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "qna")
public class QNAReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaReplyNo;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private QNA qna;

}
