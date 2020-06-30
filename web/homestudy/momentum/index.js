const title = document.querySelector('#title');

const clickedClass = "clicked";

function handleClick(){
    // const hasClass = title.classList.contains(clickedClass);

    // if (hasClass){
    //     title.classList.remove(clickedClass);
    // } else {
    //     title.classList.add(clickedClass);
    // }
    title.classList.toggle(clickedClass);
}

function init() {
    title.addEventListener("click", handleClick);
}
init();






//오프라인될때 
function handleOffline(){
    console.log('hahaha')
}
//온라인 될때
function handleOnline(){
    console.log('hihihi')
}
window.addEventListener("offline", handleOffline);
window.addEventListener("online", handleOnline);
