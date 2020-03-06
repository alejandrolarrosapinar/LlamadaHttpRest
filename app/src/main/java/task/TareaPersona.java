package task;

import android.os.AsyncTask;

import domain.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.PersonaInterface;

public class TareaPersona extends AsyncTask<Void,Void,Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        String miUrl = "http://192.168.100.17:8080/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(miUrl).addConverterFactory(GsonConverterFactory.create()).build();

        PersonaInterface post =retrofit.create(PersonaInterface.class);
        Call<Persona> llamada = post.getPersonas();
        llamada.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
        return null;
    }
}
