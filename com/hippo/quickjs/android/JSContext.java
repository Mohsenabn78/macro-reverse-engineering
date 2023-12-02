package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.hippo.quickjs.android.TypeAdapter;
import java.io.Closeable;

/* loaded from: classes6.dex */
public class JSContext implements Closeable, TypeAdapter.Context {
    public static final int EVAL_FLAG_STRICT = 8;
    public static final int EVAL_FLAG_STRIP = 16;
    public static final int EVAL_TYPE_GLOBAL = 0;
    public static final int EVAL_TYPE_MODULE = 1;

    /* renamed from: a  reason: collision with root package name */
    long f34052a;

    /* renamed from: b  reason: collision with root package name */
    final QuickJS f34053b;

    /* renamed from: c  reason: collision with root package name */
    final JSRuntime f34054c;

    /* renamed from: d  reason: collision with root package name */
    private final j<JSValue> f34055d = new b();

    /* loaded from: classes6.dex */
    private class b extends j<JSValue> {
        private b() {
        }

        @Override // com.hippo.quickjs.android.j
        public void c(long j4) {
            QuickJS.destroyValue(JSContext.this.f34052a, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSContext(long j4, QuickJS quickJS, JSRuntime jSRuntime) {
        this.f34052a = j4;
        this.f34053b = quickJS;
        this.f34054c = jSRuntime;
    }

    private <T> T c(String str, String str2, int i4, int i5, @Nullable TypeAdapter<T> typeAdapter) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("Invalid type: " + i4);
        } else if ((i5 & (-25)) == 0) {
            synchronized (this.f34054c) {
                b();
                long evaluate = QuickJS.evaluate(this.f34052a, str, str2, i4 | i5);
                if (typeAdapter != null) {
                    return typeAdapter.fromJSValue(this.f34053b, this, d(evaluate));
                } else if (QuickJS.getValueTag(evaluate) != 6) {
                    QuickJS.destroyValue(this.f34052a, evaluate);
                    return null;
                } else {
                    throw new JSEvaluationException(QuickJS.getException(this.f34052a));
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid flags: " + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        if (this.f34052a != 0) {
            this.f34055d.a();
            return this.f34052a;
        }
        throw new IllegalStateException("The JSContext is closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f34054c) {
            if (this.f34052a != 0) {
                this.f34055d.b();
                long j4 = this.f34052a;
                this.f34052a = 0L;
                QuickJS.destroyContext(j4);
            }
        }
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSArray createJSArray() {
        JSArray jSArray;
        synchronized (this.f34054c) {
            b();
            jSArray = (JSArray) d(QuickJS.createValueArray(this.f34052a)).cast(JSArray.class);
        }
        return jSArray;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSBoolean createJSBoolean(boolean z3) {
        JSBoolean jSBoolean;
        synchronized (this.f34054c) {
            b();
            jSBoolean = (JSBoolean) d(QuickJS.createValueBoolean(this.f34052a, z3)).cast(JSBoolean.class);
        }
        return jSBoolean;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSFunction createJSFunction(Object obj, Method method) {
        JSFunction jSFunction;
        if (obj != null) {
            if (method != null) {
                synchronized (this.f34054c) {
                    b();
                    jSFunction = (JSFunction) d(QuickJS.createValueFunction(this.f34052a, this, obj, method.f34067b, method.b(), method.f34066a, method.f34068c, false)).cast(JSFunction.class);
                }
                return jSFunction;
            }
            throw new NullPointerException("method == null");
        }
        throw new NullPointerException("instance == null");
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSFunction createJSFunctionS(Class cls, Method method) {
        JSFunction jSFunction;
        if (cls != null) {
            if (method != null) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(name.length());
                for (int i4 = 0; i4 < name.length(); i4++) {
                    char charAt = name.charAt(i4);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    sb.append(charAt);
                }
                String sb2 = sb.toString();
                synchronized (this.f34054c) {
                    b();
                    jSFunction = (JSFunction) d(QuickJS.createValueFunctionS(this.f34052a, this, sb2, method.f34067b, method.b(), method.f34066a, method.f34068c)).cast(JSFunction.class);
                }
                return jSFunction;
            }
            throw new NullPointerException("method == null");
        }
        throw new NullPointerException("clazz == null");
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSNull createJSNull() {
        JSNull jSNull;
        synchronized (this.f34054c) {
            b();
            jSNull = (JSNull) d(QuickJS.createValueNull(this.f34052a)).cast(JSNull.class);
        }
        return jSNull;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSNumber createJSNumber(int i4) {
        JSNumber jSNumber;
        synchronized (this.f34054c) {
            b();
            jSNumber = (JSNumber) d(QuickJS.createValueInt(this.f34052a, i4)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSObject createJSObject() {
        JSObject jSObject;
        synchronized (this.f34054c) {
            b();
            jSObject = (JSObject) d(QuickJS.createValueObject(this.f34052a)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSObject createJSPromise(PromiseExecutor promiseExecutor) {
        JSValue d4;
        JSValue d5;
        JSValue d6;
        synchronized (this.f34054c) {
            b();
            long[] createValuePromise = QuickJS.createValuePromise(this.f34052a);
            if (createValuePromise != null) {
                for (long j4 : createValuePromise) {
                    if (QuickJS.getValueTag(j4) == 6) {
                        for (long j5 : createValuePromise) {
                            QuickJS.destroyValue(this.f34052a, j5);
                        }
                        throw new JSEvaluationException(QuickJS.getException(this.f34052a));
                    }
                }
                d4 = d(createValuePromise[0]);
                d5 = d(createValuePromise[1]);
                d6 = d(createValuePromise[2]);
            } else {
                throw new NullPointerException("result == null");
            }
        }
        promiseExecutor.execute((JSFunction) d5.cast(JSFunction.class), (JSFunction) d6.cast(JSFunction.class));
        return (JSObject) d4.cast(JSObject.class);
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSString createJSString(String str) {
        JSString jSString;
        synchronized (this.f34054c) {
            b();
            jSString = (JSString) d(QuickJS.createValueString(this.f34052a, str)).cast(JSString.class);
        }
        return jSString;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSUndefined createJSUndefined() {
        JSUndefined jSUndefined;
        synchronized (this.f34054c) {
            b();
            jSUndefined = (JSUndefined) d(QuickJS.createValueUndefined(this.f34052a)).cast(JSUndefined.class);
        }
        return jSUndefined;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue d(long j4) {
        JSValue jSSymbol;
        if (j4 != 0) {
            int valueTag = QuickJS.getValueTag(j4);
            if (valueTag != -8) {
                if (valueTag != -7) {
                    if (valueTag != -1) {
                        if (valueTag != 0) {
                            if (valueTag != 1) {
                                if (valueTag != 2) {
                                    if (valueTag != 3) {
                                        if (valueTag != 6) {
                                            if (valueTag != 7) {
                                                jSSymbol = new h(j4, this);
                                            } else {
                                                jSSymbol = new f(j4, this, QuickJS.getValueFloat64(j4));
                                            }
                                        } else {
                                            QuickJS.destroyValue(this.f34052a, j4);
                                            throw new JSEvaluationException(QuickJS.getException(this.f34052a));
                                        }
                                    } else {
                                        jSSymbol = new JSUndefined(j4, this);
                                    }
                                } else {
                                    jSSymbol = new JSNull(j4, this);
                                }
                            } else {
                                jSSymbol = new JSBoolean(j4, this, QuickJS.getValueBoolean(j4));
                            }
                        } else {
                            jSSymbol = new g(j4, this, QuickJS.getValueInt(j4));
                        }
                    } else if (QuickJS.isValueFunction(this.f34052a, j4)) {
                        jSSymbol = new JSFunction(j4, this);
                    } else if (QuickJS.isValueArray(this.f34052a, j4)) {
                        jSSymbol = new JSArray(j4, this);
                    } else {
                        jSSymbol = new JSObject(j4, this, QuickJS.getValueJavaObject(this.f34052a, j4));
                    }
                } else {
                    jSSymbol = new JSString(j4, this, QuickJS.getValueString(this.f34052a, j4));
                }
            } else {
                jSSymbol = new JSSymbol(j4, this);
            }
            this.f34055d.d(jSSymbol, j4);
            return jSSymbol;
        }
        throw new IllegalStateException("Can't wrap null pointer as JSValue");
    }

    public void evaluate(String str, String str2) {
        c(str, str2, 0, 0, null);
    }

    public boolean executePendingJob() {
        boolean z3;
        synchronized (this.f34054c) {
            b();
            int executePendingJob = QuickJS.executePendingJob(this.f34052a);
            if (executePendingJob >= 0) {
                if (executePendingJob != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                throw new JSEvaluationException(QuickJS.getException(this.f34052a));
            }
        }
        return z3;
    }

    public JSObject getGlobalObject() {
        JSObject jSObject;
        synchronized (this.f34054c) {
            b();
            jSObject = (JSObject) d(QuickJS.getGlobalObject(this.f34052a)).cast(JSObject.class);
        }
        return jSObject;
    }

    public void evaluate(String str, String str2, int i4, int i5) {
        c(str, str2, i4, i5, null);
    }

    public <T> T evaluate(String str, String str2, Class<T> cls) {
        return (T) c(str, str2, 0, 0, this.f34053b.getAdapter(cls));
    }

    public <T> T evaluate(String str, String str2, TypeAdapter<T> typeAdapter) {
        return (T) c(str, str2, 0, 0, typeAdapter);
    }

    public <T> T evaluate(String str, String str2, int i4, int i5, Class<T> cls) {
        return (T) c(str, str2, i4, i5, this.f34053b.getAdapter(cls));
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSNumber createJSNumber(double d4) {
        JSNumber jSNumber;
        synchronized (this.f34054c) {
            b();
            jSNumber = (JSNumber) d(QuickJS.createValueFloat64(this.f34052a, d4)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Context
    public JSObject createJSObject(Object obj) {
        JSObject jSObject;
        synchronized (this.f34054c) {
            b();
            jSObject = (JSObject) d(QuickJS.createValueJavaObject(this.f34052a, obj)).cast(JSObject.class);
        }
        return jSObject;
    }

    public <T> T evaluate(String str, String str2, int i4, int i5, TypeAdapter<T> typeAdapter) {
        return (T) c(str, str2, i4, i5, typeAdapter);
    }

    public JSFunction createJSFunction(JSFunctionCallback jSFunctionCallback) {
        JSFunction jSFunction;
        if (jSFunctionCallback != null) {
            synchronized (this.f34054c) {
                b();
                jSFunction = (JSFunction) d(QuickJS.createValueFunction(this.f34052a, this, jSFunctionCallback, "invoke", "(Lcom/hippo/quickjs/android/JSContext;[Lcom/hippo/quickjs/android/JSValue;)Lcom/hippo/quickjs/android/JSValue;", JSValue.class, new Class[]{JSContext.class, JSValue[].class}, true)).cast(JSFunction.class);
            }
            return jSFunction;
        }
        throw new NullPointerException("callback == null");
    }
}
