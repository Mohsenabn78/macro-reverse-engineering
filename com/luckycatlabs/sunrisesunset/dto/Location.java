package com.luckycatlabs.sunrisesunset.dto;

import java.math.BigDecimal;

/* loaded from: classes6.dex */
public class Location {

    /* renamed from: a  reason: collision with root package name */
    private BigDecimal f36127a;

    /* renamed from: b  reason: collision with root package name */
    private BigDecimal f36128b;

    public Location(String str, String str2) {
        this.f36127a = new BigDecimal(str);
        this.f36128b = new BigDecimal(str2);
    }

    public BigDecimal getLatitude() {
        return this.f36127a;
    }

    public BigDecimal getLongitude() {
        return this.f36128b;
    }

    public void setLocation(String str, String str2) {
        this.f36127a = new BigDecimal(str);
        this.f36128b = new BigDecimal(str2);
    }

    public void setLocation(double d4, double d5) {
        this.f36127a = new BigDecimal(d4);
        this.f36128b = new BigDecimal(d5);
    }

    public Location(double d4, double d5) {
        this.f36127a = new BigDecimal(d4);
        this.f36128b = new BigDecimal(d5);
    }
}
