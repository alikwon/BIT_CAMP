var coffees = [];
var desserts = [];
var drinks = [];
var othermenus = [];
var selectedCoffee = {}
var orderIDX = 0;

function checkNumber(data) {
    var selectedCoffee = {}

    return selectedCoffee;
};

// 이거 자체는 이해가죠 이제는? 옙 다른거 뭐 또 해결잡을 거있음? 걍 다 말ㅇ하셈 도와줄떄 일단이걸로 뭔가를 활용할려고했는데
// 시간이 너무 많이가서.. 다까먹엇어요 뭘할지..ㅋㅋㅋㅋㅋ; ;ㅇ;ㅋㅇㅋㅇㅋ 제가 할거해드림 지금 작업하던 html이 따로 있어요? 아니면 오른쪽 목록에 넣어주는걸 해야되는데
// 그 작업을 다른사람이해요? 원래 메뉴생성이랑 옆에넣어주는거까지 한분이 맡아했는데 그분이 오늘까지 결과물이없어서
// 제가 아까 4%0한거잇자나요 이코드 한 저녁4시즘에 만들엇는데 그거갖고 작업을 하시더라구요.
// 내일되도 결과물 안나올거 같아서 저 기능에 같이 붙어서 만들고 있습니다...
// 근데 알리햄도 지금 셀렉트 해서 옆에 띄우는거 하시고
// 그분도 아까보니 어설픈데 해놓긴하셧더라구요. 지금 알리햄 작업한데서 + - 눌럿을때 수량,값변하는거 하면 되지 싶은데
// ㅇㅋ 
function imgClickEvent(data) {
    $(document).on('click', 'img', function (e) {
        // 변수 공간을 만들고 거기에 넣어줘요. 옙
        // 짠가님이 원하시는 건 이거겠쬬? 
        // 어떤 함수를 써가지고 선택된 변수의 값을 가져와줬으면 좋겠어. 옙
        for (let i = 0; i < coffees.length; i++) {
            if (coffees[i].id == this.id) {
                selectedCoffee = coffees[i];
                console.log(selectedCoffee);
                console.log("씨빨!")
                addSelectedTag(coffees[i])
                break;
            }
        }
        let sum = totalPrice($('.order-list').find('.orderprice'));
        console.log(sum);
    })
};

function addSelectedTag(data) {

    let thisName = data.name;
    let thisNum = 1;
    let thisPrice = data.price;

    addHTML = '';
    addHTML += `<div class="row order-list" id="${orderIDX}">
                    <div class="col-sm-1 delorder">❌</div>
                    <div class="col-sm-3 ordername">${thisName}</div>
                    <div class="col-sm-1 plusorder">➕</div>
                    <div class="col-sm-2 orderqty">${thisNum}</div>
                    <div class="col-sm-1 minusorder">➖</div>
                    <div class="col-sm-3 orderprice">${thisPrice}</div>
                    <div class="col-sm-1">원</div>
                </div>`;
    $('.orderslide > div.container.productList').after(addHTML);
    orderIDX++;
}
// 얘도 마찬가지로 dom 을 동적으로 생성하니깐 document 부터 찾아야해요 옙
$(document).on('click', '.plusorder', function () {
    console.log(this); // 그게 this 
    console.log($(this))  
    // 우에껀 그냥 div로 된 태그 나왔쬬?
    // 아래껀 그 태그에 대한 fn.어쩌꼬로 나왔쬬? 제이쿼리로 감싸줬따는 으미ㅣ고 제이쿼리 선택자가 된 상태에요 
    // 그럴경우에 제이쿼리에선 현재 태그의 부모태그 
    // 즉 <> </> 이런식으로 구성된건 트리형태로 만들어지거든요?
    // 트리 아래꺼처럼 트리 아무튼간에 


    let $orderprice = $(this).parent().find('.orderprice');
    let $orderqty = $(this).parent().find('.orderqty'); // 페어런트가 가지고있는 자식들 중에서 find(찾아라!) classname = 'orderqty' 인놈을 ㅇㅎ
    // 이제 여기서 고민 1 
    // 다른놈인데 클래스이름은같음. 다만 이게 가능한 이유는 기준페어런트가 다르기댸문에 ㅇㅎ
    // 이전에도 디스찍으면서 보여줬었는데 다시보여줌 
    // 자기를 눌렀으니깐this 그거에 대한 상대적위치이니깐 parent()는 그냥 그 row 하나 그 row내에서 find니깐 orderqty도 하나 댔음 사실 이해는 안해도되고 
    // 저렇게 되는거만 알면 댐 나중에 이해하셈 만약 이해안가더라도 this가 정말 중요하구나 새삼 느꼇습니다... ㅋㅋ 암튼 사실 설명을 마니할 시간이 없으니깐 방해는 안하고 
    // 딱 하나만 더 만들어주고가겠음 노설명으로 어떤..? 아니 원하는거
    let currentNum = $orderqty.text();//div 값 가져오기 ㅎ
    currentNum = parseInt(currentNum);
    let currentPrice = parseInt($orderprice.text()) / currentNum;
    $orderqty.text(currentNum + 1);// 그래서 가져온 값을 parseInt로 형변환해줌 숫자로.  // 동일하게 마이너스 구현해보셈 
    $orderprice.text(parseInt(currentPrice)*currentNum) // 잉 왜값이안바끼지 ㅋㅋㅋ 흐음..알리햄이 해놧던데..ㅋ.ㅋㅋ 아니 빨리말하지 ㅋㅋㅋㅋㅋㅋㅋㅋ
    //앍올려놓으신다고햇는데 톡으로 ㅈㅅ ㅇㅋ 뭐 마지막으로 하나 해주고 가겠음 뭥벗음? 아 합계.. 만들려고했었는데 ㅇㅋㅇㅋㅇㅋㅇㅋㅇㅋㅇ 기달

    let sum = totalPrice($('.order-list').find('.orderprice'));
    console.log(sum);
})


$(document).on('click', '.minusorder', function () {
    // $(this).parent().val(); // 플러스마이너스 코드어딨쬬 잠시만요..저도 찾아야해서..
    let $orderqty = $(this).parent().find('.orderqty');
    let currentNum = $orderqty.text();//div 값 가져오기 ㅎ
    currentNum = parseInt(currentNum);
    if(currentNum > 1) // 잘하셨어용 ㅎㅎ알리햄이도와주심...???????????????ㅋㅋㅋㅋㅋㅋㅋ;;;;;아 조큼 이해가 안된게 있어서 저기 parent().find('.order)qt

    // 저거만 설명해줄게요 제가 처음에 한 행동으로 다시 돌아가면요 아
    $orderqty.text(currentNum - 1);
    let sum = totalPrice($('.order-list').find('.orderprice'));
    console.log(sum);
})

function totalNum($tag) {

}

function totalPrice($tag) {
    sum = 0;
    $tag.each(function(index, value){
        sum += parseInt($(value).text());
    });
    return sum;
}


// 로컬 파싱
function localParse() {
    coffees = JSON.parse(localStorage.getItem('coffees'));
    desserts = JSON.parse(localStorage.getItem('dessert'));
    drinks = JSON.parse(localStorage.getItem('drinks'));
    othermenus = JSON.parse(localStorage.getItem('other'));
    console.log(coffees);
    console.log(desserts);
    console.log(drinks);
    console.log(othermenus);

}

function init() {
    localParse();
    imgClickEvent(coffees);
    // checkNumber(coffees);
}

init();