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
class Searchcontroller {
    //methode pour rechercher les chaine youtube avec un username
    @PostMapping("/Getchanel")
    public List<Chanel> getchanel(@RequestBody String id) throws JSONException, IOException {

        System.out.println("aaaaa");
        JSONObject obj = new JSONObject(id);

       // String Keywrd = obj.getString("message");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + id + "&type=channel&key=AIzaSyDPgjVoizTBsAydZfp4WM10_8xW1nfoGzA";
        System.out.println("url::::est entrer" + url);
        String jsonText = readFromUrl(url);
        JSONObject json = new JSONObject(String.valueOf(jsonText));
        List<Chanel> list = new ArrayList<>();
        JSONArray array = null;
        try {
            array = json.getJSONArray("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length(); i++) {
            // list.add(array.getJSONObject(i).getString("contentDetails"));
            try {
                Chanel v = new Chanel();

                v.setTitre(array.getJSONObject(i).getJSONObject("snippet").getString("title"));
                v.setDescription(array.getJSONObject(i).getJSONObject("snippet").getString("description"));
                v.setId_chanel(array.getJSONObject(i).getJSONObject("snippet").getString("channelId"));
                v.setLienimg(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url"));
                System.out.println(v);
                list.add(v);

            } catch (JSONException e) {
                throw e;
            }
        }
        System.out.println(list);
        return list;
    }

    //**************************************************
    //get Coments of video with id
    @GetMapping("Getcoments/{id}")
    public List<Coments> getcoments(@PathVariable String id) throws JSONException, IOException {


        String url = "https://www.googleapis.com/youtube/v3/commentThreads?key=AIzaSyDPgjVoizTBsAydZfp4WM10_8xW1nfoGzA&textFormat=plainText&part=snippet&videoId=" + id;
        System.out.println("url::::est entrer" + url);
        String jsonText = readFromUrl(url);

        JSONObject json = new JSONObject(String.valueOf(jsonText));

        Set<Coments> s = new HashSet<>();

        List<Coments> list = new ArrayList<>();
        JSONArray array = null;
        try {
            array = json.getJSONArray("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < array.length(); i++) {
            // list.add(array.getJSONObject(i).getString("contentDetails"));
            try {
                Coments v = new Coments();

                v.setComensts(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("textOriginal"));
                v.setAuthorname(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("authorDisplayName"));
                v.setAuthorurl(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("authorProfileImageUrl"));
                list.add(v);

            } catch (JSONException e) {
                throw e;
            }
        }
        System.out.println(list);
        return list;
    }
    //******************************************************
    //methode de recherche de video qui utilisie un lien jsoup pour generer une reponse json
    @PostMapping("/test")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Video> SearchVid(@RequestBody String keyword) throws JSONException, IOException {
        System.out.println(keyword);
        JSONObject obj = new JSONObject(keyword);
        String Keywrd = obj.getString("message");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=50&order=rating&q=" + Keywrd + "&key=AIzaSyDPgjVoizTBsAydZfp4WM10_8xW1nfoGzA";
        System.out.println(url);

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

                System.out.println(array.getJSONObject(i).getJSONObject("snippet").getString("title"));
                v.setTitle(array.getJSONObject(i).getJSONObject("snippet").getString("title"));
                v.setDescription(array.getJSONObject(i).getJSONObject("snippet").getString("description"));
                v.setImgUrl(array.getJSONObject(i).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url"));

                v.setId_video(array.getJSONObject(i).getJSONObject("id").getString("videoId"));
                v.setLien("https://www.youtube.com/embed/" + array.getJSONObject(i).getJSONObject("id").getString("videoId"));

                System.out.println(v);
                list.add(v);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        List<Video> vl = new ArrayList<>();
        for (Video x : list) {
            vl.add(x);
        }
        System.out.println("ooh");

        System.out.println(vl);
        return vl;
    }
//methode pour lire du JSON
    public static String readFromUrl(String requestURL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}






