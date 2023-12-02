package com.arlosoft.macrodroid.triggers.swipe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes3.dex */
public abstract class OverlayService extends Service {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f15582a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f15583b = false;

    /* renamed from: c  reason: collision with root package name */
    protected int f15584c = 0;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return 1;
    }
}
