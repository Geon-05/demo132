let validation_chk = false;

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
  let input_file = document.querySelector('#input_file');
  let extensions = ["jpg", "gif", "png"];

  if (input_title.value == "") {
    alert("도서 타이틀을 입력하세요.");
    return validation_chk=false;
  } else if (input_author.value == "") {
    alert("작가명을 입력하세요.");
    return validation_chk=false;
  } else if (input_price.value == "") {
    alert("도서 금액 입력하세요.");
    return validation_chk=false;
  } else if (input_public.value == "") {
    let res = confirm("출판사를 미기입합니까?");
    if (res) {
      return validation_chk=true;
    } else {
      return validation_chk=false;
    }
  }
  return validation_chk=true;
}
