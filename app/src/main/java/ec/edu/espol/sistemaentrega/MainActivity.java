package ec.edu.espol.sistemaentrega;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import ec.edu.espol.sistemaentrega.data.DataManager;
import ec.edu.espol.sistemaentrega.fragments.DashboardFragment;
import ec.edu.espol.sistemaentrega.fragments.RutasFragment;
import ec.edu.espol.sistemaentrega.fragments.VehiculosFragment;
import ec.edu.espol.sistemaentrega.fragments.ConductoresFragment;
import ec.edu.espol.sistemaentrega.fragments.PaquetesFragment;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fab;
    private TextView tvTitle;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Inicializar DataManager
        dataManager = DataManager.getInstance(this);
        
        // Inicializar vistas
        initViews();
        setupNavigation();
        
        // Cargar fragmento inicial
        loadFragment(new DashboardFragment());
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fab = findViewById(R.id.fab);
        tvTitle = findViewById(R.id.tv_title);
        
        // Configurar FAB
        fab.setOnClickListener(v -> showQuickActions());
    }

    private void setupNavigation() {
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_dashboard);
    }

    private void showQuickActions() {
        // Mostrar diálogo de acciones rápidas
        QuickActionsDialog dialog = new QuickActionsDialog();
        dialog.show(getSupportFragmentManager(), "quick_actions");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        String title = "";
        
        int itemId = item.getItemId();
        if (itemId == R.id.nav_dashboard) {
            fragment = new DashboardFragment();
            title = "Dashboard";
        } else if (itemId == R.id.nav_vehiculos) {
            fragment = new VehiculosFragment();
            title = "Vehículos";
        } else if (itemId == R.id.nav_conductores) {
            fragment = new ConductoresFragment();
            title = "Conductores";
        } else if (itemId == R.id.nav_paquetes) {
            fragment = new PaquetesFragment();
            title = "Paquetes";
        } else if (itemId == R.id.nav_rutas) {
            fragment = new RutasFragment();
            title = "Rutas";
        }
        
        if (fragment != null) {
            tvTitle.setText(title);
            loadFragment(fragment);
            return true;
        }
        
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dataManager != null) {
            dataManager.shutdown();
        }
    }
}
