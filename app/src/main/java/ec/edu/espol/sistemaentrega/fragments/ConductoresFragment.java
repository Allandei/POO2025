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
import ec.edu.espol.sistemaentrega.adapters.ConductorAdapter;
import ec.edu.espol.sistemaentrega.data.DataManager;
import ec.edu.espol.sistemaentrega.model.Conductor;

public class ConductoresFragment extends Fragment {

    private RecyclerView recyclerView;
    private ConductorAdapter adapter;
    private List<Conductor> conductores;
    private DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conductores, container, false);
        
        dataManager = DataManager.getInstance(requireContext());
        conductores = new ArrayList<>();
        
        initViews(view);
        setupRecyclerView();
        cargarConductores();
        
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_conductores);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_conductor);
        
        fab.setOnClickListener(v -> mostrarDialogoAgregarConductor());
    }

    private void setupRecyclerView() {
        adapter = new ConductorAdapter(conductores, new ConductorAdapter.ConductorListener() {
            @Override
            public void onConductorClick(Conductor conductor) {
                mostrarDetallesConductor(conductor);
            }

            @Override
            public void onConductorEdit(Conductor conductor) {
                editarConductor(conductor);
            }

            @Override
            public void onConductorDelete(Conductor conductor) {
                eliminarConductor(conductor);
            }
        });
        
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    private void cargarConductores() {
        dataManager.cargarConductores(new DataManager.DataCallback<List<Conductor>>() {
            @Override
            public void onSuccess(List<Conductor> result) {
                conductores.clear();
                conductores.addAll(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(requireContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDialogoAgregarConductor() {
        Toast.makeText(requireContext(), "Función en desarrollo", Toast.LENGTH_SHORT).show();
    }

    private void mostrarDetallesConductor(Conductor conductor) {
        Toast.makeText(requireContext(), "Detalles de: " + conductor.getNombre(), Toast.LENGTH_SHORT).show();
    }

    private void editarConductor(Conductor conductor) {
        Toast.makeText(requireContext(), "Editar: " + conductor.getNombre(), Toast.LENGTH_SHORT).show();
    }

    private void eliminarConductor(Conductor conductor) {
        Toast.makeText(requireContext(), "Eliminar: " + conductor.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
