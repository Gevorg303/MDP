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
const selectClass = document.getElementById('selectClass');
selectClass.addEventListener('change', fetchSubjectsByClass);
selectClass.addEventListener('click', fetchSubjectsByClass);


// Функция для получения предметов по учителю и классу
async function fetchSubjectsByClass() {
    try {
        const response = await fetch('/users/current');
            if (!response.ok) {
                throw new Error('Ошибка сети');
            }
        const user = await response.json();
        const classId = document.getElementById('selectClass').value;
        //console.log('/subject/classId='+classId+';teacherId='+user.id)
        response2 = await fetch('/subject/class='+classId+'/teacher='+user.id);
        if (!response2.ok) {
            throw new Error('Ошибка сети');
        }
        const subjects = await response2.json();
        const select = document.getElementById('selectSubject');
        select.innerHTML = ""
       // console.log(container)
        subjects.forEach(subject => {
             select.append(new Option(subject.subjectName,subject.id))
        });
          //  console.log(subjects)
    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}

//получение классов учителя
async function fetchStudentCLass() {
    try {

        const response = await fetch('/users/current');
            if (!response.ok) {
                throw new Error('Ошибка поиска учителя');
            }
        const user = await response.json();
        console.log(user)
        if(user.role.role.toLowerCase()=="учитель" || user.role.role.toLowerCase()=="админ")
        {
            response2 = await fetch('/student-class/teacherid='+user.id);
            if (!response2.ok) {
                throw new Error('Ошибка вывода классов учителя');
            }
            const classes = await response2.json();
            const select = document.getElementById('selectClass');
            classes.forEach(subject => {

              // console.log(subject.numberOfInstitution +" "+ subject.letterDesignation +" "+ subject.educationalInstitution.nameOfTheInstitution + " "+ subject.educationalInstitution.address)
               select.append(new Option(subject.numberOfInstitution +" "+ subject.letterDesignation +" "+ subject.educationalInstitution.nameOfTheInstitution + " "+ subject.educationalInstitution.address,subject.id))
            });

           // console.log(select);
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
