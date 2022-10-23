package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "applicationBoard")
public class ApplicationBoardChat extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    private String message;

    private String senderid;

    private String sendernickname;

    private String receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationBoard applicationBoard;

}
