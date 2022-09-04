![logo](./img/logo.png)

## ☀️ 봄날의 햇살

---

> WebRTC 기반 자폐 아동 상담 플랫폼 <br>
> 김규란 이준경 최지혜 배한빈 성지훈 이봄

## 📌 목차

---

- [프로젝트 소개](#📁-프로젝트-소개)
  - [프로젝트 목표](#✒️-프로젝트-목표)
  - [프로젝트 기간](#📆-프로젝트-기간)
  - [기술스택](#⚙️-기술스택)
  - [구현 기능](#🔎-구현-기능)
- [산출물](#📄-산출물)
  - [ERD Diagram]
  - [기능 명세서]
  - [API 명세서]
  - [유저스토리]
  - [서버 아키텍처]
- [주요 화면]

## 📁 프로젝트 소개

---

### ✒️ 프로젝트 목표

- 자폐 아동의 증상 데이터를 통해 상담사를 추천하고, 화상 상담을 통해 상담사와 연결한다. <br>
- 자폐 증상 치료를 위한 놀이 프로그램을 제공한다.

### 📆 프로젝트 기간

- 2022.07.11(월) ~ 2022.08.19(금)
- SSAFY 7기 2학기 공통 프로젝트

### ⚙️ 기술스택

<img src="https://img.shields.io/badge/Java-20336B?style=for-the-badge&logo=&logoColor=white">
<img src="https://img.shields.io/badge/JPA-212121?style=for-the-badge&logo=&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white">
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">

<img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white">
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">
<img src="https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=NGINX&logoColor=white">
<img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white">

<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=Jira&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
<img src="https://img.shields.io/badge/GitLab-FC6D26?style=for-the-badge&logo=GitLab&logoColor=white">

### 🔎 구현 기능

```
- 회원가입
  - 보호자 회원가입
  - 상담사 회원가입
- 로그인
  - Redis와 리프레시 토큰을 이용한 액세스 토큰 갱신
- 보호자 기능
  - 아동 추가 및 관리
  - 문진표 작성
  - 추천 상담사 조회
  - 상담 예약
  - 예약 내역 및 상담기록 조회
  - 혼자놀기 카드게임 및 놀이기록 조회
- 상담사 기능
  - 예약 관리 및 조회
  - 상담일지 작성
- 화상 상담
  - WebRTC를 이용한 화상 상담
  - 화면 공유를 통한 카드게임 진행
```

## 📄 산출물

---

### 🔗 ERD Diagram

### 🔗 기능 명세서

- [기능 명세서](https://gyurania.notion.site/API-38fe45305eeb4534b80c67ff0ee53d41)

### 🔗 API 명세서

- [API 명세서](https://gyurania.notion.site/API-38fe45305eeb4534b80c67ff0ee53d41)

### 🔗 유저스토리

![UserStory](./img/%EC%9C%A0%EC%A0%80%EC%8A%A4%ED%86%A0%EB%A6%AC.PNG)

### 🔗 서버 아키텍처

![시스템논리구성도](./img/%EC%8B%9C%EC%8A%A4%ED%85%9C%20%EB%85%BC%EB%A6%AC%EA%B5%AC%EC%84%B1%EB%8F%84.PNG)
![사용자흐름도](./img/%EC%82%AC%EC%9A%A9%EC%9E%90%20%ED%9D%90%EB%A6%84%EB%8F%84.PNG)

## 💻 주요 화면

---

- 메인화면  
  ![main](./img/main.gif)
- 보호자 회원가입
  ![parent](./img/parent.gif)
- 상담사 회원가입

- 보호자 - 아동 관리
  ![child](./img/child.gif)
- 보호자 - 아동 문진표 작성
  ![survey](./img/survey.gif)
- 보호자 - 상담사 추천
  ![recommend](./img/recommend.gif)
- 보호자 - 상담 예약
  ![reserve](./img/reserve.gif)
