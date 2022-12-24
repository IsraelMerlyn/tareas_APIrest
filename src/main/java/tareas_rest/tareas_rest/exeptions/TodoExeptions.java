package tareas_rest.tareas_rest.exeptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

/* (non-Javadoc)
 * @see java.lang.Throwable#toString()
 */
@Data
public class TodoExeptions extends RuntimeException{
    
    private String message;
    private HttpStatus httpStatus;

    public TodoExeptions(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus=httpStatus;
    }
}
