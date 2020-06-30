const clockContainer = document.querySelector(".js-clock"),
    clockTitle = clockContainer.querySelector(".js-title"),
    clockBody = clockContainer.querySelector(".js-cbody");

function getTime() {
    const date = new Date();
    const minutes = date.getMinutes();
    const hours = date.getHours();
    const seconds = date.getSeconds();
    const year = date.getFullYear();
    const month = date.getMonth();
    const day = date.getDate();
    clockBody.innerHTML=
        `${year}.${month}.${day}`
    clockTitle.innerHTML =
        `${hours > 9 ? hours : `0${hours}`}:${minutes > 9 ? minutes : `0${minutes}`}:${seconds > 9 ? seconds : `0${seconds}`}`;
}

function init() {
    getTime();
    
    //매초마다 업데이트하게 바꾸기
    setInterval(getTime, 1000);
}
init();