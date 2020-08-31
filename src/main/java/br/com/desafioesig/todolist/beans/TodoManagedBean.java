package br.com.desafioesig.todolist.beans;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.util.StringUtils;

import br.com.desafioesig.todolist.model.Todo;
import br.com.desafioesig.todolist.repository.TodoRepository;

@SessionScoped
@Named("todoMB")
public class TodoManagedBean {
	
	private Todo todo = new Todo();
	
	@Inject
	private TodoRepository repository;
	
	public void save() {
		if (StringUtils.isEmpty(todo.getDescription())) {
			return;
		}
		
		repository.save(todo);
		
		this.todo = new Todo();
	}
	
	public void edit(Todo todo) {
		if (todo == null) {
			this.todo = new Todo();
			return;
		}
		
		this.todo = todo;
	}
	
	public List<Todo> getTodos() {
		return repository.findAll();
	}
	
	public void delete(Todo todo) {
		repository.delete(todo);
	}
	
	public void toggle(Todo todo) {
		todo.setCompleted(!todo.isCompleted());
		
		repository.save(todo);
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}	
	
}
