go_book_list()

function update(){
  alert('구현중');
}

function delect(){
  alert('구현중');
}

function go_book_list(){
  let go_book_list = document.querySelector('#go_book_list')

  go_book_list.addEventListener('click',function(){
    location.href='/book/bookList'

  })
}