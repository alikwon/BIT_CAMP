var coffee = [];
var drink = [];
var dessert = [];
var othermenu = [];


// 메뉴 클릭 시 색깔 이벤트
$(document).ready(function () {
    $("li").each(function () {
        $(this).click(function () {
            $(this).addClass("selected");               //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
            $(this).siblings().removeClass("selected");  //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
        });
    });
});

// 메인 메뉴 클릭 시 리셋
$('.navbar-brand').click(function (e){
        location.reload();
});

//커피 클릭 이벤트
$('#1').click(function (e) {
    $('.swiper-container.center-block.1').show();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').hide();
});


//음료 클릭 이벤트
$('#2').click(function (e) {
    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').show();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').hide();
});

//디저트 클릭 이벤트
$('#3').click(function (e) {
    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').show();
    $('.swiper-container.center-block.4').hide();
});


//기타메뉴 클릭 이벤트
$('#4').click(function (e) {
    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').show();
});



// JSON 파일 로드(커피)
function jsonParse() {
    $.getJSON('../json/coffee.json', function (data) { 
        coffee = data;
    });
    $.getJSON('../json/drink.json', function (data) { 
        drink = data;
    });
    $.getJSON('../json/dessert.json', function (data) { 
        dessert = data;
    });
    $.getJSON('../json/othermenu.json', function (data) { 
        othermenu = data;
    });
};

function init() {
    $('.swiper-container.center-block.2').css('display', "none");
    $('.swiper-container.center-block.3').css('display', "none");
    $('.swiper-container.center-block.4').css('display', "none");
    jsonParse();
};

init();

