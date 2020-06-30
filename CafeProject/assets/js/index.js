$(document).ready(function() {
    $('.menu_coffee').css('display', 'inline');
    $('.menu_drink').css('display', 'none');
    $('.menu_dessert').css('display', 'none');
    $('.menu_etclist').css('display', 'none');

    $('.coffees').click(function() {
        $('.menu_coffee').css('display', 'inline');
        $('.menu_drink').css('display', 'none');
        $('.menu_dessert').css('display', 'none');
        $('.menu_etclist').css('display', 'none');
    });
    $('.drinks').click(function() {
        $('.menu_coffee').css('display', 'none');
        $('.menu_drink').css('display', 'inline');
        $('.menu_dessert').css('display', 'none');
        $('.menu_etclist').css('display', 'none');
    });
    $('.desserts').click(function() {
        $('.menu_coffee').css('display', 'none');
        $('.menu_drink').css('display', 'none');
        $('.menu_dessert').css('display', 'inline');
        $('.menu_etclist').css('display', 'none');
    });
    $('.etcs').click(function() {
        $('.menu_coffee').css('display', 'none');
        $('.menu_drink').css('display', 'none');
        $('.menu_dessert').css('display', 'none');
        $('.menu_etclist').css('display', 'inline');
    });
});

function docRefresh() {
    location.reload();
}