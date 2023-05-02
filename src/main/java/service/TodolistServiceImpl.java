package service;

import model.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService{

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodo() {
        Todolist[] todolists = todolistRepository.fetchAll();

        System.out.println("\nTODOLIST");

        for(Todolist todolist : todolists){
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }
    }

    @Override
    public void addTodo(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.insert(todolist);
        System.out.printf("Sukses Menambahkan Todo");
    }

    @Override
    public void deleteTodo(Integer id) {
        boolean status = todolistRepository.remove(id);

        if(status){
            System.out.println("Sukses Menghapus Todo");
        }else {
            System.out.println("Todo yang ingin dihapus tidak tersedia");
        }
    }
}
