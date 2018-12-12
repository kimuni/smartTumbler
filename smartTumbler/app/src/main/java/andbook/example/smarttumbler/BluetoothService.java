package andbook.example.smarttumbler;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.UUID;

//import java.util.logging.Handler;


public class BluetoothService {
    private static final int REQUEST_CONNECT_DEVICE=1;
    private Button btn_Connet;
    private BluetoothService bluetoothService_obj = null;
    private static final int REQUEST_ENABLE_BT =2;
    private static final String TAG = "BluetoothService";
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private BluetoothAdapter btAdapter;
    private Activity mActivity;
    private Handler mHandler;

    public BluetoothService(Activity activity, Handler handler){
        mActivity = activity;
        mHandler =handler;

        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean getDeviceState() {
        Log.d(TAG, "Check the Bluetooth support");

        if (btAdapter == null) {
            Log.d(TAG, "Bluetooth is not available");
            return false;
        } else {
            Log.d(TAG,"Bluetooth is available");
            return true;
        }
    }

    public void enableBluetooth() {
        Log.d(TAG,"Check the enabled Bluetooth");
        if (btAdapter.isEnabled()) {
            Log.d(TAG,"Bluetooth Enable Now");
        } else {
            Log.d(TAG,"Bluetooth Enable Request");
            Intent i= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            mActivity.startActivityForResult(i, REQUEST_ENABLE_BT);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.d(TAG,"onActivityResult" + resultCode);

        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (requestCode != Activity.RESULT_OK) { //취소 눌렀을때
                    Log.d(TAG,"Bluetooth is not enable");
                }
                break;
        }
    }

}

