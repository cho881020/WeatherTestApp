package kr.co.tjeit.weathertestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    String jsonString = "{\n" +
            "    \"weather\":{\n" +
            "        \"minutely\":[\n" +
            "            {\n" +
            "                \"station\":{\n" +
            "                    \"longitude\":\"126.9453\",\n" +
            "                    \"latitude\":\"37.6444\",\n" +
            "                    \"name\":\"은평\",\n" +
            "                    \"id\":\"416\",\n" +
            "                    \"type\":\"KMA\"\n" +
            "                },\n" +
            "                \"wind\":{\n" +
            "                    \"wdir\":\"280.30\",\n" +
            "                    \"wspd\":\"0.80\"\n" +
            "                },\n" +
            "                \"precipitation\":{\n" +
            "                    \"sinceOntime\":\"0.00\",\n" +
            "                    \"type\":\"0\"\n" +
            "                },\n" +
            "                \"sky\":{\n" +
            "                    \"code\":\"SKY_A01\",\n" +
            "                    \"name\":\"맑음\"\n" +
            "                },\n" +
            "                \"rain\":{\n" +
            "                    \"sinceOntime\":\"0.00\",\n" +
            "                    \"sinceMidnight\":\"0.00\",\n" +
            "                    \"last10min\":\"0.00\",\n" +
            "                    \"last15min\":\"0.00\",\n" +
            "                    \"last30min\":\"0.00\",\n" +
            "                    \"last1hour\":\"0.00\",\n" +
            "                    \"last6hour\":\"0.00\",\n" +
            "                    \"last12hour\":\"0.00\",\n" +
            "                    \"last24hour\":\"0.00\"\n" +
            "                },\n" +
            "                \"temperature\":{\n" +
            "                    \"tc\":\"26.30\",\n" +
            "                    \"tmax\":\"28.00\",\n" +
            "                    \"tmin\":\"15.00\"\n" +
            "                },\n" +
            "                \"humidity\":\"\",\n" +
            "                \"pressure\":{\n" +
            "                    \"surface\":\"\",\n" +
            "                    \"seaLevel\":\"\"\n" +
            "                },\n" +
            "                \"lightning\":\"0\",\n" +
            "                \"timeObservation\":\"2017-09-01 12:26:00\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"common\":{\n" +
            "        \"alertYn\":\"Y\",\n" +
            "        \"stormYn\":\"N\"\n" +
            "    },\n" +
            "    \"result\":{\n" +
            "        \"code\":9200,\n" +
            "        \"requestUrl\":\"/weather/current/minutely?lon=126.929946&village=&county=&stnid=&lat=37.612003&version=1&city=\",\n" +
            "        \"message\":\"성공\"\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {



        Log.d("JSON", jsonString);

        try {
            JSONObject json = new JSONObject(jsonString);
////            1. 날씨 보여주는 동네 이름 추출 : String 변수 저장.
//            JSONObject weather = json.getJSONObject("weather");
//            Log.d("weather", weather.toString());
//            JSONArray minutely = weather.getJSONArray("minutely");
////            배열의 첫번째 0번칸 JSONObject 코드
//            JSONObject firstObject = minutely.getJSONObject(0);
//            JSONObject station = firstObject.getJSONObject("station");
//            Log.d("station", station.toString());
//            String name = station.getString("name");
//
//            Toast.makeText(mContext, "사는 동네 : " + name, Toast.LENGTH_SHORT).show();

//            result -> message 내용 : 성공 을 토스트로 출력.

            JSONObject weather = json.getJSONObject("weather");
            JSONArray minutely = weather.getJSONArray("minutely");
            JSONObject first = minutely.getJSONObject(0);
            JSONObject sky = first.getJSONObject("sky");
            String name = sky.getString("name");

            Toast.makeText(mContext, "현재 날씨 : " + name, Toast.LENGTH_SHORT).show();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void bindViews() {

    }
}
