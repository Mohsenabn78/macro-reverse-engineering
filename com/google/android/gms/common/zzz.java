package com.google.android.gms.common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzz {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f20803a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f20804b = -1;

    /* renamed from: c  reason: collision with root package name */
    private zzag f20805c = zzag.zzl();

    /* renamed from: d  reason: collision with root package name */
    private zzag f20806d = zzag.zzl();

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz a(long j4) {
        this.f20804b = j4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz b(List list) {
        Preconditions.checkNotNull(list);
        this.f20806d = zzag.zzk(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz c(List list) {
        Preconditions.checkNotNull(list);
        this.f20805c = zzag.zzk(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz d(String str) {
        this.f20803a = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzab e() {
        if (this.f20803a != null) {
            if (this.f20804b >= 0) {
                if (this.f20805c.isEmpty() && this.f20806d.isEmpty()) {
                    throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
                }
                return new zzab(this.f20803a, this.f20804b, this.f20805c, this.f20806d, null);
            }
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        throw new IllegalStateException("packageName must be defined");
    }
}
