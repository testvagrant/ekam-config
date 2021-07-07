package com.testvagrant.ekam.commons.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class GsonParser {

  private final Gson gson;

  public GsonParser() {
    this.gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
  }

  public <T> String serialize(T object) {
    return gson.toJson(object);
  }

  public <T, Q> Q serialize(T object, Class<Q> typeToUpdate) {
    String serializedData = serialize(object);
    return deserializeFromString(serializedData, typeToUpdate);
  }

  public <T, Q> Q deserialize(T object, Class<Q> qClass) {
    String serialize = serialize(object);
    return deserializeFromString(serialize, qClass);
  }

  public <T> T deserializeFromString(String object, Class<T> tClass) {
    return gson.fromJson(object, tClass);
  }

  public <T> T deserialize(FileReader reader, Class<T> tClass) {
    return gson.fromJson(reader, tClass);
  }

  public <T> T deserialize(String filePath, Class<T> tClass) {
    try {
      JsonReader reader = new JsonReader(new FileReader(filePath));
      return gson.fromJson(reader, tClass);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public <T> T deserialize(String filePath, Type tType) {
    try {
      JsonReader reader = new JsonReader(new FileReader(filePath));
      return gson.fromJson(reader, tType);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public <T> T deserialize(LinkedTreeMap<String, Object> treeMap, Type tType) {
    JsonElement json = gson.toJsonTree(treeMap);
    return gson.fromJson(json, tType);
  }

  public <T> T deserialize(LinkedTreeMap<String, Object> treeMap, Class<T> tClass) {
    JsonElement json = gson.toJsonTree(treeMap);
    return gson.fromJson(json, tClass);
  }

  public <T> T deserialize(InputStreamReader reader, Type tType) {
    return gson.fromJson(reader, tType);
  }

  public <T> T deserialize(InputStreamReader streamReader, Class<T> tClass) {
    return gson.fromJson(streamReader, tClass);
  }

  public <T> T deserialize(JsonElement jsonElement, Class<T> tClass) {
    return gson.fromJson(jsonElement, tClass);
  }
}
