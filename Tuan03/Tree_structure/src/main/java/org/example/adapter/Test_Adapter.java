package org.example.adapter;

public class Test_Adapter {
    public static void main(String[] args) {

        XMLService xmlService = new XMLService();

        JSONService adapter = new JSONAdapter(xmlService);

        adapter.sendJSON("{name:'John'}");
    }

}
