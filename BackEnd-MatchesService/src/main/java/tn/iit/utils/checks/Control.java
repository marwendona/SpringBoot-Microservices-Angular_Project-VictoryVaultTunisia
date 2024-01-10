package tn.iit.utils.checks;

public abstract class Control<T> {
    protected T entityToCheck;
    protected boolean isValid = true;

    public boolean finish(){
        return this.isValid;
    }

}
