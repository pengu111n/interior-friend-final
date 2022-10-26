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
@ToString(exclude = "writer")
public class ApplicationBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 20)
    private String username;

    @Column(length = 20)
    private String nickname;


    @Column(length = 20)
    private String title;




    @Column(length = 20)
    private String category;

    @Column(length = 20)
    private String address;

    @Column
    private int area;

    @Column(length = 50)
    private String startDate;

    @Column(length = 50)
    private String endDate;




    @Column(length = 20)
    private int budget;

    @Column(length = 10)
    private String part;

    @Column(length = 500)
    private String required;

    @ManyToOne (fetch = FetchType.LAZY)
    private Member writer;

    @Column
    @ColumnDefault("1")
    private int view_count;




    @Column(columnDefinition = "int default 0")
    private Integer status;

    public void changeStatus(Integer status) {
        this.status = status;
    }

}
