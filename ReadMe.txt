�ۼ��� : ����3�� ������
�ۼ���¥ : 2016/01/15

*** ��Ŭ���� conf���ù� ***
Main ���α׷� ��Ŭ�� -> Run As -> Run Configurations -> Java Application ����Ŭ�� -> [Main]�� ������Ʈ(Daegu_thread), Main class (DaeguConnMain / DaeguCivilMain) ���� ���� -> [Classpath]�� User Entries Ŭ�� - > Advanced Ŭ�� -> Add Folders Ŭ�� �� [OK] -> ���� [conf]��  ���� �� [OK] -> [Apply] Ŭ�� �� [Run]

*** sh ���ϵ� ***
�⺻������ �����ϴ� sh�� run�� ���� ���ϵ��Դϴ�.
run_conn.sh : DaeguConnMain ���� (�������������а� ATMS���� ������� �����͵��� tibero�� ����)
run_civil.sh : DaeguCivilMain ���� (�ο��� ����.����Ŭ -> Ƽ����)
run_rain.sh : DaeguRainMain ���� (���������� ����. mysql -> Ƽ����)

stop_xxx.sh : ���� ���������� ������ java ���μ����� ������.

start_all.sh : run ���ϵ��� �ѹ��� �����ϴ� �� ����.
shutdown_all.sh : ���� ���� conn, civil, rain ���η��� ��� ������.

rm_log.sh : �α������� ����� �� ��ũ��Ʈ�� crontab�� �������� �Ǿ��ֽ��ϴ�.
crontab -l �ϸ� ��ϵ� ����Ʈ�� �� ����.
������������ �ϸ� �ش� sh�� ũ�п� ����ؾ��մϴ�. ��δ� �����η� ���� ��.
#crontab -e : 00 01 # # # /root/daegu/Daegu_thread/sh/rm_log.sh


Ȥ�� ������������ �۾� �� ���α׷��� ������� ������ �Ʒ��� �ش��ϴ� ������ telnet���� �پ ��.
===============���輭������ �����ϴ� ��================
��� ���� : http://hibernate.org
�ǽð� ���� ���� : http://car.daegu.go.kr/atmshome/pubcdata/linkInfo.jsp
����/��� ���� : http://car.daegu.go.kr/atmshome/SVC/IF004_R_01.jsp?type=4

���� ��Ȳ, Ȳ��, ���Ư��, ��ǳ  : http://newsky2.kma.go.kr/service/~~~~~~�����͸��� �ٸ�
�ش� ��/���� ������ǥ �ڵ� : http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl.27.json.txt 
��/���� ���� ������ǥ �ڵ�  : http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf.%s.json.txt (%s�� ����������, ������ �޾ƿ� �������� ���� ����)

��/�� ���� : http://opendata.kwater.or.kr/openapi-data/service/pubd/dam/sluicePresentCondition/hour/list
--------------------------���� ��Ȳ, Ȳ��, ���Ư��, ��ǳ�� �� url------------------------
���� ��Ȳ : http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib
Ȳ�� : http://newsky2.kma.go.kr/service/YlwsndInfoService/NationalDustStromObservation
��� Ư�� : http://newsky2.kma.go.kr/service/WetherSpcnwsInfoService/WeatherWarningList
��ǳ : http://newsky2.kma.go.kr/service/TyphnInfoService/TyphoonInformation

newsky2.kma.go.kr  	203.247.66.147 
www.kma.go.kr		1.201.64.19
opendata.kwater.or.kr	203.237.3.199
car.daegu.go.kr		210.91.152.33	