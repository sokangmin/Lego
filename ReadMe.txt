작성자 : 개발3팀 박진영
작성날짜 : 2016/01/15

*** 이클립스 conf셋팅법 ***
Main 프로그램 우클릭 -> Run As -> Run Configurations -> Java Application 더블클릭 -> [Main]탭 프로젝트(Daegu_thread), Main class (DaeguConnMain / DaeguCivilMain) 으로 셋팅 -> [Classpath]탭 User Entries 클릭 - > Advanced 클릭 -> Add Folders 클릭 후 [OK] -> 폴더 [conf]를  지정 후 [OK] -> [Apply] 클릭 후 [Run]

*** sh 파일들 ***
기본적으로 실행하는 sh는 run이 붙은 파일들입니다.
run_conn.sh : DaeguConnMain 실행 (공공데이터포털과 ATMS에서 연계받은 데이터들을 tibero로 연계)
run_civil.sh : DaeguCivilMain 실행 (민원쪽 연계.오라클 -> 티베로)
run_rain.sh : DaeguRainMain 실행 (빗문펌프장 연계. mysql -> 티베로)

stop_xxx.sh : 위와 마찬가지로 각자의 java 프로세스를 중지함.

start_all.sh : run 파일들을 한번에 실행하는 쉘 파일.
shutdown_all.sh : 실행 중인 conn, civil, rain 프로램을 모두 내린다.

rm_log.sh : 로그파일을 지우는 쉘 스크립트로 crontab에 실행등록이 되어있습니다.
crontab -l 하면 등록된 리스트볼 수 있음.
서버이전등을 하면 해당 sh를 크론에 등록해야합니다. 경로는 절대경로로 적을 것.
#crontab -e : 00 01 # # # /root/daegu/Daegu_thread/sh/rm_log.sh


혹시 서버이전등의 작업 후 프로그램이 실행되지 않으면 아래에 해당하는 곳들을 telnet으로 붙어볼 것.
===============연계서버에서 접속하는 곳================
디비 관련 : http://hibernate.org
실시간 교통 정보 : http://car.daegu.go.kr/atmshome/pubcdata/linkInfo.jsp
공사/사고 정보 : http://car.daegu.go.kr/atmshome/SVC/IF004_R_01.jsp?type=4

날씨 실황, 황사, 기상특보, 태풍  : http://newsky2.kma.go.kr/service/~~~~~~데이터마다 다름
해당 군/구의 예보좌표 코드 : http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl.27.json.txt 
군/구의 동의 예보좌표 코드  : http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf.%s.json.txt (%s는 가변데이터, 위에서 받아온 데이터의 값을 넣음)

댐/보 정보 : http://opendata.kwater.or.kr/openapi-data/service/pubd/dam/sluicePresentCondition/hour/list
--------------------------날씨 실황, 황사, 기상특보, 태풍의 상세 url------------------------
날씨 실황 : http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib
황사 : http://newsky2.kma.go.kr/service/YlwsndInfoService/NationalDustStromObservation
기상 특보 : http://newsky2.kma.go.kr/service/WetherSpcnwsInfoService/WeatherWarningList
태풍 : http://newsky2.kma.go.kr/service/TyphnInfoService/TyphoonInformation

newsky2.kma.go.kr  	203.247.66.147 
www.kma.go.kr		1.201.64.19
opendata.kwater.or.kr	203.237.3.199
car.daegu.go.kr		210.91.152.33	