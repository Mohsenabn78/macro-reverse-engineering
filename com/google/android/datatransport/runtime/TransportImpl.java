package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* loaded from: classes.dex */
final class TransportImpl<T> implements Transport<T> {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f18681a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18682b;

    /* renamed from: c  reason: collision with root package name */
    private final Encoding f18683c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<T, byte[]> f18684d;

    /* renamed from: e  reason: collision with root package name */
    private final TransportInternal f18685e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f18681a = transportContext;
        this.f18682b = str;
        this.f18683c = encoding;
        this.f18684d = transformer;
        this.f18685e = transportInternal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportContext b() {
        return this.f18681a;
    }

    @Override // com.google.android.datatransport.Transport
    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f18685e.send(SendRequest.a().setTransportContext(this.f18681a).b(event).setTransportName(this.f18682b).c(this.f18684d).a(this.f18683c).build(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void send(Event<T> event) {
        schedule(event, new TransportScheduleCallback() { // from class: com.google.android.datatransport.runtime.a
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void onSchedule(Exception exc) {
                TransportImpl.c(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }
}
