import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultaMoneda {

    public Moneda convertirMoneda(int opcion, float valor) {

        String currencyCode = obtenerCurrencyCode(opcion);
        
        String api = "cdef8844840e854407b9c0d6";
        
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + api + "/pair/" + currencyCode + "/" + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró.");
        }
    }

    public String obtenerCurrencyCode(int opcion) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "USD/ARS");
        map.put(2, "ARS/USD");
        map.put(3, "USD/BRL");
        map.put(4, "BRL/USD");
        map.put(5, "USD/COP");
        map.put(6, "COP/USD");

        return map.get(opcion);
    }

    public void mostrarResultado(float valor, Moneda moneda) {
        System.out.println("El valor " + valor + " [" + moneda.base_code() + "] corresponde al valor final de ==> " + moneda.conversion_result() + " [" + moneda.target_code() + "]");
    }
}
