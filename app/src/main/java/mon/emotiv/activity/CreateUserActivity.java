package mon.emotiv.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mon.emotiv.R;
import mon.emotiv.dataget.EngineConnector;

/**
 * Created by admin on 9/6/2016.
 */
public class CreateUserActivity extends Activity {
    EditText etUserName;
    protected static final int REQUEST_COARSE_LOCATION_PERMISSIONS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        EngineConnector.setContext(this);
        etUserName=(EditText)findViewById(R.id.etUserName);
    }

    public void onclickCreate(View v)
    {
        doDiscovery();
    }

    public void continueDoDiscovery(){
        Intent intent=new Intent(this,ActivityTrainning.class);
        startActivity(intent);
    }

    public void doDiscovery() {
        int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (hasPermission == PackageManager.PERMISSION_GRANTED) {
            continueDoDiscovery();
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{
                        android.Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_COARSE_LOCATION_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_COARSE_LOCATION_PERMISSIONS: {
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    continueDoDiscovery();
                } else {
                    Toast.makeText(this,"Need to grant permission",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
