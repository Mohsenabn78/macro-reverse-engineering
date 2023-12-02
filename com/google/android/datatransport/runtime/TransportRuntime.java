package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class TransportRuntime implements TransportInternal {

    /* renamed from: e  reason: collision with root package name */
    private static volatile TransportRuntimeComponent f18686e;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f18687a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f18688b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f18689c;

    /* renamed from: d  reason: collision with root package name */
    private final Uploader f18690d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public TransportRuntime(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f18687a = clock;
        this.f18688b = clock2;
        this.f18689c = scheduler;
        this.f18690d = uploader;
        workInitializer.ensureContextsScheduled();
    }

    private EventInternal a(SendRequest sendRequest) {
        return EventInternal.builder().setEventMillis(this.f18687a.getTime()).setUptimeMillis(this.f18688b.getTime()).setTransportName(sendRequest.g()).setEncodedPayload(new EncodedPayload(sendRequest.b(), sendRequest.d())).setCode(sendRequest.c().getCode()).build();
    }

    private static Set<Encoding> b(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).getSupportedEncodings());
        }
        return Collections.singleton(Encoding.of("proto"));
    }

    public static TransportRuntime getInstance() {
        TransportRuntimeComponent transportRuntimeComponent = f18686e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (f18686e == null) {
            synchronized (TransportRuntime.class) {
                if (f18686e == null) {
                    f18686e = DaggerTransportRuntimeComponent.d().setApplicationContext(context).build();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Uploader getUploader() {
        return this.f18690d;
    }

    @Deprecated
    public TransportFactory newFactory(String str) {
        return new TransportFactoryImpl(b(null), TransportContext.builder().setBackendName(str).build(), this);
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    public void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f18689c.schedule(sendRequest.f().withPriority(sendRequest.c().getPriority()), a(sendRequest), transportScheduleCallback);
    }

    public TransportFactory newFactory(Destination destination) {
        return new TransportFactoryImpl(b(destination), TransportContext.builder().setBackendName(destination.getName()).setExtras(destination.getExtras()).build(), this);
    }
}
