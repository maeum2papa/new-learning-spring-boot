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
    - H2 Database
    - Mustache
    - Spring Data JPA
10. 프로젝트 생성되고 메세지창에서 add Workspace 선택

- https://start.spring.io/ 통해서 프로젝트 생성 시 참조
  - **Project**는 **Gradle-Kotlin** 선택

