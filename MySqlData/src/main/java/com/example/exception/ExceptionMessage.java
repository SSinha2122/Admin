package com.example.exception;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ExceptionMessage {

   private String errorMessage;
   private String errorCode;

   public ExceptionMessage(String errorMessage, String errorCode) {
       super();
       this.errorMessage = errorMessage;
       this.errorCode=errorCode;
       
   }
}
