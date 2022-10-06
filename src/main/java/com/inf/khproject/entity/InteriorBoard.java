package com.inf.khproject.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InteriorBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column
    private Long memno;

    @Column(length = 20)
    private String nickName;

    @Column(length = 20)
    private String title;

    @Column(length = 500)
    private String content;



    @Column(length = 20)
    private String category;

    @Column(length = 10)
    private String part;

    @Column
    private int area;

    @Column
    private int cost;

    @Column
    private int period;


    @Column(length = 20)
    private String address;

    @Column(length = 500)
    private String phonenum;

    @Column(length = 50)
    private String email;

    @Column
    @ColumnDefault("1")
    private int view_count;


}
