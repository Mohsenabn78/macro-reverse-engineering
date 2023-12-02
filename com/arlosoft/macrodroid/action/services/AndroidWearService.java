package com.arlosoft.macrodroid.action.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.utils.AndroidWearConstants;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AndroidWearService extends IntentService {
    public AndroidWearService() {
        super("AndroidWearService");
    }

    private GoogleApiClient a() {
        GoogleApiClient build;
        try {
            build = new GoogleApiClient.Builder(getApplicationContext()).addApi(Wearable.API).build();
        } catch (Throwable unused) {
        }
        if (build.blockingConnect(30L, TimeUnit.SECONDS).isSuccess()) {
            return build;
        }
        Log.e("AndroidWearService", "Failed to connect to GoogleApiClient.");
        return null;
    }

    private String b(GoogleApiClient googleApiClient) {
        NodeApi.GetConnectedNodesResult await = Wearable.NodeApi.getConnectedNodes(googleApiClient).await();
        if (await.getNodes().size() > 0) {
            return await.getNodes().iterator().next().getId();
        }
        return null;
    }

    private void c(int i4) {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            String b4 = b(a4);
            if (b4 != null) {
                MessageApi messageApi = Wearable.MessageApi;
                StringBuilder sb = new StringBuilder();
                sb.append("SENT: Message sending result = ");
                sb.append(messageApi.sendMessage(a4, b4, "/macrodroid/request-set-brightness/" + i4, null).await().getStatus());
            }
            a4.disconnect();
        }
    }

    private void d(String str) {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            String b4 = b(a4);
            if (b4 != null) {
                MessageApi messageApi = Wearable.MessageApi;
                StringBuilder sb = new StringBuilder();
                sb.append("SENT: Message sending result = ");
                sb.append(messageApi.sendMessage(a4, b4, "/macrodroid/request-open-app/" + str, null).await().getStatus());
            }
            a4.disconnect();
        }
    }

    private void e(int i4) {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            String b4 = b(a4);
            if (b4 != null) {
                MessageApi messageApi = Wearable.MessageApi;
                StringBuilder sb = new StringBuilder();
                sb.append("SENT: Message sending result = ");
                sb.append(messageApi.sendMessage(a4, b4, "/macrodroid/request-set-wifi/" + i4, null).await().getStatus());
            }
            a4.disconnect();
        }
    }

    private void f(String[] strArr, String[] strArr2, long[] jArr, boolean z3) {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            try {
                PutDataMapRequest create = PutDataMapRequest.create(AndroidWearConstants.TRANSFER_MACRO_LIST);
                create.getDataMap().putStringArray(AndroidWearConstants.KEY_MACRO_NAMES, strArr);
                create.getDataMap().putStringArray(AndroidWearConstants.KEY_MACRO_RESOURCE_NAMES, strArr2);
                create.getDataMap().putLongArray(AndroidWearConstants.KEY_ICON_COLORS, jArr);
                create.getDataMap().putBoolean(AndroidWearConstants.KEY_FORCE_UPDATE, z3);
                Wearable.DataApi.putDataItem(a4, create.asPutDataRequest());
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            a4.disconnect();
        }
    }

    private void g(int i4) {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            String b4 = b(a4);
            if (b4 != null) {
                MessageApi messageApi = Wearable.MessageApi;
                StringBuilder sb = new StringBuilder();
                sb.append("SENT: Message sending result = ");
                sb.append(messageApi.sendMessage(a4, b4, "/macrodroid/request-vibrate/" + i4, null).await().getStatus());
            }
            a4.disconnect();
        }
    }

    private void h() {
        GoogleApiClient a4 = a();
        if (a4 != null) {
            String b4 = b(a4);
            if (b4 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SENT: Message sending result = ");
                sb.append(Wearable.MessageApi.sendMessage(a4, b4, AndroidWearConstants.REQUEST_WAKE_SCREEN, null).await().getStatus());
            }
            a4.disconnect();
        }
    }

    public static void requestOpenApp(Context context, String str) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("OpenApp");
        intent.putExtra("OpenAppPackage", str);
        context.startService(intent);
    }

    public static void requestSetBrightness(Context context, int i4) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("SetBrightness");
        intent.putExtra(ExifInterface.TAG_BRIGHTNESS_VALUE, i4);
        context.startService(intent);
    }

    public static void requestSetWifi(Context context, int i4) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("SetWifi");
        intent.putExtra("WifiOption", i4);
        context.startService(intent);
    }

    public static void requestSyncMacros(Context context, String[] strArr, String[] strArr2, long[] jArr, boolean z3) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("SyncMacros");
        intent.putExtra("MacroNameList", strArr);
        intent.putExtra("MacroResourceNameList", strArr2);
        intent.putExtra("IconColorList", jArr);
        intent.putExtra("ForceUpdate", z3);
        context.startService(intent);
    }

    public static void requestVibrate(Context context, int i4) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("Vibrate");
        intent.putExtra("VibratePattern", i4);
        context.startService(intent);
    }

    public static void requestWakeScreen(Context context) {
        Intent intent = new Intent(context, AndroidWearService.class);
        intent.setAction("WakeScreen");
        context.startService(intent);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        char c4;
        if (intent != null) {
            try {
                String action = intent.getAction();
                switch (action.hashCode()) {
                    case -645237129:
                        if (action.equals("SetWifi")) {
                            c4 = 5;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case -388161342:
                        if (action.equals("SyncMacros")) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 270618448:
                        if (action.equals("WakeScreen")) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 401430359:
                        if (action.equals("OpenApp")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1923506739:
                        if (action.equals("SetBrightness")) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 2115964239:
                        if (action.equals("Vibrate")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                if (c4 != 0) {
                    if (c4 != 1) {
                        if (c4 != 2) {
                            if (c4 != 3) {
                                if (c4 != 4) {
                                    if (c4 == 5) {
                                        e(intent.getIntExtra("WifiOption", 0));
                                    }
                                } else {
                                    f(intent.getStringArrayExtra("MacroNameList"), intent.getStringArrayExtra("MacroResourceNameList"), intent.getLongArrayExtra("IconColorList"), intent.getBooleanExtra("ForceUpdate", false));
                                }
                            } else {
                                h();
                            }
                        } else {
                            c(intent.getIntExtra(ExifInterface.TAG_BRIGHTNESS_VALUE, 0));
                        }
                    } else {
                        g(intent.getIntExtra("VibratePattern", 0));
                    }
                } else {
                    d(intent.getStringExtra("OpenAppPackage"));
                }
            } catch (IllegalStateException unused) {
            }
        }
        stopSelf();
    }
}
