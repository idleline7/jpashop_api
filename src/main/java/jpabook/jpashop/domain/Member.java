package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @JsonIgnore
    @Embedded
    private Address address;

    //내가 매핑x, 매핑된 것의 거울일 뿐이다 / 양방향 매핑
    @OneToMany(mappedBy = "member") //1대다 관계(Member 입장에서는 하나의 회원이 여러 상품 주문)
    private List<Order> orders = new ArrayList<>(); //만든 컬렉션 손대지x, 처음 생성한 그대로 사용: 필드에서 초기화

}
