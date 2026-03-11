package org.example.adapter;

public class XmlToJsonAdapter implements JsonService {

    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void processJson(String jsonData) {
        // Giả lập chuyển JSON → XML
        String xmlData = "<data>" + jsonData + "</data>";
        xmlService.processXml(xmlData);
    }
}
