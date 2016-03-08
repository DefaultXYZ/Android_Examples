package default_xyz.playground.rest.service;

import java.util.Collections;

import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Service Generator for Rest Connection
 * Created by yevhenii_ishchenko on 20/02/16.
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "http://172.20.8.197:80";

    private static ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT)
            .build();

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectionSpecs(Collections.singletonList(spec))
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
