package com.luckycatlabs.sunrisesunset;

import java.math.BigDecimal;

/* loaded from: classes6.dex */
public class Zenith {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f36124a;
    public static final Zenith ASTRONOMICAL = new Zenith(108.0d);
    public static final Zenith NAUTICAL = new Zenith(102.0d);
    public static final Zenith CIVIL = new Zenith(96.0d);
    public static final Zenith OFFICIAL = new Zenith(90.8333d);

    public Zenith(double d4) {
        this.f36124a = BigDecimal.valueOf(d4);
    }

    public BigDecimal degrees() {
        return this.f36124a;
    }
}
