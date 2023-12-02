package com.google.protobuf;

/* loaded from: classes6.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final GeneratedMessageInfoFactory f33395a = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory a() {
        return f33395a;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.z(cls.asSubclass(GeneratedMessageLite.class)).j();
            } catch (Exception e4) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e4);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }
}
