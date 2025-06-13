package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Estado;
import org.alandoc.pixup.model.Municipio;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;


public class MunicipioCatalogo extends Catalogos{


    @Override
    public Catalogo newT() {
        return null;
    }

    @Override
    public boolean processNewT(Catalogo catalogo) {
        return false;
    }

    @Override
    public void processEditT(Catalogo catalogo) {

    }
}
