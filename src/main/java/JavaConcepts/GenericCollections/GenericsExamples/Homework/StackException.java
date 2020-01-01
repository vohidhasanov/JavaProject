package JavaConcepts.GenericCollections.GenericsExamples.Homework;


import java.util.ArrayList;
import java.util.List;

public class StackException extends Exception {
    private Object[] parameters;
    private List<StackException> exceptions;

    public StackException (String mensagem) {
        super(mensagem);
    }

    public StackException (String mensagem, Object...parameters) {
        super (mensagem);
        this.parameters = parameters;
    }

    public StackException () {}

    public Object getParametros () {
        return parameters;
    }

    public Object getParameters () {
        return parameters;
    }

    public List <StackException> getExceptions () {
        return exceptions;
    }

    public void setExceptions (List <StackException> execoes)  {
        this.exceptions = execoes;
    }

    /** throw Exception if getExceptions is not empty
     * @throws StackException
    */

    public void check() throws StackException {
        if (this.isNotEmpty()) {
            throw this;
        }
    }

    public void add (String mensagem, Object... parametros) {
        if (exceptions == null) {
            exceptions = new ArrayList<StackException>();
        }
        exceptions.add(new StackException(mensagem, parametros));
    }

    public void add (StackException ex) {
        if (exceptions==null) {
            exceptions = new ArrayList <StackException>();
        }
        if ( ex.getExceptions()==null || ex.getExceptions().isEmpty()) {
            exceptions.add(ex);
        }
        else {
            for (StackException ce : ex.getExceptions()) {
                exceptions.add(ce);
            }
        }
    }

    public boolean isNotEmpty () {
        return exceptions!=null && !exceptions.isEmpty();
    }

    public void clear () {
        if (exceptions!= null && !exceptions.isEmpty()) {
            exceptions.clear();
        }
    }



}
