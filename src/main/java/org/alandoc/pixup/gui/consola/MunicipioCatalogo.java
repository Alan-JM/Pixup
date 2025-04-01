package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Municipio;
import org.alandoc.pixup.util.ReadUtil;

public class MunicipioCatalogo extends Catalogos<Municipio>{
    public static MunicipioCatalogo municipioCatalogo;
    private MunicipioCatalogo( )
    {
        super();
    }

    public static MunicipioCatalogo getInstance( )
    {
        if(municipioCatalogo==null)
        {
            municipioCatalogo = new MunicipioCatalogo();
        }
        return municipioCatalogo;
    }
String estad = "";
    @Override
    public Municipio newT()
    {
        return new Municipio( );
    }

    @Override
    public boolean processNewT(Municipio municipio)
    {
        System.out.println("Teclee un Municipio" );
        municipio.setNombre( ReadUtil.read( ) );
        return true;
    }





    @Override
    public void processEditT(Municipio municipio)
    {
        System.out.println("Id del Municipio " + municipio.getId( ) );
        System.out.println("Municipio a editar: " + municipio.getNombre( ) );
        System.out.println("Teclee el valor nuevo del Municipio" );
        municipio.setNombre( ReadUtil.read( ) );
    }

}
