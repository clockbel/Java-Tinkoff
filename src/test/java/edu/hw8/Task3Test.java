package edu.hw8;

import edu.hw8.task3.MultiThreadedPasswordCracker;
import java.util.HashMap;
import java.util.Map;
import edu.hw8.task3.SingleThreadedPasswordCracker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    public void test1() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a.v.petrov", "202cb962ac59075b964b07152d234b70");
        Map<String, String> result = new HashMap<>();
        result.put("a.v.petrov", "123");
        Map<String, String> crackMap;
        SingleThreadedPasswordCracker cracker = new SingleThreadedPasswordCracker(hashMap);
        crackMap = cracker.crack();
        assertThat(crackMap).isEqualTo(result);
    }

    @Test
    public void test2() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a.v.petrov", "202cb962ac59075b964b07152d234b70");
        Map<String, String> result = new HashMap<>();
        result.put("a.v.petrov", "123");
        Map<String, String> crackMap;
        MultiThreadedPasswordCracker cracker = new MultiThreadedPasswordCracker(hashMap, 4);
        crackMap = cracker.crack();
        assertThat(crackMap).isEqualTo(result);
    }
}
