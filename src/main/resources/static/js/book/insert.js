let validation_chk = true;

insert_book();

function insert_book() {
  let btn_addBook = document.querySelector("#btn_addBook");

  btn_addBook.addEventListener("click", function () {
    if (validation()) {
      insertForm.submit();
    }
  });
}

function validation() {
  let input_title = document.querySelector("#input_title");
  let input_author = document.querySelector("#input_author");
  let input_price = document.querySelector("#input_price");
  let input_public = document.querySelector("#input_public");
  let input_file = document.querySelector("#input_file");

  let msgBox = "";
  let msgId = "";
  let extensions = ["jpg", "gif", "png"];

  if (input_title.value == "") {
    msgBoxInsert("도서 타이틀을 입력하세요.", "input_title");
    validation_chk = false;
  }

  if(input_author.value == "") {
    msgBoxInsert("작가명을 입력하세요.", "input_author");
    validation_chk = false;
  }
  
  if (input_price.value == "") {
    msgBoxInsert("도서 금액 입력하세요.", "input_price");
    validation_chk = false;
  }
  
  if (input_public.value == "") {
    let res = confirm("출판사를 미기입합니까?");
    if (res) {
      validation_chk = true;
    } else {
      validation_chk = false;
    }
  }
}

function msgBoxInsert(msgBox, msgId) {
  let existingMsg = document.querySelector(`#${msgId} + p`);
  if (existingMsg) {
    existingMsg.remove();
  }
  document.getElementById(msgId).insertAdjacentHTML('afterend', `<p id='msgBox'>${msgBox}</p>`);
}
