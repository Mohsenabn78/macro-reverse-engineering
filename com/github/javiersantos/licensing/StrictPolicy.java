package com.github.javiersantos.licensing;

/* loaded from: classes3.dex */
public class StrictPolicy implements Policy {

    /* renamed from: a  reason: collision with root package name */
    private int f18402a = Policy.RETRY;

    @Override // com.github.javiersantos.licensing.Policy
    public boolean allowAccess() {
        if (this.f18402a == 2954) {
            return true;
        }
        return false;
    }

    @Override // com.github.javiersantos.licensing.Policy
    public void processServerResponse(int i4, ResponseData responseData) {
        this.f18402a = i4;
    }
}
