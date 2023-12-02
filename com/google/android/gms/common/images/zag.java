package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public abstract class zag {

    /* renamed from: a  reason: collision with root package name */
    final zad f20419a;

    /* renamed from: b  reason: collision with root package name */
    protected int f20420b;

    public zag(Uri uri, int i4) {
        this.f20420b = 0;
        this.f20419a = new zad(uri);
        this.f20420b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(@Nullable Drawable drawable, boolean z3, boolean z4, boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Context context, zam zamVar, boolean z3) {
        Drawable drawable;
        int i4 = this.f20420b;
        if (i4 != 0) {
            drawable = context.getResources().getDrawable(i4);
        } else {
            drawable = null;
        }
        a(drawable, z3, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context, Bitmap bitmap, boolean z3) {
        Asserts.checkNotNull(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
