var modal = document.getElementById('myModal');
    var openModalBtn = document.getElementById('openModal');
    var confirmActionBtn = document.getElementById('confirmAction');
    var action;
    var itemNameInput = document.getElementById('itemName');

    openModalBtn.onclick = function() {
        modal.style.display = 'block';
    }

    confirmActionBtn.onclick = function() {
        var actionRadios = document.getElementsByName('action');
        var itemName = itemNameInput.value;

        for (var i = 0; i < actionRadios.length; i++) {
            if (actionRadios[i].checked) {
                action = actionRadios[i].value;
                break;
            }
        }

        if (action === 'delete') {
            fetch('/theme/delete', {
                method: 'DELETE'
            })
            .then(response => {
                if (response.ok) {
                    console.log('Тема удалена: ' + itemName);
                } else {
                    console.error('Ошибка удаления темы');
                }
            });
        } else if (action === 'add') {
            fetch('/theme/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ itemName: itemName })
            })
            .then(response => {
                if (response.ok) {
                    console.log('Тема добавлена: ' + itemName);
                } else {
                    console.error('Ошибка добавления темы');
                }
            });5
        }

        modal.style.display = 'none';
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }

