package repository;

import model.Todolist;

public interface TodolistRepository {
    Todolist[] fetchAll();
    void insert(Todolist todo);
    boolean remove(Integer number);
}
