package cn.wolfcode.rbac.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    private Long id;

    private String name;

    private String sn;
}