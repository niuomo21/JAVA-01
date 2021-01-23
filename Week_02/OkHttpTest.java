package Week02;


import org.omg.CORBA.Request;

import javax.xml.ws.Response;

public class OkHttpTest {
    private OkHttpClient client =new OkHttpClient();

    public static void main(String[] args) {
        String url = "http://localhost:8801";
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());
    }
}
