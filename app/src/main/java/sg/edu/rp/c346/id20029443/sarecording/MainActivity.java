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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnLink,BtnAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnLink = findViewById(R.id.BtnLink);
        BtnAdvance = findViewById(R.id.BtnAdvance);

        BtnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/1KindOfSky"));
                startActivity(intentWeb);
            }
        });

        BtnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

    }
}