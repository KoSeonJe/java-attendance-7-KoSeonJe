# java-attendance-precourse

### 기능

- [x]  초기 데이터를 초기화한다.
- [x]  입력한 시간이 출석, 지각, 결석, 상태인지 판단한다.

출석

- [x]  닉네임을 입력 받는다.
- [x]  등교 시간을 입력 받는다.
- [x]  입력한 등교 시간이 출석, 지각, 결석 상태를 판단한다
- [x]  현재 날짜와 요일, 시간과 함께 출석 상태를 출력한다.

수정

- [x]  수정할 닉네임을 입력 받는다.
- [x]  수정하려는 날짜를 입력 받는다.
- [x]  시간을 변경할 수 있다.
- [x]  입력한시간이 출석, 지각, 결석 상태를 판단한다
- [x]  현재 출석 상태와 바꾼 출석 상태를 비교하여 수정 완료 메시지를 보낸다.

기록확인

- [x]  닉네임을 입력한다.
- [x]  입력한 닉네임의 출석 기록을 나열한다.
- [x]  출석, 지각, 결석 횟수를 총합을 구한다.
- [x]  경고, 면담, 제적 대상자인지 확인한다.

제적위험 확인

- [ ]  경고, 면담 대상자를 모두 출력한다.
- [ ]  제적 위험자 이름과 결석, 지각 현황을 출력한다.

### 예외

- 사용자가 잘못된 값을 입력할 경우, [ERROR]와 함께 IllegalArgumentException을 발생시키고, 애플리케이션을 종료한다.
