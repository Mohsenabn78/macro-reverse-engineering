package com.arlosoft.macrodroid.action.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.NonAppActivityWithPreventClash;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.saf.StorageAccessFrameworkHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.DebugKt;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class TakePictureActivity extends NonAppActivityWithPreventClash implements SurfaceHolder.Callback {
    public static final String CAMERA_ID_EXTRA = "CameraId";
    public static final String FILE_PATH = "FilePath";
    public static final String FILE_PATH_URI = "FilePathUri";
    public static final String FLASH_OPTION_EXTRA = "FlashOption";
    public static final String SHOW_ICON_EXTRA = "ShowIcon";

    /* renamed from: e  reason: collision with root package name */
    private SurfaceHolder f2925e;

    /* renamed from: f  reason: collision with root package name */
    private Camera f2926f;

    /* renamed from: g  reason: collision with root package name */
    private Camera.PictureCallback f2927g;

    /* renamed from: h  reason: collision with root package name */
    private int f2928h;

    /* renamed from: i  reason: collision with root package name */
    private int f2929i;

    /* renamed from: j  reason: collision with root package name */
    private String f2930j;

    /* renamed from: k  reason: collision with root package name */
    private String f2931k;

    /* renamed from: l  reason: collision with root package name */
    private String f2932l;

    /* renamed from: m  reason: collision with root package name */
    private String f2933m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2934a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2935b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2936c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2937d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f2938e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f2939f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f2940g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ long f2941h;

        a(Context context, int i4, boolean z3, int i5, String str, String str2, String str3, long j4) {
            this.f2934a = context;
            this.f2935b = i4;
            this.f2936c = z3;
            this.f2937d = i5;
            this.f2938e = str;
            this.f2939f = str2;
            this.f2940g = str3;
            this.f2941h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f2934a, TakePictureActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("CameraId", this.f2935b);
                intent.putExtra("ShowIcon", this.f2936c);
                intent.putExtra("FlashOption", this.f2937d);
                intent.putExtra("FilePathUri", this.f2938e);
                intent.putExtra("FilePath", this.f2939f);
                intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", this.f2940g);
                intent.putExtra(Util.EXTRA_GUID, this.f2941h);
                this.f2934a.startActivity(intent);
            } catch (Exception e4) {
                SystemLog.logError("Failed to take picture: " + e4.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends AsyncTask<byte[], String, String> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(byte[]... bArr) {
            OutputStream outputStream;
            byte[] bArr2;
            String str = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date()) + ".jpg";
            try {
                if (TakePictureActivity.this.f2933m != null) {
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(MacroDroidApplication.getInstance(), Uri.parse(TakePictureActivity.this.f2933m));
                    DocumentFile findFile = fromTreeUri.findFile(str);
                    if (findFile == null) {
                        findFile = fromTreeUri.createFile("application/custom", str);
                    }
                    if (findFile == null) {
                        TakePictureActivity.this.q(str);
                        return null;
                    }
                    outputStream = TakePictureActivity.this.getContentResolver().openOutputStream(findFile.getUri(), "wa");
                    if (outputStream == null) {
                        SystemLog.logError("Taking picture failed: Error writing to picture file", TakePictureActivity.this.f2931k);
                        SystemLog.logError(TakePictureActivity.this.getString(R.string.please_reconfigure_take_picture_action_path), TakePictureActivity.this.f2931k);
                        return TakePictureActivity.this.getString(R.string.error) + " - " + TakePictureActivity.this.getString(R.string.take_picture_action);
                    }
                    findFile.getUri().toString();
                } else if (TakePictureActivity.this.f2932l != null) {
                    SystemLog.logError("No file path found for taking picture, defaulting to MacroDroid/Photos", TakePictureActivity.this.f2931k);
                    TakePictureActivity.this.f2932l = new File(Environment.getExternalStorageDirectory(), "MacroDroid/Photos").getAbsolutePath();
                    File file = new File(TakePictureActivity.this.f2932l);
                    if (!file.exists() && !file.mkdirs()) {
                        SystemLog.logInfo("Take Picture Failed - could not write to external storage");
                        Util.displayNotification(TakePictureActivity.this, "Take Picture Failed", "Could not write to external storage", false);
                        return null;
                    }
                    File file2 = new File(file + RemoteSettings.FORWARD_SLASH_STRING + str);
                    outputStream = new FileOutputStream(file2);
                    file2.getAbsolutePath();
                } else {
                    outputStream = null;
                }
                if (bArr != null && (bArr2 = bArr[0]) != null) {
                    outputStream.write(bArr2);
                    outputStream.close();
                    System.gc();
                    return null;
                }
                SystemLog.logError("TakePictureActivity: Error writing to picture file jpeg was null");
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("TakePictureActivity: Error writing to picture file jpeg was null"));
                return TakePictureActivity.this.getString(R.string.error) + " - " + TakePictureActivity.this.getString(R.string.take_picture_action);
            } catch (Exception e4) {
                if (e4 instanceof FileNotFoundException) {
                    TakePictureActivity takePictureActivity = TakePictureActivity.this;
                    takePictureActivity.q(takePictureActivity.f2932l);
                }
                SystemLog.logError("Taking picture failed: Error writing to picture file: " + e4.getMessage(), TakePictureActivity.this.f2931k);
                SystemLog.logError(TakePictureActivity.this.getString(R.string.please_reconfigure_take_picture_action_path), TakePictureActivity.this.f2931k);
                return TakePictureActivity.this.getString(R.string.error) + " - " + TakePictureActivity.this.getString(R.string.take_picture_action);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (str != null) {
                ToastCompat.makeText((Context) MacroDroidApplication.getInstance(), (CharSequence) str, 1).show();
            }
        }

        /* synthetic */ b(TakePictureActivity takePictureActivity, a aVar) {
            this();
        }
    }

    @JvmStatic
    public static void invoke(Context context, int i4, boolean z3, int i5, String str, String str2, String str3, long j4) {
        new Handler().postDelayed(new a(context, i4, z3, i5, str, str2, str3, j4), NonAppActivityWithPreventClash.getDelayUntilNextDisplay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Camera.CameraInfo cameraInfo, byte[] bArr, Camera camera) {
        new b(this, null).execute(bArr);
        if (cameraInfo.canDisableShutterSound) {
            this.f2926f.enableShutterSound(true);
        }
        SystemLog.logInfo("Picture Taken");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            Camera camera = this.f2926f;
            if (camera != null) {
                camera.takePicture(null, null, this.f2927g);
            }
        } catch (Exception e4) {
            SystemLog.logInfo("Take Picture Failed - failed in surfaceCreated:" + e4.getMessage());
            Util.displayNotification(this, "Take picture failed", "Failed to connect to camera", false);
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            try {
                this.f2926f.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.f2926f.release();
            } catch (Exception unused2) {
            }
            this.f2926f = null;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        SystemLog.logError("Error - could not write to file: " + str + ". Need to re-select path and grant access.", this.f2931k);
        StorageAccessFrameworkHelper.requiresAccessGranted(this, getString(R.string.please_reconfigure_take_picture_action_path), this.f2930j);
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.take_picture_layout);
        Window window = getWindow();
        window.addFlags(4194304);
        window.addFlags(524288);
        window.addFlags(2097152);
        if (getIntent() != null) {
            this.f2932l = getIntent().getStringExtra("FilePath");
            this.f2928h = getIntent().getIntExtra("CameraId", 0);
            boolean booleanExtra = getIntent().getBooleanExtra("ShowIcon", true);
            this.f2929i = getIntent().getIntExtra("FlashOption", 0);
            this.f2933m = getIntent().getStringExtra("FilePathUri");
            this.f2930j = getIntent().getStringExtra("com.arlosoft.macrodroid.MACRO_NAME");
            this.f2931k = getIntent().getStringExtra(Util.EXTRA_GUID);
            if (!booleanExtra) {
                ((ImageView) findViewById(R.id.take_picture_icon)).setVisibility(8);
            }
        } else {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("TakePictureActivity: the intent was null"));
            this.f2933m = null;
            this.f2928h = 0;
            this.f2929i = 0;
        }
        SurfaceView surfaceView = new SurfaceView(getApplicationContext());
        addContentView(surfaceView, new ViewGroup.LayoutParams(1, 1));
        if (this.f2925e == null) {
            this.f2925e = surfaceView.getHolder();
        }
        this.f2925e.addCallback(this);
        SystemLog.logInfo("Taking picture");
        this.f2925e.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    @SuppressLint({"NewApi"})
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        int i7;
        int i8;
        Camera camera = this.f2926f;
        if (camera == null) {
            SystemLog.logError("Take picture failed surfaceChanged mCamera is null");
            finish();
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            final Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f2928h, cameraInfo);
            if (cameraInfo.canDisableShutterSound) {
                this.f2926f.enableShutterSound(false);
            }
            Camera.Size pictureResolution = Settings.getPictureResolution(this, this.f2926f, cameraInfo);
            int i9 = this.f2929i;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2) {
                        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    }
                } else {
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                }
            } else {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            parameters.setPictureFormat(256);
            int i10 = getResources().getConfiguration().orientation;
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation != 3) {
                        i7 = 0;
                    } else {
                        i7 = 90;
                    }
                } else {
                    i7 = 180;
                }
            } else {
                i7 = 270;
            }
            int i11 = ((i7 + 45) / 90) * 90;
            if (cameraInfo.facing == 1) {
                i8 = ((cameraInfo.orientation - i11) + 360) % 360;
            } else {
                i8 = (cameraInfo.orientation + i11) % 360;
            }
            parameters.setRotation(i8);
            parameters.setPictureSize(pictureResolution.width, pictureResolution.height);
            this.f2927g = new Camera.PictureCallback() { // from class: com.arlosoft.macrodroid.action.activities.f0
                @Override // android.hardware.Camera.PictureCallback
                public final void onPictureTaken(byte[] bArr, Camera camera2) {
                    TakePictureActivity.this.o(cameraInfo, bArr, camera2);
                }
            };
            try {
                this.f2926f.setParameters(parameters);
                this.f2926f.startPreview();
                new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TakePictureActivity.this.p();
                    }
                }, 1000L);
            } catch (Exception e4) {
                Util.displayNotification(this, "Take Picture Failed", "Could not take picture at this time", false);
                SystemLog.logError("Take Picture Failed: " + e4.getMessage() + ". Try setting an explicit resolution via MacroDroid Settings -> action options -> Take Picture Action");
                finish();
                if (e4 instanceof FileNotFoundException) {
                    q(this.f2932l);
                }
            }
        } catch (Exception unused) {
            SystemLog.logError("Take picture failed surfaceChanged camera parameters are empty");
            finish();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            Camera open = Camera.open(this.f2928h);
            this.f2926f = open;
            open.setPreviewDisplay(surfaceHolder);
        } catch (Exception e4) {
            if (e4 instanceof FileNotFoundException) {
                q(this.f2932l);
            }
            SystemLog.logInfo("Take Picture Failed - failed in surfaceCreated: " + e4.getMessage());
            Util.displayNotification(this, "Take picture failed", "Failed to connect to camera", false);
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            try {
                this.f2926f.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.f2926f.release();
            } catch (Exception unused2) {
            }
            this.f2926f = null;
            finish();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Camera camera = this.f2926f;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.f2926f.release();
            } catch (Exception unused2) {
            }
            this.f2926f = null;
        }
        finish();
    }
}
