import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("src/data.json");

        try {
            String content = Files.readString(filePath);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, List<List<Object>>> map = mapper.readValue(content, Map.class);

            double sum = 0;
            for (List<Object> innerList : map.get("data")) {
                if (innerList.size() > 0 && innerList.get(0) instanceof Number) {
                    sum += ((Number) innerList.get(0)).doubleValue();
                }
            }

            System.out.println("SUM =======> " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
