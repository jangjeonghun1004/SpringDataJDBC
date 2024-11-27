# Spring JDBC API

    JDBC(java Database Connectivity, 자바 데이터베이스 연결)는 
    DB 제작사에 구애받지 않고 RDBMS에 액세스할 수 있도록 표준 API 세트를 제공합니다.

    Spring Boot는 기본적으로 데이터베이스 연결 풀을 지원합니다.(HikariCP가 기본)

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

    # JDBC Template 사용 가능

# Spring Data JDBC

    Spring Data JPA처럼 Repository 인터페이스 기반으로 동작하지만 JPA와 달리 가벼운 객체 매핑과 단순한 구조를 지향합니다.
    
    결론 
    Repository 패턴을 지원한다는 측면에서 보다면 "Spring Data JPA"와 유사하지만 
    모든면에서 "Spring Data JPA"를 사용하는 것보다 좋은점이 없다.


# 예외 처리

    Spring JDBC는 SQL 관련 예외를 스프링 예외로 변환합니다. 
    예: SQLException → DataAccessException

# 용어

    ORM(Object Relational Mapping, 객체 관계형 매핑)
