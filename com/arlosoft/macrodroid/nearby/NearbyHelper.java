package com.arlosoft.macrodroid.nearby;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: NearbyHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nNearbyHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearbyHelper.kt\ncom/arlosoft/macrodroid/nearby/NearbyHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,329:1\n1#2:330\n*E\n"})
/* loaded from: classes3.dex */
public final class NearbyHelper {
    @NotNull
    public static final String NAME = "MacroDroid nearby share";
    @NotNull
    public static final String SERVICE_ID_ACTION_BLOCK_SHARE = "com.arlosoft.macrodroid.ACTION_BLOCK_SHARE";
    @NotNull
    public static final String SERVICE_ID_MACRO_SHARE = "com.arlosoft.macrodroid.MACRO_SHARE";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12992a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ActionBlockStore f12993b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private NearbyDevice f12994c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f12995d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private NearbySendListener f12996e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Macro f12997f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private NearbyReceiveListener f12998g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final NearbyHelper$sendPayloadCallback$1 f12999h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final PayloadCallback f13000i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final NearbyHelper$sendConnectionLifecycleCallback$1 f13001j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final NearbyHelper$receiveConnectionLifecycleCallback$1 f13002k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final NearbyHelper$endPointDiscoveryCallback$1 f13003l;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NearbyHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NearbyHelper.kt */
    /* loaded from: classes3.dex */
    public interface NearbyReceiveListener {
        void jsonDataAvailable(@NotNull String str);
    }

    /* compiled from: NearbyHelper.kt */
    /* loaded from: classes3.dex */
    public interface NearbySendListener {
        void fileSent(@NotNull NearbyDevice nearbyDevice);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NearbyHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Void, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13004d = new a();

        a() {
            super(1);
        }

        public final void a(@Nullable Void r22) {
            Timber.d("[NEARBY] - Start discovery success", new Object[0]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.arlosoft.macrodroid.nearby.NearbyHelper$sendPayloadCallback$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.arlosoft.macrodroid.nearby.NearbyHelper$sendConnectionLifecycleCallback$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.arlosoft.macrodroid.nearby.NearbyHelper$receiveConnectionLifecycleCallback$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.arlosoft.macrodroid.nearby.NearbyHelper$endPointDiscoveryCallback$1] */
    @Inject
    public NearbyHelper(@ApplicationContext @NotNull Context context, @NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        this.f12992a = context;
        this.f12993b = actionBlockStore;
        this.f12999h = new PayloadCallback() { // from class: com.arlosoft.macrodroid.nearby.NearbyHelper$sendPayloadCallback$1
            @Override // com.google.android.gms.nearby.connection.PayloadCallback
            public void onPayloadReceived(@NotNull String endPointId, @NotNull Payload payload) {
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(payload, "payload");
                Timber.d("[NEARBY] Payload Received: " + endPointId, new Object[0]);
            }

            @Override // com.google.android.gms.nearby.connection.PayloadCallback
            public void onPayloadTransferUpdate(@NotNull String endPointId, @NotNull PayloadTransferUpdate payloadTransferUpdate) {
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(payloadTransferUpdate, "payloadTransferUpdate");
                long bytesTransferred = payloadTransferUpdate.getBytesTransferred();
                Timber.d("[NEARBY] Payload Transfer: " + endPointId + ", bytes=" + bytesTransferred, new Object[0]);
            }
        };
        this.f13000i = new PayloadCallback() { // from class: com.arlosoft.macrodroid.nearby.NearbyHelper$recivePayloadCallback$1
            @Override // com.google.android.gms.nearby.connection.PayloadCallback
            public void onPayloadReceived(@NotNull String endpointId, @NotNull Payload payload) {
                NearbyHelper.NearbyReceiveListener nearbyReceiveListener;
                Intrinsics.checkNotNullParameter(endpointId, "endpointId");
                Intrinsics.checkNotNullParameter(payload, "payload");
                Timber.d("[NEARBY] Payload Received: %s", payload);
                byte[] asBytes = payload.asBytes();
                NearbyHelper nearbyHelper = NearbyHelper.this;
                Intrinsics.checkNotNull(asBytes);
                String decompressByteArrayToString = nearbyHelper.decompressByteArrayToString(asBytes);
                NearbyHelper.this.disconnect();
                NearbyHelper.this.stopAdvertising();
                nearbyReceiveListener = NearbyHelper.this.f12998g;
                if (nearbyReceiveListener != null) {
                    nearbyReceiveListener.jsonDataAvailable(decompressByteArrayToString);
                }
            }

            @Override // com.google.android.gms.nearby.connection.PayloadCallback
            public void onPayloadTransferUpdate(@NotNull String endpointId, @NotNull PayloadTransferUpdate payloadTransferUpdate) {
                Intrinsics.checkNotNullParameter(endpointId, "endpointId");
                Intrinsics.checkNotNullParameter(payloadTransferUpdate, "payloadTransferUpdate");
                Timber.d("[NEARBY] Payload Transfer update %s, bytes transferred = %d", endpointId, Long.valueOf(payloadTransferUpdate.getBytesTransferred()));
            }
        };
        this.f13001j = new ConnectionLifecycleCallback() { // from class: com.arlosoft.macrodroid.nearby.NearbyHelper$sendConnectionLifecycleCallback$1
            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onConnectionInitiated(@NotNull String endPointId, @NotNull ConnectionInfo connectionInfo) {
                NearbyHelper$sendPayloadCallback$1 nearbyHelper$sendPayloadCallback$1;
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(connectionInfo, "connectionInfo");
                Timber.d("[NEARBY] Connection Initiated: " + endPointId, new Object[0]);
                ConnectionsClient connectionsClient = Nearby.getConnectionsClient(Gradients.INSTANCE.getContext());
                nearbyHelper$sendPayloadCallback$1 = NearbyHelper.this.f12999h;
                connectionsClient.acceptConnection(endPointId, nearbyHelper$sendPayloadCallback$1);
            }

            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onConnectionResult(@NotNull String endPointId, @NotNull ConnectionResolution connectionInfo) {
                Macro macro;
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(connectionInfo, "connectionInfo");
                if (connectionInfo.getStatus().isSuccess()) {
                    NearbyHelper.this.f12995d = endPointId;
                    macro = NearbyHelper.this.f12997f;
                    if (macro != null) {
                        NearbyHelper.this.n(endPointId);
                    }
                }
            }

            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onDisconnected(@NotNull String endPointId) {
                NearbyDevice nearbyDevice;
                String str;
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                NearbyHelper.this.f12995d = null;
                nearbyDevice = NearbyHelper.this.f12994c;
                if (nearbyDevice != null) {
                    str = nearbyDevice.getEndPointId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, endPointId)) {
                    NearbyHelper.this.f12994c = null;
                }
                Timber.d("[NEARBY] Disconnected: " + endPointId, new Object[0]);
            }
        };
        this.f13002k = new ConnectionLifecycleCallback() { // from class: com.arlosoft.macrodroid.nearby.NearbyHelper$receiveConnectionLifecycleCallback$1
            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onConnectionInitiated(@NotNull String endPointId, @NotNull ConnectionInfo connectionInfo) {
                Context context2;
                PayloadCallback payloadCallback;
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(connectionInfo, "connectionInfo");
                Timber.d("[NEARBY] - Connection Initiated: %s", endPointId);
                context2 = NearbyHelper.this.f12992a;
                ConnectionsClient connectionsClient = Nearby.getConnectionsClient(context2);
                payloadCallback = NearbyHelper.this.f13000i;
                connectionsClient.acceptConnection(endPointId, payloadCallback);
            }

            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onConnectionResult(@NotNull String endPointId, @NotNull ConnectionResolution connectionResolution) {
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(connectionResolution, "connectionResolution");
                if (connectionResolution.getStatus().isSuccess()) {
                    Timber.d("[NEARBY] - Connection Result: %s", endPointId);
                    NearbyHelper.this.f12995d = endPointId;
                }
            }

            @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
            public void onDisconnected(@NotNull String endPointId) {
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Timber.d("[NEARBY] - Disconnected: %s", endPointId);
            }
        };
        this.f13003l = new EndpointDiscoveryCallback() { // from class: com.arlosoft.macrodroid.nearby.NearbyHelper$endPointDiscoveryCallback$1
            @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
            public void onEndpointFound(@NotNull String endPointId, @NotNull DiscoveredEndpointInfo endPointInfo) {
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                Intrinsics.checkNotNullParameter(endPointInfo, "endPointInfo");
                NearbyHelper.this.m(endPointId, endPointInfo);
            }

            @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
            public void onEndpointLost(@NotNull String endPointId) {
                NearbyDevice nearbyDevice;
                String str;
                Intrinsics.checkNotNullParameter(endPointId, "endPointId");
                nearbyDevice = NearbyHelper.this.f12994c;
                if (nearbyDevice != null) {
                    str = nearbyDevice.getEndPointId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, endPointId)) {
                    NearbyHelper.this.f12994c = null;
                }
                Timber.d("[NEARBY] Lost device: " + endPointId, new Object[0]);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Void r12) {
        Timber.d("Connect - OnSuccess", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Exception exc) {
        Timber.d("Connect - OnFailure: " + exc, new Object[0]);
    }

    private final String j() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String anonymousUserId = Settings.getAnonymousUserId(this.f12992a);
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2 + " (" + anonymousUserId + ")";
    }

    private final String k() {
        String json = GsonUtils.getMacroGson().toJson(this.f12997f);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(macro)");
        return json;
    }

    private final String l(String str) {
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "(", false, 2, (Object) null)) {
            String substring = str.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, "(", 0, false, 6, (Object) null) - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, DiscoveredEndpointInfo discoveredEndpointInfo) {
        String str2 = this.f12995d;
        if (str2 != null && !Intrinsics.areEqual(str2, str)) {
            disconnect(str2);
            this.f12995d = null;
        }
        String endpointName = discoveredEndpointInfo.getEndpointName();
        Intrinsics.checkNotNullExpressionValue(endpointName, "endPointInfo.endpointName");
        this.f12994c = new NearbyDevice(str, endpointName);
        sendFileNearby();
        String endpointName2 = discoveredEndpointInfo.getEndpointName();
        Timber.d("[NEARBY] Found device: " + str + ", name=" + endpointName2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str) {
        NearbySendListener nearbySendListener;
        Macro macro;
        ActionBlock actionBlockByGuid;
        ArrayList arrayList = new ArrayList();
        Macro macro2 = this.f12997f;
        Intrinsics.checkNotNull(macro2);
        Iterator<Action> it = macro2.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            if ((next instanceof ActionBlockAction) && (actionBlockByGuid = this.f12993b.getActionBlockByGuid(((ActionBlockAction) next).getActionBlockId())) != null) {
                arrayList.add(actionBlockByGuid);
            }
        }
        if (arrayList.size() > 0 && (macro = this.f12997f) != null) {
            macro.initialiseExportedActionBlocks(this.f12993b);
        }
        byte[] compressStringToByteArray = compressStringToByteArray(k());
        if (compressStringToByteArray.length < 1047552) {
            Payload fromBytes = Payload.fromBytes(compressStringToByteArray);
            Intrinsics.checkNotNullExpressionValue(fromBytes, "fromBytes(compressedBytes)");
            final Task<Void> sendPayload = Nearby.getConnectionsClient(Gradients.INSTANCE.getContext()).sendPayload(str, fromBytes);
            Intrinsics.checkNotNullExpressionValue(sendPayload, "getConnectionsClient(Gra…endPointId, bytesPayload)");
            sendPayload.addOnCompleteListener(new OnCompleteListener() { // from class: e0.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    NearbyHelper.o(Task.this, this, task);
                }
            });
        } else {
            ToastCompat.makeText(this.f12992a, (int) R.string.share_nearby_macro_too_large, 1).show();
        }
        NearbyDevice nearbyDevice = this.f12994c;
        if (nearbyDevice != null && (nearbySendListener = this.f12996e) != null) {
            nearbySendListener.fileSent(nearbyDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Task task, NearbyHelper this$0, Task it) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!task.isSuccessful()) {
            ToastCompat.makeText(this$0.f12992a, (int) R.string.share_nearby_transfer_failed, 1).show();
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            Exception exception = task.getException();
            firebaseCrashlytics.log("Failed to share to nearby device: " + exception);
        }
        this$0.stopDiscovery();
        this$0.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Void r12) {
        Timber.d("[NEARBY] - Start advertising success", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Exception exc) {
        Timber.e("[NEARBY] - Start advertising failed: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Exception exc) {
        Timber.d("[NEARBY] - Start discovery failed: " + exc, new Object[0]);
        if (exc instanceof ApiException) {
            int statusCode = ((ApiException) exc).getStatusCode();
            SystemLog.logError("Could not start nearby discovery: " + statusCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void cleanUpHelper() {
        this.f12997f = null;
        this.f12996e = null;
        this.f12998g = null;
    }

    @NotNull
    public final byte[] compressStringToByteArray(@NotNull String string) {
        BufferedWriter bufferedWriter;
        Intrinsics.checkNotNullParameter(string, "string");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(byteArrayOutputStream), Charsets.UTF_8);
        if (outputStreamWriter instanceof BufferedWriter) {
            bufferedWriter = (BufferedWriter) outputStreamWriter;
        } else {
            bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
        }
        try {
            bufferedWriter.write(string);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
            return byteArray;
        } finally {
        }
    }

    public final void connect(@NotNull String endPointId, @NotNull ConnectionLifecycleCallback connectionLifecycleCallback) {
        Intrinsics.checkNotNullParameter(endPointId, "endPointId");
        Intrinsics.checkNotNullParameter(connectionLifecycleCallback, "connectionLifecycleCallback");
        Nearby.getConnectionsClient(this.f12992a).requestConnection(this.f12992a.getString(R.string.menu_share), endPointId, connectionLifecycleCallback).addOnSuccessListener(new OnSuccessListener() { // from class: e0.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                NearbyHelper.h((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: e0.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                NearbyHelper.i(exc);
            }
        });
    }

    @NotNull
    public final String decompressByteArrayToString(@NotNull byte[] byteArray) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        InputStreamReader inputStreamReader = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(byteArray)), Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) inputStreamReader;
        } else {
            bufferedReader = new BufferedReader(inputStreamReader, 8192);
        }
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readText;
        } finally {
        }
    }

    public final void disconnect() {
        String str = this.f12995d;
        if (str != null) {
            disconnect(str);
        }
        this.f12995d = null;
        this.f12994c = null;
    }

    @NotNull
    public final String getAnonymousIdFromDeviceName(@NotNull String deviceName) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        String substring = deviceName.substring(StringsKt.lastIndexOf$default((CharSequence) deviceName, "(", 0, false, 6, (Object) null), deviceName.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final void initialiseHelperForReceiving(@NotNull NearbyReceiveListener nearbyReceiveListener) {
        Intrinsics.checkNotNullParameter(nearbyReceiveListener, "nearbyReceiveListener");
        this.f12998g = nearbyReceiveListener;
    }

    public final void initialiseHelperForSending(@NotNull Macro macro, @NotNull NearbySendListener nearbySendListener) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(nearbySendListener, "nearbySendListener");
        this.f12997f = macro;
        this.f12996e = nearbySendListener;
    }

    public final void sendFile(@NotNull String endPointId, @NotNull File file) {
        Intrinsics.checkNotNullParameter(endPointId, "endPointId");
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            Payload fromFile = Payload.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(file)");
            Nearby.getConnectionsClient(this.f12992a).sendPayload(endPointId, fromFile);
        } catch (FileNotFoundException e4) {
            SystemLog.logError("Could not share file: " + e4);
        }
    }

    public final void sendFileNearby() {
        NearbyDevice nearbyDevice = this.f12994c;
        if (nearbyDevice != null) {
            Context context = this.f12992a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.share_nearby_sharing_to_device_name);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…y_sharing_to_device_name)");
            String format = String.format(string, Arrays.copyOf(new Object[]{l(nearbyDevice.getDeviceName())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ToastCompat.makeText(context, (CharSequence) format, 1).show();
        }
        NearbyDevice nearbyDevice2 = this.f12994c;
        if (nearbyDevice2 != null) {
            if (Intrinsics.areEqual(this.f12995d, nearbyDevice2.getEndPointId())) {
                n(nearbyDevice2.getEndPointId());
                return;
            }
            if (this.f12995d != null) {
                disconnect(nearbyDevice2.getEndPointId());
                this.f12995d = null;
            }
            connect(nearbyDevice2.getEndPointId(), this.f13001j);
        }
    }

    public final void startAdvertising(@NotNull String serviceId) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        AdvertisingOptions build = new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().setStrategy(St…P_POINT_TO_POINT).build()");
        Nearby.getConnectionsClient(this.f12992a).startAdvertising(j(), serviceId, this.f13002k, build).addOnSuccessListener(new OnSuccessListener() { // from class: e0.d
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                NearbyHelper.p((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: e0.e
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                NearbyHelper.q(exc);
            }
        });
    }

    public final void startDiscovery(@NotNull String serviceId) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        DiscoveryOptions build = new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().setStrategy(St…P_POINT_TO_POINT).build()");
        Task<Void> startDiscovery = Nearby.getConnectionsClient(this.f12992a).startDiscovery(serviceId, this.f13003l, build);
        final a aVar = a.f13004d;
        startDiscovery.addOnSuccessListener(new OnSuccessListener() { // from class: e0.f
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                NearbyHelper.s(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: e0.g
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                NearbyHelper.r(exc);
            }
        });
    }

    public final void stopAdvertising() {
        Nearby.getConnectionsClient(this.f12992a).stopAdvertising();
    }

    public final void stopDiscovery() {
        Nearby.getConnectionsClient(this.f12992a).stopDiscovery();
    }

    public final void disconnect(@NotNull String endPointId) {
        Intrinsics.checkNotNullParameter(endPointId, "endPointId");
        Nearby.getConnectionsClient(this.f12992a).disconnectFromEndpoint(endPointId);
    }
}
