package com.example.roomapp.Network;

import com.example.roomapp.data.FileOperation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MyConverter implements Converter {

    @Override
    public Object convert(Object value) throws IOException {
        return null;
    }

    final static class JsonConverter implements Converter<ResponseBody, JSONObject> {
        static final JsonConverter INSTANCE = new JsonConverter();

        @Override
        public JSONObject convert(ResponseBody responseBody) throws IOException {
            try {
                return new JSONObject(responseBody.string());
            } catch (JSONException e) {
                throw new IOException("Failed to parse JSON", e);
            }
        }
    }

    public static void writeJSON(Object jsonData,String filename) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileOperation.writeFile("json",filename,gson.toJson(jsonData).getBytes());

    }
}