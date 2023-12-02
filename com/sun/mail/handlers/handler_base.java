package com.sun.mail.handlers;

import java.io.IOException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;

/* loaded from: classes6.dex */
public abstract class handler_base implements DataContentHandler {
    protected Object getData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        return getContent(dataSource);
    }

    protected abstract ActivationDataFlavor[] getDataFlavors();

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        ActivationDataFlavor[] dataFlavors = getDataFlavors();
        for (int i4 = 0; i4 < dataFlavors.length; i4++) {
            if (dataFlavors[i4].equals(activationDataFlavor)) {
                return getData(dataFlavors[i4], dataSource);
            }
        }
        return null;
    }

    @Override // javax.activation.DataContentHandler
    public ActivationDataFlavor[] getTransferDataFlavors() {
        return (ActivationDataFlavor[]) getDataFlavors().clone();
    }
}
