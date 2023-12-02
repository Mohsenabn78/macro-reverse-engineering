package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.UserManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeartBeatInfoStorage> f31426a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f31427b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f31428c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<HeartBeatConsumer> f31429d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f31430e;

    private DefaultHeartBeatController(final Context context, final String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this(new Provider() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                HeartBeatInfoStorage g4;
                g4 = DefaultHeartBeatController.g(context, str);
                return g4;
            }
        }, set, executor, provider, context);
    }

    @NonNull
    public static Component<DefaultHeartBeatController> component() {
        final Qualified qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.setOf(HeartBeatConsumer.class)).add(Dependency.requiredProvider(UserAgentPublisher.class)).add(Dependency.required(qualified)).factory(new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                DefaultHeartBeatController e4;
                e4 = DefaultHeartBeatController.e(Qualified.this, componentContainer);
                return e4;
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController e(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get(qualified));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String f() throws Exception {
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = this.f31426a.get();
            List<HeartBeatResult> c4 = heartBeatInfoStorage.c();
            heartBeatInfoStorage.b();
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < c4.size(); i4++) {
                HeartBeatResult heartBeatResult = c4.get(i4);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", heartBeatResult.getUserAgent());
                jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", ExifInterface.GPS_MEASUREMENT_2D);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
            try {
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HeartBeatInfoStorage g(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h() throws Exception {
        synchronized (this) {
            this.f31426a.get().k(System.currentTimeMillis(), this.f31428c.get().getUserAgent());
        }
        return null;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.f31426a.get();
        if (heartBeatInfoStorage.i(currentTimeMillis)) {
            heartBeatInfoStorage.g();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task<String> getHeartBeatsHeader() {
        if (!UserManagerCompat.isUserUnlocked(this.f31427b)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.f31430e, new Callable() { // from class: com.google.firebase.heartbeatinfo.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String f4;
                f4 = DefaultHeartBeatController.this.f();
                return f4;
            }
        });
    }

    public Task<Void> registerHeartBeat() {
        if (this.f31429d.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.f31427b)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.f31430e, new Callable() { // from class: com.google.firebase.heartbeatinfo.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void h4;
                h4 = DefaultHeartBeatController.this.h();
                return h4;
            }
        });
    }

    @VisibleForTesting
    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.f31426a = provider;
        this.f31429d = set;
        this.f31430e = executor;
        this.f31428c = provider2;
        this.f31427b = context;
    }
}
