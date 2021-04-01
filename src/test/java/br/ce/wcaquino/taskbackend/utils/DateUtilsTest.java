package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class DateUtilsTest {
  
  @Test 
  public void deveRetornarTrueParaDatasFuturas() {
    LocalDate date = LocalDate.of(2030, 01, 01);
    Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    //System.out.println(DateUtils.isEqualOrFutureDate(date));
    //DateUtils.isEqualOrFutureDate(date);
  }
  
   @Test 
  public void deveRetornarTrueParaDataAtual() {
    LocalDate date = LocalDate.now();
    Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    //System.out.println(DateUtils.isEqualOrFutureDate(date));
    //DateUtils.isEqualOrFutureDate(date);
  }
  
  @Test 
  public void deveRetornarFalseParaDatasPassadas() {
    LocalDate date = LocalDate.of(2010, 01, 01);
    Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    //System.out.println(DateUtils.isEqualOrFutureDate(date));
    //DateUtils.isEqualOrFutureDate(date);
  }
}