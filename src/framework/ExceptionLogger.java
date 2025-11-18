package framework;

public class ExceptionLogger extends Exception {
    public ExceptionLogger(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN IABot para el LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "NO sea sapo..";
    }    
}
