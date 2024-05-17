package org.zerock.bo01.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{

    @Id
//  primary key 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  MariaDB autoIncrement
//  Oracle sequence
//    private Long bno;
//    @Column(length = 500, nullable = false)
//    private String title;
//    @Column(length = 2000, nullable = false)
//    private String content;
//    @Column(length = 50, nullable = false)
//    private String writer;
    private Long bno;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)
    private String content;
    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}