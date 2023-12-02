package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes3.dex */
public final class JsonReadContext extends JsonStreamContext {

    /* renamed from: c  reason: collision with root package name */
    protected final JsonReadContext f17794c;

    /* renamed from: d  reason: collision with root package name */
    protected int f17795d;

    /* renamed from: e  reason: collision with root package name */
    protected int f17796e;

    /* renamed from: f  reason: collision with root package name */
    protected String f17797f;

    /* renamed from: g  reason: collision with root package name */
    protected JsonReadContext f17798g = null;

    public JsonReadContext(JsonReadContext jsonReadContext, int i4, int i5, int i6) {
        this.f17662a = i4;
        this.f17794c = jsonReadContext;
        this.f17795d = i5;
        this.f17796e = i6;
        this.f17663b = -1;
    }

    public static JsonReadContext createRootContext(int i4, int i5) {
        return new JsonReadContext(null, 0, i4, i5);
    }

    protected void a(int i4, int i5, int i6) {
        this.f17662a = i4;
        this.f17663b = -1;
        this.f17795d = i5;
        this.f17796e = i6;
        this.f17797f = null;
    }

    public JsonReadContext createChildArrayContext(int i4, int i5) {
        JsonReadContext jsonReadContext = this.f17798g;
        if (jsonReadContext == null) {
            JsonReadContext jsonReadContext2 = new JsonReadContext(this, 1, i4, i5);
            this.f17798g = jsonReadContext2;
            return jsonReadContext2;
        }
        jsonReadContext.a(1, i4, i5);
        return jsonReadContext;
    }

    public JsonReadContext createChildObjectContext(int i4, int i5) {
        JsonReadContext jsonReadContext = this.f17798g;
        if (jsonReadContext == null) {
            JsonReadContext jsonReadContext2 = new JsonReadContext(this, 2, i4, i5);
            this.f17798g = jsonReadContext2;
            return jsonReadContext2;
        }
        jsonReadContext.a(2, i4, i5);
        return jsonReadContext;
    }

    public boolean expectComma() {
        int i4 = this.f17663b + 1;
        this.f17663b = i4;
        if (this.f17662a != 0 && i4 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this.f17797f;
    }

    public JsonLocation getStartLocation(Object obj) {
        return new JsonLocation(obj, -1L, this.f17795d, this.f17796e);
    }

    public void setCurrentName(String str) {
        this.f17797f = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i4 = this.f17662a;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    sb.append('{');
                    if (this.f17797f != null) {
                        sb.append(Typography.quote);
                        CharTypes.appendQuoted(sb, this.f17797f);
                        sb.append(Typography.quote);
                    } else {
                        sb.append('?');
                    }
                    sb.append('}');
                }
            } else {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                sb.append(getCurrentIndex());
                sb.append(']');
            }
        } else {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        }
        return sb.toString();
    }

    public static JsonReadContext createRootContext() {
        return new JsonReadContext(null, 0, 1, 0);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonReadContext getParent() {
        return this.f17794c;
    }
}
