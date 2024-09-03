window.addEventListener('load',function(){
  go_insert_book();
})

let go_insert_book = function(){
  let btn_insert_book = document.querySelector('#btn_insert_book');

  btn_insert_book.addEventListener('click',function(){
    location.href='/book/bookInsert'
  })
}
