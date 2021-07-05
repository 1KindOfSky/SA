package sg.edu.rp.c346.id20029443.sarecording;

/*I, Skyler Ling Kiat, declare that:
        •	This submission is my original work – all sources have been properly referenced and acknowledged.
        •	I have not copied the words or graphics or ideas or codes from another person/source and submitted it as my own.
        •	I neither received nor rendered any assistance (either paid or unpaid) on work that requires individual effort.
        •	I have not communicated, discussed, shared or made available my work with other students, in part or in whole, formally or informally. By doing so, I am also guilty of plagiarism and cheating.

        If found guilty of committing any act of academic dishonesty, I understand that I will be liable:
        •	for disciplinary action by the School
        •	to the full extent of penalties, including immediate failure for this assessment and other disciplinary actions such as dismissal*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class ItemListActivity extends AppCompatActivity {

    Spinner Spinner;
    Button BtnInsert,BtnDelete,BtnUpdate;
    EditText ETName,ETExpire,ETUExpire;
    ListView ItemLV;
    ArrayList<String> alItems;
    ArrayAdapter<String> aaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Spinner = findViewById(R.id.Spinner);
        BtnInsert = findViewById(R.id.BtnInsert);
        BtnDelete = findViewById(R.id.BtnDelete);
        BtnUpdate = findViewById(R.id.BtnUpdate);
        ETName = findViewById(R.id.ETName);
        ETExpire = findViewById(R.id.ETExpire);
        ETUExpire = findViewById(R.id.ETUExpire);
        ItemLV = findViewById(R.id.ItemLV);

        alItems = new ArrayList<>();

        alItems.add("Expires 2021-8-6 Logi Mouse");
        alItems.add("Expires 2021-9-6 Logi Mouse");
        alItems.add("Expires 2021-10-6 Logi Mouse");
        alItems.add("Expires 2021-11-6 Logi Mouse");
        alItems.add("Expires 2021-12-6 Logi Mouse");

        aaItems = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, alItems);
        Collections.sort(alItems);
        ItemLV.setAdapter(aaItems);

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ItemName = ETName.getText().toString();
                String ItemExpire = ETExpire.getText().toString();
                String ItemUExpire = ETUExpire.getText().toString();
                int index = alItems.indexOf("Expires " + ItemExpire + " " + ItemName);
                alItems.set(index, "Expires " + ItemUExpire + " " + ItemName);
                aaItems.notifyDataSetChanged();
            }
        });

        BtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ItemName = ETName.getText().toString();
                String ItemExpire = ETExpire.getText().toString();
                alItems.add("Expires "  + ItemExpire + " "+ ItemName);
                Collections.sort(alItems);
                aaItems.notifyDataSetChanged();
            }
        });

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ItemName = ETName.getText().toString();
                String ItemExpire = ETExpire.getText().toString();
                int index = alItems.indexOf("Expires " + ItemExpire + " " + ItemName);
                alItems.remove(index);
                aaItems.notifyDataSetChanged();
            }
        });

        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Date C = Calendar.getInstance().getTime();

                SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
                String formattedDate = df.format(C);

                String[] Sets = formattedDate.split("-");
                int Year = Integer.parseInt(Sets[0]);
                int Month = Integer.parseInt(Sets[1]);

                switch (position) {
                    case 0:
                        return;
                    case 1:
                        Month += 1;
                        break;
                    case 2:
                        Month += 3;
                        break;
                    case 3:
                        Month += 6;
                        break;

                }

                if (Month > 12) {
                    Month -= 12;
                    Year += 1;
                }

                String text = Year + "-" + Month + "-";

                (ItemListActivity.this).aaItems.getFilter().filter(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}