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
import ec.edu.espol.sistemaentrega.adapters.VehiculoAdapter;
import ec.edu.espol.sistemaentrega.data.DataManager;
import ec.edu.espol.sistemaentrega.model.Vehiculo;

public class VehiculosFragment extends Fragment {

    private RecyclerView recyclerView;
    private VehiculoAdapter adapter;
    private List<Vehiculo> vehiculos;
    private DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehiculos, container, false);
        
        dataManager = DataManager.getInstance(requireContext());
        vehiculos = new ArrayList<>();
        
        initViews(view);
        setupRecyclerView();
        cargarVehiculos();
        
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_vehiculos);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_vehiculo);
        
        fab.setOnClickListener(v -> mostrarDialogoAgregarVehiculo());
    }

    private void setupRecyclerView() {
        adapter = new VehiculoAdapter(vehiculos, new VehiculoAdapter.VehiculoListener() {
            @Override
            public void onVehiculoClick(Vehiculo vehiculo) {
                mostrarDetallesVehiculo(vehiculo);
            }

            @Override
            public void onVehiculoEdit(Vehiculo vehiculo) {
                editarVehiculo(vehiculo);
            }

            @Override
            public void onVehiculoDelete(Vehiculo vehiculo) {
                eliminarVehiculo(vehiculo);
            }
        });
        
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    private void cargarVehiculos() {
        dataManager.cargarVehiculos(new DataManager.DataCallback<List<Vehiculo>>() {
            @Override
            public void onSuccess(List<Vehiculo> result) {
                vehiculos.clear();
                vehiculos.addAll(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(requireContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDialogoAgregarVehiculo() {
        // Mostrar diálogo para agregar vehículo
        VehiculoDialog dialog = new VehiculoDialog();
        dialog.setVehiculoListener(new VehiculoDialog.VehiculoDialogListener() {
            @Override
            public void onVehiculoSaved(Vehiculo vehiculo) {
                guardarVehiculo(vehiculo);
            }
        });
        dialog.show(getChildFragmentManager(), "add_vehiculo");
    }

    private void guardarVehiculo(Vehiculo vehiculo) {
        dataManager.guardarVehiculo(vehiculo, new DataManager.DataCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                Toast.makeText(requireContext(), "Vehículo guardado exitosamente", Toast.LENGTH_SHORT).show();
                cargarVehiculos();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(requireContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDetallesVehiculo(Vehiculo vehiculo) {
        // Mostrar detalles del vehículo
        VehiculoDetallesDialog dialog = new VehiculoDetallesDialog(vehiculo);
        dialog.show(getChildFragmentManager(), "vehiculo_details");
    }

    private void editarVehiculo(Vehiculo vehiculo) {
        // Mostrar diálogo de edición
        VehiculoDialog dialog = new VehiculoDialog(vehiculo);
        dialog.setVehiculoListener(new VehiculoDialog.VehiculoDialogListener() {
            @Override
            public void onVehiculoSaved(Vehiculo vehiculoEditado) {
                // Actualizar vehículo
                Toast.makeText(requireContext(), "Vehículo actualizado", Toast.LENGTH_SHORT).show();
                cargarVehiculos();
            }
        });
        dialog.show(getChildFragmentManager(), "edit_vehiculo");
    }

    private void eliminarVehiculo(Vehiculo vehiculo) {
        // Mostrar confirmación de eliminación
        Toast.makeText(requireContext(), "Función de eliminación en desarrollo", Toast.LENGTH_SHORT).show();
    }
}
