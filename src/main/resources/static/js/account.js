
// Получение предметов при загрузке страницы
document.addEventListener('DOMContentLoaded', fetchUserToAccount);

async function fetchUserToAccount() {
    try {

        const response = await fetch('/users/current');
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        const response = await fetch('/users/current');
                if (!response.ok) {
                    throw new Error('Ошибка сети');
                }
        const user = await response.json();
        const surname = document.getElementById('surname');
        const name = document.getElementById('name');
        const patronymic = document.getElementById('patronymic');
        const email = document.getElementById('email');
        const role = document.getElementById('role');

        surname.innerHTML = user.surname;
        name.innerHTML = user.name;
        patronymic.innerHTML = user.patronymic;
        email.innerHTML = user.email;
        role.innerHTML = user.roles.role;
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}
