package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33396a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f33396a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33396a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private final MessageType f33397a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f33398b;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.f33397a = messagetype;
            if (!messagetype.E()) {
                this.f33398b = j();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void i(MessageType messagetype, MessageType messagetype2) {
            Protobuf.a().d(messagetype).mergeFrom(messagetype, messagetype2);
        }

        private MessageType j() {
            return (MessageType) this.f33397a.M();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void f() {
            if (!this.f33398b.E()) {
                g();
            }
        }

        protected void g() {
            MessageType j4 = j();
            i(j4, this.f33398b);
            this.f33398b = j4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: h */
        public BuilderType d(MessageType messagetype) {
            return mergeFrom((Builder<MessageType, BuilderType>) messagetype);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.D(this.f33398b, false);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.e(buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (!this.f33398b.E()) {
                return this.f33398b;
            }
            this.f33398b.F();
            return this.f33398b;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            if (!this.f33397a.E()) {
                this.f33398b = j();
                return this;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.f33397a;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo4173clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.f33398b = buildPartial();
            return buildertype;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            if (getDefaultInstanceForType().equals(messagetype)) {
                return this;
            }
            f();
            i(this.f33398b, messagetype);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr, int i4, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            f();
            try {
                Protobuf.a().d(this.f33398b).b(this.f33398b, bArr, i4, i4 + i5, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e4) {
                throw e4;
            } catch (IOException e5) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e5);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr, int i4, int i5) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i4, i5, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            f();
            try {
                Protobuf.a().d(this.f33398b).c(this.f33398b, CodedInputStreamReader.h(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e4) {
                if (e4.getCause() instanceof IOException) {
                    throw ((IOException) e4.getCause());
                }
                throw e4;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        private FieldSet<ExtensionDescriptor> k() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.f33398b).extensions;
            if (fieldSet.s()) {
                FieldSet<ExtensionDescriptor> clone = fieldSet.clone();
                ((ExtendableMessage) this.f33398b).extensions = clone;
                return clone;
            }
            return fieldSet;
        }

        private void l(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            l(k4);
            f();
            k().a(k4.f33411d, k4.d(type));
            return this;
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            l(k4);
            f();
            k().b(k4.f33411d);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        protected void g() {
            super.g();
            if (((ExtendableMessage) this.f33398b).extensions != FieldSet.i()) {
                MessageType messagetype = this.f33398b;
                ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return (Type) ((ExtendableMessage) this.f33398b).getExtension(extensionLite);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.f33398b).getExtensionCount(extensionLite);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.f33398b).hasExtension(extensionLite);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            l(k4);
            f();
            k().D(k4.f33411d, k4.e(type));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i4) {
            return (Type) ((ExtendableMessage) this.f33398b).getExtension(extensionLite, i4);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (!((ExtendableMessage) this.f33398b).E()) {
                return (MessageType) this.f33398b;
            }
            ((ExtendableMessage) this.f33398b).extensions.y();
            return (MessageType) super.buildPartial();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i4, Type type) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            l(k4);
            f();
            k().E(k4.f33411d, i4, k4.d(type));
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i4);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        final Internal.EnumLiteMap<?> f33403a;

        /* renamed from: b  reason: collision with root package name */
        final int f33404b;

        /* renamed from: c  reason: collision with root package name */
        final WireFormat.FieldType f33405c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f33406d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f33407e;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i4, WireFormat.FieldType fieldType, boolean z3, boolean z4) {
            this.f33403a = enumLiteMap;
            this.f33404b = i4;
            this.f33405c = fieldType;
            this.f33406d = z3;
            this.f33407e = z4;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f33404b - extensionDescriptor.f33404b;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.f33403a;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.f33405c.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.f33405c;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.f33404b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((Builder) ((GeneratedMessageLite) messageLite));
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.f33407e;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.f33406d;
        }
    }

    /* loaded from: classes6.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f33408a;

        /* renamed from: b  reason: collision with root package name */
        final Type f33409b;

        /* renamed from: c  reason: collision with root package name */
        final MessageLite f33410c;

        /* renamed from: d  reason: collision with root package name */
        final ExtensionDescriptor f33411d;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype != null) {
                if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f33408a = containingtype;
                this.f33409b = type;
                this.f33410c = messageLite;
                this.f33411d = extensionDescriptor;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object b(Object obj) {
            if (this.f33411d.isRepeated()) {
                if (this.f33411d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(c(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return c(obj);
        }

        Object c(Object obj) {
            if (this.f33411d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return this.f33411d.f33403a.findValueByNumber(((Integer) obj).intValue());
            }
            return obj;
        }

        Object d(Object obj) {
            if (this.f33411d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }

        Object e(Object obj) {
            if (this.f33411d.isRepeated()) {
                if (this.f33411d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(d(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return d(obj);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f33408a;
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.f33409b;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.f33411d.getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.f33410c;
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return this.f33411d.getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.f33411d.f33406d;
        }
    }

    /* loaded from: classes6.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* loaded from: classes6.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(MessageLite messageLite) {
            Class<?> cls = messageLite.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = messageLite.toByteArray();
        }

        @Deprecated
        private Object a() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Unable to call parsePartialFrom", e6);
            } catch (NoSuchFieldException e7) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e7);
            } catch (SecurityException e8) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e8);
            }
        }

        private Class<?> b() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            if (cls == null) {
                return Class.forName(this.messageClassName);
            }
            return cls;
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Unable to call parsePartialFrom", e6);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e7) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object C(java.lang.reflect.Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean D(T t3, boolean z3) {
        Object obj;
        byte byteValue = ((Byte) t3.s(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.a().d(t3).isInitialized(t3);
        if (z3) {
            MethodToInvoke methodToInvoke = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (isInitialized) {
                obj = t3;
            } else {
                obj = null;
            }
            t3.t(methodToInvoke, obj);
        }
        return isInitialized;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList H(Internal.DoubleList doubleList) {
        int i4;
        int size = doubleList.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size * 2;
        }
        return doubleList.mutableCopyWithCapacity(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList I(Internal.IntList intList) {
        int i4;
        int size = intList.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size * 2;
        }
        return intList.mutableCopyWithCapacity(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList J(Internal.LongList longList) {
        int i4;
        int size = longList.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size * 2;
        }
        return longList.mutableCopyWithCapacity(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> K(Internal.ProtobufList<E> protobufList) {
        int i4;
        int size = protobufList.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size * 2;
        }
        return protobufList.mutableCopyWithCapacity(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object L(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T N(T t3, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) l(Z(t3, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T O(T t3, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(Z(t3, inputStream, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T P(T t3, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) l(Q(t3, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T Q(T t3, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(a0(t3, byteString, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T R(T t3, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) S(t3, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T S(T t3, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(b0(t3, codedInputStream, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T T(T t3, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) l(b0(t3, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T U(T t3, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(b0(t3, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T V(T t3, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) W(t3, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T W(T t3, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(S(t3, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T X(T t3, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) l(c0(t3, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T Y(T t3, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) l(c0(t3, bArr, 0, bArr.length, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T Z(T t3, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T t4 = (T) b0(t3, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return t4;
            } catch (InvalidProtocolBufferException e4) {
                throw e4.setUnfinishedMessage(t4);
            }
        } catch (InvalidProtocolBufferException e5) {
            if (e5.a()) {
                throw new InvalidProtocolBufferException((IOException) e5);
            }
            throw e5;
        } catch (IOException e6) {
            throw new InvalidProtocolBufferException(e6);
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T a0(T t3, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        T t4 = (T) b0(t3, newCodedInput, extensionRegistryLite);
        try {
            newCodedInput.checkLastTagWas(0);
            return t4;
        } catch (InvalidProtocolBufferException e4) {
            throw e4.setUnfinishedMessage(t4);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T b0(T t3, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t4 = (T) t3.M();
        try {
            Schema d4 = Protobuf.a().d(t4);
            d4.c(t4, CodedInputStreamReader.h(codedInputStream), extensionRegistryLite);
            d4.makeImmutable(t4);
            return t4;
        } catch (InvalidProtocolBufferException e4) {
            e = e4;
            if (e.a()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t4);
        } catch (UninitializedMessageException e5) {
            throw e5.asInvalidProtocolBufferException().setUnfinishedMessage(t4);
        } catch (IOException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw new InvalidProtocolBufferException(e6).setUnfinishedMessage(t4);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e7.getCause());
            }
            throw e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends GeneratedMessageLite<T, ?>> T c0(T t3, byte[] bArr, int i4, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t4 = (T) t3.M();
        try {
            Schema d4 = Protobuf.a().d(t4);
            d4.b(t4, bArr, i4, i4 + i5, new ArrayDecoders.Registers(extensionRegistryLite));
            d4.makeImmutable(t4);
            return t4;
        } catch (InvalidProtocolBufferException e4) {
            e = e4;
            if (e.a()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t4);
        } catch (UninitializedMessageException e5) {
            throw e5.asInvalidProtocolBufferException().setUnfinishedMessage(t4);
        } catch (IOException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw new InvalidProtocolBufferException(e6).setUnfinishedMessage(t4);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.n().setUnfinishedMessage(t4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void d0(Class<T> cls, T t3) {
        defaultInstanceMap.put(cls, t3);
        t3.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> k(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.a()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T l(T t3) throws InvalidProtocolBufferException {
        if (t3 != null && !t3.isInitialized()) {
            throw t3.f().asInvalidProtocolBufferException().setUnfinishedMessage(t3);
        }
        return t3;
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i4, WireFormat.FieldType fieldType, boolean z3, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i4, fieldType, true, z3), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i4, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i4, fieldType, false, false), cls);
    }

    private int p(Schema<?> schema) {
        if (schema == null) {
            return Protobuf.a().d(this).getSerializedSize(this);
        }
        return schema.getSerializedSize(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.DoubleList v() {
        return DoubleArrayList.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList w() {
        return IntArrayList.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.LongList x() {
        return LongArrayList.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> y() {
        return ProtobufArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T z(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) UnsafeUtil.l(cls)).getDefaultInstanceForType();
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) generatedMessageLite;
    }

    int A() {
        return this.memoizedHashCode;
    }

    boolean B() {
        if (A() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        Protobuf.a().d(this).makeImmutable(this);
        G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType M() {
        return (MessageType) s(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int c() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int d(Schema schema) {
        if (E()) {
            int p4 = p(schema);
            if (p4 >= 0) {
                return p4;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + p4);
        } else if (c() != Integer.MAX_VALUE) {
            return c();
        } else {
            int p5 = p(schema);
            g(p5);
            return p5;
        }
    }

    void e0(int i4) {
        this.memoizedHashCode = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Protobuf.a().d(this).equals(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void g(int i4) {
        if (i4 >= 0) {
            this.memoizedSerializedSize = (i4 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i4);
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) s(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        return d(null);
    }

    public int hashCode() {
        if (E()) {
            return o();
        }
        if (B()) {
            e0(o());
        }
        return A();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return D(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object j() throws Exception {
        return s(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.memoizedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        g(Integer.MAX_VALUE);
    }

    int o() {
        return Protobuf.a().d(this).hashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType q() {
        return (BuilderType) s(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType r(MessageType messagetype) {
        return (BuilderType) q().mergeFrom(messagetype);
    }

    protected Object s(MethodToInvoke methodToInvoke) {
        return u(methodToInvoke, null, null);
    }

    @CanIgnoreReturnValue
    protected Object t(MethodToInvoke methodToInvoke, Object obj) {
        return u(methodToInvoke, obj, null);
    }

    public String toString() {
        return MessageLiteToString.f(this, super.toString());
    }

    protected abstract Object u(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.a().d(this).a(this, CodedOutputStreamWriter.f(codedOutputStream));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) s(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) s(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) s(MethodToInvoke.NEW_BUILDER)).mergeFrom((Builder) this);
    }

    /* loaded from: classes6.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f33399b;

        public DefaultInstanceBasedParser(T t3) {
            this.f33399b = t3;
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.b0(this.f33399b, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public T parsePartialFrom(byte[] bArr, int i4, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.c0(this.f33399b, bArr, i4, i5, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.i();

        /* loaded from: classes6.dex */
        protected class ExtensionWriter {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> f33400a;

            /* renamed from: b  reason: collision with root package name */
            private Map.Entry<ExtensionDescriptor, Object> f33401b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f33402c;

            public void writeUntil(int i4, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.f33401b;
                    if (entry != null && entry.getKey().getNumber() < i4) {
                        ExtensionDescriptor key = this.f33401b.getKey();
                        if (this.f33402c && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.f33401b.getValue());
                        } else {
                            FieldSet.I(key, this.f33401b.getValue(), codedOutputStream);
                        }
                        if (this.f33400a.hasNext()) {
                            this.f33401b = this.f33400a.next();
                        } else {
                            this.f33401b = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private void g0(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public FieldSet<ExtensionDescriptor> f0() {
            if (this.extensions.s()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            g0(k4);
            Object j4 = this.extensions.j(k4.f33411d);
            if (j4 == null) {
                return k4.f33409b;
            }
            return (Type) k4.b(j4);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            g0(k4);
            return this.extensions.n(k4.f33411d);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            g0(k4);
            return this.extensions.q(k4.f33411d);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i4) {
            GeneratedExtension<MessageType, ?> k4 = GeneratedMessageLite.k(extensionLite);
            g0(k4);
            return (Type) k4.c(this.extensions.m(k4.f33411d, i4));
        }
    }
}
