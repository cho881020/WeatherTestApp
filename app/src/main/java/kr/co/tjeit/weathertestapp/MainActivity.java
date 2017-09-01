package kr.co.tjeit.weathertestapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import kr.co.tjeit.weathertestapp.util.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.TextView stationNameTxt;
    private TextView skyTxt;
    private TextView currentTempTxt;
    private TextView maxTempTxt;
    private TextView minTempTxt;
    private TextView windDirTxt;
    private TextView windSpdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();

        ServerUtil.getCurrentWeatherFromServer(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
//                서버에서 응답이 오면 자동으로 실행되는 부분.
//                json이 재료로 날아오는걸 분석해서 화면에 뿌려주기.

                Log.d("실시간날씨JSON", json.toString());

                try {
                    currentTempTxt.setText(String.format(Locale.KOREA, "%.1f ℃", Double.parseDouble(json.getJSONObject("weather").getJSONArray("minutely")
                            .getJSONObject(0).getJSONObject("temperature").getString("tc"))));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.windSpdTxt = (TextView) findViewById(R.id.windSpdTxt);
        this.windDirTxt = (TextView) findViewById(R.id.windDirTxt);
        this.minTempTxt = (TextView) findViewById(R.id.minTempTxt);
        this.maxTempTxt = (TextView) findViewById(R.id.maxTempTxt);
        this.currentTempTxt = (TextView) findViewById(R.id.currentTempTxt);
        this.skyTxt = (TextView) findViewById(R.id.skyTxt);
        this.stationNameTxt = (TextView) findViewById(R.id.stationNameTxt);

    }
}
