const MENU = document.querySelectorAll(".menu");
const cofBtn = document.querySelector(".btn-cof");
const bevBtn = document.querySelector(".btn-bev");
const desBtn = document.querySelector(".btn-des");
const etcBtn = document.querySelector(".btn-etc");
// const cofBtn = document.querySelector(".btn-cof");
// const bevBtn = document.querySelector(".btn-bev");
// const desBtn = document.querySelector(".btn-des");
// const etcBtn = document.querySelector(".btn-etc");

function click(menuClass) {
	removeShowing();
	menuClass.classList.add("show");

}

function removeShowing() {
	for (var i = 0; i < MENU.length; i++) {
		if (MENU[i].classList.contains("show")) {
			MENU[i].classList.remove("show");
		}
	}
}
function displayCofMenu() {
	console.log("clickc");
	cofBtn.setAttribute('style', 'background-color:white;color:#5D4037;border:1px solid white;');
	bevBtn.setAttribute('style', '');
	desBtn.setAttribute('style', '');
	etcBtn.setAttribute('style', '');
	// click(menuClass);
	$('.coffee').css('display', 'block');
	$('.beverage').css('display', 'none');
	$('.desert').css('display', 'none');
	$('.etc').css('display', 'none');
}

function displayBevMenu() {
	console.log("clickb");
	const menuClass = document.querySelector(".beverage");
	// click(menuClass);
	cofBtn.setAttribute('style', '');
	bevBtn.setAttribute('style', 'background-color:white;color:#5D4037;border:1px solid white;');
	desBtn.setAttribute('style', '');
	etcBtn.setAttribute('style', '');

	$('.coffee').css('display', 'none');
	$('.beverage').css('display', 'block');
	$('.desert').css('display', 'none');
	$('.etc').css('display', 'none');
}

function displayDesMenu() {
	console.log("clickd");
	const menuClass = document.querySelector(".desert");
	// click(menuClass);
	cofBtn.setAttribute('style', '');
	bevBtn.setAttribute('style', '');
	desBtn.setAttribute('style', 'background-color:white;color:#5D4037;border:1px solid white;');
	etcBtn.setAttribute('style', '');

	$('.coffee').css('display', 'none');
	$('.beverage').css('display', 'none');
	$('.desert').css('display', 'block');
	$('.etc').css('display', 'none');
}

function displayEtcMenu() {
	console.log("clicke");
	const menuClass = document.querySelector(".etc");
	// click(menuClass);
	cofBtn.setAttribute('style', '');
	bevBtn.setAttribute('style', '');
	desBtn.setAttribute('style', '');
	etcBtn.setAttribute('style', 'background-color:white;color:#5D4037;border:1px solid white;');

	$('.coffee').css('display', 'none');
	$('.beverage').css('display', 'none');
	$('.desert').css('display', 'none');
	$('.etc').css('display', 'block');
}
function printDisplay() {
	cofBtn.addEventListener("click", displayCofMenu);
	bevBtn.addEventListener("click", displayBevMenu);
	desBtn.addEventListener("click", displayDesMenu);
	etcBtn.addEventListener("click", displayEtcMenu);
}



function init() {
	// $.getJSON('ex1.json', function (data) {
	// 	var html = '';
	// 	$.each(data, function (entryIndex, entry) {
	// 		html += '<div class="entry">';
	// 		html += '<h3 class="term">' + entry.term + '</h3>';
	// 		html += '<div class="part">' + entry.part + '</div>';
	// 		html += '<div class="definition">';
	// 		html += entry.definition;
	// 		html += '</div>';
	// 		html += '</div>';
	// 	});
	// 	console.log(html);
	// 	$('#dictionary').html(html);
	// });


	// console.log(cofBtn.innerText);
	printDisplay();
}
init();