package vn.edu.greenwich.rentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddApartmentPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment_post);

        String notification = getResources().getString(R.string.notification);

        Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(btnAdd_Click);
    }

    private View.OnClickListener btnAdd_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Boolean isValid = true;

            TextView txtNameofprovider = findViewById(R.id.txtNameofprovider);
            TextView txtAddress = findViewById(R.id.txtAddress);
            TextView txtTypesofhouse = findViewById(R.id.txtTypesofhouse);
            TextView txtBedroom = findViewById(R.id.txtBedroom);
            TextView txtFurniture = findViewById(R.id.txtFurniture);
            TextView txtPrice = findViewById(R.id.txtPrice);
            TextView txtYourname = findViewById(R.id.txtYourname);

            String error = "";
            String nameofprovider = txtNameofprovider.getText().toString();
            String address = txtAddress.getText().toString();
            String typesofhouse = txtTypesofhouse.getText().toString();
            String bedroom = txtBedroom.getText().toString();
            String furniture = txtFurniture.getText().toString();
            String price = txtPrice.getText().toString();
            String yourname = txtYourname.getText().toString();

            String notification = getResources().getString(R.string.notification);

            if (TextUtils.isEmpty(nameofprovider)) {
                isValid = false;
                error += "* Name of provider cannot be blank.\n";
            }

            if (TextUtils.isEmpty(address)) {
                isValid = false;
                error += "* Address cannot be blank.\n";
            }

            if (TextUtils.isEmpty(typesofhouse)) {
                isValid = false;
                error += "* Types of house cannot be blank.\n";
            }

            if (TextUtils.isEmpty(bedroom)) {
                isValid = false;
                error += "* Bedroom cannot be blank.\n";
            }

            if (TextUtils.isEmpty(furniture)) {
                isValid = false;
                error += "* Furniture cannot be blank.\n";
            }

            if (TextUtils.isEmpty(price)) {
                isValid = false;
                error += "* Price cannot be blank.\n";
            }

            if (TextUtils.isEmpty(yourname)) {
                isValid = false;
                error += "* Your name cannot be blank.\n";
            }

            if(isValid) {
                Toast.makeText(view.getContext(), notification,Toast.LENGTH_SHORT).show();
                Toast.makeText(view.getContext(), "The accommodation of " + nameofprovider + " is added successfully by " + yourname ,Toast.LENGTH_SHORT).show();

                Bundle postInfo = new Bundle();

                postInfo.putString("nameofprovider", nameofprovider);
                postInfo.putString("address", address);
                postInfo.putString("typesofhouse", typesofhouse);
                postInfo.putString("bedroom", bedroom);
                postInfo.putString("furniture", furniture);
                postInfo.putString("price", price);
                postInfo.putString("yourname", yourname);


                Intent confirmActivity = new Intent(view.getContext(), ConfirmActivity.class);

                confirmActivity.putExtras(postInfo);

                startActivity(confirmActivity);
                finish();
            } else {
                Toast.makeText(view.getContext(), error,Toast.LENGTH_SHORT).show();
            }
        }
    };
}