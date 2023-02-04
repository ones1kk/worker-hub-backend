# 개발 정의서

## 프로젝트 구조
### 공통
1. 그룹명: **com.breakingbad.workerhub** 
   1. 팀이름: Breaking Bad 
   2. 프로젝트명: Worker-Hub Backend
2. Architecture 및 Directory
   1. Architecture는 **Monolithic > Multi Module** 방식으로 구성한다.
   2. Directory 구조는 **도메인형 디렉토리 방식**으로 구성한다.

### 모듈
1. api
   1. Service Layer를 관리하는 모듈.
      1. Application Services 및 Infrastructure Services...을 담당한다.
   2. 최초 external, internal로 패키지를 구성한다.
      1. external: 추후 외부에 제공할 api를 관리하기 위한 패키지.
      2. internal: **worker-hub-backend** 프로젝트 내부에서 사용할 api 파일들이 작성 될 패키지.
2. common
   1. 전역적으로 사용할 수 있는 Utils, Exception, Constant... 정의 되어 있는 모듈이다.
   2. Java 외 의존성 주입은 지양한다.
3. core
   1. 다른 모듈들에 공통적으로 적용 될 Configuration을 관리해주는 모듈.
4. domain
   1. Repository Layer를 관리하는 모듈.
      1. Entity, Repository Interfaces & Implementations... 정의 되어 있는 모듈이다.
5. web
   1. Web Layer를 관리하는 모듈.
      1. Controllers, Exception Handlers, Filters, Interceptors... 정의 되어 있는 모듈이다.

> Package 구성 예시
1. com
   1. breakingbad
      1. workerhub
         1. core
            1. config
            2. filter
            3. provider
            4. interceptor
            5. handler
            6. ...
         2. domain
            1. member
               1. controller
               2. ...
            2. company
            3. ...

### Code Convention

#### Java
> <details>
>  <summary>자세히</summary>
>
>  1. 한 메서드에서 한 단계 들여쓰기만 사용하자.
>   > Use only one level of indentation.
>
>  2. else 예약어를 쓰지 말자.
>  > Don’t use the else keyword.
>
>  3. 모든 원시값과 문자열을 포장하자.
>   > Wrap all primitives and strings.
>
>  4. 일급 컬렉션을 사용하자.
>   > Use first-class collections.
>
>  5. 한 줄에서 한개의 점만 사용하자.
>   > Use only one dot per line
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
>  > * Setter 사용은 강력하게 지양한다.
> </details>

### resources
1. Application Property에 대한 내용 정의는 classpath:/env/${profile}/application-${profile}.yml 파일에 정의한다.
2. Public Repository 특성상 민감한 정보가 담긴 내용은 classpath:/env/${profile}/application-secret-${profile}.yml 파일에 정의한다.
3. 해당 파일에 작성된 내용은 classpath:/application-secret-sample.yml을 작성한다.

### Test Code
1. Test Coverage 70% 이상을 목표로 작성한다.
2. Test Framework는 Junit5며 실제 검증 코드는 [AssertJ](https://joel-costigliola.github.io/assertj/)로 작성한다.
   1. 기본적으로 BDD(Behaviour-Driven Development) 기반으로 작성한다.
   2. 생성, 성공 및 실패 케이스를 작성한다.
      1. Feature : 테스트에 대상의 기능/책임을 명시한다.
      2. Scenario : 테스트 목적에 대한 상황을 설명한다.
      3. Given : 시나리오 진행에 필요한 값을 설정한다.
      4. When : 시나리오를 진행하는데 필요한 조건을 명시한다.
      5. Then : 시나리오를 완료했을 때 보장해야 하는 결과를 명시한다.
3. Domain Layer의 경우 DB 의존성을 낮추기 위해 Repository 관련 Mocking을 강제한다. 

## Git 전략

### Branch

#### 구성
1. master
2. develop
3. 개인 브런치(미적용)

### 전략(미적용)
1. master: 실제 운영에 배포 될 브런치로 해당 브런치.
   1. Require a pull request before merging.
      1. 해당 브런치로 Direct Push를 금하며 PR을 통한 Merge가 이루어진다.
   2. Require status checks to pass before merging.
      1. 테스트 결과 이상이 없을 시에만 Merge가 가능하다.
   3. Require signed commits.
      2. Github에서 발행 된 GPG Key를 가진 사람이 커밋할 수 있다.

2. develop: 개인이 작업한 코드들을 Merge 하는 브런치.
   1. Require a pull request before merging.
      1. 해당 브런치로 Direct Push를 금하며 PR을 통한 Merge가 이루어진다.
   2. Require status checks to pass before merging.
      1. 테스트 결과 이상이 없을 시에만 Merge가 가능하다.
   3. Require conversation resolution before merging.
      1. PR 후 Conversation이 모두 solved 되어야만 Merge가 가능하다.
   4. Require signed commits.
      1. Github에서 발행 된 GPG Key를 가진 사람이 커밋할 수 있다.

3. 개인 브런치: Role별 작업하는 브런치.


## ERD
> [ERDCloud](https://www.erdcloud.com/d/CKSfMbhWhHDN52AiS)  



