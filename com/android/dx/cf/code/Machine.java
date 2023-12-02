package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface Machine {
    void auxCstArg(Constant constant);

    void auxInitValues(ArrayList<Constant> arrayList);

    void auxIntArg(int i4);

    void auxSwitchArg(SwitchList switchList);

    void auxTargetArg(int i4);

    void auxType(Type type);

    void clearArgs();

    Prototype getPrototype();

    void localArg(Frame frame, int i4);

    void localInfo(boolean z3);

    void localTarget(int i4, Type type, LocalItem localItem);

    void popArgs(Frame frame, int i4);

    void popArgs(Frame frame, Prototype prototype);

    void popArgs(Frame frame, Type type);

    void popArgs(Frame frame, Type type, Type type2);

    void popArgs(Frame frame, Type type, Type type2, Type type3);

    void run(Frame frame, int i4, int i5);
}
