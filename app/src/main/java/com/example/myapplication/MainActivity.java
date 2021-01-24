package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String [] Best= { "Sophie's Choice - Meryl Streep", "Konjanik - Zrinka Cvitešić", "Me Before You - Emilia Clarke"};
    Random rand= new Random();

    TextView tvcaption, tvMeryl, tvdescription_1, tvZrinka, tvdescription_2, tvEmilia, tvdescription_3, tvBestMovie;
    ImageView ivMeryl_Streep, ivZrinka_Cvitesic, ivEmilia_Clarke;
    EditText etReplace;
    RadioButton rbMeryl, rbZrinka, rbEmilia;
    Button btnReplace, btnBestMovie;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
    }

    private void initialiseUI() {
        this.tvcaption = (TextView) findViewById(R.id.tvcaption);
        this.ivMeryl_Streep = (ImageView) findViewById(R.id.ivMeryl_Streep);
        this.tvMeryl = (TextView) findViewById(R.id.tvMeryl);
        this.tvdescription_1 = (TextView) findViewById(R.id.tvdescription_1);
        this.ivZrinka_Cvitesic = (ImageView) findViewById(R.id.ivZrinka_Cvitesic);
        this.tvZrinka = (TextView) findViewById(R.id.tvZrinka);
        this.tvdescription_2 = (TextView) findViewById(R.id.tvdescription_2);
        this.ivEmilia_Clarke = (ImageView) findViewById(R.id.ivEmilia_Clarke);
        this.tvEmilia = (TextView) findViewById(R.id.tvMeryl);
        this.tvdescription_3 = (TextView) findViewById(R.id.tvdescription_3);
        this.etReplace = (EditText) findViewById(R.id.etReplace);
        this.rbMeryl = (RadioButton) findViewById(R.id.rbMeryl);
        this.rbZrinka = (RadioButton) findViewById(R.id.rbZrinka);
        this.rbEmilia = (RadioButton) findViewById(R.id.rbEmilia);
        this.btnReplace = (Button) findViewById(R.id.btnReplace);
        this.btnBestMovie = (Button) findViewById(R.id.btnBestovie);
        this.tvBestMovie=(TextView)findViewById(R.id.tvBestMovie);

        this.ivMeryl_Streep.setOnClickListener( this);
        this.ivZrinka_Cvitesic.setOnClickListener(this);
        this.ivEmilia_Clarke.setOnClickListener(this);

        this.etReplace.setOnClickListener(this);

        this.btnReplace.setOnClickListener(this);
        this.btnBestMovie.setOnClickListener(this);


    }
        public void MoveImage(ImageView image){
            image.setVisibility(View.INVISIBLE);
        }
        public void ApearImage(ImageView image1, ImageView image2){
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
        }



    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.ivMeryl_Streep) {
            MoveImage(ivMeryl_Streep);
            ApearImage(ivZrinka_Cvitesic, ivEmilia_Clarke);
        }
        else if (view.getId()== R.id.ivZrinka_Cvitesic){
            MoveImage(ivZrinka_Cvitesic);
            ApearImage(ivMeryl_Streep,ivEmilia_Clarke);
        }
        else if(view.getId()== R.id.ivEmilia_Clarke) {
            MoveImage(ivEmilia_Clarke);
            ApearImage(ivMeryl_Streep,ivZrinka_Cvitesic);
        }



        if(view.getId()==R.id.btnReplace){
            if(rbMeryl.isChecked()){
                this.tvdescription_1.setText(etReplace.getText());
            }
            else if(rbZrinka.isChecked()){
                this.tvdescription_2.setText(etReplace.getText());
            }
            else if(rbEmilia.isChecked()){
                this.tvdescription_3.setText(etReplace.getText());
            }
        }


        if(view.getId()==R.id.btnBestovie){
            this.displayToast(Best[rand.nextInt(Best.length)]);
        }

    }
    private void displayToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}