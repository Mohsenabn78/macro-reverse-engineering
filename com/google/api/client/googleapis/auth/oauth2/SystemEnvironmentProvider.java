package com.google.api.client.googleapis.auth.oauth2;

/* loaded from: classes5.dex */
class SystemEnvironmentProvider {

    /* renamed from: a  reason: collision with root package name */
    static final SystemEnvironmentProvider f25601a = new SystemEnvironmentProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        return System.getenv(str);
    }
}
