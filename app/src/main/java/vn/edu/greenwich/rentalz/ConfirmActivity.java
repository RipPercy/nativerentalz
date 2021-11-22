package vn.edu.greenwich.rentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        TextView tvNameofprovider = findViewById(R.id.tvNameofprovider_Text);
        TextView tvAddress = findViewById(R.id.tvAddress_Text);
        TextView tvTypesofhouse = findViewById(R.id.tvTypesofhouse_Text);
        TextView tvBedroom = findViewById(R.id.tvBedroom_Text);
        TextView tvFurniture = findViewById(R.id.tvFurniture_Text);
        TextView tvPrice = findViewById(R.id.tvPrice_Text);
        TextView tvYourname = findViewById(R.id.tvYourname_Text);

        String nameofprovider = "", address = "", typesofhouse = "", bedroom = "", furniture = "", price = "", yourname = "";

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            nameofprovider = bundle.getString("nameofprovider");
            address = bundle.getString("address");
            typesofhouse = bundle.getString("typesofhouse");
            bedroom = bundle.getString("bedroom");
            furniture = bundle.getString("furniture");
            price = bundle.getString("price");
            yourname = bundle.getString("yourname");
        }

        tvNameofprovider.setText(nameofprovider);
        tvAddress.setText(address);
        tvTypesofhouse.setText(typesofhouse);
        tvBedroom.setText(bedroom);
        tvFurniture.setText(furniture);
        tvPrice.setText(price);
        tvYourname.setText(yourname);
    }
}