# Seoul-Public-Service-Reservation-Information
서울시 및 산하기관, 자치구의 체육시설 중 예약가능한 목록 정보와 서울시 문화행사 공공서비스예약 정보를 제공합니다.

언어: Kotlin

프레임워크: spring-webflux 

스토리지 엔진: MongoDB

---
주의점: 서울열린데이터광장의 open api를 이용 하고 있으며 실행 시 open api의 키 값이 필요합니다.
https://data.seoul.go.kr 에서 api key를 발급 받으신 후 실행 시 환경 변수 값을 api.key={발급 받은 키}로 등록 하셔야 합니다.
또는 application.yml에 다음과 같이 작성하셔도 됩니다.
~~~
api:
  key: {발급 받은 키}
~~~
---

체육 시설 예약 목록 조회
~~~
GET http://localhost:8080/sport/reservations?size=한번에 조회할 데이터 크기&page=조회할 페이지&category={ALL, SOCCER_STADIUM, FUTSAL_STADIUM,
TENNIS_COURT, FOOTBALL_COURT, BASKETBALL_COURT, MULTIPURPOSE_STADIUM, VOLLEYBALL_COURT, BADMINTON_COURT, FUTSAL, PLAYGROUND, GYM, TABLE_TENNIS_COURT,
PARK_GOLF_COURSE}
~~~
request example:

~~~
GET http://localhost:8080/sport/reservations?size=2&page=1&category=ALL 
~~~

response example: 

~~~
"content": [
        {
            "GUBUN": "자체",
            "SVCID": "S120423174310156240",
            "MAXCLASSNM": "체육시설",
            "MINCLASSNM": "축구장",
            "SVCSTATNM": "접수중",
            "SVCNM": "△ [야간] 마포 난지천 인조잔디 축구장",
            "PAYATNM": "유료",
            "PLACENM": "월드컵공원>난지천인조잔디축구장",
            "USETGTINFO": "제한없음",
            "SVCURL": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S120423174310156240",
            "X": "37.574238294219086",
            "Y": "126.88390026512282",
            "SVCOPNBGNDT": "2012-04-23 00:00:00.0",
            "SVCOPNENDDT": "2020-12-31 00:00:00.0",
            "RCPTBGNDT": "2019-11-01 09:00:00.0",
            "RCPTENDDT": "2020-12-31 00:00:00.0",
            "AREANM": "마포구",
            "IMGURL": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2012/12/28/S120423174310156240&n=hu69ma3H7VZ1cGm496P23na3qbQ9Lp&on=S120423174310156240.jpg",
            "DTLCONT": "<p>1. 공공시설 예약서비스 이용시 필수 준수사항</p><p>모든 서비스의 이용은 담당 기관의 규정에 따릅니다. 각 시설의 규정 및 허가조건을 반드시 준수하여야 합니다.</p><p>각 관리기관의 시설물과 부대시설을 이용함에 있어 담당자들과 협의 후 사용합니다.</p><p>각 관리기관의 사고 발생시 서울시청에서는 어떠한 책임도 지지않습니다.</p><p>시설이용료 납부는 각 관리기관에서 규정에 준 합니다.</p><p>본 사이트와 각 관리기관의 규정을 위반할시에는 시설이용 취소 및 시설이용 불허의 조치를 취할 수 있습니다.</p><p>접수시간을 기준으로 브라우저에서 새로고침을 하면 변경된 정보를 볼 수 있습니다.</p><p>2. 시설예약</p><p>비회원일 경우에는 실명 확인을 통하여 사용하실 수 있으며 서울시 통합 회원에 가입 하시게 되면 서울시에서 제공하는 다양하고 많은 혜택을 받으실 수 있습니다.</p><p>3. 상세내용</p><p><!--StartFragment--><span style=\"text-align: left; line-height: 14.4pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">예약이 완료 된 팀은 마이페이지 예약 확인증을 인출하여 난지천 축구장</span> <span style=\"text-align: left; line-height: 14.4pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">관리자에게 확인시켜 주시기 바랍니다.</span></p>\r\n<p style=\"text-align: left; line-height: 120%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: justify; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\"><span style=\"text-align: justify; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\"><!--StartFragment--></span></span></p>\r\n<p class=\"바탕글\" style=\"margin-bottom: 1.6pt;\"><span style=\"font-family: HY그래픽; font-size: 12pt; font-weight: bold; mso-fareast-font-family: HY그래픽; mso-hansi-font-family: HY그래픽;\" lang=\"EN-US\">&clubs;</span><span style=\"color: #ff0000; font-family: HY그래픽; font-size: 15pt; font-weight: bold; mso-hansi-font-family: HY그래픽; mso-ascii-font-family: HY그래픽;\">휴대폰번호 및 주소 미기재 시 예약취소합니다</span><span style=\"font-family: HY그래픽; font-size: 12pt; font-weight: bold; mso-fareast-font-family: HY그래픽; mso-hansi-font-family: HY그래픽;\" lang=\"EN-US\"> &clubs; </span></p>\r\n<p style=\"text-align: justify; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color",
            "V_MIN": "18:00",
            "V_MAX": "22:00",
            "REVSTDDAYNM": "이용일",
            "REVSTDDAY": "1"
        },
        {
            "GUBUN": "자체",
            "SVCID": "S120605140843257226",
            "MAXCLASSNM": "체육시설",
            "MINCLASSNM": "축구장",
            "SVCSTATNM": "접수중",
            "SVCNM": "○ [평일] <오전>마포 난지천 인조잔디축구장",
            "PAYATNM": "유료",
            "PLACENM": "월드컵공원>난지천인조잔디축구장",
            "USETGTINFO": "제한없음",
            "SVCURL": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S120605140843257226",
            "X": "37.574238294219086",
            "Y": "126.88390026512282",
            "SVCOPNBGNDT": "2012-04-23 00:00:00.0",
            "SVCOPNENDDT": "2020-12-31 00:00:00.0",
            "RCPTBGNDT": "2020-05-07 10:00:00.0",
            "RCPTENDDT": "2020-12-31 12:00:00.0",
            "AREANM": "마포구",
            "IMGURL": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2012/12/28/S120605140843257226&n=9rXvLr3Mi22Y43ThKyhC8Ty977b2nf&on=S120605140843257226.jpg",
            "DTLCONT": "<p>1. 공공시설 예약서비스 이용시 필수 준수사항</p><p>모든 서비스의 이용은 담당 기관의 규정에 따릅니다. 각 시설의 규정 및 허가조건을 반드시 준수하여야 합니다.</p><p>각 관리기관의 시설물과 부대시설을 이용함에 있어 담당자들과 협의 후 사용합니다.</p><p>각 관리기관의 사고 발생시 서울시청에서는 어떠한 책임도 지지않습니다.</p><p>시설이용료 납부는 각 관리기관에서 규정에 준 합니다.</p><p>본 사이트와 각 관리기관의 규정을 위반할시에는 시설이용 취소 및 시설이용 불허의 조치를 취할 수 있습니다.</p><p>접수시간을 기준으로 브라우저에서 새로고침을 하면 변경된 정보를 볼 수 있습니다.</p><p>2. 시설예약</p><p>비회원일 경우에는 실명 확인을 통하여 사용하실 수 있으며 서울시 통합 회원에 가입 하시게 되면 서울시에서 제공하는 다양하고 많은 혜택을 받으실 수 있습니다.</p><p>3. 상세내용</p><!--StartFragment-->&nbsp;\r\n<p style=\"text-align: left; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">&clubs; 2020년 평일 주간 예약신청</span></p>\r\n<p style=\"text-align: left; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">가. 신청기간 : </span><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold; text-decoration: underline;\">사용일 30일 전 12:00</span><span style=\"text-decoration: underline;\"><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\">부터</span><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\"> 1일 전 18:00까지 </span><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\">선착순</span></span></p>\r\n<p style=\"text-align: justify; line-height: 160%; text-indent: ",
            "V_MIN": "06:00",
            "V_MAX": "9:00",
            "REVSTDDAYNM": "이용일",
            "REVSTDDAY": "1"
        }
    ],
    "pageInfo": {
        "totalCount": 224,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 2,
        "firstPage": 1,
        "lastPage": 112
    }
}
~~~

체육 시설 후기 조회

~~~
GET http://localhost:8080/sport/reservation/comments?svcId={체육 시설 svcid}&size=10&page=1
~~~

request example: 
~~~
GET http://localhost:8080/sport/reservation/comments?svcId=S200102152019666829&size=5&page=1
~~~
response example:
~~~
{
    "content": [
        {
            "id": "5e9fec66161eea2327b3f6da",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 4,
            "comment": "좋아요",
            "registerDate": "2020-04-22T07:04:06.453+0000",
            "updateDate": "2020-04-22T07:04:06.453+0000"
        },
        {
            "id": "5e981f7f5e225d2d28f02449",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 5,
            "comment": "test comment",
            "registerDate": "2020-04-16T09:03:58.934+0000",
            "updateDate": "2020-04-16T09:03:58.934+0000"
        },
        {
            "id": "5e61ce85a2a0f325acd127f1",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 5,
            "comment": "test comment",
            "registerDate": "2020-03-06T04:16:04.895+0000",
            "updateDate": "2020-03-06T04:16:04.895+0000"
        },
        {
            "id": "5e61ac377cb5f51415536979",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 4,
            "comment": "test comment"
        },
        {
            "id": "5e61ad135d22ab27818f32b1",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 4,
            "comment": "test comment"
        }
    ],
    "pageInfo": {
        "totalCount": 9,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 5,
        "firstPage": 1,
        "lastPage": 2
    }
}
~~~

체육 시설 후기 등록

~~~
POST http://localhost:8080/sport/reservation/comment

body {
   "svcId": "{예약 정보 svcid}",
   "userName" : "{후기 등록할 닉네임}",
   "password": "{후기 등록 후 수정/삭제를 위한 password}",
   "rating": {1~5 별점},
   "comment": "{후기 내용}" 
}
~~~

request example: 
~~~
POST http://localhost:8080/sport/reservation/comment
body : {
       	    "svcId": "S200102152019666829",
               "userName" : "tester",
               "password": "123123",
               "rating": 3,
               "comment": "보통이에요"
       }
~~~

response example: 
~~~
{
    "id": "5e9fee7e161eea2327b3f6db",
    "svcId": "S200102152019666829",
    "userName": "tester",
    "rating": 3,
    "comment": "보통이에요",
    "registerDate": "2020-04-22T07:13:02.795+0000",
    "updateDate": "2020-04-22T07:13:02.795+0000"
}
~~~

체육 시설 후기 수정

~~~
PUT http://localhost:8080/sport/reservation/comment

body : {
            "id": "{id}",
            "password": "{후기 등록 후 수정/삭제를 위한 password}",
            "rating": {1~5 별점},
            "comment": "{후기 내용}"
        }
~~~

request example:
~~~
PUT http://localhost:8080/sport/reservation/comment

body: {
            "id": "5e9fee7e161eea2327b3f6db",
      	    "password": "123123",
            "rating": 4,
            "comment": "괜찮아요"
      }

~~~
response example: 
~~~
{
    "id": "5e9fee7e161eea2327b3f6db",
    "svcId": "S200102152019666829",
    "userName": "tester",
    "rating": 4,
    "comment": "괜찮아요",
    "registerDate": "2020-04-22T07:13:02.795+0000",
    "updateDate": "2020-04-27T05:15:34.186+0000"
}
~~~

체육 시설 후기 삭제

~~~
DELETE http://localhost:8080/sport/reservation/comment?password={후기 등록 후 수정/삭제를 위한 password}&id={id}
~~~

request example: 

~~~
DELETE http://localhost:8080/sport/reservation/comment?password=123123&id=5e9fee7e161eea2327b3f6db
~~~

response example: 
~~~
200 OK
~~~

문화 시설 예약 목록 조회
~~~
GET http://localhost:8080/culture/reservations?size=한번에 조회할 데이터 크기&page=조회할 페이지&category={ALL, COMPETITION, EXHIBITION, PREVIEW, PERFORMANCE, CONCERT}
~~~
request example:
~~~
GET http://localhost:8080/culture/reservations?size=2&page=1&category=EXHIBITION 
~~~
response example: 
~~~
{
    "content": [
        {
            "GUBUN": "자체",
            "SVCID": "S191212150329702277",
            "MAXCLASSNM": "문화행사",
            "MINCLASSNM": "전시/관람",
            "SVCSTATNM": "접수중",
            "SVCNM": "최규하 가옥 전시관람",
            "PAYATNM": "무료",
            "PLACENM": "최규하대통령가옥 ",
            "USETGTINFO": "제한없음",
            "SVCURL": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S191212150329702277",
            "X": "37.555340210386554",
            "Y": "126.9149254525266",
            "SVCOPNBGNDT": "2020-01-01 00:00:00.0",
            "SVCOPNENDDT": "2020-12-31 00:00:00.0",
            "RCPTBGNDT": "2020-01-01 00:00:00.0",
            "RCPTENDDT": "2020-12-30 22:00:00.0",
            "AREANM": "마포구",
            "NOTICE": "눈으로 즐겁게 관람 부탁드립니다 ^^",
            "IMG_PATH": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2019/12/12/S191212150329702277&n=6Ba7EgRuL28wO55PU918NeP2T4I2qt&on=최규하가옥전경.jpg",
            "V_MIN": "10:00",
            "V_MAX": "18:00",
            "REVSTDDAYNM": "이용일",
            "REVSTDDAY": "1",
            "tel": "02-2133-2628"
        },
        {
            "GUBUN": "자체",
            "SVCID": "S191212154137223185",
            "MAXCLASSNM": "문화행사",
            "MINCLASSNM": "전시/관람",
            "SVCSTATNM": "접수중",
            "SVCNM": "박정희 가옥 전시관람 ",
            "PAYATNM": "무료",
            "PLACENM": "박정희 대통령 가옥 ",
            "USETGTINFO": "제한없음",
            "SVCURL": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S191212154137223185",
            "X": "37.56147074284965",
            "Y": "127.01985673233767",
            "SVCOPNBGNDT": "2020-01-01 00:00:00.0",
            "SVCOPNENDDT": "2020-12-31 00:00:00.0",
            "RCPTBGNDT": "2020-01-01 00:00:00.0",
            "RCPTENDDT": "2020-12-30 22:00:00.0",
            "AREANM": "중구",
            "NOTICE": "눈으로 즐겁게 관람 부탁드립니다 ^^",
            "IMG_PATH": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2019/12/12/S191212154137223185&n=qACE5owYpeJ6o729KTJ25UQpNj1Pij&on=_DSC4120.JPG",
            "V_MIN": "10:00",
            "V_MAX": "18:00",
            "REVSTDDAYNM": "이용일",
            "REVSTDDAY": "1",
            "tel": "02-2133-2628"
        }
    ],
    "pageInfo": {
        "totalCount": 15,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 2,
        "firstPage": 1,
        "lastPage": 8
    }
}
~~~

문화 시설 후기 조회

~~~
GET http://localhost:8080/culture/reservation/comments?svcId={체육 시설 svcid}&size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/culture/reservation/comments?svcId=S200102152019666829&size=5&page=1
~~~

response example:
~~~
{
    "content": [
        {
            "id": "5eb89b5e35b5a81fd81ee9c1",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 2,
            "comment": "그저 그래요",
            "registerDate": "2020-05-11T00:25:02.874+0000",
            "updateDate": "2020-05-11T00:25:02.874+0000"
        },
        {
            "id": "5eb89b5035b5a81fd81ee9c0",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 1,
            "comment": "싫어요",
            "registerDate": "2020-05-11T00:24:48.435+0000",
            "updateDate": "2020-05-11T00:24:48.435+0000"
        },
        {
            "id": "5eb89b3435b5a81fd81ee9bf",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 4,
            "comment": "좋아요",
            "registerDate": "2020-05-11T00:24:20.744+0000",
            "updateDate": "2020-05-11T00:24:20.744+0000"
        },
        {
            "id": "5e65e5e321745d2282b5d99c",
            "svcId": "S200102152019666829",
            "userName": "tester",
            "rating": 5,
            "comment": "test comment",
            "registerDate": "2020-03-09T06:44:50.872+0000",
            "updateDate": "2020-03-09T06:44:50.872+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 4,
        "hasNext": false,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 4,
        "firstPage": 1,
        "lastPage": 1
    }
}
~~~
문화 시설 후기 등록

~~~
POST http://localhost:8080/culture/reservation/comment

body {
   "svcId": "{예약 정보 svcid}",
   "userName" : "{후기 등록할 닉네임}",
   "password": "{후기 등록 후 수정/삭제를 위한 password}",
   "rating": {1~5 별점},
   "comment": "{후기 내용}" 
}
~~~

request example: 
~~~
POST http://localhost:8080/culture/reservation/comment
body : {
       	    "svcId": "S200102152019666829",
               "userName" : "tester",
               "password": "123123",
               "rating": 3,
               "comment": "보통이에요"
       }
~~~

response example: 
~~~
{
    "id": "5eb89bef35b5a81fd81ee9c2",
    "svcId": "S200102152019666829",
    "userName": "tester",
    "rating": 3,
    "comment": "보통이에요",
    "registerDate": "2020-05-11T00:27:27.471+0000",
    "updateDate": "2020-05-11T00:27:27.471+0000"
}
~~~

문화 시설 후기 수정

~~~
PUT http://localhost:8080/culture/reservation/comment

body : {
            "id": "{id}",
            "password": "{후기 등록 후 수정/삭제를 위한 password}",
            "rating": {1~5 별점},
            "comment": "{후기 내용}"
        }
~~~

request example:
~~~
PUT http://localhost:8080/culture/reservation/comment

body: {
          "id": "5eb89bef35b5a81fd81ee9c2",
      	  "password": "123123",
          "rating": 4,
          "comment": "괜찮아요"
      }

~~~
response example: 
~~~
{
    "id": "5eb89bef35b5a81fd81ee9c2",
    "svcId": "S200102152019666829",
    "userName": "tester",
    "rating": 4,
    "comment": "괜찮아요",
    "registerDate": "2020-05-11T00:27:27.471+0000",
    "updateDate": "2020-05-11T00:28:39.047+0000"
}
~~~

체육 시설 후기 삭제

~~~
DELETE http://localhost:8080/culture/reservation/comment?password={후기 등록 후 수정/삭제를 위한 password}&id={id}
~~~

request example: 

~~~
DELETE http://localhost:8080/culture/reservation/comment?password=123123&id=5eb89bef35b5a81fd81ee9c2
~~~

response example: 
~~~
200 OK
~~~

게시글 조회

~~~
GET http://localhost:8080/community/post?id={게시글 id}
~~~

request example: 
~~~
GET http://localhost:8080/community/post?id=5eb9ee71ade7d537db018f3e
~~~

response example:
~~~
{
    "id": "5eb9ee71ade7d537db018f3e",
    "username": "tester",
    "postCategory": "SOCCER",
    "title": "업데이트 제목",
    "content": "업데이트 내용3",
    "viewCount": 1,
    "registerDate": "2020-05-12T00:31:45.220+0000",
    "updateDate": "2020-05-14T07:36:37.938+0000"
}
~~~

게시글 등록

~~~
POST http://localhost:8080/community/post

body {
   "username" : "{게시글 등록할 닉네임}",
   "password": "{게시글 등록 후 수정/삭제를 위한 password}",
   "postCategory": "{SOCCER, BASEBALL, BASKETBALL}"
   "title": {제목},
   "content": "{본문}" 
}
~~~

request example: 
~~~
POST http://localhost:8080/community/post
body : {
            "username" : "tester",
            "password" : "123123",
            "postCategory" : "SOCCER",
            "title": "제목",
            "content" : "내용"
        }
~~~

response example: 
~~~
{
    "id": "5eb9eac3ade7d537db018f37",
    "username": "tester",
    "postCategory": "SOCCER",
    "title": "제목",
    "content": "내용",
    "viewCount": 0,
    "registerDate": "2020-05-12T00:16:03.080+0000",
    "updateDate": "2020-05-12T00:16:03.080+0000"
}
~~~

게시글 수정

~~~
PUT http://localhost:8080/community/post

body {
   "password": "{게시글 등록 후 수정/삭제를 위한 password}",
   "id": "{게시글 id}"
   "title": {제목},
   "content": "{본문}" 
}
~~~

request example: 
~~~
PUT http://localhost:8080/community/post
body : {
           "id": "5eb9ee71ade7d537db018f3e",
           "title": "업데이트 제목",
           "content": "업데이트 내용3",
           "password": "123123"
       }
~~~

response example: 
~~~
{
    "id": "5eb9ee71ade7d537db018f3e",
    "username": "tester",
    "postCategory": "SOCCER",
    "title": "업데이트 제목",
    "content": "업데이트 내용3",
    "viewCount": 0,
    "registerDate": "2020-05-12T00:31:45.220+0000",
    "updateDate": "2020-05-12T00:35:45.468+0000"
}
~~~

게시글 삭제

~~~
DELETE http://localhost:8080/community/post?password={게시글 등록 후 수정/삭제를 위한 password}&id={id}
~~~

request example: 

~~~
DELETE http://localhost:8080/community/post?password=123123&id=5ebbb850e48a084ae5d50ebf
~~~

response example: 
~~~
200 OK
~~~

모든 카테고리 게시글 조회

~~~
GET http://localhost:8080/community/posts?size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/community/posts?size=5&page=1
~~~

response example:
~~~
{
    "content": [
        {
            "id": "5eb9ee71ade7d537db018f3e",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "업데이트 제목",
            "content": "업데이트 내용3",
            "viewCount": 1,
            "registerDate": "2020-05-12T00:31:45.220+0000",
            "updateDate": "2020-05-14T07:36:37.938+0000"
        },
        {
            "id": "5eb9ee62ade7d537db018f3d",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 테스트",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:30.599+0000",
            "updateDate": "2020-05-12T00:31:30.599+0000"
        },
        {
            "id": "5eb9ee5aade7d537db018f3c",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 제목",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:22.982+0000",
            "updateDate": "2020-05-12T00:31:22.982+0000"
        },
        {
            "id": "5eb9ee51ade7d537db018f3b",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목00",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:13.372+0000",
            "updateDate": "2020-05-12T00:31:13.372+0000"
        },
        {
            "id": "5eb9ee4bade7d537db018f3a",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목4",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:07.797+0000",
            "updateDate": "2020-05-12T00:31:07.797+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 8,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 5,
        "firstPage": 1,
        "lastPage": 2
    }
}
~~~

특정 카테고리 게시글 조회

~~~
GET http://localhost:8080/community/posts/search/category/{SOCCER, BASEBALL, BASKETBALL}?size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/community/posts/search/category/SOCCER?size=5&page=1
~~~

response example:

~~~
{
    "content": [
        {
            "id": "5eb9ee71ade7d537db018f3e",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "업데이트 제목",
            "content": "업데이트 내용3",
            "viewCount": 1,
            "registerDate": "2020-05-12T00:31:45.220+0000",
            "updateDate": "2020-05-14T07:36:37.938+0000"
        },
        {
            "id": "5eb9ee62ade7d537db018f3d",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 테스트",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:30.599+0000",
            "updateDate": "2020-05-12T00:31:30.599+0000"
        },
        {
            "id": "5eb9ee5aade7d537db018f3c",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 제목",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:22.982+0000",
            "updateDate": "2020-05-12T00:31:22.982+0000"
        },
        {
            "id": "5eb9ee51ade7d537db018f3b",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목00",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:13.372+0000",
            "updateDate": "2020-05-12T00:31:13.372+0000"
        },
        {
            "id": "5eb9ee4bade7d537db018f3a",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목4",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:07.797+0000",
            "updateDate": "2020-05-12T00:31:07.797+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 8,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 5,
        "firstPage": 1,
        "lastPage": 2
    }
}
~~~

특정 카테고리 게시글 본문 검색

~~~
GET http://localhost:8080/community/posts/search/category/{SOCCER, BASEBALL, BASKETBALL}/content?keyword=검색 키워드size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/community/posts/search/category/SOCCER/content?keyword=내용&size=5&page=1
~~~

response example:
~~~
{
    "content": [
        {
            "id": "5eb9ee71ade7d537db018f3e",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "업데이트 제목",
            "content": "업데이트 내용3",
            "viewCount": 1,
            "registerDate": "2020-05-12T00:31:45.220+0000",
            "updateDate": "2020-05-14T07:36:37.938+0000"
        },
        {
            "id": "5eb9ee62ade7d537db018f3d",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 테스트",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:30.599+0000",
            "updateDate": "2020-05-12T00:31:30.599+0000"
        },
        {
            "id": "5eb9ee5aade7d537db018f3c",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 제목",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:22.982+0000",
            "updateDate": "2020-05-12T00:31:22.982+0000"
        },
        {
            "id": "5eb9ee51ade7d537db018f3b",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목00",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:13.372+0000",
            "updateDate": "2020-05-12T00:31:13.372+0000"
        },
        {
            "id": "5eb9ee4bade7d537db018f3a",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목4",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:07.797+0000",
            "updateDate": "2020-05-12T00:31:07.797+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 8,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 5,
        "firstPage": 1,
        "lastPage": 2
    }
}
~~~

특정 카테고리 게시글 제목 검색

~~~
GET http://localhost:8080/community/posts/search/category/{SOCCER, BASEBALL, BASKETBALL}/title?keyword=검색 키워드size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/community/posts/search/category/SOCCER/title?keyword=테스트%20테스트&size=5&page=1
~~~

response example:
~~~
{
    "content": [
        {
            "id": "5eb9ee62ade7d537db018f3d",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 테스트",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:30.599+0000",
            "updateDate": "2020-05-12T00:31:30.599+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 1,
        "hasNext": false,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 1,
        "firstPage": 1,
        "lastPage": 1
    }
}
~~~

특정 카테고리 게시글 글쓴이 검색

~~~
GET http://localhost:8080/community/posts/search/category/{SOCCER, BASEBALL, BASKETBALL}/uesrname?keyword=검색 키워드size=한번에 조회할 데이터 크기&page=페이지 번호
~~~

request example: 
~~~
GET http://localhost:8080/community/posts/search/category/SOCCER/username?keyword=tester&size=5&page=1
~~~

response example:
~~~
{
    "content": [
        {
            "id": "5eb9ee71ade7d537db018f3e",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "업데이트 제목",
            "content": "업데이트 내용3",
            "viewCount": 1,
            "registerDate": "2020-05-12T00:31:45.220+0000",
            "updateDate": "2020-05-14T07:36:37.938+0000"
        },
        {
            "id": "5eb9ee62ade7d537db018f3d",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 테스트",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:30.599+0000",
            "updateDate": "2020-05-12T00:31:30.599+0000"
        },
        {
            "id": "5eb9ee5aade7d537db018f3c",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "테스트 제목",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:22.982+0000",
            "updateDate": "2020-05-12T00:31:22.982+0000"
        },
        {
            "id": "5eb9ee51ade7d537db018f3b",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목00",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:13.372+0000",
            "updateDate": "2020-05-12T00:31:13.372+0000"
        },
        {
            "id": "5eb9ee4bade7d537db018f3a",
            "username": "tester",
            "postCategory": "SOCCER",
            "title": "제목4",
            "content": "내용3",
            "viewCount": 0,
            "registerDate": "2020-05-12T00:31:07.797+0000",
            "updateDate": "2020-05-12T00:31:07.797+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 8,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 5,
        "firstPage": 1,
        "lastPage": 2
    }
}
~~~

게시물 댓글 조회
~~~
GET http://localhost:8080/community/post/comments?size=한번에 조회할 데이터 크기&page=페이지 번호&postId=게시글 id
~~~

request example: 

~~~
GET http://localhost:8080/community/post/comments?size=10&page=1&postId=5eb9eac3ade7d537db018f37
~~~

response example: 

~~~
{
    "content": [
        {
            "id": "5ec20880dd032d1d2cfed69c",
            "userName": "테스터",
            "comment": "테스트 댓글",
            "registerDate": "2020-05-18T04:01:04.237+0000",
            "updateDate": "2020-05-18T04:01:04.237+0000"
        }
    ],
    "pageInfo": {
        "totalCount": 1,
        "hasNext": false,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 1,
        "firstPage": 1,
        "lastPage": 1
    }
}
~~~


게시글 댓글 작성

~~~
POST http://localhost:8080/community/post/comment

Body: {
    postId: "{게시글 id}",
    username: "{댓글을 등록할 사용자 이름}",
    password: "{댓글을 수정/삭제할 password}",
    comment: "{댓글 내용}"     
}
~~~

request example: 
~~~
POST http://localhost:8080/community/post/comment

Body: {
    "postId": "5eb9eac3ade7d537db018f37",
    "username": "테스터",
    "password": "123456",
    "comment": "테스트 댓글"
}
~~~

response example:

~~~
{
    "id": "5ec20880dd032d1d2cfed69c",
    "userName": "테스터",
    "comment": "테스트 댓글",
    "registerDate": "2020-05-18T04:01:04.237+0000",
    "updateDate": "2020-05-18T04:01:04.237+0000"
}
~~~

게시글 댓글 수정

~~~
PUT http://localhost:8080/community/post/comment

Body: {
    id: "{댓글 id}",
    password: "{댓글을 수정/삭제할 password}",
    comment: "{업데이트 할 댓글 내용}"     
}
~~~

request example: 
~~~
PUT http://localhost:8080/community/post/comment

Body: {
    "id": "5ec20880dd032d1d2cfed69c",
    "password": "123456",
    "comment": "테스트 update 댓글"
}
~~~

response example: 
~~~
{
    "id": "5ec20880dd032d1d2cfed69c",
    "password": "123456",
    "comment": "테스트 update 댓글"
}
~~~

게시글 댓글 삭제
~~~
DELETE http://localhost:8080/community/post/comment?password={게시글 등록 후 수정/삭제를 위한 password}&id={id}
~~~

request example: 

~~~
DELETE http://localhost:8080/community/post/comment?password=123456&id=5eb9eac3ade7d537db018f37
~~~

response example: 
~~~
200 OK
~~~

  