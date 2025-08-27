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
import ec.edu.espol.sistemaentrega.adapters.RutaAdapter;
import ec.edu.espol.sistemaentrega.data.DataManager;
import ec.edu.espol.sistemaentrega.model.Ruta;

public class RutasFragment extends Fragment {

    private RecyclerView recyclerView;
    private RutaAdapter adapter;
    private List<Ruta> rutas;
    private DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rutas, container, false);
        
        dataManager = DataManager.getInstance(requireContext());
        rutas = new ArrayList<>();
        
        initViews(view);
        setupRecyclerView();
        cargarRutas();
        
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_rutas);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_ruta);
        
        fab.setOnClickListener(v -> mostrarDialogoAgregarRuta());
    }

    private void setupRecyclerView() {
        adapter = new RutaAdapter(rutas, new RutaAdapter.RutaListener() {
            @Override
            public void onRutaClick(Ruta ruta) {
                mostrarDetallesRuta(ruta);
            }

            @Override
            public void onRutaEdit(Ruta ruta) {
                editarRuta(ruta);
            }

            @Override
            public void onRutaDelete(Ruta ruta) {
                eliminarRuta(ruta);
            }

            @Override
            public void onRutaStart(Ruta ruta) {
                iniciarRuta(ruta);
            }
        });
        
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    private void cargarRutas() {
        dataManager.cargarRutas(new DataManager.DataCallback<List<Ruta>>() {
            @Override
            public void onSuccess(List<Ruta> result) {
                rutas.clear();
                rutas.addAll(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(requireContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDialogoAgregarRuta() {
        Toast.makeText(requireContext(), "Función en desarrollo", Toast.LENGTH_SHORT).show();
    }

    private void mostrarDetallesRuta(Ruta ruta) {
        Toast.makeText(requireContext(), "Detalles de: " + ruta.getId(), Toast.LENGTH_SHORT).show();
    }

    private void editarRuta(Ruta ruta) {
        Toast.makeText(requireContext(), "Editar: " + ruta.getId(), Toast.LENGTH_SHORT).show();
    }

    private void eliminarRuta(Ruta ruta) {
        Toast.makeText(requireContext(), "Eliminar: " + ruta.getId(), Toast.LENGTH_SHORT).show();
    }

    private void iniciarRuta(Ruta ruta) {
        Toast.makeText(requireContext(), "Iniciando ruta: " + ruta.getId(), Toast.LENGTH_SHORT).show();
    }
}
