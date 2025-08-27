package ec.edu.espol.sistemaentrega.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import ec.edu.espol.sistemaentrega.R;
import ec.edu.espol.sistemaentrega.data.DataManager;

public class DashboardFragment extends Fragment {

    private TextView tvTotalVehiculos, tvTotalConductores, tvTotalPaquetes, tvRutasActivas;
    private TextView tvEntregasHoy, tvVehiculosOperativos, tvConductoresDisponibles;
    private CardView cardVehiculos, cardConductores, cardPaquetes, cardRutas;
    private DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        
        dataManager = DataManager.getInstance(requireContext());
        initViews(view);
        setupClickListeners();
        cargarEstadisticas();
        
        return view;
    }

    private void initViews(View view) {
        tvTotalVehiculos = view.findViewById(R.id.tv_total_vehiculos);
        tvTotalConductores = view.findViewById(R.id.tv_total_conductores);
        tvTotalPaquetes = view.findViewById(R.id.tv_total_paquetes);
        tvRutasActivas = view.findViewById(R.id.tv_rutas_activas);
        tvEntregasHoy = view.findViewById(R.id.tv_entregas_hoy);
        tvVehiculosOperativos = view.findViewById(R.id.tv_vehiculos_operativos);
        tvConductoresDisponibles = view.findViewById(R.id.tv_conductores_disponibles);
        
        cardVehiculos = view.findViewById(R.id.card_vehiculos);
        cardConductores = view.findViewById(R.id.card_conductores);
        cardPaquetes = view.findViewById(R.id.card_paquetes);
        cardRutas = view.findViewById(R.id.card_rutas);
    }

    private void setupClickListeners() {
        cardVehiculos.setOnClickListener(v -> navegarAVehiculos());
        cardConductores.setOnClickListener(v -> navegarAConductores());
        cardPaquetes.setOnClickListener(v -> navegarAPaquetes());
        cardRutas.setOnClickListener(v -> navegarARutas());
    }

    private void cargarEstadisticas() {
        // Cargar estadísticas de vehículos
        dataManager.cargarVehiculos(new DataManager.DataCallback<>() {
            @Override
            public void onSuccess(java.util.List<ec.edu.espol.sistemaentrega.model.Vehiculo> vehiculos) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        tvTotalVehiculos.setText(String.valueOf(vehiculos.size()));
                        long operativos = vehiculos.stream().filter(v -> v.isOperativo()).count();
                        tvVehiculosOperativos.setText(String.valueOf(operativos));
                    });
                }
            }

            @Override
            public void onError(String error) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> 
                        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show());
                }
            }
        });

        // Cargar estadísticas de conductores
        dataManager.cargarConductores(new DataManager.DataCallback<>() {
            @Override
            public void onSuccess(java.util.List<ec.edu.espol.sistemaentrega.model.Conductor> conductores) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        tvTotalConductores.setText(String.valueOf(conductores.size()));
                        long disponibles = conductores.stream().filter(c -> c.isDisponible()).count();
                        tvConductoresDisponibles.setText(String.valueOf(disponibles));
                    });
                }
            }

            @Override
            public void onError(String error) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> 
                        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show());
                }
            }
        });

        // Cargar estadísticas de paquetes
        dataManager.cargarPaquetes(new DataManager.DataCallback<>() {
            @Override
            public void onSuccess(java.util.List<ec.edu.espol.sistemaentrega.model.Paquete> paquetes) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        tvTotalPaquetes.setText(String.valueOf(paquetes.size()));
                        // Calcular entregas de hoy (simulado)
                        tvEntregasHoy.setText("5");
                    });
                }
            }

            @Override
            public void onError(String error) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> 
                        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show());
                }
            }
        });

        // Cargar estadísticas de rutas
        dataManager.cargarRutas(new DataManager.DataCallback<>() {
            @Override
            public void onSuccess(java.util.List<ec.edu.espol.sistemaentrega.model.Ruta> rutas) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        long activas = rutas.stream().filter(r -> "En Progreso".equals(r.getEstado())).count();
                        tvRutasActivas.setText(String.valueOf(activas));
                    });
                }
            }

            @Override
            public void onError(String error) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> 
                        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    private void navegarAVehiculos() {
        // Navegar a la sección de vehículos
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).onNavigationItemSelected(
                getActivity().findViewById(R.id.nav_vehiculos).getMenu().findItem(R.id.nav_vehiculos)
            );
        }
    }

    private void navegarAConductores() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).onNavigationItemSelected(
                getActivity().findViewById(R.id.nav_conductores).getMenu().findItem(R.id.nav_conductores)
            );
        }
    }

    private void navegarAPaquetes() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).onNavigationItemSelected(
                getActivity().findViewById(R.id.nav_paquetes).getMenu().findItem(R.id.nav_paquetes)
            );
        }
    }

    private void navegarARutas() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).onNavigationItemSelected(
                getActivity().findViewById(R.id.nav_rutas).getMenu().findItem(R.id.nav_rutas)
            );
        }
    }
}
