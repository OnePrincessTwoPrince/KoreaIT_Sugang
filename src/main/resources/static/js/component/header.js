class HeaderService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new HeaderService();
        }
        return this.#instance;
    }

    loadHeader() {
        const headerContainer = document.querySelector(".header-container");
        const principal = PrincipalApi.getInstance().getPrincipal();

        headerContainer.innerHTML=`
        <div class="lnb wrap">
        <div class="lnb-inner">
            <h1>
                <a href="/templates/announcement.html"><img src="/static/image/logo.png" alt="코리아IT 대학교 수강신청"></a>
            </h1>
            <span class="school-name"><a href="/templates/announcement.html">코리아IT 대학교 <li>KOREA-IT UNIVERSITY</li></span></a>
            <span class="sugang-date">2023학년도 1학기 수강신청</span>
        </div>
        <div class="user-info">
            <ul>
                ${principal == null
                    ?`
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    
                    `:`
                <li class="user"><a href="/templates/mypage.html">${principal.user.name}<span>${principal.user.username}</span></a></li>
                <li>공과대학</li>
                <li>메카트로닉스공학부</li>
                <li>4학년</li>
                `
                }
            </ul>
        </div>
        
    </div>
    <div class="menulist wrap">
            <li class="on"><a href="http://localhost:8000/announcement">공지사항</a></li>
            <li><a href="">강의시간표</a></li>
            <li><a href="http://localhost:8000/search">수강신청</a></li>
            <li><a href="">수강확정/대기내역</a></li>
            <li><a href="">학점이수현황</a></li>
            <li><a href="">재수강신청</a></li>
            <li><a href="">재수강내역</a></li>
            <li><a href="">강의평가</a></li>
            <li><a href="">매뉴얼</a></li>
            <li><a href="">로그아웃</a></li>
    </div>
        `;
    }
}