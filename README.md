# Worker-Hub(워커 허브)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/08be7e1934a6450594e17c96d95c0c5d)](https://www.codacy.com/gh/worker-hub/worker-hub-backend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=worker-hub/worker-hub-backend&amp;utm_campaign=Badge_Grade)

## 프로젝트 설명
**Worker-Hub(워커 허브)** 는 통합 인력 관리를 지원해주는 웹 서비스입니다.
> 연차/근태 관리, 지출 결의서 작성, 경조사 신청, 비품 등... 보다 효율적으로 관리할 수 있도록 도와드립니다.

## 기술 스택
### 애플리케이션
- Java 11
- Spring Framework
    - Spring Boot
    - Spring MVC
    - Spring Security
    - Spring Data JPA + QueryDSL
    - Spring Doc
- MYSQL
- Gradle
- Junit5, AssertJ, Mockito

### 인프라 아키텍처
- Git
- Github Actions
- Slack(alarm)

## 개발자
> ### Backend
- [ones1kk](https://github.com/ones1kk)   
  - 프로젝트 구조 및 초기 설정 구성
  - DB 설계
  - JPA Model 설계
  - Github Actions 설정
- [MyPottery](https://github.com/MyPottery)
  - DB 설계
> ### Frontend
- [paulront](https://github.com/paulront)
  - 프로젝트 구조 및 초기 설정 구성

## Code Convention

### Java
> <details>
>  <summary>자세히</summary>
>
>  1. 한 메서드에서 한 단계 들여쓰기만 사용하자.  
>   > Use only one level of indentation.
>
> 
>  2. else 예약어를 쓰지 말자.
>  > Don’t use the else keyword.
>
>
>  3. 모든 원시값과 문자열을 포장하자.
>   > Wrap all primitives and strings.
>
>
>  4. 일급 컬렉션을 사용하자.
>   > Use first-class collections.
>
>  5. 한 줄에서 한개의 점만 사용하자.
>   > Use only one dot per line
>
>
>  6. 축약하지 말자.
>  >  Don’t abbreviate.
>
>  7.  모든 엔티티를  작게 유지하자.
>  >  Keep all entities small.
>
>  8. 클래스는 변수 두 개를 넘지 않게 하자.
>  >  Don’t use any classes with more than two instance variables.
>
>  9. Getter / Setter / Properties를 사용하지 말자.
>  > Don’t use any getters/setters/properties
> </details>

