//결제 클릭 이벤트
// $('#5').click(function(){
//     alert('click!!');
// });

$('#5').click(function(){
    var $href = $(this).attr('href');
    layer_popup($href);
});

function layer_popup(el){

    var $el = $(el);        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}


// 초기화 클릭 이벤트
$('#6').click(function(){
    location.replace('index.html');
});

$(function () {
    $("#draggable").draggable();
    $("#droppable").droppable({
        drop: function (event, ui) {
            droppedmsg();
        }
    });
});

function droppedmsg() {
    var result = confirm('주문이 완료되었습니다 !!!');
    if(result) { 
        location.replace('index.html'); 
    }
    return;
}


$(document).ready(function () {
    var $banner = $(".banner").find("ul");

    var $bannerWidth = $banner.children().outerWidth();//이미지의 폭
    var $bannerHeight = $banner.children().outerHeight(); // 높이
    var $length = $banner.children().length;//이미지의 갯수
    var rollingId;

    //정해진 초마다 함수 실행
    rollingId = setInterval(function () { rollingStart(); }, 2100);//다음 이미지로 롤링 애니메이션 할 시간차

    function rollingStart() {
        $banner.css("width", $bannerWidth * $length + "px");
        $banner.css("height", $bannerHeight + "px");
        //alert(bannerHeight);
        //배너의 좌측 위치를 옮겨 준다.
        $banner.animate({ left: - $bannerWidth + "px" }, 1500, function () { //숫자는 롤링 진행되는 시간이다.
            //첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
            $(this).append("<li>" + $(this).find("li:first").html() + "</li>");
            //뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
            $(this).find("li:first").remove();
            //다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
            $(this).css("left", 0);
            //이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
        });
    }
});