package ec.edu.espol.sistemaentrega.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ec.edu.espol.sistemaentrega.R;
import ec.edu.espol.sistemaentrega.model.Vehiculo;

public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.VehiculoViewHolder> {

    private List<Vehiculo> vehiculos;
    private VehiculoListener listener;

    public interface VehiculoListener {
        void onVehiculoClick(Vehiculo vehiculo);
        void onVehiculoEdit(Vehiculo vehiculo);
        void onVehiculoDelete(Vehiculo vehiculo);
    }

    public VehiculoAdapter(List<Vehiculo> vehiculos, VehiculoListener listener) {
        this.vehiculos = vehiculos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VehiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vehiculo, parent, false);
        return new VehiculoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculoViewHolder holder, int position) {
        Vehiculo vehiculo = vehiculos.get(position);
        holder.bind(vehiculo);
    }

    @Override
    public int getItemCount() {
        return vehiculos.size();
    }

    class VehiculoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlaca, tvModelo, tvTipo, tvCapacidad, tvEstado;
        private ImageButton btnEdit, btnDelete;

        public VehiculoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaca = itemView.findViewById(R.id.tv_placa);
            tvModelo = itemView.findViewById(R.id.tv_modelo);
            tvTipo = itemView.findViewById(R.id.tv_tipo);
            tvCapacidad = itemView.findViewById(R.id.tv_capacidad);
            tvEstado = itemView.findViewById(R.id.tv_estado);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onVehiculoClick(vehiculos.get(position));
                }
            });

            btnEdit.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onVehiculoEdit(vehiculos.get(position));
                }
            });

            btnDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onVehiculoDelete(vehiculos.get(position));
                }
            });
        }

        public void bind(Vehiculo vehiculo) {
            tvPlaca.setText(vehiculo.getPlaca());
            tvModelo.setText(vehiculo.getModelo());
            tvTipo.setText(vehiculo.getTipo());
            tvCapacidad.setText(String.format("%.1f kg", vehiculo.getCapacidad()));
            
            if (vehiculo.isOperativo()) {
                tvEstado.setText("Operativo");
                tvEstado.setTextColor(itemView.getContext().getResources().getColor(R.color.colorSuccess));
            } else {
                tvEstado.setText("No Operativo");
                tvEstado.setTextColor(itemView.getContext().getResources().getColor(R.color.colorError));
            }
        }
    }
}
