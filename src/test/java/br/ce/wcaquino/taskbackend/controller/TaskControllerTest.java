package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.utils.ValidationException;


public class TaskControllerTest {
  
  //@Mock
  //private TaskRepo taskRepo;
  
  //@InjectMocks
  //private TaskController controller;
  
  //@Before
  //public void setup() {
    //MockitoAnnotations.initMocks(this);
  //}
  
  
  @Test
  public void naoDeveSalvarTarefaSemDescricao()  {
    Task todo = new Task();
    todo.setDueDate(LocalDate.now());
    //TaskController controller = new TaskController();
    try {
      controller.save(todo);
      Assert.fail("Nao deveria chegar nesse ponto");
    } catch (ValidationException e) {
      Assert.assertEquals("Fill the task description", e.getMessage());
      //TODO auto-generate catch block
      //e.printStackTrace();
    }   
  
  }
  
  @Test 
  public void naoDeveSalvarTarefaSemData() {
    Task todo = new Task();
    todo.setTask("Descrição");
   // todo.setDueDate(LocalDate.now());
    //TaskController controller = new TaskController();
    try {
      controller.save(todo);
      Assert.fail("Nao deveria chegar nesse ponto");
    } catch (ValidationException e) {
      Assert.assertEquals("Fill the due date", e.getMessage());
      //TODO auto-generate catch block
      //e.printStackTrace();
    }    
  
  }
    
  
  @Test 
  public void naoDeveSalvarTarefaComDataPassada() {
    Task todo = new Task();
    todo.setTask("Descrição");
    todo.setDueDate(LocalDate.of(2010, 01, 01));
    //TaskController controller = new TaskController();
    try {
      controller.save(todo);
      Assert.fail("Nao deveria chegar nesse ponto");
    } catch (ValidationException e) {
      Assert.assertEquals("Due date must not be in past", e.getMessage());
      //TODO auto-generate catch block
      //e.printStackTrace();
    }
    
  }
  
  @Test    
  public void deveSalvarTarefaComSucesso() {
    Task todo = new Task();
    todo.setTask("Descrição");
    todo.setDueDate(LocalDate.now());
    //TaskController controller = new TaskController();
    controller.save(todo);
    
    }
}
