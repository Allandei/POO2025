package ec.edu.espol.sistemaentrega.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.sistemaentrega.R;
import ec.edu.espol.sistemaentrega.adapters.PaqueteAdapter;
import ec.edu.espol.sistemaentrega.data.DataManager;
import ec.edu.espol.sistemaentrega.model.Paquete;

public class PaquetesFragment extends Fragment {

    private RecyclerView recyclerView;
    private PaqueteAdapter adapter;
    private List<Paquete> paquetes;
    private DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paquetes, container, false);
        
        dataManager = DataManager.getInstance(requireContext());
        paquetes = new ArrayList<>();
        
        initViews(view);
        setupRecyclerView();
        cargarPaquetes();
        
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_paquetes);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_paquete);
        
        fab.setOnClickListener(v -> mostrarDialogoAgregarPaquete());
    }

    private void setupRecyclerView() {
        adapter = new PaqueteAdapter(paquetes, new PaqueteAdapter.PaqueteListener() {
            @Override
            public void onPaqueteClick(Paquete paquete) {
                mostrarDetallesPaquete(paquete);
            }

            @Override
            public void onPaqueteEdit(Paquete paquete) {
                editarPaquete(paquete);
            }

            @Override
            public void onPaqueteDelete(Paquete paquete) {
                eliminarPaquete(paquete);
            }
        });
        
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    private void cargarPaquetes() {
        dataManager.cargarPaquetes(new DataManager.DataCallback<List<Paquete>>() {
            @Override
            public void onSuccess(List<Paquete> result) {
                paquetes.clear();
                paquetes.addAll(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(requireContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDialogoAgregarPaquete() {
        Toast.makeText(requireContext(), "Función en desarrollo", Toast.LENGTH_SHORT).show();
    }

    private void mostrarDetallesPaquete(Paquete paquete) {
        Toast.makeText(requireContext(), "Detalles de: " + paquete.getCodigo(), Toast.LENGTH_SHORT).show();
    }

    private void editarPaquete(Paquete paquete) {
        Toast.makeText(requireContext(), "Editar: " + paquete.getCodigo(), Toast.LENGTH_SHORT).show();
    }

    private void eliminarPaquete(Paquete paquete) {
        Toast.makeText(requireContext(), "Eliminar: " + paquete.getCodigo(), Toast.LENGTH_SHORT).show();
    }
}
