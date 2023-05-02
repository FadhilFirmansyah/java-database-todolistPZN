package self.java.todolist;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import util.DatabaseUtil;
import view.TodolistView;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodolistRepository repository = new TodolistRepositoryImpl(dataSource);
        TodolistService service = new TodolistServiceImpl(repository);
        TodolistView view = new TodolistView(service);

        view.showTodoList();
    }
}
