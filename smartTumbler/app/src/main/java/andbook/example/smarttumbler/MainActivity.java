package andbook.example.smarttumbler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="MAIN";

    private static final int REQUEST_CONNECT_DEVICE=1;
    private static final int REQUEST_EVABLE_BT =2;
    private Button btn_Connet;
    private BluetoothService bluetoothService_obj = null;

    private static int ONE_MINUTE = 5626;

    TimePicker timePicker;
    //Button btn_start;
    TextView textView;
    Calendar calendar;

    Button check;
    TextView tv;
    EditText editText;

    private final Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        check = (Button)findViewById(R.id.check);



        calendar = Calendar.getInstance();
        int hourofDay = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        textView = (TextView) findViewById(R.id.show);
        timePicker = (TimePicker)findViewById(R.id.time_picker);


        //btn_start=(Button)findViewById(R.id.btn_start);
        //textView=(TextView)findViewById(R.id.show);
        //timePicker=(TimePicker)findViewById(R.id.time_picker);
        //btn_start.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View v) {
        //String hour = timePicker.getCurrentHour().toString();
        //String minute = timePicker.getCurrentMinute().toString();
        //String time = hour + " : " + minute + "알람설정완료!";
        //textView.setText(time);
        //}
        //});

        //txtView = (TextView) findViewById(R.id.txtView);
        //txtView.setVisibility(View.VISIBLE);

        //btn_Connet = (Button) findViewById(R.id.bluetooth_connect);
        //btn_Connet.setOnClickListener(mClickListener);


        //BluetoothService 클래스 생성
        if (bluetoothService_obj ==null) {
            bluetoothService_obj = new BluetoothService(this, mHandler);
        }

    }

    public void onCLICK(View v) {
        editText = (EditText)findViewById(R.id.editText);
        String str = editText.getText().toString();
        int result=Integer.parseInt(str);
        result=200-result;
        tv=(TextView)findViewById(R.id.tv);
        tv.setText(String.valueOf(result));
    }

    public void start(View v) {
        //textView.setText(hourofDay +" : " + minute + "알람설정완료!");
        Toast.makeText(this,"알람설정완료!",Toast.LENGTH_LONG).show();
    }

    public void mOnClick(View v) {
        setContentView(R.layout.menu);

        StringBuilder time = new StringBuilder();

        Calendar cal = new GregorianCalendar();
        time.append(String.format("%d년 %d월 %d일 %d시 %d분\n",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)));

        TextView dayTime = (TextView) findViewById(R.id.dayTime);
        dayTime.setText(time);
    }

    /*public void mOnClick2 (View v) {
        Toast.makeText(this,"연결 상태입니다.",Toast.LENGTH_LONG).show();
    }*/

    public void mOnClick3 (View v) {
        //txtView.setVisibility(View.VISIBLE);
    }

    public void mOnClick4 (View v) {
        setContentView(R.layout.alarm);
    }

    public void back (View v) {
        setContentView(R.layout.menu);
    }


}