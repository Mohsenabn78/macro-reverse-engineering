package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes6.dex */
public class LazyFieldLite {

    /* renamed from: e  reason: collision with root package name */
    private static final ExtensionRegistryLite f33446e = ExtensionRegistryLite.getEmptyRegistry();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f33447a;

    /* renamed from: b  reason: collision with root package name */
    private ExtensionRegistryLite f33448b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile MessageLite f33449c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f33450d;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        a(extensionRegistryLite, byteString);
        this.f33448b = extensionRegistryLite;
        this.f33447a = byteString;
    }

    private static void a(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite != null) {
            if (byteString != null) {
                return;
            }
            throw new NullPointerException("found null ByteString");
        }
        throw new NullPointerException("found null ExtensionRegistry");
    }

    private static MessageLite c(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    protected void b(MessageLite messageLite) {
        if (this.f33449c != null) {
            return;
        }
        synchronized (this) {
            if (this.f33449c != null) {
                return;
            }
            try {
                if (this.f33447a != null) {
                    this.f33449c = messageLite.getParserForType().parseFrom(this.f33447a, this.f33448b);
                    this.f33450d = this.f33447a;
                } else {
                    this.f33449c = messageLite;
                    this.f33450d = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f33449c = messageLite;
                this.f33450d = ByteString.EMPTY;
            }
        }
    }

    public void clear() {
        this.f33447a = null;
        this.f33449c = null;
        this.f33450d = null;
    }

    public boolean containsDefaultInstance() {
        ByteString byteString;
        ByteString byteString2 = this.f33450d;
        ByteString byteString3 = ByteString.EMPTY;
        if (byteString2 != byteString3 && (this.f33449c != null || ((byteString = this.f33447a) != null && byteString != byteString3))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f33449c;
        MessageLite messageLite2 = lazyFieldLite.f33449c;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.f33450d != null) {
            return this.f33450d.size();
        }
        ByteString byteString = this.f33447a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f33449c != null) {
            return this.f33449c.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        b(messageLite);
        return this.f33449c;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (lazyFieldLite.containsDefaultInstance()) {
            return;
        }
        if (containsDefaultInstance()) {
            set(lazyFieldLite);
            return;
        }
        if (this.f33448b == null) {
            this.f33448b = lazyFieldLite.f33448b;
        }
        ByteString byteString2 = this.f33447a;
        if (byteString2 != null && (byteString = lazyFieldLite.f33447a) != null) {
            this.f33447a = byteString2.concat(byteString);
        } else if (this.f33449c == null && lazyFieldLite.f33449c != null) {
            setValue(c(lazyFieldLite.f33449c, this.f33447a, this.f33448b));
        } else if (this.f33449c != null && lazyFieldLite.f33449c == null) {
            setValue(c(this.f33449c, lazyFieldLite.f33447a, lazyFieldLite.f33448b));
        } else {
            setValue(this.f33449c.toBuilder().mergeFrom(lazyFieldLite.f33449c).build());
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.f33448b == null) {
            this.f33448b = extensionRegistryLite;
        }
        ByteString byteString = this.f33447a;
        if (byteString != null) {
            setByteString(byteString.concat(codedInputStream.readBytes()), this.f33448b);
            return;
        }
        try {
            setValue(this.f33449c.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.f33447a = lazyFieldLite.f33447a;
        this.f33449c = lazyFieldLite.f33449c;
        this.f33450d = lazyFieldLite.f33450d;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.f33448b;
        if (extensionRegistryLite != null) {
            this.f33448b = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        a(extensionRegistryLite, byteString);
        this.f33447a = byteString;
        this.f33448b = extensionRegistryLite;
        this.f33449c = null;
        this.f33450d = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f33449c;
        this.f33447a = null;
        this.f33450d = null;
        this.f33449c = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.f33450d != null) {
            return this.f33450d;
        }
        ByteString byteString = this.f33447a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f33450d != null) {
                return this.f33450d;
            }
            if (this.f33449c == null) {
                this.f33450d = ByteString.EMPTY;
            } else {
                this.f33450d = this.f33449c.toByteString();
            }
            return this.f33450d;
        }
    }
}
