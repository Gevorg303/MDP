// Получить модальное окно
    var modal = document.getElementById("helpModal");

    // Получить кнопку, которая открывает модальное окно
    var btn = document.getElementById("helpBtn");

    // Получить элемент <span>, который закрывает модальное окно
    var span = document.getElementsByClassName("close")[0];

    // Когда пользователь нажимает на кнопку, открыть модальное окно
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // Когда пользователь нажимает на <span> (x), закрыть модальное окно
    span.onclick = function() {
        modal.style.display = "none";
    }

    // Когда пользователь кликает в любом месте за пределами модального окна, закрыть его
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }