package com.airbnb.lottie.model;

/* loaded from: classes2.dex */
public class Marker {

    /* renamed from: b  reason: collision with root package name */
    private static String f1605b = "\r";

    /* renamed from: a  reason: collision with root package name */
    private final String f1606a;
    public final float durationFrames;
    public final float startFrame;

    public Marker(String str, float f4, float f5) {
        this.f1606a = str;
        this.durationFrames = f5;
        this.startFrame = f4;
    }

    public boolean matchesName(String str) {
        if (this.f1606a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f1606a.endsWith(f1605b)) {
            String str2 = this.f1606a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
