package project.dao;

import redis.clients.jedis.Jedis;

public class CityCache {

    private static final String URL = "localhost";
    private static final int PORT = 6379;

    private static final CityCache INSTANCE = new CityCache();

    private final Jedis client = new Jedis(URL, PORT);

    public void add(String key, String value) {
        client.set(key, value);
    }

    public String get(String key) {
        return client.get(key);
    }

    public static CityCache getInstance() {
        return INSTANCE;
    }

}
