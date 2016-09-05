package mon.emotiv.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.emotiv.insight.IEmoStateDLL;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import mon.emotiv.R;
import mon.emotiv.connection.EngineConnector;
import mon.emotiv.connection.EngineInterface;
import mon.emotiv.spinner.SpinnerAdapter;
import mon.emotiv.spinner.SpinnerModel;

/**
 * Created by admin on 9/5/2016.
 */
public class ActivityTrainning extends Activity implements EngineInterface {
    EngineConnector engineConnector;
    Spinner spinAction;
    Button btnTrain,btnClear;
    ProgressBar progressBarTime,progressPower;
    SpinnerAdapter spinAdapter;
    ImageView imgBox;
    ArrayList<SpinnerModel> model = new ArrayList<SpinnerModel>();

    Timer timer;
    TimerTask timerTask;

    boolean isTrainning = false;

    int indexAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainning);
        engineConnector = EngineConnector.shareInstance();
        engineConnector.delegate = this;
    }

    public void init(){
        spinAction = (Spinner) findViewById(R.id.spinnerAction);
        btnTrain = (Button) findViewById(R.id.btstartTraing);
        btnClear = (Button) findViewById(R.id.btClearData);
        progressBarTime = (ProgressBar) findViewById(R.id.progressBarTime);
        progressPower = (ProgressBar) findViewById(R.id.ProgressBarpower);
        imgBox = (ImageView) findViewById(R.id.imgBox);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: set something
            }
        });

        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: set something
            }
        });

        setDataSpinner();

        spinAction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                indexAction = position;
            }
        });
    }

    public void setDataSpinner() {
        model.clear();
        SpinnerModel data = new SpinnerModel();
        data.setTvName("Neutral");
        data.setChecked(engineConnector.checkTrained(IEmoStateDLL.IEE_MentalCommandAction_t.MC_NEUTRAL.ToInt()));
        model.add(data);

        data = new SpinnerModel();
        data.setTvName("Push");
        data.setChecked(engineConnector.checkTrained(IEmoStateDLL.IEE_MentalCommandAction_t.MC_PUSH.ToInt()));
        model.add(data);

        data = new SpinnerModel();
        data.setTvName("Pull");
        data.setChecked(engineConnector.checkTrained(IEmoStateDLL.IEE_MentalCommandAction_t.MC_PULL.ToInt()));
        model.add(data);

        data = new SpinnerModel();
        data.setTvName("Left");
        data.setChecked(engineConnector.checkTrained(IEmoStateDLL.IEE_MentalCommandAction_t.MC_LEFT.ToInt()));
        model.add(data);


        data = new SpinnerModel();
        data.setTvName("Right");
        data.setChecked(engineConnector.checkTrained(IEmoStateDLL.IEE_MentalCommandAction_t.MC_RIGHT.ToInt()));
        model.add(data);

        spinAdapter = new SpinnerAdapter(this, R.layout.row, model);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAction.setAdapter(spinAdapter);
    }

    @Override
    public void trainStarted() {

    }

    @Override
    public void trainSucceed() {

    }

    @Override
    public void trainFailed() {

    }

    @Override
    public void trainCompleted() {

    }

    @Override
    public void trainRejected() {

    }

    @Override
    public void trainErased() {

    }

    @Override
    public void trainReset() {

    }

    @Override
    public void userAdd(int userId) {

    }

    @Override
    public void userRemoved() {

    }

    @Override
    public void detectedActionLowerFace(int typeAction, float power) {

    }

    @Override
    public void currentAction(int typeAction, float power) {

    }

}
