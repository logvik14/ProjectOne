/**
 * Created by ilyav on 21.01.2017.
 */
public interface AbstactDao <T>{

    public T save (T t) throws Exception;
    public T delete (T t) throws Exception;
}
