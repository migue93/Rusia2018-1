package com.miguelyeisonappgmail.rusia2018;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

     private final int[] BOTONESMENU={R.id.favorito, R.id.en_vivo, R.id.noticias, R.id.mas, R.id.inicio                                                                     }; // El id de cada boton esta almacenado en un arrreglo llamado BORONESMENU

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mimenu = inflater.inflate(R.layout.fragment_menu, container, false); // esta instruccion nos devuelve un view y es el fragmento que queremos cargar


        ImageButton botonmenu;

        for (int i = 0; i < BOTONESMENU.length; i ++){

            botonmenu = (ImageButton) mimenu.findViewById(BOTONESMENU[i]);

            final int cualboton = i;

            botonmenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Activity estaActividad = getActivity();
                    ((ComunicaMenu)estaActividad).menu(cualboton);

                }
            });
        }

    return mimenu;

    }


}
