package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f25336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i4, long j4) {
        this.f25336a = j4;
    }

    @Override // com.google.android.play.integrity.internal.e
    public final int a() {
        return 3;
    }

    @Override // com.google.android.play.integrity.internal.e
    public final long b() {
        return this.f25336a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            eVar.a();
            if (this.f25336a == eVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f25336a;
        return (-724379968) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        long j4 = this.f25336a;
        return "EventRecord{eventType=3, eventTimestamp=" + j4 + "}";
    }
}
