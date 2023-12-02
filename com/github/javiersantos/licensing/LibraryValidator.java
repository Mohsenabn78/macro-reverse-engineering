package com.github.javiersantos.licensing;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class LibraryValidator {

    /* renamed from: a  reason: collision with root package name */
    private final Policy f18386a;

    /* renamed from: b  reason: collision with root package name */
    private final LibraryCheckerCallback f18387b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18388c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18389d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18390e;

    /* renamed from: f  reason: collision with root package name */
    private final DeviceLimiter f18391f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibraryValidator(Policy policy, DeviceLimiter deviceLimiter, LibraryCheckerCallback libraryCheckerCallback, int i4, String str, String str2) {
        this.f18386a = policy;
        this.f18391f = deviceLimiter;
        this.f18387b = libraryCheckerCallback;
        this.f18388c = i4;
        this.f18389d = str;
        this.f18390e = str2;
    }

    private void e(int i4) {
        this.f18387b.applicationError(i4);
    }

    private void f() {
        this.f18387b.dontAllow(Policy.NOT_LICENSED);
    }

    private void g(int i4, ResponseData responseData) {
        this.f18386a.processServerResponse(i4, responseData);
        if (this.f18386a.allowAccess()) {
            this.f18387b.allow(i4);
        } else {
            this.f18387b.dontAllow(i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.security.PublicKey r6, int r7, java.lang.String r8, java.util.Calendar r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.licensing.LibraryValidator.a(java.security.PublicKey, int, java.lang.String, java.util.Calendar, java.lang.String):void");
    }

    public LibraryCheckerCallback b() {
        return this.f18387b;
    }

    public int c() {
        return this.f18388c;
    }

    public String d() {
        return this.f18389d;
    }
}
