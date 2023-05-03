package com.example.ddd.domain;

// 모든 이벤트가 공통으로 갖는 프로퍼티가 존재한다면 상위 클래스를 만들 수도 있다.
public class Event {

    private long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
