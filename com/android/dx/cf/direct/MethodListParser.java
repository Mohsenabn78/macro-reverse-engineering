package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.StdMethod;
import com.android.dx.cf.iface.StdMethodList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MethodListParser extends MemberListParser {
    private final StdMethodList methods;

    public MethodListParser(DirectClassFile directClassFile, CstType cstType, int i4, AttributeFactory attributeFactory) {
        super(directClassFile, cstType, i4, attributeFactory);
        this.methods = new StdMethodList(getCount());
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    protected int getAttributeContext() {
        return 2;
    }

    public StdMethodList getList() {
        parseIfNecessary();
        return this.methods;
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    protected String humanAccessFlags(int i4) {
        return AccessFlags.methodString(i4);
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    protected String humanName() {
        return FirebaseAnalytics.Param.METHOD;
    }

    @Override // com.android.dx.cf.direct.MemberListParser
    protected Member set(int i4, int i5, CstNat cstNat, AttributeList attributeList) {
        StdMethod stdMethod = new StdMethod(getDefiner(), i5, cstNat, attributeList);
        this.methods.set(i4, stdMethod);
        return stdMethod;
    }
}
