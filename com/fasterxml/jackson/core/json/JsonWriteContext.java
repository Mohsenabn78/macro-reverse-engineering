package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes3.dex */
public class JsonWriteContext extends JsonStreamContext {
    public static final int STATUS_EXPECT_NAME = 5;
    public static final int STATUS_EXPECT_VALUE = 4;
    public static final int STATUS_OK_AFTER_COLON = 2;
    public static final int STATUS_OK_AFTER_COMMA = 1;
    public static final int STATUS_OK_AFTER_SPACE = 3;
    public static final int STATUS_OK_AS_IS = 0;

    /* renamed from: c  reason: collision with root package name */
    protected final JsonWriteContext f17799c;

    /* renamed from: d  reason: collision with root package name */
    protected String f17800d;

    /* renamed from: e  reason: collision with root package name */
    protected JsonWriteContext f17801e = null;

    protected JsonWriteContext(int i4, JsonWriteContext jsonWriteContext) {
        this.f17662a = i4;
        this.f17799c = jsonWriteContext;
        this.f17663b = -1;
    }

    private JsonWriteContext b(int i4) {
        this.f17662a = i4;
        this.f17663b = -1;
        this.f17800d = null;
        return this;
    }

    public static JsonWriteContext createRootContext() {
        return new JsonWriteContext(0, null);
    }

    protected final void a(StringBuilder sb) {
        int i4 = this.f17662a;
        if (i4 == 2) {
            sb.append('{');
            if (this.f17800d != null) {
                sb.append(Typography.quote);
                sb.append(this.f17800d);
                sb.append(Typography.quote);
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else if (i4 == 1) {
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sb.append(getCurrentIndex());
            sb.append(']');
        } else {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        }
    }

    public final JsonWriteContext createChildArrayContext() {
        JsonWriteContext jsonWriteContext = this.f17801e;
        if (jsonWriteContext == null) {
            JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this);
            this.f17801e = jsonWriteContext2;
            return jsonWriteContext2;
        }
        return jsonWriteContext.b(1);
    }

    public final JsonWriteContext createChildObjectContext() {
        JsonWriteContext jsonWriteContext = this.f17801e;
        if (jsonWriteContext == null) {
            JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this);
            this.f17801e = jsonWriteContext2;
            return jsonWriteContext2;
        }
        return jsonWriteContext.b(2);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this.f17800d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        a(sb);
        return sb.toString();
    }

    public final int writeFieldName(String str) {
        if (this.f17662a != 2 || this.f17800d != null) {
            return 4;
        }
        this.f17800d = str;
        if (this.f17663b < 0) {
            return 0;
        }
        return 1;
    }

    public final int writeValue() {
        int i4 = this.f17662a;
        if (i4 == 2) {
            if (this.f17800d == null) {
                return 5;
            }
            this.f17800d = null;
            this.f17663b++;
            return 2;
        } else if (i4 == 1) {
            int i5 = this.f17663b;
            this.f17663b = i5 + 1;
            if (i5 >= 0) {
                return 1;
            }
            return 0;
        } else {
            int i6 = this.f17663b + 1;
            this.f17663b = i6;
            if (i6 == 0) {
                return 0;
            }
            return 3;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final JsonWriteContext getParent() {
        return this.f17799c;
    }
}
