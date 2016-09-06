package mon.emotiv.connection;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.emotiv.insight.IEdk;
import com.emotiv.insight.IEdkErrorCode;
import com.emotiv.insight.IEmoStateDLL;
import com.emotiv.insight.MentalCommandDetection;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 9/5/2016.
 */
public class EngineConnector {
    public static Context context;
    public static EngineConnector engineConnectorInstance;
    private Timer timer;
    private TimerTask timerTask;

    public boolean isConnected = false;
    private int state;
    private int userId = -1;

    /* ============================================ */
    protected static final int TYPE_USER_ADD = 16;
    protected static final int TYPE_USER_REMOVE = 32;
    protected static final int TYPE_EMOSTATE_UPDATE = 64;
    protected static final int TYPE_METACOMMAND_EVENT = 256;
    /* ============================================ */
    protected static final int HANDLER_TRAIN_STARTED = 1;
    protected static final int HANDLER_TRAIN_SUCCEED = 2;
    protected static final int HANDLER_TRAIN_FAILED = 3;
    protected static final int HANDLER_TRAIN_COMPLETED = 4;
    protected static final int HANDLER_TRAIN_ERASED = 5;
    protected static final int HANDLER_TRAIN_REJECTED = 6;
    protected static final int HANDLER_ACTION_CURRENT = 7;
    protected static final int HANDLER_USER_ADD = 8;
    protected static final int HANDLER_USER_REMOVE = 9;
    protected static final int HANDLER_TRAINED_RESET = 10;

    public EngineInterface delegate;

    public static void setContext(Context context){
        EngineConnector.context = context;
    }

    public static EngineConnector shareInstance(){
        if (engineConnectorInstance == null){
            engineConnectorInstance = new EngineConnector();
        }
        return  engineConnectorInstance;
    }

    public EngineConnector(){

    }

}
