
// 동적 메뉴 생성

var coffees = [];
var drinks = [];
var dessert = [];
var other = [];

//각각의 카테고리(커피,음료,디저트,기타)의 배열을 담는 배열 ( 이름값 비교를 위해 사용 )
var category = [];

var sum = 0;

//초기화버튼이벤트 : 클릭했을때 페이지 다시 로드
$(document).on('click', '#6', function () {
    location.replace('index.html');
});

//휴지통버튼이벤트 
$(document).on('click', '.delorder', function (e) {
    //에니메이션 처리를 위해 부모태그에 del클래스추가 (css에서 .del 클래스에 이벤트를 줌)
    $(this).parent('.order-list').addClass('del');

    //애니메이션 처리를 기다리기위해 타임을 준다
    setTimeout(function () {
        //.del 클래스를 가진 태그를 remove
        document.querySelector(".del").remove();
        //totalprice() 는 주문목록에 있는 값을 더해서 표시해준다 (주문목록갱신이 있을때마다 호출됨) 
        let sum = totalPrice($('.order-list').find('.orderprice'));
        $('.finalprice-price').text(sum);
    }, 300);
});

//플러스 버튼 이벤트
$(document).on('click', '.plusorder', function () {
    //QTY와 Price를 +해줘야 함!!

    // 플러스버튼이 있는 div의 부모태그를 선택 
    //      --> 그 부모태그에서 find()함수를 통해 QTY와 PRICE를 담고있는 태그를 선택
    let $orderqty = $(this).parent().find('.orderqty');
    let $orderprice = $(this).parent().find('.orderprice');

    //연산
    let currentprice = (parseInt($orderprice.text()) / parseInt($orderqty.text())) + parseInt($orderprice.text());
    let currentQty = parseInt($orderqty.text()) + 1;

    //연산결과를 덮어씌움
    $orderprice.text(currentprice);
    $orderqty.text(currentQty);

    //total price 갱신
    let sum = totalPrice($('.order-list').find('.orderprice'));
    $('.finalprice-price').text(sum);
});

//마이너스 버튼 이벤트 : 플러스 반대의 연산을 하면 되지만 if조건문을 넣어줘야함.
$(document).on('click', '.minusorder', function () {
    let $order = $(this).parent('.order-list');
    let $orderqty = $(this).parent().find('.orderqty');
    let $orderprice = $(this).parent().find('.orderprice');
    if (parseInt($orderqty.text()) > 1) {
        let currentprice = parseInt($orderprice.text()) - (parseInt($orderprice.text()) / parseInt($orderqty.text()));
        let currentQty = parseInt($orderqty.text()) - 1;
        $orderprice.text(currentprice);
        $orderqty.text(currentQty);
    } else {
        //QTY가 1일때 이벤트가 발생하면 아예 remove
        $order.addClass('del');
        setTimeout(function () {
            //.del 클래스를 가진 태그를 remove
            document.querySelector(".del").remove();
            //totalprice() 는 주문목록에 있는 값을 더해서 표시해준다 (주문목록갱신이 있을때마다 호출됨) 
            let sum = totalPrice($('.order-list').find('.orderprice'));
            $('.finalprice-price').text(sum);
        }, 300);
        // $order.remove();
    }
    let sum = totalPrice($('.order-list').find('.orderprice'));
    $('.finalprice-price').text(sum);
});

//total price를 구해주는 메서드
//orderprice 라는 클래스값을 가진 테그의 text를 모두 골라서 더해준다
function totalPrice($tag) {
    sum = 0;
    //each()함수 사용
    $tag.each(function (index, item) {
        //text는 문자열이므로 int변환
        sum += parseInt($(item).text());
    });
    return sum;
}

//이미지클릭 >> 주문목록에 출력해주는 함수
function addOrder(match) {
    var qty = 1;

    var a = ".order" + match.id;
    if ($(a).length === 0) {
        let html = '';
        html += '<div class="row order-list order' + match.id + '">'
        html += '<div class="col-sm-1 delorder z">🗑️</div>';
        html += '<div class="col-sm-3 ordername z">' + match.name + '</div>';
        html += '<div class="col-sm-1 plusorder z">➕</div>';
        html += '<div class="col-sm-2 orderqty z">' + qty + '</div>';
        html += '<div class="col-sm-1 minusorder z">➖</div>';
        html += '<div class="col-sm-3 orderprice z">' + match.price + '</div>';
        html += '<div class="col-sm-1 won z">원</div>';
        html += '</div>';
        $('.productList').append(html);

    } else {
        var plusQty = qty += parseInt($(a + '>.orderqty').html());

        var plusPrice = match.price + parseInt($(a + '>.orderprice').html());
        $(a + '>.orderqty').text("" + plusQty);
        $(a + '>.orderprice').text("" + plusPrice);
    }
    let sum = totalPrice($('.order-list').find('.orderprice'));
    $('.finalprice-price').text(sum);

}

//메뉴의 이미지를 클릭했을때 이벤트
function choiceMenu(id) {
    //filter() 함수 쓰기위해서 배열하나 생성
    var match = [];

    //전체카테고리에서 일치하는 id 값이 있으면 match 배열에 담기 --> 하나가 담겨지면 break;
    for (var i in category) {
        match = category[i].filter(function (item) {
            return item.id == id;
        });
        if (match.length != 0) {
            break;
        }
    }

    //id가 일치하는것은 1개뿐이므로 index는 0밖에없음
    addOrder(match[0]);
}

function displayMenu() {
    const cateName = ["coffees", "drinks", "dessert", "other"];
    for (let i = 0; i < category.length; i++) {
        const index = i + 1;
        const menuPage = $('.' + index + '>.swiper-wrapper');
        let num = 10;

        for (let j = 0; j < category[i].length; j++) {
            if (j % 4 == 0) {
                var html = '';
                html += '<div class="swiper-slide">';
                html += '<div class="container">';
                html += `<div class="row ml-4 mt-4 menu menuList" id="${cateName[i]}${num}">`;
                html += `<div class="col-sm-5 ml-3 mt-3 menu1 ${category[i][j].id}">`;
                html += `<img class="hvr-grow" src=${category[i][j].img} id=${category[i][j].id} class="rounded" onclick="choiceMenu(id)">`;
                html += `<div class="text-center mt-3 menuname">${category[i][j].name}</div>`;
                html += `<div class="text-center menuprice"> &#8361;${category[i][j].price}</div>`;
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                menuPage.append(html);
                num++;
            } else if (j % 4 != 0) {
                var manu = $(`#${cateName[i]}${num - 1}`);
                var html2 = '';
                html2 += `<div class="col-sm-5 ml-3 mt-3 menu1 ${category[i][j].id}">`;
                html2 += `<img class="hvr-grow" src=${category[i][j].img} id ="${category[i][j].id}" class="rounded" onclick="choiceMenu(id)">`;
                html2 += `<div class="text-center mt-3 menuname">${category[i][j].name}</div>`;
                html2 += `<div class="text-center menuprice"> &#8361;${category[i][j].price}</div>`;
                html2 += '</div>';
                manu.append(html2);
            }
        }
    }
}
// JSON 파일 로드 --> JS배열로 변환
function jsonParse() {
    //제이슨파일을 get 해서 로컬스토리지에 set해주기
    //갹 카테고리별로 베열을 만들어서 parsing해줌
    //메뉴생성 메서드 호출
        $.getJSON('../json/coffee.json', function (data) {
            localStorage.setItem("coffees", JSON.stringify(data));
            coffees = JSON.parse(localStorage.getItem("coffees"));
            category.push(coffees);

        });
        $.getJSON('../json/drink.json', function (data) {
            localStorage.setItem("drinks", JSON.stringify(data));
            drink = JSON.parse(localStorage.getItem("drinks"));
            category.push(drink);

        });
        $.getJSON('../json/dessert.json', function (data) {
            localStorage.setItem("dessert", JSON.stringify(data));
            dessert = JSON.parse(localStorage.getItem("dessert"));
            category.push(dessert);

        });
        $.getJSON('../json/othermenu.json', function (data) {
            localStorage.setItem("other", JSON.stringify(data));
            other = JSON.parse(localStorage.getItem("other"));
            category.push(other);

        });
};



function init() {
    jsonParse();
    setTimeout(function () {
        displayMenu();
    }, 300);
}

init();