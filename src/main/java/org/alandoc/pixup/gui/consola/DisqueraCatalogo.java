
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.util.ReadUtil;

public class DisqueraCatalogo extends CatalogosDisquera<Disquera>{
    public static DisqueraCatalogo disqueraCatalogo;
    private DisqueraCatalogo( )
    {
        super();
    }

    public static DisqueraCatalogo getInstance( )
    {
        if(disqueraCatalogo==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee un Disquera" );
        disquera.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Disquera disquera) {
        System.out.println("Id del disquera " + disquera.getId( ) );
        System.out.println("Disquera a editar: " + disquera.getNombre( ) );
        System.out.println("Teclee el valor nuevo del disquera" );
        disquera.setNombre( ReadUtil.read( ) );
    }


}
