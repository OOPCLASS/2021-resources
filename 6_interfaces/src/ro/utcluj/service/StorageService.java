package ro.utcluj.service;

public interface StorageService {

  String store(Object object);

  Object retrieve(String value);
}
