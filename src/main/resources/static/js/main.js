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
document.addEventListener('DOMContentLoaded', fetchStudentCLass);
//получение классов учителя
async function fetchStudentCLass() {
    try {
        const response = await fetch('/users/current');
            if (!response.ok) {
                throw new Error('Ошибка поиска учителя');
            }
        const user = await response.json();
        if(user.roles.role.toLowerCase()=="учитель" || user.roles.role.toLowerCase()=="админ")
        {
            response2 = await fetch('/student-class/teacherid='+user.id);
            if (!response2.ok) {
                throw new Error('Ошибка вывода классов учителя');
            }
            const classes = await response2.json();
            const select = document.getElementById('selectClass');
            let optoins = select.optoins;
            classes.forEach(subject => {

               console.log(subject.numberOfInstitution +" "+ subject.letterDesignation +" "+ subject.educationalInstitution.nameOfTheInstitution + " "+ subject.educationalInstitution.address)
               optoins.append(new Option(subject.id, subject.numberOfInstitution +" "+ subject.letterDesignation +" "+ subject.educationalInstitution.nameOfTheInstitution + " "+ subject.educationalInstitution.address))
            });
            console.log(options);
        }else{console.log("Пользователь - ученик")}
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}


// Функция для получения предметов с сервера
async function fetchSubjects() {
    try {
        const response = await fetch('/users/current');
            if (!response.ok) {
                throw new Error('Ошибка сети');
            }
        const user = await response.json();
        response2 = await fetch('/subject/'+user.login);
        if (!response2.ok) {
            throw new Error('Ошибка сети');
        }
        const subjects = await response2.json();
        const container = document.getElementById('subjects-container');
       // console.log(container)
        subjects.forEach(subject => {
            const card = createSubjectCard(subject);
            container.appendChild(card);
        });
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}
//Получение имени пользователя
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
