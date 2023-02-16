package nus.iss.tfip.pafworkshop29.Util;

import java.io.Reader;
import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class JsonReading {

    // JSON string to JSON object
    public static JsonObject toJson(String str) {
        Reader reader = new StringReader(str);
        JsonReader jsonReader = Json.createReader(reader);
        return jsonReader.readObject();
    }

    // public static Order toOrder(JsonObject jobj) {

    // }
}
