package service;

import java.util.List;

import domain.Persona;
import domain.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonaInterface {

    @GET("personas")
    Call<Persona> getPersonas();



}
