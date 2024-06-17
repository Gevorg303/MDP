 /*function registerUser(event) {
        event.preventDefault();

        var formData = {
            roleId: document.getElementById("role").value,
            surname: document.getElementById("surname").value,
            name: document.getElementById("name").value,
            patronymic: document.getElementById("patronymic").value,
            email: document.getElementById("email").value
        };

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/users/add", true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText);
                    document.getElementById('modalLogin').innerText = response.login;
                    document.getElementById('modalPassword').innerText = response.password;
                    openModal();
                } else {
                    alert('Ошибка регистрации. Пожалуйста, попробуйте еще раз.');
                }
            }
        };
        xhr.send(JSON.stringify(formData));
    }*/

    document.addEventListener("DOMContentLoaded", function() {
        fetchRoles();
    });

    function fetchRoles() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/role/all", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    var roles = JSON.parse(xhr.responseText);
                    var roleSelect = document.getElementById("role");
                    roles.forEach(function(role) {
                        var option = document.createElement("option");
                        option.value = role.id;
                        option.textContent = role.role;
                        roleSelect.appendChild(option);
                    });
                } else {
                    console.error('Не удалось загрузить роли. Статус:', xhr.status);
                }
            }
        };
        xhr.send();
    }

    function openModal() {
        document.getElementById('myModal').style.display = 'block';
        document.getElementById('overlay').style.display = 'block';
    }

    function closeModal() {
        document.getElementById('myModal').style.display = 'none';
        document.getElementById('overlay').style.display = 'none';
    }