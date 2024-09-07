document.addEventListener("DOMContentLoaded", function () {
  go_book_list();
  bookDelete();
});

function update() {
  alert("구현중");
}

function bookDelete() {
  let btn_book_delete = document.querySelector("#btn_book_delete");

  btn_book_delete.addEventListener("click", function () {
    location.href = `/book/bookDelete?book_no=${btn_book_delete.value}`;
  });
}

function go_book_list() {
  let go_book_list = document.querySelector("#go_book_list");

  go_book_list.addEventListener("click", function () {
    location.href = "/book/bookList";
  });
}
