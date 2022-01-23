function multipleChoiseLimiter() {
    var books = document.getElementById('books')
    var numSelected = 0;
    for (var i = 0; i < books.options.length; i++) {
        if (books.options[i].selected ) {
            numSelected++;
        }
    }
    if (numSelected > 5) {
        for (var i = 0; i < books.options.length; i++) {
            books.options[i].select = false;
            }
    }

}
