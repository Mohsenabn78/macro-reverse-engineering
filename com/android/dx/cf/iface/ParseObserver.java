package com.android.dx.cf.iface;

import com.android.dx.util.ByteArray;

/* loaded from: classes2.dex */
public interface ParseObserver {
    void changeIndent(int i4);

    void endParsingMember(ByteArray byteArray, int i4, String str, String str2, Member member);

    void parsed(ByteArray byteArray, int i4, int i5, String str);

    void startParsingMember(ByteArray byteArray, int i4, String str, String str2);
}
