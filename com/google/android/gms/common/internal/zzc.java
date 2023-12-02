package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzc {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Object f20555a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20556b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20557c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f20557c = baseGmsClient;
        this.f20555a = obj;
    }

    protected abstract void a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b();

    public final void zze() {
        Object obj;
        synchronized (this) {
            obj = this.f20555a;
            if (this.f20556b) {
                String obj2 = toString();
                Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e4) {
                throw e4;
            }
        }
        synchronized (this) {
            this.f20556b = true;
        }
        zzg();
    }

    public final void zzf() {
        synchronized (this) {
            this.f20555a = null;
        }
    }

    public final void zzg() {
        ArrayList arrayList;
        ArrayList arrayList2;
        zzf();
        arrayList = this.f20557c.zzt;
        synchronized (arrayList) {
            arrayList2 = this.f20557c.zzt;
            arrayList2.remove(this);
        }
    }
}
