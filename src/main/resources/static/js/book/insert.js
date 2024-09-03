window.addEventListener('load',function(){
  insert_book();
})

let insert_book = function(){
  let input_title = document.querySelector("#input_title");
  let input_author = document.querySelector("#input_author");
  let input_price = document.querySelector("#input_price");
  let input_public = document.querySelector("#input_public");
  let btn_addBook = document.querySelector("#btn_addBook")

  btn_addBook.addEventListener('click',function(){
    if(input_title.value == ''){
      alert('도서 타이틀을 입력하세요.');
      return;
    } else if (input_author.value==''){
      alert('작가명을 입력하세요.');
      return;
    } else if (input_price.value==''){
      alert('도서 금액 입력하세요.');
      return;
    } else if (input_public.value==''){
      let res = confirm('출판사를 미기입합니까?');
      if(res){
        insertForm.submit();
      } else{
        return;
      }
    }
    insertForm.submit();

  })
}