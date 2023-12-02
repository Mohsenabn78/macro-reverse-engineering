package com.arlosoft.macrodroid.action.hotspot;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.android.dx.Code;
import com.android.dx.DexMaker;
import com.android.dx.FieldId;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class CallbackMaker {

    /* renamed from: a  reason: collision with root package name */
    private final MyOnStartTetheringCallback f3681a;

    /* renamed from: b  reason: collision with root package name */
    Context f3682b;

    /* renamed from: c  reason: collision with root package name */
    Class<?> f3683c;

    /* renamed from: d  reason: collision with root package name */
    DexMaker f3684d;

    @RequiresApi(api = 21)
    public CallbackMaker(Context context, MyOnStartTetheringCallback myOnStartTetheringCallback) {
        Class<?> cls;
        this.f3682b = context;
        this.f3681a = myOnStartTetheringCallback;
        try {
            cls = Class.forName("android.net.ConnectivityManager$OnStartTetheringCallback");
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            cls = null;
        }
        TypeId<?> typeId = TypeId.get(cls);
        this.f3684d = new DexMaker();
        TypeId<?> typeId2 = TypeId.get("LTetheringCallback;");
        this.f3684d.declare(typeId2, "TetheringCallback.generated", 1, typeId, new TypeId[0]);
        this.f3684d.declare(typeId2.getField(TypeId.get(MyOnStartTetheringCallback.class), "callback"), 2, null);
        generateConstructorWorking(typeId2, typeId);
        try {
            this.f3683c = this.f3684d.generateAndLoad(CallbackMaker.class.getClassLoader(), this.f3682b.getCodeCacheDir()).loadClass("TetheringCallback");
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
        }
    }

    public void generateConstructor(TypeId<?> typeId, TypeId<?> typeId2, FieldId<?, ?> fieldId) {
        MethodId<?, Void> constructor = typeId2.getConstructor(new TypeId[0]);
        Code declare = this.f3684d.declare(typeId.getConstructor(TypeId.get(MyOnStartTetheringCallback.class)), 1);
        declare.invokeDirect(constructor, null, declare.getThis(typeId), new Local[0]);
        declare.returnVoid();
    }

    public void generateConstructorWorking(TypeId<?> typeId, TypeId<?> typeId2) {
        MethodId<?, Void> constructor = typeId2.getConstructor(new TypeId[0]);
        Code declare = this.f3684d.declare(typeId.getConstructor(TypeId.INT), 1);
        declare.invokeDirect(constructor, null, declare.getThis(typeId), new Local[0]);
        declare.returnVoid();
    }

    public Class<?> getCallBackClass() {
        return this.f3683c;
    }
}
