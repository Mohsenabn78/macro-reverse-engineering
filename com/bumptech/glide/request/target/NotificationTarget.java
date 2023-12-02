package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private final RemoteViews f17510d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f17511e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17512f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17513g;

    /* renamed from: h  reason: collision with root package name */
    private final Notification f17514h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17515i;

    public NotificationTarget(Context context, int i4, RemoteViews remoteViews, Notification notification, int i5) {
        this(context, i4, remoteViews, notification, i5, null);
    }

    private void a() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.f17511e.getSystemService("notification"))).notify(this.f17513g, this.f17512f, this.f17514h);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public NotificationTarget(Context context, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, notification, i5, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        this.f17510d.setImageViewBitmap(this.f17515i, bitmap);
        a();
    }

    public NotificationTarget(Context context, int i4, int i5, int i6, RemoteViews remoteViews, Notification notification, int i7, String str) {
        super(i4, i5);
        this.f17511e = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.f17514h = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.f17510d = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f17515i = i6;
        this.f17512f = i7;
        this.f17513g = str;
    }
}
