const body = document.querySelector("body");
const IMG_NUM = 8;
const a = document.getElementsByClassName("write");
function handleImgLoad(){
    console.log("load finish")
}

function paintImage(imgNum){
    //image 객체 생성
    const image = new Image();

    //이미지 src 설정
    image.src = `../../../images/${imgNum+1}.jpg`
    //이미지 추가
    image.classList.add("bgImage");
    body.appendChild(image);
}

//렌덤 번호 생성해서 백그라운드 이미지 출력
function genRandom(){
    //Math.floor() : 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환
    //Math.ceil()  : 주어진 숫자와 같거나 큰 숫자 중 가장 작은 숫자를 반환
    const num = Math.floor(Math.random()*IMG_NUM);
    return num;
}


function init(){
    const randomNum = genRandom();
    paintImage(randomNum);
}
init();