// Функция для создания HTML-карточки предмета
function createSubjectCard(subject) {
    const card = document.createElement('div');
    card.className = 'card';

    const title = document.createElement('h2');
    title.textContent = subject.subjectName;
    card.appendChild(title);

    const description = document.createElement('p');
    description.textContent = subject.description;
    card.appendChild(description);

    return card;
}

// Получение предметов при загрузке страницы
document.addEventListener('DOMContentLoaded', fetchSubjects);
document.addEventListener('DOMContentLoaded', fetchUser);

// Функция для получения предметов с сервера
async function fetchSubjects() {
    try {
        const response = await fetch('/subject/all');
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        const subjects = await response.json();
        const container = document.getElementById('subjects-container');
        subjects.forEach(subject => {
            const card = createSubjectCard(subject);
            container.appendChild(card);
        });
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}

async function fetchUser() {
    try {

        const response = await fetch('/users/current');
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        const user = await response.json();
        const welcome = document.getElementById('welcome');
        welcome.innerHTML = "Здравствуйте, "+user.name;
       /* subjects.forEach(subject => {
            const card = createSubjectCard(subject);
            container.appendChild(card);
        });*/
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}
