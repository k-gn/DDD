package com.example.ddd.domain.order;

public class Store {

    // 애그리거트를 팩토리로 사용할 수 있다.
    // 애그리거트가 가진 데이터를 이용해 다른 애그리거트를 생성해야 한다면, 이러한 패턴을 고려해보자.
    // 다른 많은 정보로 생성해야 한다면, 여기서 ProductFactory 같은 다른 클래스에 위임 시켜도 된다.
    public Product createProduct(Long id) {
        // ...
        return new Product();
    }
}
