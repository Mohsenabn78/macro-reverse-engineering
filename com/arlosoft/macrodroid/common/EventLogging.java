package com.arlosoft.macrodroid.common;

import android.content.Context;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class EventLogging {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f9857a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ExecutorService f9858b = Executors.newSingleThreadExecutor();

    public static void clearLogFile(Context context) {
        synchronized (f9857a) {
            File file = new File(context.getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + "macrodroid_event_log_1");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(context.getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + "macrodroid_event_log_2");
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    public static String constructSystemLogOutput(Context context) {
        String str;
        synchronized (f9857a) {
            str = context.getExternalFilesDir(null) + "/MacroDroidLog.txt";
            List<String> allLogLines = getAllLogLines(context);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(str)));
                if (Settings.getReverseSystemLog(context)) {
                    for (int size = allLogLines.size() - 1; size >= 0; size--) {
                        dataOutputStream.write(allLogLines.get(size).getBytes());
                    }
                } else {
                    for (int i4 = 0; i4 < allLogLines.size(); i4++) {
                        dataOutputStream.write(allLogLines.get(i4).getBytes());
                    }
                }
                dataOutputStream.close();
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to output html log file: " + e4.getMessage()));
                return null;
            }
        }
        return str;
    }

    public static List<String> getAllLogLines(Context context) {
        int i4;
        synchronized (f9857a) {
            int currentLogFile = Settings.getCurrentLogFile(context);
            ArrayList arrayList = new ArrayList();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i5 = 2;
                if (currentLogFile == 1) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                sb.append(getLogFile(i4));
                if (new File(sb.toString()).exists()) {
                    if (currentLogFile != 1) {
                        i5 = 1;
                    }
                    DataInputStream dataInputStream = new DataInputStream(context.openFileInput(getLogFile(i5)));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine + "\n");
                    }
                    dataInputStream.close();
                }
                if (!new File(context.getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + getLogFile(currentLogFile)).exists()) {
                    return null;
                }
                DataInputStream dataInputStream2 = new DataInputStream(context.openFileInput(getLogFile(currentLogFile)));
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(dataInputStream2));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2 + "\n");
                    } else {
                        dataInputStream2.close();
                        return arrayList;
                    }
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to output html log file: " + e4.getMessage()));
                return null;
            }
        }
    }

    public static String getCurrentLogFile(Context context) {
        int currentLogFile = Settings.getCurrentLogFile(context);
        return context.getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + getLogFile(currentLogFile);
    }

    public static String getLogFile(int i4) {
        if (i4 == 1) {
            return "macrodroid_event_log_1";
        }
        if (i4 != 2) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Invalid logNumber: " + i4));
            return "macrodroid_event_log_1";
        }
        return "macrodroid_event_log_2";
    }
}
