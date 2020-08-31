package br.com.desafioesig.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafioesig.todolist.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
