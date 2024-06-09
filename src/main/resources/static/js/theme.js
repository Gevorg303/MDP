// Функция для создания HTML-карточки темы
function createSubjectCard(subject) {
    const card = document.createElement('div');
    card.className = 'card';

    const title = document.createElement('h2');
    title.textContent = subject.themeName;
    card.appendChild(title);

    const description = document.createElement('p');
    description.textContent = subject.description;
    card.appendChild(description);

    return card;
}

// Получение тем при загрузке страницы
document.addEventListener('DOMContentLoaded', fetchSubjects);

// Функция для получения тем с сервера
async function fetchSubjects() {
    try {
        const response = await fetch('/theme/all');
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
