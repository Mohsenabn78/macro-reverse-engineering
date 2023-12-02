package com.twofortyfouram.locale.sdk.host.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.bundle.BundleKeyComparator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundleSerializer {
    private static final int CONTROL_CODE_CONTINUE = 1;
    private static final int CONTROL_CODE_END = 0;
    private static final int TYPE_BUNDLE = 1;
    private static final int TYPE_SERIALIZABLE = 0;
    private static final int VERSION_1 = 1;

    private BundleSerializer() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    public static Bundle deserializeFromByteArray(@NonNull byte[] bArr) throws ClassNotFoundException {
        Assertions.assertNotNull(bArr, "bytesToDeserialize");
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(bArr));
                try {
                    Bundle bundle = new Bundle();
                    int readInt = objectInputStream2.readInt();
                    if (readInt == 1) {
                        while (1 == objectInputStream2.readInt()) {
                            int readInt2 = objectInputStream2.readInt();
                            if (readInt2 != 0) {
                                if (readInt2 == 1) {
                                    bundle.putBundle((String) objectInputStream2.readObject(), deserializeFromByteArray((byte[]) objectInputStream2.readObject()));
                                } else {
                                    throw new RuntimeException(Lumberjack.formatMessage("Type %d unrecognized", Integer.valueOf(readInt2)));
                                }
                            } else {
                                bundle.putSerializable((String) objectInputStream2.readObject(), (Serializable) objectInputStream2.readObject());
                            }
                        }
                        try {
                            objectInputStream2.close();
                            return bundle;
                        } catch (IOException e4) {
                            throw new RuntimeException("IOException when closing ObjectInputStream", e4);
                        }
                    }
                    throw new RuntimeException(Lumberjack.formatMessage("Version %d unrecognized", Integer.valueOf(readInt)));
                } catch (IOException e5) {
                    e = e5;
                    throw new RuntimeException("IOException when deserializing", e);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                            throw new RuntimeException("IOException when closing ObjectInputStream", e6);
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NonNull
    public static byte[] serializeToByteArray(@NonNull Bundle bundle) throws NotSerializableException, Exception {
        Assertions.assertNotNull(bundle, "bundleToSerialize");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(1);
                    TreeSet<String> treeSet = new TreeSet(new BundleKeyComparator());
                    treeSet.addAll(bundle.keySet());
                    int size = treeSet.size();
                    if (size == 0) {
                        objectOutputStream2.writeInt(0);
                    } else {
                        objectOutputStream2.writeInt(1);
                    }
                    int i4 = 0;
                    for (String str : treeSet) {
                        Object obj = bundle.get(str);
                        if (obj instanceof Bundle) {
                            objectOutputStream2.writeInt(1);
                            objectOutputStream2.writeObject(str);
                            objectOutputStream2.writeObject(serializeToByteArray((Bundle) obj));
                        } else {
                            if (!(obj instanceof Serializable) && obj != null) {
                                throw new NotSerializableException(Lumberjack.formatMessage("Key \"%s\"'s value %s isn't Serializable.  Only primitives or objects implementing Serializable can be stored.  Parcelable is not stable for long-term storage.", str, bundle.get(str)));
                            }
                            objectOutputStream2.writeInt(0);
                            objectOutputStream2.writeObject(str);
                            objectOutputStream2.writeObject(bundle.get(str));
                        }
                        i4++;
                        if (i4 == size) {
                            objectOutputStream2.writeInt(0);
                        } else {
                            objectOutputStream2.writeInt(1);
                        }
                    }
                    try {
                        objectOutputStream2.close();
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e4) {
                        throw new RuntimeException("IOException when closing ObjectOutputStream", e4);
                    }
                } catch (NotSerializableException e5) {
                    throw e5;
                } catch (IOException e6) {
                    e = e6;
                    throw new RuntimeException("IOException when serializing to byte[]", e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                            throw new RuntimeException("IOException when closing ObjectOutputStream", e7);
                        }
                    }
                    throw th;
                }
            } catch (NotSerializableException e8) {
                throw e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
