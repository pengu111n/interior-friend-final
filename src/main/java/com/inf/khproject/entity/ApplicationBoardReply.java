package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "applicationBoard")
public class ApplicationBoardReply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replycontent;

    private String replyer;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationBoard applicationBoard;

}
