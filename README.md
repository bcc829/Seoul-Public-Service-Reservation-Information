# Seoul-Public-Service-Reservation-Information
서울시 및 산하기관, 자치구의 체육시설 중 예약가능한 목록 정보와 서울시 문화행사 공공서비스예약 정보를 제공합니다.

언어: Kotlin

프레임워크: spring-webflux 

스토리지 엔진: MongoDB

---
주의점: 서울열린데이터광장의 open api를 이용 하고 있으며 실행 시 open api의 키 값이 필요합니다.
https://data.seoul.go.kr 에서 api key를 발급 받으신 후 실행 시 환경 변수 값을 api.key={발급 받은 키}로 등록 하셔야 합니다.
또는 application.yml에 다음과 같이 작성하셔도 됩니다.
api:
  key: {발급 받은 키}
---

체육시설 예약 목록 조회

http://localhost:8080/sport/reservations?size=한번에 조회할 데이터 크기&page=조회할 페이지&category={ALL, SOCCER_STADIUM, FUTSAL_STADIUM,
TENNIS_COURT, FOOTBALL_COURT, BASKETBALL_COURT, MULTIPURPOSE_STADIUM, VOLLEYBALL_COURT, BADMINTON_COURT, FUTSAL, PLAYGROUND, GYM, TABLE_TENNIS_COURT,
PARK_GOLF_COURSE}

request example:
GET http://localhost:8080/sport/reservations?size=2&page=1&category=ALL 

response example: 

~~~
{
    "content": [
        {
            "y": "126.88390026512282",
            "x": "37.574238294219086",
            "svcid": "S120423174310156240",
            "svcnm": "△ [야간] 마포 난지천 인조잔디 축구장",
            "areanm": "마포구",
            "svcopnbgndt": "2012-04-23 00:00:00.0",
            "imgurl": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2012/12/28/S120423174310156240&n=hu69ma3H7VZ1cGm496P23na3qbQ9Lp&on=S120423174310156240.jpg",
            "maxclassnm": "체육시설",
            "revstddaynm": "이용일",
            "minclassnm": "축구장",
            "placenm": "월드컵공원>난지천인조잔디축구장",
            "svcopnenddt": "2020-12-31 00:00:00.0",
            "rcptenddt": "2020-12-31 00:00:00.0",
            "svcurl": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S120423174310156240",
            "gubun": "자체",
            "v_MAX": "22:00",
            "rcptbgndt": "2019-11-01 09:00:00.0",
            "usetgtinfo": "제한없음",
            "dtlcont": "<p>1. 공공시설 예약서비스 이용시 필수 준수사항</p><p>모든 서비스의 이용은 담당 기관의 규정에 따릅니다. 각 시설의 규정 및 허가조건을 반드시 준수하여야 합니다.</p><p>각 관리기관의 시설물과 부대시설을 이용함에 있어 담당자들과 협의 후 사용합니다.</p><p>각 관리기관의 사고 발생시 서울시청에서는 어떠한 책임도 지지않습니다.</p><p>시설이용료 납부는 각 관리기관에서 규정에 준 합니다.</p><p>본 사이트와 각 관리기관의 규정을 위반할시에는 시설이용 취소 및 시설이용 불허의 조치를 취할 수 있습니다.</p><p>접수시간을 기준으로 브라우저에서 새로고침을 하면 변경된 정보를 볼 수 있습니다.</p><p>2. 시설예약</p><p>비회원일 경우에는 실명 확인을 통하여 사용하실 수 있으며 서울시 통합 회원에 가입 하시게 되면 서울시에서 제공하는 다양하고 많은 혜택을 받으실 수 있습니다.</p><p>3. 상세내용</p><p><!--StartFragment--><span style=\"text-align: left; line-height: 14.4pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">예약이 완료 된 팀은 마이페이지 예약 확인증을 인출하여 난지천 축구장</span> <span style=\"text-align: left; line-height: 14.4pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">관리자에게 확인시켜 주시기 바랍니다.</span></p>\r\n<p style=\"text-align: left; line-height: 120%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: justify; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\"><span style=\"text-align: justify; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\"><!--StartFragment--></span></span></p>\r\n<p class=\"바탕글\" style=\"margin-bottom: 1.6pt;\"><span style=\"font-family: HY그래픽; font-size: 12pt; font-weight: bold; mso-fareast-font-family: HY그래픽; mso-hansi-font-family: HY그래픽;\" lang=\"EN-US\">&clubs;</span><span style=\"color: #ff0000; font-family: HY그래픽; font-size: 15pt; font-weight: bold; mso-hansi-font-family: HY그래픽; mso-ascii-font-family: HY그래픽;\">휴대폰번호 및 주소 미기재 시 예약취소합니다</span><span style=\"font-family: HY그래픽; font-size: 12pt; font-weight: bold; mso-fareast-font-family: HY그래픽; mso-hansi-font-family: HY그래픽;\" lang=\"EN-US\"> &clubs; </span></p>\r\n<p style=\"text-align: justify; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color",
            "v_MIN": "18:00",
            "revstdday": "1",
            "svcstatnm": "예약일시중지",
            "payatnm": "유료"
        },
        {
            "y": "126.88390026512282",
            "x": "37.574238294219086",
            "svcid": "S120605140843257226",
            "svcnm": "○ [평일] <오전>마포 난지천 인조잔디축구장",
            "areanm": "마포구",
            "svcopnbgndt": "2012-04-23 00:00:00.0",
            "imgurl": "https://yeyak.seoul.go.kr/fileDownload.web?p=/TB_SVCIMG/2012/12/28/S120605140843257226&n=9rXvLr3Mi22Y43ThKyhC8Ty977b2nf&on=S120605140843257226.jpg",
            "maxclassnm": "체육시설",
            "revstddaynm": "이용일",
            "minclassnm": "축구장",
            "placenm": "월드컵공원>난지천인조잔디축구장",
            "svcopnenddt": "2020-12-31 00:00:00.0",
            "rcptenddt": "2020-12-31 12:00:00.0",
            "svcurl": "http://yeyak.seoul.go.kr/reservation/view.web?rsvsvcid=S120605140843257226",
            "gubun": "자체",
            "v_MAX": "9:00",
            "rcptbgndt": "2019-11-01 09:00:00.0",
            "usetgtinfo": "제한없음",
            "dtlcont": "<p>1. 공공시설 예약서비스 이용시 필수 준수사항</p><p>모든 서비스의 이용은 담당 기관의 규정에 따릅니다. 각 시설의 규정 및 허가조건을 반드시 준수하여야 합니다.</p><p>각 관리기관의 시설물과 부대시설을 이용함에 있어 담당자들과 협의 후 사용합니다.</p><p>각 관리기관의 사고 발생시 서울시청에서는 어떠한 책임도 지지않습니다.</p><p>시설이용료 납부는 각 관리기관에서 규정에 준 합니다.</p><p>본 사이트와 각 관리기관의 규정을 위반할시에는 시설이용 취소 및 시설이용 불허의 조치를 취할 수 있습니다.</p><p>접수시간을 기준으로 브라우저에서 새로고침을 하면 변경된 정보를 볼 수 있습니다.</p><p>2. 시설예약</p><p>비회원일 경우에는 실명 확인을 통하여 사용하실 수 있으며 서울시 통합 회원에 가입 하시게 되면 서울시에서 제공하는 다양하고 많은 혜택을 받으실 수 있습니다.</p><p>3. 상세내용</p><!--StartFragment-->&nbsp;\r\n<p style=\"text-align: left; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">&clubs; 2020년 평일 주간 예약신청</span></p>\r\n<p style=\"text-align: left; line-height: 160%; text-indent: 0pt; margin: 0pt; font-family: 'HY그래픽'; color: #000000; font-size: 12pt;\"><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold;\">가. 신청기간 : </span><span style=\"text-align: left; line-height: 19.2pt; font-family: 'HY그래픽'; letter-spacing: 0pt; color: #000000; font-size: 12pt; font-weight: bold; text-decoration: underline;\">사용일 30일 전 12:00</span><span style=\"text-decoration: underline;\"><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\">부터</span><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\"> 1일 전 18:00까지 </span><span style=\"text-align: left; color: #000000; line-height: 19.2pt; letter-spacing: 0pt; font-family: 'HY그래픽'; font-size: 12pt; font-weight: bold; text-decoration: underline;\">선착순</span></span></p>\r\n<p style=\"text-align: justify; line-height: 160%; text-indent: ",
            "v_MIN": "06:00",
            "revstdday": "1",
            "svcstatnm": "예약일시중지",
            "payatnm": "유료"
        }
    ],
    "pageInfo": {
        "totalCount": 212,
        "hasNext": true,
        "isLast": false,
        "isFirst": true,
        "numberOfElements": 2,
        "firstPage": 1,
        "lastPage": 106
    }
}
~~~
