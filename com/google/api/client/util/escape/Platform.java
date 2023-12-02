package com.google.api.client.util.escape;

/* loaded from: classes5.dex */
final class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<char[]> f26165a = new ThreadLocal<char[]>() { // from class: com.google.api.client.util.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    };

    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] a() {
        return f26165a.get();
    }
}
