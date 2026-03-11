package org.example.adapter;

class JSONAdapter implements JSONService {

    private XMLService xmlService;

    public JSONAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void sendJSON(String json) {

        String xml = convertJSONtoXML(json);

        xmlService.sendXML(xml);
    }

    private String convertJSONtoXML(String json) {

        return "<data>" + json + "</data>";
    }
}