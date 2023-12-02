package apo.Service;
import java.util.List;
public interface DemoService {
    List<String> findAll();
    int add(String userId, int points);
    int sub(String userId, int points);
    int mul(String userId, int points);
    int div(String userId, int points);

}
