package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes5.dex */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31476a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31477b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstanceIdResultImpl(String str, String str2) {
        this.f31476a = str;
        this.f31477b = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getId() {
        return this.f31476a;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getToken() {
        return this.f31477b;
    }
}
