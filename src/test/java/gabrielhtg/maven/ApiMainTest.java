package gabrielhtg.maven;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gabrielhtg.maven.model.ErrorData;
import gabrielhtg.maven.model.Item;
import gabrielhtg.maven.model.MessageData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.List;

public class ApiMainTest {
    final private ApiMain apiMain = new ApiMain();
    final private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetAllNotNull () {
        try {
            List<Item> items = objectMapper.readValue(apiMain.getAllItems().body(), new TypeReference<List<Item>>() {
            });

            Assertions.assertNotNull(items);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsGetAllReturn13Items () {
        try {
            List<Item> items = objectMapper.readValue(apiMain.getAllItems().body(), new TypeReference<List<Item>>() {
            });

            Assertions.assertEquals(13, items.size());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsGetAllSuccess () {
        int statusCode = apiMain.getAllItems().statusCode();

        Assertions.assertEquals(200, statusCode);
    }

    @Test
    public void testGetOneId1 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("1").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("1", item.getId());
            Assertions.assertEquals("Google Pixel 6 Pro", item.getName());
            Assertions.assertEquals("Cloudy White", item.getData().get("color"));
            Assertions.assertEquals("128 GB", item.getData().get("capacity"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId2 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("2").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("2", item.getId());
            Assertions.assertEquals("Apple iPhone 12 Mini, 256GB, Blue", item.getName());
            Assertions.assertNull(item.getData());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId3 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("3").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("3", item.getId());
            Assertions.assertEquals("Apple iPhone 12 Pro Max", item.getName());
            Assertions.assertEquals("Cloudy White", item.getData().get("color"));
            Assertions.assertEquals(512, item.getData().get("capacity GB"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId4 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("4").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("4", item.getId());
            Assertions.assertEquals("Apple iPhone 11, 64GB", item.getName());
            Assertions.assertEquals(389.99, item.getData().get("price"));
            Assertions.assertEquals("Purple", item.getData().get("color"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId5 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("5").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("5", item.getId());
            Assertions.assertEquals("Samsung Galaxy Z Fold2", item.getName());
            Assertions.assertEquals(689.99, item.getData().get("price"));
            Assertions.assertEquals("Brown", item.getData().get("color"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId6 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("6").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("6", item.getId());
            Assertions.assertEquals("Apple AirPods", item.getName());
            Assertions.assertEquals("3rd", item.getData().get("generation"));
            Assertions.assertEquals(120, item.getData().get("price"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId7 () {
        try {
            System.out.println(apiMain.getOneItem("7").body());
            Item item = objectMapper.readValue(apiMain.getOneItem("7").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("7", item.getId());
            Assertions.assertEquals("Apple MacBook Pro 16", item.getName());
            Assertions.assertEquals(1849.99, item.getData().get("price"));
            Assertions.assertEquals("Intel Core i9", item.getData().get("CPU model"));
            Assertions.assertEquals("1 TB", item.getData().get("Hard disk size"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId8 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("8").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("8", item.getId());
            Assertions.assertEquals("Apple Watch Series 8", item.getName());
            Assertions.assertEquals("Elderberry", item.getData().get("Strap Colour"));
            Assertions.assertEquals("41mm", item.getData().get("Case Size"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId9 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("9").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("9", item.getId());
            Assertions.assertEquals("Beats Studio3 Wireless", item.getName());
            Assertions.assertEquals("Red", item.getData().get("Color"));
            Assertions.assertEquals("High-performance wireless noise cancelling headphones", item.getData().get("Description"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId10 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("10").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("10", item.getId());
            Assertions.assertEquals("Apple iPad Mini 5th Gen", item.getName());
            Assertions.assertEquals("64 GB", item.getData().get("Capacity"));
            Assertions.assertEquals(7.9, item.getData().get("Screen size"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId11 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("11").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("11", item.getId());
            Assertions.assertEquals("Apple iPad Mini 5th Gen", item.getName());
            Assertions.assertEquals("254 GB", item.getData().get("Capacity"));
            Assertions.assertEquals(7.9, item.getData().get("Screen size"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId12 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("12").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("12", item.getId());
            Assertions.assertEquals("Apple iPad Air", item.getName());
            Assertions.assertEquals("4th", item.getData().get("Generation"));
            Assertions.assertEquals("419.99", item.getData().get("Price"));
            Assertions.assertEquals("64 GB", item.getData().get("Capacity"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneId13 () {
        try {
            Item item = objectMapper.readValue(apiMain.getOneItem("13").body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertEquals("13", item.getId());
            Assertions.assertEquals("Apple iPad Air", item.getName());
            Assertions.assertEquals("4th", item.getData().get("Generation"));
            Assertions.assertEquals("519.99", item.getData().get("Price"));
            Assertions.assertEquals("256 GB", item.getData().get("Capacity"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetOneSuccess () {
        int statusCode = apiMain.getOneItem("1").statusCode();

        Assertions.assertEquals(200, statusCode);
    }

    @Test
    public void testGetOneFailedIdUnknown() {
        int statusCode = apiMain.getOneItem("99").statusCode();

        Assertions.assertNotEquals(200, statusCode);
        Assertions.assertEquals(404, statusCode);
        Assertions.assertEquals("""
                {"error":"Oject with id=99 was not found."}
                """.trim(), apiMain.getOneItem("99").body());
    }

    @Test
    public void testGetMoreThanOne() {
        int statusCode = apiMain.getOneItem("99").statusCode();
        try {
            ErrorData error = objectMapper.readValue(apiMain.getOneItem("99").body(), ErrorData.class);
            Assertions.assertNotEquals(200, statusCode);
            Assertions.assertEquals(404, statusCode);
            Assertions.assertEquals("Oject with id=99 was not found.", error.getError());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void testIsGetSelected3ItemsReturn3Items() {
        try {
            List<Item> items = objectMapper.readValue(apiMain.getSelectedItem(new String[] {"3", "5", "10"}).body(), new TypeReference<List<Item>>() {
            });

            Assertions.assertEquals(3, items.size());

            for (int i = 0; i < items.size(); i++) {
                if (i == 0) {
                    Assertions.assertNotNull(items.get(i));
                    Assertions.assertEquals("3", items.get(i).getId());
                    Assertions.assertEquals("Apple iPhone 12 Pro Max", items.get(i).getName());
                    Assertions.assertEquals("Cloudy White", items.get(i).getData().get("color"));
                    Assertions.assertEquals(512, items.get(i).getData().get("capacity GB"));
                }

                else if (i == 1) {
                    Assertions.assertNotNull(items.get(i));
                    Assertions.assertEquals("5", items.get(i).getId());
                    Assertions.assertEquals("Samsung Galaxy Z Fold2", items.get(i).getName());
                    Assertions.assertEquals(689.99, items.get(i).getData().get("price"));
                    Assertions.assertEquals("Brown", items.get(i).getData().get("color"));
                }

                else if (i == 2) {
                    Assertions.assertNotNull(items.get(i));
                    Assertions.assertEquals("10", items.get(i).getId());
                    Assertions.assertEquals("Apple iPad Mini 5th Gen", items.get(i).getName());
                    Assertions.assertEquals("64 GB", items.get(i).getData().get("Capacity"));
                    Assertions.assertEquals(7.9, items.get(i).getData().get("Screen size"));
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsGetSelected3ItemsReturn3ItemsFailed() {
        try {
            List<Item> items = objectMapper.readValue(apiMain.getSelectedItem(new String[] {"3", "5", "99"}).body(), new TypeReference<List<Item>>() {
            });

            Assertions.assertEquals(2, items.size());

            for (int i = 0; i < items.size(); i++) {
                if (i == 0) {
                    Assertions.assertNotNull(items.get(i));
                    Assertions.assertEquals("3", items.get(i).getId());
                    Assertions.assertEquals("Apple iPhone 12 Pro Max", items.get(i).getName());
                    Assertions.assertEquals("Cloudy White", items.get(i).getData().get("color"));
                    Assertions.assertEquals(512, items.get(i).getData().get("capacity GB"));
                }

                else if (i == 1) {
                    Assertions.assertNotNull(items.get(i));
                    Assertions.assertEquals("5", items.get(i).getId());
                    Assertions.assertEquals("Samsung Galaxy Z Fold2", items.get(i).getName());
                    Assertions.assertEquals(689.99, items.get(i).getData().get("price"));
                    Assertions.assertEquals("Brown", items.get(i).getData().get("color"));
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddItem() {
        String json = """
                {
                   "name": "Apple MacBook Pro 16",
                   "data": {
                      "year": 2019,
                      "price": 1849.99,
                      "CPU model": "Intel Core i9",
                      "Hard disk size": "1 TB"
                   }
                }
                """;
        try {
            Item item = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());
            Assertions.assertEquals("Apple MacBook Pro 16", item.getName());
            Assertions.assertEquals(1849.99, item.getData().get("price"));
            Assertions.assertEquals("Intel Core i9", item.getData().get("CPU model"));
            Assertions.assertEquals("1 TB", item.getData().get("Hard disk size"));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddItemMouse() {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB"
                    }
                 }
                """;
        try {
            Item item = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());
            Assertions.assertEquals("Mouse Gaming Keren", item.getName());
            Assertions.assertEquals(1000, item.getData().get("price"));
            Assertions.assertEquals(2024, item.getData().get("year"));
            Assertions.assertEquals("Intel Core i9", item.getData().get("CPU model"));
            Assertions.assertEquals("1 TB", item.getData().get("Hard disk size"));
            Assertions.assertNotNull(item.getCreatedAt());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddItemMouseGagal() {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                    }
                 }
                """;
        try {
            Item item = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());
            Assertions.assertEquals("Mouse Gaming Keren", item.getName());
            Assertions.assertEquals(1000, item.getData().get("price"));
            Assertions.assertEquals(2024, item.getData().get("year"));
            Assertions.assertEquals("Intel Core i9", item.getData().get("CPU model"));
        } catch (JsonProcessingException e) {
            try {
                ErrorData errorMessage = objectMapper.readValue(apiMain.addItem(json).body(), ErrorData.class);

                Assertions.assertEquals(400, apiMain.addItem(json).statusCode());
                Assertions.assertEquals("400 Bad Request. If you are trying to create or update the data, potential issue is that you are sending incorrect body json or it is missing at all.", errorMessage.getError());
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Test
    public void testDeleteItemSuccess () {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB"
                    }
                 }
                """;

        try {
            Item item = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            MessageData messageData = objectMapper.readValue(apiMain.deleteItem(item.getId()).body(), MessageData.class);

            Assertions.assertNotNull(messageData);
            Assertions.assertEquals(String.format("Object with id = %s, has been deleted.", item.getId()), messageData.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeleteReservedIdFailed () {
        try {
            ErrorData errorData = objectMapper.readValue(apiMain.deleteItem("6").body(), ErrorData.class);

            Assertions.assertNotNull(errorData);
            Assertions.assertEquals("6 is a reserved id and the data object of it cannot be deleted. You can create your own new object via POST request and try to send a DELETE request with new generated object id.", errorData.getError());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeleteUnknownIdFailed () {
        try {
            String id = "sdfhaidshfadifija";
            ErrorData errorData = objectMapper.readValue(apiMain.deleteItem(id).body(), ErrorData.class);

            Assertions.assertNotNull(errorData);
            Assertions.assertEquals(String.format("Object with id = %s doesn't exist.", id), errorData.getError());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateItemFailReservedId () {
        String json = """
                {
                    "name": "Mouse Gaming Update",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB",
                       "Color": "black"
                    }
                 }
                """;
        String id = "7";

        try {
            ErrorData error = objectMapper.readValue(apiMain.updateItem(id, json).body(), ErrorData.class);

            Assertions.assertNotNull(error);
            Assertions.assertEquals(String.format("%s is a reserved id and the data object of it cannot be overridden. You can create a new object via POST request and use new generated by id from it to send a PUT request.", id), error.getError());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateItemSuccess () {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB"
                    }
                 }
                """;

        String jsonUpdate = """
                {
                    "name": "Mouse Gaming Update",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB",
                       "Color": "black"
                    }
                 }
                """;

        try {
            Item itemAdded = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            Item itemUpdate = objectMapper.readValue(apiMain.updateItem(itemAdded.getId(), jsonUpdate).body(), Item.class);

            Assertions.assertNotNull(itemUpdate);
            Assertions.assertNotNull(itemAdded.getId(), itemUpdate.getId());
            Assertions.assertEquals("Mouse Gaming Update", itemUpdate.getName());
            Assertions.assertEquals(1000, itemUpdate.getData().get("price"));
            Assertions.assertEquals(2024, itemUpdate.getData().get("year"));
            Assertions.assertEquals("Intel Core i9", itemUpdate.getData().get("CPU model"));
            Assertions.assertEquals("1 TB", itemUpdate.getData().get("Hard disk size"));
            Assertions.assertEquals("black", itemUpdate.getData().get("Color"));
            Assertions.assertNotEquals(itemAdded.getCreatedAt(), itemUpdate.getUpdatedAt());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateItemWrongDataType () {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB"
                    }
                 }
                """;

        String jsonUpdate = """
                {
                    "name": true,
                    "data": {
                       "year": false,
                       "price": true,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB",
                       "Color": "black"
                    }
                 }
                """;

        try {
            Item itemAdded = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

//            Item updateItem = objectMapper.readValue(apiMain.updateItem(itemAdded.getId(), jsonUpdate).body(), Item.class);

            System.out.println(apiMain.updateItem(itemAdded.getId(), jsonUpdate).body());
//            Assertions.assertNotNull(updateItem);
        } catch (JsonProcessingException e) {
            // API seharusnya tidak bisa menerima name dengan tipe data boolean!
            Assertions.fail();
        }
    }

    @Test
    public void updateItemFailFormatWrong () {
        String json = """
                {
                    "name": "Mouse Gaming Keren",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                       "Hard disk size": "1 TB"
                    }
                 }
                """;

        String jsonUpdate = """
                {
                    "name": "Mouse Gaming Update",
                    "data": {
                       "year": 2024,
                       "price": 1000,
                       "CPU model": "Intel Core i9",
                    }
                 }
                """;

        try {
            Item itemAdded = objectMapper.readValue(apiMain.addItem(json).body(), Item.class);

            System.out.println(apiMain.updateItem(itemAdded.getId(), jsonUpdate).body());
            ErrorData errorData = objectMapper.readValue(apiMain.updateItem(itemAdded.getId(), jsonUpdate).body(), ErrorData.class);

            Assertions.assertNotNull(errorData);
            Assertions.assertEquals("400 Bad Request. If you are trying to create or update the data, potential issue is that you are sending incorrect body json or it is missing at all.", errorData.getError());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
