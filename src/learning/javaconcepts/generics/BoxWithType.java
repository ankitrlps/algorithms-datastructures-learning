package learning.javaconcepts.generics;

public class BoxWithType<T> {

    private T object;

    public void setObject(T object){
        this.object = object;
    }
    public T getObject(){
        return this.object;
    }
}
