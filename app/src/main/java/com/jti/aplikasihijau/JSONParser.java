package com.jti.aplikasihijau;

import com.jti.aplikasihijau.Model.ModelProfile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    //Declare the arrays of fields you require
    public static String[] names;
    public static String[] urls;
    private JSONArray Data = null;


    List<ModelProfile> profile ;


    private String json;

    public JSONParser(String json){

        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;

        try {

            Data = new JSONArray(json);


            names = new String[Data.length()];
            urls = new String[Data.length()];
            profile = new ArrayList<ModelProfile>();



            for(int i=0;i< Data.length();i++){
                ModelProfile movie_object =  new ModelProfile();

                JSONObject jsonObject1 = Data.getJSONObject(i);

                names[i] = jsonObject1.getString("name");
                urls[i] = jsonObject1.getString("url");

                movie_object.setFirstName(names[i]);
                movie_object.setLastName(urls[i]);
                profile.add(movie_object);



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    List<ModelProfile> getMovies()
    {
        //function to return the final populated list
        return profile;
    }



}
