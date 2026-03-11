package org.example.adapter;

public class Main_Adapter {
    public static void main(String[] args) {

        XmlService xmlService = new XmlService();

        // Adapter chuyển XML ↔ JSON
        JsonService adapter = new XmlToJsonAdapter(xmlService);

        // Client chỉ biết JSON
        String json = "{ \"name\": \"ChatGPT\", \"type\": \"AI\" }";
        adapter.processJson(json);
    }
}
