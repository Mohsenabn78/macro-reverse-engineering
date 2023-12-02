package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zae extends zag {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference f20417c;

    public zae(ImageView imageView, int i4) {
        super(Uri.EMPTY, i4);
        Asserts.checkNotNull(imageView);
        this.f20417c = new WeakReference(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.images.zag
    public final void a(@Nullable Drawable drawable, boolean z3, boolean z4, boolean z5) {
        ImageView imageView = (ImageView) this.f20417c.get();
        if (imageView != null) {
            if (!z4 && !z5 && (imageView instanceof zal)) {
                zal zalVar = (zal) imageView;
                throw null;
            }
            boolean z6 = false;
            if (!z4 && !z3) {
                z6 = true;
            }
            if (z6) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 != null) {
                    if (drawable2 instanceof zak) {
                        drawable2 = ((zak) drawable2).zaa();
                    }
                } else {
                    drawable2 = null;
                }
                drawable = new zak(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (!(imageView instanceof zal)) {
                if (drawable != null && z6) {
                    ((zak) drawable).zab(250);
                    return;
                }
                return;
            }
            zal zalVar2 = (zal) imageView;
            throw null;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.f20417c.get();
        ImageView imageView2 = (ImageView) ((zae) obj).f20417c.get();
        if (imageView2 != null && imageView != null && Objects.equal(imageView2, imageView)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.f20417c = new WeakReference(imageView);
    }
}
