public interface ClientRequests {
    String get(String endpoint);
    String put(String endpoint);
    String post(String endpoint);
    String delete(String endpoint);
}
