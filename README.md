# JejuPlanner

## 🗒️ 프로젝트 개요

다양한 여행 플래너를 사용하면서 다른 유저들과 여행 계획을 공유 하고싶었습니다. 이에 착안하여 KAKAO Map API, 한국관광공사 Tour API, Spring Framework 를 이용해 제주도 여행 플래너 공유 웹 애플리케이션을 제작했습니다.

## 🚩 프로젝트 기간 & 팀원

- 2021년 5월 6일 - 2021년 6월 16일
- 이진희(팀장), 전형일(팀원), 서종현(팀원)

## ⚙️ Planner 기술 스택

📃 API & Library : Kakao Map API, 한국관광공사 Visit Korea API, Bootstrap

💬 Language : JAVA 8, JavaScript, JSTL, JSP, JQuery, XML

💾 DataBase : MariaDB

🗄️ Framework & Server :  SpringFramework 5.2.13, Maven,  ApacheTomcat 9.0v, Spring Security 5.3.9,  Mybatis 3.5.3

🔨 Tool : Eclipse, Visual Studio Code, Trello, Git, Github

## ✈️ 기능 소개

![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/704879c0-aa01-41dc-b470-4059f1685015/.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T064936Z&X-Amz-Expires=86400&X-Amz-Signature=c45d7f3b109b3a5bbb8e4d17dd156b40664a18e8a80f453caf90f0972f3ed4b3&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/704879c0-aa01-41dc-b470-4059f1685015/.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T064936Z&X-Amz-Expires=86400&X-Amz-Signature=c45d7f3b109b3a5bbb8e4d17dd156b40664a18e8a80f453caf90f0972f3ed4b3&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22.jpg%22)
초기화면  
![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1ce7cb7d-c3d7-40fe-af90-f128e49e3f5e/1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065704Z&X-Amz-Expires=86400&X-Amz-Signature=3bee18d0a360536cc28cb4306ce52de49ae4d47db45bb7434167a3111ff604b5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%221.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1ce7cb7d-c3d7-40fe-af90-f128e49e3f5e/1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065704Z&X-Amz-Expires=86400&X-Amz-Signature=3bee18d0a360536cc28cb4306ce52de49ae4d47db45bb7434167a3111ff604b5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%221.jpg%22)

1. 카카오 맵 API를 이용하여 제주도의 관광 명소, 식당, 숙소 등의 위치정보를 제공받습니다.  


![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/84d96d75-b8e1-4141-823b-3f3d7fc197d6/2.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065743Z&X-Amz-Expires=86400&X-Amz-Signature=8857545bb287e8d1e7da78d9de19e1ca58b5d09e6ca3a49d02585db3c3384472&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%222.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/84d96d75-b8e1-4141-823b-3f3d7fc197d6/2.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065743Z&X-Amz-Expires=86400&X-Amz-Signature=8857545bb287e8d1e7da78d9de19e1ca58b5d09e6ca3a49d02585db3c3384472&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%222.jpg%22)

2. 한국관광공사 API를 통해 관광명소의 사진을 제공 받습니다.   


![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/85eb13df-3e11-408b-8aff-a4b0274026ca/3.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065618Z&X-Amz-Expires=86400&X-Amz-Signature=e87fd063d55b60a1da6a91800e08b79b10e36bd1d9f3bb481e0a2ce4f9048ab0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%223.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/85eb13df-3e11-408b-8aff-a4b0274026ca/3.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065618Z&X-Amz-Expires=86400&X-Amz-Signature=e87fd063d55b60a1da6a91800e08b79b10e36bd1d9f3bb481e0a2ce4f9048ab0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%223.jpg%22)

3. API로부터 제공받은 정보로 일별, 시간별 여행계획을 세울 수 있습니다.  


![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f2c12ea2-469d-44e2-bec8-701b9a3e7bed/4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065824Z&X-Amz-Expires=86400&X-Amz-Signature=678863d3978daee7fde8f1b8eb348e8d2c01acdcdadf697fa97bc42313a4ad3a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%224.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f2c12ea2-469d-44e2-bec8-701b9a3e7bed/4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065824Z&X-Amz-Expires=86400&X-Amz-Signature=678863d3978daee7fde8f1b8eb348e8d2c01acdcdadf697fa97bc42313a4ad3a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%224.jpg%22)

4. 사용자가 일정에 추가한 장소를 언제든 확인할 수 있습니다.  


![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a138111b-c1cf-4197-a6e6-d9d5ec10eb09/5.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065841Z&X-Amz-Expires=86400&X-Amz-Signature=8a59c21c93f1c68e80c2b204ed22f776b7518f815e25da4c844d9e4b3639e3a8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%225.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a138111b-c1cf-4197-a6e6-d9d5ec10eb09/5.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065841Z&X-Amz-Expires=86400&X-Amz-Signature=8a59c21c93f1c68e80c2b204ed22f776b7518f815e25da4c844d9e4b3639e3a8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%225.jpg%22)

![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ee30e24d-80ae-4a2a-929f-d135e8496d65/5-1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065906Z&X-Amz-Expires=86400&X-Amz-Signature=4aa42a1aa91e4e750a0364a2e94dd104ba1d07ad210d1e949cba9baad4e331a0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%225-1.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ee30e24d-80ae-4a2a-929f-d135e8496d65/5-1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065906Z&X-Amz-Expires=86400&X-Amz-Signature=4aa42a1aa91e4e750a0364a2e94dd104ba1d07ad210d1e949cba9baad4e331a0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%225-1.jpg%22)

5. 작성한 계획을 저장하고 '내 일정 보관' 에서 조회, 수정할 수 있습니다.  


![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/35f80e4e-cebc-4332-8838-cb269989d196/6.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065922Z&X-Amz-Expires=86400&X-Amz-Signature=955e367aa9b84e31baf14f2e29fe9525f469d3583dd05b27db2f5f375ffb0f03&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%226.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/35f80e4e-cebc-4332-8838-cb269989d196/6.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065922Z&X-Amz-Expires=86400&X-Amz-Signature=955e367aa9b84e31baf14f2e29fe9525f469d3583dd05b27db2f5f375ffb0f03&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%226.jpg%22)

![https://s3.us-west-2.amazonaws.com/secure.notion-static.com/350312b4-d4dc-410b-97a7-dbfb72ef5fc5/6-1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065938Z&X-Amz-Expires=86400&X-Amz-Signature=842ae6431b84b9c028ea715223cffe03263de318f2d6afe4f4f9f17f36b4323a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%226-1.jpg%22](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/350312b4-d4dc-410b-97a7-dbfb72ef5fc5/6-1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210614%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210614T065938Z&X-Amz-Expires=86400&X-Amz-Signature=842ae6431b84b9c028ea715223cffe03263de318f2d6afe4f4f9f17f36b4323a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%226-1.jpg%22)

6. '공유 일정' 게시판에서 다른 사용자의 여행 계획을 열람할 수 있습니다.  


## 🔗 Planner 깃허브 주소 & 네이버 카페

1. [https://github.com/devgin23/JejuPlanner](https://github.com/devgin23/JejuPlanner)
2. [https://cafe.naver.com/gteamproject](https://cafe.naver.com/gteamproject)

## 💡 Reference

UI(HTML, CSS, Javascript)

1. [https://getbootstrap.com/](https://getbootstrap.com/)

API

1. [https://apis.map.kakao.com/](https://apis.map.kakao.com/)
2. [https://api.visitkorea.or.kr/main.do](https://api.visitkorea.or.kr/main.do)
