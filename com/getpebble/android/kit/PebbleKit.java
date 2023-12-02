package com.getpebble.android.kit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.getpebble.android.kit.Constants;
import com.getpebble.android.kit.util.PebbleDictionary;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class PebbleKit {

    /* loaded from: classes3.dex */
    public static class FirmwareVersionInfo {

        /* renamed from: a  reason: collision with root package name */
        private final int f18331a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18332b;

        /* renamed from: c  reason: collision with root package name */
        private final int f18333c;

        /* renamed from: d  reason: collision with root package name */
        private final String f18334d;

        FirmwareVersionInfo(int i4, int i5, int i6, String str) {
            this.f18331a = i4;
            this.f18332b = i5;
            this.f18333c = i6;
            this.f18334d = str;
        }

        public final int getMajor() {
            return this.f18331a;
        }

        public final int getMinor() {
            return this.f18332b;
        }

        public final int getPoint() {
            return this.f18333c;
        }

        public final String getTag() {
            return this.f18334d;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class PebbleAckReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            receiveAck(context, intent.getIntExtra("transaction_id", -1));
        }

        public abstract void receiveAck(Context context, int i4);
    }

    /* loaded from: classes3.dex */
    public static abstract class PebbleDataLogReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f18335a;

        /* renamed from: b  reason: collision with root package name */
        private int f18336b;

        private void a(Context context, Intent intent, UUID uuid, Long l4, Long l5) {
            onFinishSession(context, uuid, l4, l5);
        }

        private void b(Context context, Intent intent, UUID uuid, Long l4, Long l5) {
            int intExtra = intent.getIntExtra(Constants.PBL_DATA_ID, -1);
            if (intExtra >= 0) {
                Log.i("pebble", "DataID: " + intExtra + " LastDataID: " + this.f18336b);
                if (intExtra == this.f18336b) {
                    return;
                }
                Constants.PebbleDataType fromByte = Constants.PebbleDataType.fromByte(intent.getByteExtra(Constants.PBL_DATA_TYPE, Constants.PebbleDataType.INVALID.ord));
                if (fromByte != null) {
                    int i4 = a.f18338a[fromByte.ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3) {
                                Integer num = (Integer) intent.getSerializableExtra(Constants.PBL_DATA_OBJECT);
                                if (num != null) {
                                    receiveData(context, uuid, l4, l5, num.intValue());
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid type:" + fromByte.toString());
                            }
                        } else {
                            Long l6 = (Long) intent.getSerializableExtra(Constants.PBL_DATA_OBJECT);
                            if (l6 != null) {
                                receiveData(context, uuid, l4, l5, l6);
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                    } else {
                        byte[] decode = Base64.decode(intent.getStringExtra(Constants.PBL_DATA_OBJECT), 2);
                        if (decode != null) {
                            receiveData(context, uuid, l4, l5, decode);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                    this.f18336b = intExtra;
                    Intent intent2 = new Intent(Constants.INTENT_DL_ACK_DATA);
                    intent2.putExtra(Constants.DATA_LOG_UUID, uuid);
                    intent2.putExtra(Constants.PBL_DATA_ID, intExtra);
                    context.sendBroadcast(intent2);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!this.f18335a.equals((UUID) intent.getSerializableExtra(Constants.APP_UUID))) {
                return;
            }
            try {
                UUID uuid = (UUID) intent.getSerializableExtra(Constants.DATA_LOG_UUID);
                if (uuid != null) {
                    Long l4 = (Long) intent.getSerializableExtra(Constants.DATA_LOG_TIMESTAMP);
                    if (l4 != null) {
                        Long l5 = (Long) intent.getSerializableExtra(Constants.DATA_LOG_TAG);
                        if (l5 != null) {
                            if (intent.getAction() == Constants.INTENT_DL_RECEIVE_DATA) {
                                b(context, intent, uuid, l4, l5);
                                return;
                            } else if (intent.getAction() == Constants.INTENT_DL_FINISH_SESSION) {
                                a(context, intent, uuid, l4, l5);
                                return;
                            } else {
                                return;
                            }
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            }
        }

        public void receiveData(Context context, UUID uuid, Long l4, Long l5, Long l6) {
            throw new UnsupportedOperationException("UnsignedInteger handler not implemented");
        }

        public void receiveData(Context context, UUID uuid, Long l4, Long l5, byte[] bArr) {
            throw new UnsupportedOperationException("Byte array handler not implemented");
        }

        public void receiveData(Context context, UUID uuid, Long l4, Long l5, int i4) {
            throw new UnsupportedOperationException("int handler not implemented");
        }

        public void onFinishSession(Context context, UUID uuid, Long l4, Long l5) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class PebbleDataReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f18337a;

        /* JADX INFO: Access modifiers changed from: protected */
        public PebbleDataReceiver(UUID uuid) {
            this.f18337a = uuid;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!this.f18337a.equals((UUID) intent.getSerializableExtra(Constants.APP_UUID))) {
                return;
            }
            int intExtra = intent.getIntExtra("transaction_id", -1);
            String stringExtra = intent.getStringExtra(Constants.MSG_DATA);
            if (stringExtra != null && !stringExtra.isEmpty()) {
                try {
                    receiveData(context, intExtra, PebbleDictionary.fromJson(stringExtra));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }

        public abstract void receiveData(Context context, int i4, PebbleDictionary pebbleDictionary);
    }

    /* loaded from: classes3.dex */
    public static abstract class PebbleNackReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            receiveNack(context, intent.getIntExtra("transaction_id", -1));
        }

        public abstract void receiveNack(Context context, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18338a;

        static {
            int[] iArr = new int[Constants.PebbleDataType.values().length];
            f18338a = iArr;
            try {
                iArr[Constants.PebbleDataType.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18338a[Constants.PebbleDataType.UINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18338a[Constants.PebbleDataType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private PebbleKit() {
    }

    private static Cursor a(Context context) {
        Cursor query = context.getContentResolver().query(Constants.f18328b, null, null, null, null);
        if (query != null) {
            if (query.moveToFirst() && query.getInt(0) == 1) {
                query.moveToPrevious();
                return query;
            }
            query.close();
        }
        return context.getContentResolver().query(Constants.f18327a, null, null, null, null);
    }

    public static boolean areAppMessagesSupported(Context context) {
        Cursor cursor;
        try {
            cursor = a(context);
            boolean z3 = false;
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        if (cursor.getInt(1) == 1) {
                            z3 = true;
                        }
                        cursor.close();
                        return z3;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static BroadcastReceiver b(Context context, String str, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return null;
        }
        context.registerReceiver(broadcastReceiver, new IntentFilter(str));
        return broadcastReceiver;
    }

    public static void closeAppOnPebble(Context context, UUID uuid) throws IllegalArgumentException {
        if (uuid != null) {
            Intent intent = new Intent(Constants.INTENT_APP_STOP);
            intent.putExtra(Constants.APP_UUID, uuid);
            context.sendBroadcast(intent);
            return;
        }
        throw new IllegalArgumentException("uuid cannot be null");
    }

    public static void customizeWatchApp(Context context, Constants.PebbleAppType pebbleAppType, String str, Bitmap bitmap) throws IllegalArgumentException {
        if (pebbleAppType != null) {
            if (str.length() <= 32) {
                if (bitmap.getHeight() <= 32 && bitmap.getWidth() <= 32) {
                    Intent intent = new Intent(Constants.INTENT_APP_CUSTOMIZE);
                    intent.putExtra(Constants.CUST_APP_TYPE, pebbleAppType.ord);
                    intent.putExtra("name", str);
                    intent.putExtra(Constants.CUST_ICON, bitmap);
                    context.sendBroadcast(intent);
                    return;
                }
                throw new IllegalArgumentException(String.format("app icon exceeds maximum dimensions (32px x 32px); got (%dpx x %dpx)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
            }
            throw new IllegalArgumentException(String.format("app name exceeds maximum length (%d)", 32));
        }
        throw new IllegalArgumentException("app type cannot be null");
    }

    public static FirmwareVersionInfo getWatchFWVersion(Context context) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = a(context);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        FirmwareVersionInfo firmwareVersionInfo = new FirmwareVersionInfo(cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getString(6));
                        cursor.close();
                        return firmwareVersionInfo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static boolean isDataLoggingSupported(Context context) {
        Cursor cursor;
        try {
            cursor = a(context);
            boolean z3 = false;
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        if (cursor.getInt(2) == 1) {
                            z3 = true;
                        }
                        cursor.close();
                        return z3;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static boolean isWatchConnected(Context context) {
        Cursor cursor;
        try {
            cursor = a(context);
            boolean z3 = false;
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        if (cursor.getInt(0) == 1) {
                            z3 = true;
                        }
                        cursor.close();
                        return z3;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static BroadcastReceiver registerDataLogReceiver(Context context, PebbleDataLogReceiver pebbleDataLogReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.INTENT_DL_RECEIVE_DATA);
        intentFilter.addAction(Constants.INTENT_DL_FINISH_SESSION);
        context.registerReceiver(pebbleDataLogReceiver, intentFilter);
        return pebbleDataLogReceiver;
    }

    public static BroadcastReceiver registerPebbleConnectedReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        return b(context, Constants.INTENT_PEBBLE_CONNECTED, broadcastReceiver);
    }

    public static BroadcastReceiver registerPebbleDisconnectedReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        return b(context, Constants.INTENT_PEBBLE_DISCONNECTED, broadcastReceiver);
    }

    public static BroadcastReceiver registerReceivedAckHandler(Context context, PebbleAckReceiver pebbleAckReceiver) {
        return b(context, Constants.INTENT_APP_RECEIVE_ACK, pebbleAckReceiver);
    }

    public static BroadcastReceiver registerReceivedDataHandler(Context context, PebbleDataReceiver pebbleDataReceiver) {
        return b(context, Constants.INTENT_APP_RECEIVE, pebbleDataReceiver);
    }

    public static BroadcastReceiver registerReceivedNackHandler(Context context, PebbleNackReceiver pebbleNackReceiver) {
        return b(context, Constants.INTENT_APP_RECEIVE_NACK, pebbleNackReceiver);
    }

    public static void requestDataLogsForApp(Context context, UUID uuid) {
        Intent intent = new Intent(Constants.INTENT_DL_REQUEST_DATA);
        intent.putExtra(Constants.APP_UUID, uuid);
        context.sendBroadcast(intent);
    }

    public static void sendAckToPebble(Context context, int i4) throws IllegalArgumentException {
        if ((i4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            Intent intent = new Intent(Constants.INTENT_APP_ACK);
            intent.putExtra("transaction_id", i4);
            context.sendBroadcast(intent);
            return;
        }
        throw new IllegalArgumentException(String.format("transaction id must be between (0, 255); got '%d'", Integer.valueOf(i4)));
    }

    public static void sendDataToPebble(Context context, UUID uuid, PebbleDictionary pebbleDictionary) throws IllegalArgumentException {
        sendDataToPebbleWithTransactionId(context, uuid, pebbleDictionary, -1);
    }

    public static void sendDataToPebbleWithTransactionId(Context context, UUID uuid, PebbleDictionary pebbleDictionary, int i4) throws IllegalArgumentException {
        if (uuid != null) {
            if (pebbleDictionary != null) {
                if (pebbleDictionary.size() == 0) {
                    return;
                }
                Intent intent = new Intent(Constants.INTENT_APP_SEND);
                intent.putExtra(Constants.APP_UUID, uuid);
                intent.putExtra("transaction_id", i4);
                intent.putExtra(Constants.MSG_DATA, pebbleDictionary.toJsonString());
                context.sendBroadcast(intent);
                return;
            }
            throw new IllegalArgumentException("data cannot be null");
        }
        throw new IllegalArgumentException("uuid cannot be null");
    }

    public static void sendNackToPebble(Context context, int i4) throws IllegalArgumentException {
        if ((i4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            Intent intent = new Intent(Constants.INTENT_APP_NACK);
            intent.putExtra("transaction_id", i4);
            context.sendBroadcast(intent);
            return;
        }
        throw new IllegalArgumentException(String.format("transaction id must be between (0, 255); got '%d'", Integer.valueOf(i4)));
    }

    public static void startAppOnPebble(Context context, UUID uuid) throws IllegalArgumentException {
        if (uuid != null) {
            Intent intent = new Intent(Constants.INTENT_APP_START);
            intent.putExtra(Constants.APP_UUID, uuid);
            context.sendBroadcast(intent);
            return;
        }
        throw new IllegalArgumentException("uuid cannot be null");
    }
}
