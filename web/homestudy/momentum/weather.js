//날씨 출력
const weather = document.querySelector(".js-weather");
const COORDS = 'coords';
const API_KEY = '9cc6221d627c56a61f9ca221f8ddb980';

//자바스크립트는 웹사이트로 요청를보내고 응답을통해 데이터 획득
// --> 가져온 데이터를 refresh없이 적용가능
function getWeather(lat, lon) {
    //데이터를 가져올땐 fetch
    //backtick(``) 사용할것!!
    fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
    ).then(function (response) {
        //then을 사용해서 완전히 호출됐을때 실행
        return response.json();
    }).then(function (json) {
        const temper = json.main.temp;
        const place = json.name;
        const icon = json.weather[0].icon;
        const iconUrl = "http://openweathermap.org/img/wn/"+icon+"@2x.png";
        console.log(icon);
        weather.innerHTML = `<img class="icon" src="" alt="Weather icon"> <br>${temper} ˚C `;
        weather.innerHTML += `<br>@ ${place}`;
        document.querySelector(".icon").setAttribute('src',iconUrl);
    });
}

function saveCoords(coordsObj) {
    localStorage.setItem(COORDS, JSON.stringify(coordsObj));
}
function handleGeoError() {
    console.log("cant access")
}
function handleGeoSucces(position) {
    //위도와 경도 읽어오기
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    const coordsObj = {
        // latitude : latitude,
        // longitude : longitude
        // 객체의 변수와 객체의 key의 이름을 같게 저장할때는 밑의 방법가능
        latitude,
        longitude
    };
    saveCoords(coordsObj);
    getWeather(latitude, longitude);
}
function askForCoords() {
    //네비게이터 API
    navigator.geolocation.getCurrentPosition(handleGeoSucces, handleGeoError);
}

function loadCoords() {
    const loadedCoords = localStorage.getItem(COORDS);
    if (loadedCoords === null) {
        //좌표요청함수
        askForCoords();

    } else {
        // getWeather
        const parseCoords = JSON.parse(loadedCoords);
        getWeather(parseCoords.latitude, parseCoords.longitude);
    }
}
function init() {
    loadCoords();
}
init();