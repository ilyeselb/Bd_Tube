package com.bdtube.bdtube.Controller;

import com.bdtube.bdtube.Model.Chanel;
import com.bdtube.bdtube.Model.Coments;
import com.bdtube.bdtube.Model.Video;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.BadLocationException;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ChanelController {
    static List<Video> lv ;
    static Chanel c;
    //*************************
    //afficher la  liste des videos d'une chaine choisi

    @PostMapping("/chanel")
    public List<Video> getChanelVideo(@RequestBody Chanel vd) throws IOException, JSONException {
        System.out.println("aaaaa");

String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="+vd.getId_chanel()+"&order=date&key=AIzaSyDPgjVoizTBsAydZfp4WM10_8xW1nfoGzA";
        System.out.println("url::::est entrer"+url);
        String jsonText = readFromUrl(url);
        JSONObject json = new JSONObject(String.valueOf(jsonText));
        List<Video> list = new ArrayList<>();
        JSONArray array = null;
        try {
            array = json.getJSONArray("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length(); i++) {
            // list.add(array.getJSONObject(i).getString("contentDetails"));
            try {
                Video v = new Video();
                v.setChanel_ofvideo(vd);
                v.setTitle(array.getJSONObject(i).getJSONObject("snippet").getString("title"));
                v.setDescription(array.getJSONObject(i).getJSONObject("snippet").getString("description"));
                v.setImgUrl(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url"));

                v.setId_video(array.getJSONObject(i).getJSONObject("id").getString("videoId"));
                v.setLien("https://www.youtube.com/embed/" + array.getJSONObject(i).getJSONObject("id").getString("videoId"));
                System.out.println(v);
                list.add(v);

            } catch (JSONException e) {
                throw e;
            }
        }
        System.out.println(list);
        lv=list;
        return list;
    }
    public static String readFromUrl(String requestURL) throws IOException
    {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
    //******************
    //transferer las video de la chaine dans une variable static
    @GetMapping("/transfere3")
    public List<Video> transfere3(){
        System.out.println("transfere3");
        System.out.println(lv);

        return lv;
    }




}
