package com.facebook.stetho.dumpapp;

/* loaded from: classes3.dex */
public interface DumperPlugin {
    void dump(DumperContext dumperContext) throws DumpException;

    String getName();
}
