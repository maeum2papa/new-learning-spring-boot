## MAC + Spring Boot + VSCode 개발환경 세팅
### openjdk11 설치
```
brew tap AdoptOpenJDK/opnjdk
brew install --cask adoptopenjdk11
```

### 설치 확인
```
java --version
```

### JAVA_HOME 수정 / VSCode settings.json
1. 메뉴 **Code > Preferences > Settings** 클릭
2. 우측 문서 아이콘 클릭
3. java.jdt.ls.java.home을 사용 jdk 경로로 수정
```json
"java.jdt.ls.java.home": "/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home",
```

### (필요시) .bash_profile 설정 / 환경변수
```
nano .bash_progile
-----------------------
export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
export PATH=${PATH}:$JAVA_HOME/bin
```

### VSCode 익스텐션 설치
- Extension Pack for Java
- Gradle for Java
- Spring Boot Extension Pack
- Lombok Annotations Support for VS Code

## 프로젝트 생성
1. **f1키** 또는 **fn+f1** 눌러서 명령창 활성하
2. **Spring Initializr: Create a Gradle Project...** 선택
3. 스프링부트 버전 선택
4. Java 선택
5. Group Id 입력
6. 프로젝트명 입력
7. 패키징 타입 Jar 선택
8. Java 버전 선택 / JAVA_HOME 환경변수와 일치 필요
9. dependencies 선택
    - Spring Web
    - H2 Database : 가벼운 데이터베이스 (임시용)
    - Mustache
    - Spring Data JPA
10. 프로젝트 생성되고 메세지창에서 add Workspace 선택

- https://start.spring.io/ 통해서 프로젝트 생성 시 참조
  - **Project**는 **Gradle-Kotlin** 선택

## MVC
### Model
- controller/MainController.java 참조
- 데이터를 View로 보낼 수 있음

### View
- 화면
- {{>header}}식으로 import 가능
- Model에서 보내온 데이터를 {{name}} 식으로 사용

### Controller
- 처음 인입
- GET 인입 controller/MainController.java 참조
- POST 인입 controller/SearchController.java 참조
- POST 인입시 DTO 활용 (파라미터를 객체로 받을 수 있게 함, Form)
  - dto/SearchForm.java 참조


## JPA
- 데이터베이스로 데이터를 보내기 위한 도구
- 일련의 과정 controller/SearchController.java 참조
### DTO를 Entity로 바꾸고((Form -> Object) -> Entity)
- dto, entity 폴더 참조
- dto = 파라미터 구조
- entity = 데이터베이스 테이블 구조

### Entity를 Repository를 통해 Database로 
- respotory 폴더 참조
- Extends CrudRepository를 활용하여 거의 고정
- extends CrudRepository<엔티티명,아이디타입>
~~~java
public interface ArticleRepository extends CrudRepository<Article,Long>{
    
}
~~~

### H2 Database 사용을 위한 세팅
- resources/applicationi.properies 에 아래 코드 추가
~~~
spring.h2.console.enabled=true
~~~

### H2 콘솔 접속은 
- 도메인/h2-console
- Connect 정보는 콘솔에서 jdbc로 검색

## Loombok
### 설치
1. https://projectlombok.org/setup/gradle 참조
~~~
/* build.gradle */
dependencies {
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok'
~~~

2. **f1키** 또는 **fn+f1** 눌러서 명령창 활성하
3. **Java:Clean Java Language Server Workspace** 검색 후 선택

### 주요 어노테이션
- @NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
- @AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 만듦
- @ToString : toString() 대체
- @Slf4j : 로깅을 만드는데 도움