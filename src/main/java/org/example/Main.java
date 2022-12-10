package org.example;

public class Main {

    public static void main(String[] args) {
        //Добавление записей
        UserService.add(new User("Salmon", 30));
        UserService.add(new User("Bomon", 32));
        UserService.add(new User("Gery", 22));
        UserService.add(new User("Ured", 19));
        UserService.add(new User("Baby", 5));
        UserService.add(new User("Oldman", 77));
        //Получение всех записей
        UserService.get();
        //Получение записи по имени
        UserService.get("Oldman");
        //Получение записей по полуинтервалу возрастов
        UserService.get(10,35);
        //Удаление записи по имени
        UserService.delete("Baby");
        //Проверка результата
        UserService.get();
    }
}