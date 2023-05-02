package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {
    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodoList(){
        while (true){
            todolistService.showTodo();
            System.out.println("\nMenu");
            System.out.println("1. Menambah Todo");
            System.out.println("2. Menghapus Todo");
            System.out.println("x. Keluar");
            String input = InputUtil.input("Operasi");

            if(input.equals("1")){
                addTodoList();
            } else if (input.equals("2")) {
                deleteTodoList();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("Input tidak tersedia");
            }
        }
        System.out.println("Sampai Jumpa Kembali");
    }

    public void addTodoList(){
        System.out.println("MENAMBAH TODO");
        var input = InputUtil.input("Todo(x untuk cancel)");

        if(input.equals("x")){
            System.out.println("Gagal Menambahkan Todo");
        }else {
            todolistService.addTodo(input);
        }
    }

    public void deleteTodoList(){
        System.out.println("MENGHAPUS TODO");
        var number = InputUtil.input("No(x untuk cancel)");

        if(number.equals("x")){
            System.out.println("Gagal Menghapus Todo");
        }else {
            todolistService.deleteTodo(Integer.valueOf(number));
        }
    }
}
