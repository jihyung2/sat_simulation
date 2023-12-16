# Sat_Simulation

**팀 구성**
- 20181624 신희관 
- 20187098 이지형

## <u>Teamate</u> Project Background
- ### 필요성 및 문제점
  - 캔위성 대회를 수행하기 위해서는 캔위성을 개발하고 개발된 캔위성을 수 백미터 고도로 상승 시키고, 캔위성을 낙하시키면서, 수행된 임무데이터를 수신하는 과정이 필요함
  - 하지만 캔위성 개발부터 고도 상승, 임무 수행, 낙하까지 이러한 과정은 복잡하고 시간이 많이 소요된다. 뿐만 아니라, 실제로 캔위성을 발사하는 것은 제한적이고 어려운 작업이며, 이에 따른 위험 요소도 배제할 수 없음
- ### 해결책
  - 실제 캔위성에서 데이터를 지상국에 전송하는 것처럼 가상 환경에서 시뮬레이션 함으로써, 위성 환경에서의 문제 상황을 예측하고, 적절한 해결책을 마련하여 지상국 소프트웨어 개발 과정에서 도움을 받을 수 있음


## System Design
  - ### CanSat
    - 발사 및 임무 운용에 필요한 위성 구성요소를 단순하게 구성하여 고공에서 짧은 시간동안 위성처럼 운용하는 특징을 가진 초소형 위성
     ![1_can](https://github.com/jihyung2/sat_simulation/assets/108830942/4bcd0d66-ae46-4e0f-aa1f-adb48575ec65)

  - ### System Requirements
    - 시뮬레이션을 활용하여 센서부에서 위성 서버로 들어오는 데이터를 가상화
    - 지상국 오픈소스 SW를 목표로, 확장 가능 형태 개발

  - ### Can Development
![2_pro](https://github.com/jihyung2/sat_simulation/assets/108830942/a72027a2-a85b-4ef8-958f-851dedf2fc5a)
    
![3_sys](https://github.com/jihyung2/sat_simulation/assets/108830942/7e4958fc-80ce-4e26-bbff-6b383c6ef0e8)

![4_flow](https://github.com/jihyung2/sat_simulation/assets/108830942/d4dafc8c-945e-45df-a98b-aa6b4158e9b1)

![5_method](https://github.com/jihyung2/sat_simulation/assets/108830942/2eba2648-5d65-4bba-be3b-d0939cb7d867)

![6_vis](https://github.com/jihyung2/sat_simulation/assets/108830942/2344afb5-d75a-41a0-bc18-aa99fb57772c)

![7_sina](https://github.com/jihyung2/sat_simulation/assets/108830942/c8678082-9674-4d0d-9b61-67c7a0f64e16)

## 추가 기능
  ![8_graph](https://github.com/jihyung2/sat_simulation/assets/108830942/19393411-8a83-462a-8cd9-18d82c30ee44)

  ![9_database](https://github.com/jihyung2/sat_simulation/assets/108830942/3e1bc75b-dd9d-4fa4-9b5f-4f4854ccca28)

  ![10_can](https://github.com/jihyung2/sat_simulation/assets/108830942/661dc27b-7597-4cde-8d42-c05177b6ed4c)

  ![10_user](https://github.com/jihyung2/sat_simulation/assets/108830942/811ce958-48d2-4331-a4f3-e9624e9a86f9)

  ![11_sidebar](https://github.com/jihyung2/sat_simulation/assets/108830942/14605c23-696e-480a-b9c3-9236b88fe50f)

## 💻 Tech Stack
<h4> Platforms & Languages </h4>

<div align="left">
	<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
    <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
    <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">
    <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/flask-000000?style=for-the-badge&logo=flask&logoColor=white">
    <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
	  <img src="https://img.shields.io/badge/jpa-745671?style=for-the-badge&logo=jpa&logoColor=white">
    <img src="https://img.shields.io/badge/jdbc-256168?style=for-the-badge&logo=jdbc&logoColor=white">
</div>

<h4> Tools </h4>
<div align=left>
	<img src="https://img.shields.io/badge/Intellij%20IDE-000000?style=flat&logo=intellijidea&logoColor=white" />
	<img src="https://img.shields.io/badge/PyCharm-000000?style=flat-square&logo=PyCharm&logoColor=white"/>
    <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/>
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white" />
</div>
  
## Conclusion
  - 위성으로부터 수신한 데이터를 처리해야하는 지상국 서버는 오픈소스를 목표로 확장 가능하도록 제작
  - 캔 위성의 고도를 고려하여 통신 프로토콜 및 산업용 블루투스 연결 방식의 근거리 무선 통신 방식 채택
  - 캔위성을 시뮬레이션으로 대체하여 효과적으로 오픈소스 기반의 지상국 서버를 개발 
  
## Project Outcome
- ### 2023년 시뮬레이션 학회 논문
![12_front](https://github.com/jihyung2/sat_simulation/assets/108830942/3037a018-80fe-4a6c-aef7-0a1aca37536b)

![13_front2](https://github.com/jihyung2/sat_simulation/assets/108830942/9363b866-1a53-4f95-a864-7249efb0f29a)

- ### 시뮬레이션 학회 추계학술대회 경진대회 참가 확인서
![14_hak](https://github.com/jihyung2/sat_simulation/assets/108830942/4a387928-3d2b-4a35-a76b-fb68b245b3ff)


- ### 시뮬레이션 학회 경진대회, 장려상 수상
![15_bal](https://github.com/jihyung2/sat_simulation/assets/108830942/66780aef-e647-45b4-ab2f-cb8d9b6ef8fd)

![16_sang](https://github.com/jihyung2/sat_simulation/assets/108830942/36814e96-8e1a-4ff6-af9f-d82778cc5d36)



## 개발 과정

재사용성 높은 rest api 제작기
룰 베이스로 제작

간단한 REST API 서버 만들기 (스프링부트) https://velog.io/@tjdals9638/Spring-boot%EB%A1%9C-Rest-API-%EB%A7%8C%EB%93%A4%EA%B8%B0

1. controller: 클라이언트 요청을 받고 서비스에 처리를 요청, 이후 클라이언트에게 응답
2. service: controller의 호출에 따라 사용자의 요구사항을 처리, DB의 정보 등 필요에 따라 repository에 요청
3. repository: 데이터베이스 관련 처리 담당

어노테이션
간단하게 @를 시작으로 구성된 노란색 코드 부분이다.
어노테이션은 컴파일러에 문법 에러를 체크하며 빌드 또는 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공한다.
@RestController: @Controller와 @ResponseBody가 합쳐진 어노테이션으로 주 용도는 Json 형태로 객체 데이터를 반환하는 것이다.
@GetMapping(): API의 메서드 지정으로 GET 방식의 API를 지정하는 방식이다.

GET:

데이터 전송 방식: URL의 쿼리 파라미터에 데이터를 포함시켜 전송합니다.
데이터 노출: URL에 데이터가 노출되므로 보안에 취약합니다.
데이터 크기 제한: URL의 길이 제한으로 인해 전송할 수 있는 데이터의 크기에 제약이 있습니다.
캐싱 가능: 동일한 GET 요청은 캐시를 활용하여 이전에 가져온 응답을 재사용할 수 있습니다.
멱등성: 동일한 GET 요청을 여러 번 보내더라도 항상 동일한 결과를 반환해야 합니다.
주로 데이터 조회, 검색 등 데이터를 요청하는 용도로 사용됩니다.

POST:

데이터 전송 방식: 요청 본문에 데이터를 담아 전송합니다.
데이터 노출: 요청 본문에 데이터를 담아 전송하므로 URL에 데이터가 노출되지 않습니다.
데이터 크기 제한: 일반적으로 크기 제한이 없으며, 요청 본문에 다양한 타입의 데이터를 담아 전송할 수 있습니다.
캐싱 어려움: POST 요청은 캐싱을 어렵게 만들기 때문에 일반적으로 캐시되지 않습니다.
멱등성: 동일한 POST 요청을 여러 번 보내면 서버에서는 동일한 동작을 반복 수행할 수 있습니다.
주로 데이터 생성, 수정, 삭제 등 서버의 상태 변경을 요청하는 용도로 사용됩니다.


Get 방식
    서버로부터 리소스를 요청할 때 사용되는 요청 방식입니다. GET요청은 주로 데이터 조회나 검색 등에 사용되며, 데이터를 요청 URL의 쿼리 파라미터에 포함시켜 전송합니다.
    GET 요청은 URL에 데이터가 노출되므로 보안에 취약할 수 있고, 데이터 전송에 제약이 있을 수 있습니다. 

Post 방식
    프론트엔드에서 데이터를 백엔드로 전송하고자 할 때, 일반적으로는 POST요청을 사용합니다.
    POST요청은 클라이언트가 서버에 데이터를 제출하기 위해 사용되며, 요청 본문에 데이터를 담아 서버로 전송합니다. 데이터의 크기나 형식에 제약이 없고, 보안에 더 적합합니다.

GET은 데이터를 요청하는 용도로 주로 사용되고, POST는 데이터를 서버에 전송하여 처리를 요청하는 용도로 주로 사용됩니다. 

1. WebClient 방식 사용하기
WebClient는 비동기적인 HTTP 클라이언트입니다. WebClient를 사용하여 HTTP 요청을 보낼 때, 요청은 비동기적으로 전송되고 응답은 비동기적으로 받아옵니다. 이는 블로킹하지 않고 다른 작업을 수행할 수 있도록 합니다.

WebClient는 Reactor 프로젝트의 일부로서 Reactor의 Mono와 Flux 타입과 함께 사용됩니다. Mono는 0 또는 1개의 결과를 가질 수 있는 단일 값이고, Flux는 0부터 N개의 결과를 가질 수 있는 여러 값을 가집니다.

WebClient의 retrieve() 메서드는 Mono나 Flux를 반환하며, bodyToMono() 또는 bodyToFlux() 메서드를 사용하여 응답 본문을 Mono나 Flux로 변환할 수 있습니다. 이러한 리액티브 타입을 활용하여 비동기적으로 응답을 처리할 수 있습니다.

따라서 WebClient를 사용하면 비동기적으로 백엔드 서버와 통신할 수 있으며, 다른 작업을 동시에 수행할 수 있는 장점이 있습니다.

사용법
build.gradle에
implementation 'org.springframework.boot:spring-boot-starter-webflux' 넣기

2. Mono
Mono는 0-1개의 결과만을 처리하기 위한 Reactor 객체
Flux는 0-N개의 결과물을 처리하기 위한 Reactor 객체

3. 스프링 부트에서 API 서버의 IP 주소와 포트를 설정하는 방법은 application.properties 파일이나 application.yml 파일을 사용하여 할 수 있습니다.
server.address=0.0.0.0
server.port=8080

application.properties 파일에서 IP 주소와 포트 번호를 설정하면 스프링 부트 애플리케이션에서 자동으로 해당 주소와 포트에 연결됩니다. 이는 스프링 부트의 내장 웹 서버가 해당 설정을 인식하고 설정된 IP 주소와 포트 번호로 바인딩되기 때문입니다.

4. 프론트 서버에서 받아온 API콜의 데이터를 자바의 API 서버로 전송할 때 해시 맵 방식을 사용하는데
해시맵이란 딕셔너리 개념을 구현한 클래스중 하나로, 키 와 값의 쌍으로 이루어진 데이터를 저장하고, 효율적인 검색과 접근을 제공함, 파이썬에서는 dict, 자바는 Hashmap이라고 생각하면 편함

@RequestBody HashMap<String, Object> map
map.get("type")

5. URL 함수자체에 변수를 줘서 입력할 때는 이런방식으로 사용한다.
@GetMapping(/getData/{type}) 
public Mono<String> getDataFromBackend2(@PathVariable String type, @RequestBody HashMap<String, Object> map)

6-1. 프론트에서 받은 데이터를 백엔드 서버로 보내는 방법 /GET
        webClient.get()
                .uri(uriBuilder -> uriBuilder.path(backendUrl) 
                        .queryParam("type", datatype)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(result -> {System.out.println(result);
                });
uriBuilder를 활용해서 url값에 query파라미터를 넣는다.

6-2. 프론트에서 받은 데이터를 백엔드 서버로 보내는 방법 /POST
        webClient.post()
                .uri(backendUrl)
                .bodyValue(map)
                .retrieve()
                .bodyToMono(String.class);

    백엔드 서버에선 request.json.get('type')로 받는다.

### 작동 방식

1. @GetMapping("/getData") 메서드는 /api/getData 경로로 들어오는 GET 요청을 처리합니다.
프론트로부터의 요청이 들어오면, getDataFromBackend() 메서드가 실행됩니다.
2. getDataFromBackend() 메서드 내에서는 WebClient를 사용하여 백엔드 서버에 GET 요청을 보냅니다.
backendUrl 변수에는 백엔드 서버의 URL인 "http://127.0.0.1/api/data"가 설정되어 있습니다.
webClient.get().uri(backendUrl)를 호출하여 백엔드 서버로 GET 요청을 보냅니다.
3. retrieve()를 호출하여 응답을 가져오고, bodyToMono(String.class)를 사용하여 응답 본문을 Mono<String>으로 변환합니다.
반환된 Mono<String>은 비동기적으로 응답을 받을 수 있는 객체입니다.
4. 최종적으로 Mono<String>을 반환합니다.
프론트로는 이 Mono<String> 객체를 비동기적으로 받아 처리할 수 있습니다.
5. URL에 변수를 붙여서 하기보단, 보내는 data의 type값을 붙여서 보내면, 그 값을 중간 api서버가 읽어들여 url 붙여서 기능에 맞는 값을 출력하려고 함

결과적으로, 프론트에서 API 서버의 /api/getData 엔드포인트에 GET 요청을 보내면, API 서버는 백엔드 서버에 해당 데이터를 요청하고 응답을 받습니다. 그리고 해당 응답은 Mono<String> 형태로 프론트로 반환됩니다. 프론트는 이 Mono<String> 객체를 비동기적으로 받아서 원하는 방식으로 처리할 수 있습니다.

### 에러
1. 순환 참조 에러가 발생했음 
2. 종속성 누락으로 인한 MacOS오류
3. json 출력시 에러
4. 하드코딩을 막기위해 자바 프레임워크인 스프링부트에서 제공하는 프로퍼티 파일에 url을 넣고 출력하는 과정에서 변수값 에러가 발생

### 해결방법
1. @bean을 제거하고 그 문장을 합쳐서 해결함
2. macos 사용시 native Dns 설정이 필요함 
implementation("io.netty:netty-resolver-dns-native-macos:4.1.79.Final:osx-aarch_64")
3. response.json()['query'] 이런 형식으로 출력해야함
4. 기본 url만 출력받고 변수는 그후에 출력하여 해결

application.properties
api.url1: http://127.0.0.1:8070/

API server
@Value("${api.url1}")
private String apiUrl;


## 아이디어 
7/13
어떤식으로 하면 범용적으로 사용할 수 있을까
일단 기존의 url 을 코드에 넣지 않고 프로퍼티에 넣어서 유지보수를 용이하게 가져가고,
입력을 받을때 중간 api 서버에서 입력받은 내용 별로 코드를 짜면 결국 의존성이 높아지기때문에
입력은 하나로 받고 출력을 여러개로 가는게 맞지 않나 싶음 대신 보내는 api콜에 type을 담아서 보내는건 어떠한가 싶다 일단은

7/14
Front <--Rest api--> backend api serve(java) <---Restapi---> main server
         GET 방식                                 POST 방식

기존의 GET, GET 방식으로 전송했을때 프론트의 type값을 백엔드로 보내기 제약이 많아서 변경함

프론트 서버, REST API 서버, 백엔드 서버 (총 3개 서버)를 다루는 경우:

장점:
역할과 책임의 분리: 각 서버는 독립적인 역할과 책임을 수행하여 코드의 가독성과 유지보수성을 향상시킵니다.
확장성: 각 서버는 독립적으로 확장이 가능하므로, 애플리케이션 전체의 확장성을 향상시킬 수 있습니다.
보안 및 인증 관리: REST API 서버를 통해 프론트 엔드와 백엔드 간의 보안 및 인증을 중앙 집중적으로 관리할 수 있습니다.
클라이언트 다양성: REST API 서버를 통해 다양한 클라이언트 (웹 애플리케이션, 모바일 앱 등)가 데이터를 요청할 수 있습니다.

단점:
구현 및 유지보수 복잡성: 각 서버 간의 통신과 데이터 전달을 관리해야 하므로 구현과 유지보수의 복잡성이 증가할 수 있습니다.
네트워크 오버헤드: 프론트 서버와 REST API 서버, REST API 서버와 백엔드 서버 간의 통신으로 인해 약간의 네트워크 오버헤드가 발생할 수 있습니다.

프론트 서버, 백엔드 서버 (총 2개 서버)를 다루는 경우:

장점:
간결성: 서버 간의 통신이 단순화되어 개발 및 유지보수가 더 쉬울 수 있습니다.
성능: 중간 단계의 REST API 서버를 거치지 않으므로 약간의 성능 향상이 있을 수 있습니다.

단점:
확장성 제한: 프론트 서버와 백엔드 서버는 함께 확장해야 하므로, 확장성이 제한될 수 있습니다.
종속성: 프론트 서버와 백엔드 서버가 직접 연결되므로, 인터페이스 변경 시 양쪽 모두에 영향을 줄 수 있습니다.
클라이언트 다양성 제한: REST API 서버를 통한 다양한 클라이언트 지원이 제한될 수 있습니다.

GET, POST 방식을 둘다 사용한 이유로는 WebClient를 사용하여 JSON 형태의 데이터를 GET 요청으로 보내는 방식은 일반적으로 지원되지 않습니다. 
GET 요청으로 JSON 데이터를 직접 전송하는 것은 일반적으로 권장되지 않습니다. 

**백엔드 서버에 코드자체를 다 넣지 않고 파일을 여러개로 분산해서 개발하면 좋을듯

### 데이터의 예시를 
$(데이터의 시작), &(데이터의 끝), #(센서데이터 구분)=(센서값)
$#sensor1.Analog=abca#sensor.2Binary=baba#sensor3.Image=avav&

### JPA
JPA는 자바 애플리케이션과 관계형 데이터베이스 시스템 간의 데이터베이스 액세스 및 데이터 조작을 단순화하고 추상화하는 목적으로 개발
작업을 단순하게 할 수 있음 
단점으로는 SQL문을 사용하지않기 때문에, 동적 생성이 어려움

### JDBC
데이터베이스에 접속하여 SQL문을 사용하여 작업할 수 있음
동적 생성 가능

데이터베이스 부분 ) 하다가 고유값이 없는데 하는게 좀 생각보다 효율이 떨어져서 걍 데이터베이스 하나로 하고, 너가 말한거처럼 누적쌓는거 + timestamp 버전으로 추가했고, 혹시모를 고유 id값을 사용할때를 대비해서 하나 만들어놨음

이미지 전송) 일단 지금 이미지 전송하는 코드까지 다했는데
파일밖에 image_server 라는 파일을 만들어야함, 이게 깃풀로는 이게 파일밖에있어서 안담긴다. 
일단 흐름만 말해주자면 
위성(서버) 쪽에서 이미지를 보낼때 jpeg로 변환(이미지 크기가 줄어들음) 후 전송하는데 이미지가 너무 크면 길기때문에 크기나, 비율을 퀄리티를 조정해서 보내야함 
jpeg로 변환한 이미지파일을 바이트 배열로 변환해서 전송

전송받은 바이트 배열을 복호화해서 이미지파일로 저장
이미지 파일을 저장한 경로를 데이터베이스에 저장

데이터베이스에 바이트배열의 이미지파일을 넣으려고했는데 
너무 커서 안들어가고 이거떄문에 전체 길이를 2000이상 늘리기엔 너무 비효율적이라고 판단됨

## 중간 결과물 
### 위성
현재는 시뮬레이션으로 대체했지만, 기계과 분들과 협업하여 실제 센서데이터를 받아올때 위성서버와 센서간의 통신 프로토콜을 어떻게 할지 고민한 결과 CAN통신을 사용하여 위성간 통신을 하는거로 결정
확장 가능한 형태로 제작하기 위해 json을 임베딩하여 확장성을 높임

### 지상국 
지상국은 확장 가능한 형태로 제작하기 위해 json을 임베딩하여 확장성을 높임
여러 사용자가 사용할 경우 동적으로 데이터베이스를 생성해야하지만 JPA로는 불가능하여 JDBC로 동적 테이블 생성
위성 통신의 CAN통신중 센서이름, 센서값, 위성이름을 추출하여, 위성이름으로된 테이블로 값이 들어간다.
이미지 처리의 경우 바이트 형태로 분할하여 전송
들어온 데이터의 경우 startindex(@), endindex(&)을 붙여 구분

### 데이터베이스
데이터가 들어올때 Timestamp를 남기고 이미지처리는 데이터가 크기 때문에 같은 데이터베이스에 넣는것은 효율적이지 않다고 판단하여 추가로 테이블을 생성하여 Medium Blob 형태로 데이터를 저장

### 웹
현재는 프로토타입으로 여러 사용자가 사용했을 경우 고유id값으로 구분짓고, 센서 그래프 여러개를 동시에 보여주는 기능을 추가할 예정
웹 소켓으로 데이터베이스나 서버와 연결하여 실시간으로 데이터가 추가되는 부분 구현할 예정


## 최종 시나리오
위성에서 CAN 통신 프레임 방식을 사용하여 확장 ID방식으로 전송함
이미지, 음성데이터는 라즈베리파이위성의 캔 통신 변환 모듈을 사용하지 않고 저장소에서 바로 출력하는 방식
그 외 위성에서 수집된 센서 데이터는 캔 통신 변환 모듈을 거쳐서 자동으로 변환되어 들어옴

$, * 인덱스를 사용하여 스트림 데이터가 들어올때마다 끝까지 기다리는게 아닌 한 데이터의 종류가 다 들어오면 바로 가공 후 전송 및 저장

Json 파일을 사용하여 위성 및 지상국에 임베딩하여 종류가 새로 추가되어도 json 파일의 캔위성 비트를 수정해서 넣으면 처리 가능

데이터 가공은 위성에서 하고 들어옴

### 데이터베이스
Image_data - id, data, name, timestamp, userid 
	- id : 자동으로 증가하는 수, 기본키
 	- name : 캔 비트를 Json에 임베딩 시켜서 문자열로 변환한 센서이름, Image 고정
  	- timestamp : 데이터가 들어온 시간 표시
   	- userid : 사용자가 지정한 고유의 id
    	- data : 이미지를 바이트로 변환한 MEDIUMBLOB

Voice_data - id, data, name, timestamp, userid 
	- id : 자동으로 증가하는 수, 기본키
 	- name : 캔 비트를 Json에 임베딩 시켜서 문자열로 변환한 센서이름, Voice 고정
  	- timestamp : 데이터가 들어온 시간 표시
   	- userid : 사용자가 지정한 고유의 id
    	- data : 음성데이터를 바이트로 변환한 MEDIUMBLOB

Sensor_all_data - id, data, name, timestamp, userid 
	- id : 자동으로 증가하는 수, 기본키
 	- name : 캔 비트를 Json에 임베딩 시켜서 문자열로 변환한 센서이름
  	- timestamp : 데이터가 들어온 시간 표시
   	- userid : 사용자가 지정한 고유의 id
    	- data : 센서 값을 문자열로 저장

     
### 지상국의 웹 시각화의 제공 기능
1) 사용자 구분 - Login 버튼을 클릭하여 위성의 고유값 입력 -> 위성의 고유 id로 들어온 이미지, 데이터, 그래프 표시 ( 고유 id부분은 나중에 로그인이나 위성서버의 고유핀 값을 사용하던 선택하면 됨 )
2) 그래프 - 아래의 데이터베이스 표를 기준으로 데이터값을 이어서 그래프 표시, 왼쪽 세팅값을 클릭하여 여러 센서값의 종류를 볼 수 있고, 다른 센서값들과 동시에 확인 가능 ( 체크바로 동시에 확인 )
3) 데이터베이스 표 - 원하는 값 검색 가능, export 기능으로 추출 가능
4) 이미지 - 사용자가 입력한 위성의 id값이 포함된 이미지만 출력, 왼쪽 오른쪽 버튼을 클릭하여 사진을 넘길 수 있음

### JDBC 사용 공부 ( 현재 작업물은 JPA만을 사용 )
package com.example.reuse_api.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class MyDatabaseComponent {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyDatabaseComponent(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void ensureTableExists(String satelliteId) {
        if (StringUtils.hasText(satelliteId) && !tableExists(satelliteId)) {
            createTable(satelliteId);
        }
    }

    private boolean tableExists(String tableName) {
        try {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            ResultSet tables = metaData.getTables(null, null, tableName, null);
            return tables.next();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to check if table exists: " + tableName, e);
        }
    }

    private void createTable(String tableName) {
        jdbcTemplate.execute("CREATE TABLE " + tableName + " (id SERIAL PRIMARY KEY, name VARCHAR(255), data VARCHAR(255), timestamp TIMESTAMP)");
        jdbcTemplate.execute("CREATE TABLE " + tableName+"Image" + " (id SERIAL PRIMARY KEY, name VARCHAR(255), data MEDIUMBLOB, timestamp TIMESTAMP)");
        jdbcTemplate.execute("CREATE TABLE " + tableName+"Voice" + " (id SERIAL PRIMARY KEY, name VARCHAR(255), data MEDIUMBLOB, timestamp TIMESTAMP)");
    }

    public void insertSensorData(String tableName, String sensorName, String streamData) {
        String sql = "INSERT INTO " + tableName + " (name, data, timestamp) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sensorName, streamData, new Date());
    }
    public void insertImageSensorData(String tableName, String sensorName, byte[] streamData) {
        String sql = "INSERT INTO " + tableName+"Image" + " (name, data, timestamp) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sensorName, streamData, new Date());
    }
    public void insertVoiceSensorData(String tableName, String sensorName, byte[] streamData) {
        String sql = "INSERT INTO " + tableName+"Voice" + " (name, data, timestamp) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sensorName, streamData, new Date());
    }

}
