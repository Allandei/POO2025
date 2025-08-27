package ec.edu.espol.sistemaentrega;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import ec.edu.espol.sistemaentrega.R;

public class QuickActionsDialog extends DialogFragment {

    public interface QuickActionListener {
        void onAddVehiculo();
        void onAddConductor();
        void onAddPaquete();
        void onAddRuta();
    }

    private QuickActionListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuickActionListener) {
            listener = (QuickActionListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_quick_actions, container, false);
        
        Button btnVehiculo = view.findViewById(R.id.btn_add_vehiculo);
        Button btnConductor = view.findViewById(R.id.btn_add_conductor);
        Button btnPaquete = view.findViewById(R.id.btn_add_paquete);
        Button btnRuta = view.findViewById(R.id.btn_add_ruta);
        Button btnCancelar = view.findViewById(R.id.btn_cancelar);

        btnVehiculo.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddVehiculo();
            }
            dismiss();
        });

        btnConductor.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddConductor();
            }
            dismiss();
        });

        btnPaquete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddPaquete();
            }
            dismiss();
        });

        btnRuta.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddRuta();
            }
            dismiss();
        });

        btnCancelar.setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
