const toDoForm = document.querySelector(".js-toDoForm"),
    toDoInput = toDoForm.querySelector("input"),
    toDoList = document.querySelector(".js-toDoList");

const TODOS_LS =  'toDos';

let toDos = [];

function deleteToDo(event){
    //target : 해당 버튼이 어떤 li에 있는 버튼인지 알 수 있음
    const btn = event.target;
    const li = btn.parentNode;
    li.setAttribute('class','del');
    setTimeout(function(){
        toDoList.removeChild(li);
    }, 300);
    //filter : 배열의 모든 아이템을 통해 함수를 실행하고 true인 아이템으로 새로운 배열생성
    //li의 id값과 같지 않은 배열요소를 찾아서 새로운배열 cleanToDos 생성
    const cleanToDos = toDos.filter(function(item){
        return item.id !== parseInt(li.id);
    });
    
    //새로운 배열 cleanToDos를 toDos에 대입 
    // ==> 그러나 toDos가 const이기 때문에 let으로 바꿔줌 
    toDos = cleanToDos;

    //새로생긴 toDos 배열을 로컬스토리지에 저장
    saveToDos();
} 

function saveToDos(){
    localStorage.setItem(TODOS_LS, JSON.stringify(toDos));
}

function paintToDo(text){
    const li = document.createElement("li");
    const delBtn = document.createElement("button");
    const span = document.createElement("span");
    const idx = toDos.length+1;

    delBtn.innerText = "삭제 ❌";

    //삭제버튼 클릭이벤트
    delBtn.addEventListener("click", deleteToDo);

    span.innerText = text;
    li.appendChild(delBtn);
    li.appendChild(span);
    li.id =idx;
    toDoList.appendChild(li);
    const toDoObj = {
        text : text,
        id : idx
    };
    toDos.push(toDoObj);
    saveToDos();
    // var li = '';
    // li += '<li>';
    // li += '<button>삭제 ❌</button>';
    // li += `<span>${text}</span>`;
    // li += '</li>';
    // toDoList.innerHTML=li;
}

function handleSubmit(event){
    event.preventDefault();
    const currentVal = toDoInput.value;
    paintToDo(currentVal);

    //submit 하고 나면 value 지워주기
    toDoInput.value = "";
}

function loadToDos(){
    const loadedToDos = localStorage.getItem(TODOS_LS);
    if(loadedToDos !==null){
        // console.log(loadedToDos);
        //String --> JavaScript Obj
        const parsedToDos = JSON.parse(loadedToDos);
        // console.log(parsedToDos);
        parsedToDos.forEach(function(item){
            paintToDo(item.text);
        });
    }
}
function init() {
    loadToDos();
    toDoForm.addEventListener("submit", handleSubmit);
}
init();